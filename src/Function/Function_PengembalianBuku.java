/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Function;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMUEL
 */
public class Function_PengembalianBuku {
    
    private static Connection connection;
    private static ResultSet rs;
    
    public Model.Buku Pengembalian(String kodeBuku){
        
        Model.Buku buku = new Model.Buku();
        try {
            // TODO code application logic here
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan","root","");
            String a = "SELECT * FROM buku where kode_buku = ?";
            PreparedStatement stmt = connection.prepareStatement(a);
            stmt.setString(1,kodeBuku);
            rs =stmt.executeQuery();
            while(rs.next()){
                buku.setJudulBuku(rs.getString("judul_buku"));
                buku.setKodeBuku(kodeBuku);
                buku.setNamaPenerbit(rs.getString("nama_penerbit"));
                buku.setNamaPengarang(rs.getString("nama_pengarang"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Function_PengembalianBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Function_PengembalianBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buku;
    }
}
