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
}
