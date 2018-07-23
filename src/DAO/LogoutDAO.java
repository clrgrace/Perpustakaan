package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author JC Krisna
 */
public class LogoutDAO {
    
    public static boolean logOut(){
        boolean out = false;
        int r = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(r == JOptionPane.YES_OPTION){
            ConnectionManager.cutConnection();
            out = true;
        }
        
        return out;
    }    
    
}
