/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grace
 */
public class GenerateHistoryDAO {
    
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
