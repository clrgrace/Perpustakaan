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
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Grace
 */
public class DataAkses {
    // JACOB
    // The code has been moved
    
    
    
    
    // SAMUEL
    // The code has been moved
    
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
            st.setString(8, dosen.getTglGabung());
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
            st.setString(8, mhs.getTglGabung());
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
            st.setString(8, tamu.getTglGabung());
            st.setString(9, tamu.getStatus());
            
            st.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static Object [][] genDataTableHistory(String code){
        Object [][] arrObj = new Object[3][3];
        int i = 0;
        
        String query = "SELECT * FROM transaksi WHERE kode_buku = ?";
        try{
            Connection con4 = ConnectionManager.getConnection();
            PreparedStatement st4 = con4.prepareStatement(query);
            st4.setString(1, code);
            ResultSet rs4 = st4.executeQuery();
            while(rs4.next()){
                arrObj[i][0] = rs4.getString("id_peminjam");
                arrObj[i][1] = rs4.getString("status");
                arrObj[i][2] = rs4.getString("tgl_peminjaman");
                i++;
//              DefaultTableModel dtm = new DefaultTableModel(arrObj, title);
//              tblShow.setModel(dtm);
//              spTbl1.setViewportView(tblShow);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return arrObj;
    }
    
    public static Object[][] genDataTableList(){
//        Object [][] data = {{}};
        Object [][] arrObj = new Object[20][3];
        int i = 0;
        
        String query = "SELECT * FROM buku";
        try{
            Connection con4 = ConnectionManager.getConnection();
            PreparedStatement st4 = con4.prepareStatement(query);
            ResultSet rs4 = st4.executeQuery();
            while(rs4.next()){
                arrObj[i][0] = rs4.getInt("kode_buku");
                arrObj[i][1] = rs4.getString("judul_buku");
                arrObj[i][2] = rs4.getString("nama_pengarang");
                i++;
                
//              DefaultTableModel dtm = new DefaultTableModel(arrObj, title);
//              tblShow.setModel(dtm);
//              spTbl1.setViewportView(tblShow);
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return arrObj;
    }
    
}
