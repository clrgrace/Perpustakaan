/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Grace
 */
public class DaftarAnggotaDAO {
    
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
    
}
