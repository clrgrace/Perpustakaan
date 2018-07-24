package DAO;

import Model.BukuFiksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JC Krisna
 */
public class BukuDAO {
    
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
    
}
