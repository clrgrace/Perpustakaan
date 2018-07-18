/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import View.LoginFrame;
import View.MainMenuFrame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public static boolean logOut(){
        boolean out = false;
        int r = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(r == JOptionPane.YES_OPTION){
            ConnectionManager.cutConnection();
            out = true;
        }
        
        return out;
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
