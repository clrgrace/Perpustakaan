/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BukuFiksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMUEL
 */
public class PinjamDanPengembalianDAO {

    public static void updateAvaiblity(String x, String kodeBuku) {
        Connection con4 = ConnectionManager.getConnection();
        String query = "UPDATE buku SET available = ?  WHERE kode_buku = ?";
        try {
            PreparedStatement st = con4.prepareStatement(query);
            st.setString(1, x);
            st.setInt(2, Integer.parseInt(kodeBuku));
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void lend(String kodeBuku, String x, String y, String z) {
        try {
            Connection con4 = ConnectionManager.getConnection();
            String query = "INSERT INTO transaksi (kode_buku,status,id_peminjam,tgl_peminjaman) VALUES (?,?,?,?)";
            PreparedStatement st = con4.prepareStatement(query);
            st.setInt(1, Integer.parseInt(kodeBuku));
            st.setString(2, x);
            st.setString(3, y);
            st.setString(4, z);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // JACOB
    // The code has been moved
    // SAMUEL
    public static List<BukuFiksi> showBuku(String x, String y) {
        List<BukuFiksi> listBukuFiksi = new ArrayList<>();
        String query = "SELECT * FROM buku where " + x + " = ?";
        try {
            Connection con4 = ConnectionManager.getConnection();
            PreparedStatement st4 = con4.prepareStatement(query);
            st4.setString(1, y);
            ResultSet rs4 = st4.executeQuery();
            while (rs4.next()) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listBukuFiksi;
    }

    public static String lend_data(String kodeBuku, int y) {
        Connection con4 = ConnectionManager.getConnection();
        String query = "SELECT a.*,b.* FROM buku a INNER JOIN transaksi b ON a.kode_buku = b.kode_buku AND a.kode_buku = ?";
        String[] x = new String[2];
        try {
            PreparedStatement st = con4.prepareStatement(query);
            st.setInt(1, Integer.parseInt(kodeBuku));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                x[0] = rs.getString("a.jenis_buku");
                x[1] = rs.getString("b.tgl_peminjaman");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x[y];
    }

    public static String checkAvaiblity(String kodeBuku) {
        Connection con4 = ConnectionManager.getConnection();
        String query = "SELECT * FROM buku WHERE kode_buku = ?";
        String x = null;
        try {
            PreparedStatement st = con4.prepareStatement(query);
            st.setInt(1, Integer.parseInt(kodeBuku));
            ResultSet r = st.executeQuery();
            while (r.next()) {
                x = r.getString("available");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public static void expire_lend(String kodeBuku, int x, String y) {
        try {
            Connection con4 = ConnectionManager.getConnection();
            String query = "UPDATE transaksi set tgl_pengembalian = ?, lama_pinjam = ?  where kode_buku = ?";
            PreparedStatement st = con4.prepareStatement(query);
            st.setInt(2, x);
            st.setString(1, y);
            st.setInt(3, Integer.parseInt(kodeBuku));
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataAkses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
