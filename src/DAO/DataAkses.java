/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Buku;
import Model.BukuFiksi;
import View.LoginFrame;
import View.MainMenuFrame;
import java.util.List;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Grace
 */
public class DataAkses {
    
    //JACOB
    public static boolean logIn(String id, String pass){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;    
        boolean found = false;
        
        String username = id + "";
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Username");
        }
        else{
            String sql = "SELECT * FROM petugas WHERE id_petugas=? AND password=?";
            try{
                con = ConnectionManager.getConnection();
                pst = con.prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, pass);

                rs = pst.executeQuery();
                if(rs.next()){ // if found
                    found = true;
                } else{
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                }
            } 
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
        return found;
    }
   
    public static boolean logOut(){
        boolean out = false;
        int r = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(r == JOptionPane.YES_OPTION){
            ConnectionManager.cutConnection();
            out = true;
        }
        
        return out;
    }
    
    public static void forgotPassword(String id, String em){
        Connection con2 = null;
        PreparedStatement pst2 = null;
        ResultSet rs2 = null; 
        
        String sql = "SELECT * FROM petugas WHERE id_petugas=? AND email=?";
        try{
            con2 = ConnectionManager.getConnection();
            pst2 = con2.prepareStatement(sql);
            pst2.setString(1, id);
            pst2.setString(2, em);

            rs2 = pst2.executeQuery();
            if(rs2.next()){
                String newPass = JOptionPane.showInputDialog("Please Enter New Password..");
                String newPassConfirm = JOptionPane.showInputDialog("Re-enter New Password..");
                
                if(newPass.equals(newPassConfirm)){
                    String sql2 = "UPDATE petugas SET password=? WHERE id_petugas=?";
                    con2 = ConnectionManager.getConnection();
                    pst2 = con2.prepareStatement(sql2);
                    pst2.setString(1, newPassConfirm);
                    pst2.setString(2, id);
                    
                    pst2.execute();
                    JOptionPane.showMessageDialog(null, "Change Password Success!");
                } else{
                    JOptionPane.showMessageDialog(null, "Wrong Password Confirmation!");
                }
            } 
            else{
               JOptionPane.showMessageDialog(null, "Petugas Not Found!");
            }
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
        
    public static boolean addBuku(String kB, String jB, String nPeng, String nPen, String tT, String gen, String jen){
        boolean add = false;
        Connection con3 = null;
        PreparedStatement pst3 = null;
        
        String sql = "INSERT INTO buku (kode_buku,judul_buku,nama_pengarang,nama_penerbit,tahun_terbit,jenis_buku,spesifikasi_buku,available) "
                     + " VALUES (?,?,?,?,?,?,?,?)";
        try{
            con3 = ConnectionManager.getConnection();
            pst3 = con3.prepareStatement(sql);
            pst3.setString(1, kB);
            pst3.setString(2, jB);
            pst3.setString(3, nPeng);
            pst3.setString(4, nPen);
            pst3.setString(5, tT);
            pst3.setString(6, gen);
            pst3.setString(7, jen);
            pst3.setString(8, "Y");

            pst3.execute();
            add = true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return add;
    }
    
    public static List<BukuFiksi> showBuku(){
        List <BukuFiksi> listBukuFiksi = new ArrayList<>();
        
        String query = "SELECT * FROM buku";
        try{
            Connection con4 = ConnectionManager.getConnection();
            PreparedStatement st4 = con4.prepareStatement(query);
            ResultSet rs4 = st4.executeQuery();
            while(rs4.next()){
                BukuFiksi b = new BukuFiksi();
                b.setKodeBuku(rs4.getString("kode_buku"));
                b.setJudulBuku(rs4.getString("judul_buku"));
                b.setNamaPengarang(rs4.getString("nama_pengarang"));
                b.setNamaPenerbit(rs4.getString("nama_penerbit"));
                b.setTahunTerbit(rs4.getInt("tahun_terbit"));
                b.setJenisBuku(rs4.getString("jenis_buku"));
                b.setJenisFiksi(rs4.getString("spesifikasi_buku"));
                b.setAvailable(rs4.getString("available"));
                
                listBukuFiksi.add(b);
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return listBukuFiksi;
    }
    
    public static void deleteBuku(int kode){
        
        String query = "DELETE FROM buku WHERE kode_buku = ?";
        try{
            Connection con5 = ConnectionManager.getConnection();
            PreparedStatement st5 = con5.prepareStatement(query);
            st5.setInt(1, kode);
            
            st5.execute();
            JOptionPane.showMessageDialog(null, "Delete Sukses!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void updateBuku(int kode){
        
        String query = "SELECT * FROM buku WHERE kode_buku = ?";
        try{
            Connection con6 = ConnectionManager.getConnection();
            PreparedStatement st6 = con6.prepareStatement(query);
            st6.setInt(1, kode);
            
            ResultSet rs6 = st6.executeQuery();
            if(rs6.next()){
                String jdl = JOptionPane.showInputDialog(null,"Input Judul Buku : ");
                String pgr = JOptionPane.showInputDialog(null, "Input Pengarang : ");
                String pbt = JOptionPane.showInputDialog(null, "Input Penerbit : ");
                int tT = Integer.parseInt(JOptionPane.showInputDialog(null, "Input Tahun Terbit : "));
                String jenis = JOptionPane.showInputDialog(null, "Fiksi / NonFiksi (Text must Appropriate)");
                String sps = JOptionPane.showInputDialog(null, "Spesifikasi Buku");
                String stat = JOptionPane.showInputDialog(null, "Available (Y / N)");
                
                String query2 = "UPDATE buku SET judul_buku=?, nama_pengarang=?, nama_penerbit=?, tahun_terbit=?, jenis_buku=?, spesifikasi_buku=?, available=? WHERE kode_buku=?";
                    PreparedStatement st7 = con6.prepareStatement(query2);
                    st7.setString(1, jdl);
                    st7.setString(2, pgr);
                    st7.setString(3, pbt);
                    st7.setInt(4, tT);
                    st7.setString(5, jenis);
                    st7.setString(6, sps);
                    st7.setString(7, stat);
                    st7.setInt(8, kode);
                    
                    st7.execute();
                    JOptionPane.showMessageDialog(null, "Update Buku Sukses!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Book not found!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    // SAMUEL
    public static List<BukuFiksi> showBuku(String x,String y){
        List <BukuFiksi> listBukuFiksi = new ArrayList<>();
        
        String query = "SELECT * FROM buku where "+ x +" = ?";
        
        try{
            Connection con4 = ConnectionManager.getConnection();
            PreparedStatement st4 = con4.prepareStatement(query);
            st4.setString(1,y);
            ResultSet rs4 = st4.executeQuery();
            while(rs4.next()){
                BukuFiksi b = new BukuFiksi();
                b.setKodeBuku(rs4.getString("kode_buku"));
                b.setJudulBuku(rs4.getString("judul_buku"));
                b.setNamaPengarang(rs4.getString("nama_pengarang"));
                b.setNamaPenerbit(rs4.getString("nama_penerbit"));
                b.setTahunTerbit(rs4.getInt("tahun_terbit"));
                b.setJenisBuku(rs4.getString("jenis_buku"));
                b.setJenisFiksi(rs4.getString("spesifikasi_buku"));
                b.setAvailable("available");
                System.out.println(rs4.getString("kode_buku"));
                System.out.println("x");
                listBukuFiksi.add(b);
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return listBukuFiksi;
    }
    
    public static void updateAvaiblity(String x,String kodeBuku){
        Connection con4 = ConnectionManager.getConnection();
        String query = "UPDATE buku SET avaible = ? WHERE kode_buku = ?";
        try {
            PreparedStatement st = con4.prepareStatement(query);
            st.setString(1,x);
            st.setInt(2,Integer.parseInt(kodeBuku));
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void checkAvaiblity(String kodeBuku){
        Connection con4 = ConnectionManager.getConnection();
        String query = "SELECT * FROM buku WHERE kode_buku = ?";
        
        try {
            PreparedStatement st = con4.prepareStatement(query);
            st.setInt(1,Integer.parseInt(kodeBuku));
            ResultSet r = st.executeQuery();
            while(r.next()){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void deleteTranksaksi(int kode){
        
        String query = "DELETE FROM tranksaksi WHERE kode_buku = ?";
        try{
            Connection con5 = ConnectionManager.getConnection();
            PreparedStatement st5 = con5.prepareStatement(query);
            st5.setInt(1, kode);
            st5.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    //GRACE
    public static void addDosen(Model.Dosen dosen){
        String query = "INSERT into peminjam values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, dosen.getIdDosen());
            st.setString(2, dosen.getNama());
            st.setString(3, dosen.getJenisKelamin());
            st.setString(4, dosen.getTglLahir());
            st.setString(5, dosen.getAlamat());
            st.setString(6, dosen.getNoTelepon());
            st.setString(7, dosen.getEmail());
            st.setInt(8, dosen.getTglGabung());
            st.setString(9, dosen.getStatus());
            
            st.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void addMahasiswa(Model.Mahasiswa mhs){
        String query = "INSERT into peminjam values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, mhs.getIdMahasiswa());
            st.setString(2, mhs.getNama());
            st.setString(3, mhs.getJenisKelamin());
            st.setString(4, mhs.getTglLahir());
            st.setString(5, mhs.getAlamat());
            st.setString(6, mhs.getNoTelepon());
            st.setString(7, mhs.getEmail());
            st.setInt(8, mhs.getTglGabung());
            st.setString(9, mhs.getStatus());
            
            st.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void addTamu(Model.Tamu tamu){
        String query = "INSERT into peminjam values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement st = ConnectionManager.getConnection().prepareStatement(query);
            st.setString(1, tamu.getIdKTP());
            st.setString(2, tamu.getNama());
            st.setString(3, tamu.getJenisKelamin());
            st.setString(4, tamu.getTglLahir());
            st.setString(5, tamu.getAlamat());
            st.setString(6, tamu.getNoTelepon());
            st.setString(7, tamu.getEmail());
            st.setInt(8, tamu.getTglGabung());
            st.setString(9, tamu.getStatus());
            
            st.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}
