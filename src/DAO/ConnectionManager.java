package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grace
 */
public class ConnectionManager {
    
    private static String server = "jdbc:mysql://localhost/db_perpustakaan";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;
    
    public static Connection getConnection(){
        if(connection == null){
            connection = logOn();
        }
        
        return connection;
    }
    
    public static void cutConnection(){
        logOff();
    }
    
    private static Connection logOn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Koneksi sukses!");
            return DriverManager.getConnection(server, username, password);
        } catch(SQLException e){
            e.printStackTrace(System.err);
            System.out.println("Koneksi gagal : " + e.toString());
        } catch(ClassNotFoundException ex){
            ex.printStackTrace(System.err);
            System.out.println("JDBC.OOBC driver tidak ditemukan!");
        }
        
        return null;
    }
    
    private static void logOff(){
        try{
            connection = null;
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    
    public static void main(String[] args) {
        logOn();
    }
    
}
