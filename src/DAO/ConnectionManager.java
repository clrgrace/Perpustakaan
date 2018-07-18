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
            
            return DriverManager.getConnection(server, username, password);
        } catch(SQLException e){
            e.printStackTrace(System.err);
        } catch(ClassNotFoundException ex){
            ex.printStackTrace(System.err);
        }
        
        return null;
    }
    
    private static void logOff(){
        try{
            connection.close();
            System.out.println("logOut!");
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
    
}
