
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author JC Krisna
 */
public class LoginFrame extends JFrame {
    
    public LoginFrame(){
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        
        this.setTitle("Perpustakaan");
        this.getContentPane().setLayout(null); // jpanel position
        
        //JPanel
        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBounds(0,0,500,30);
        pnl1.setBackground(new Color(219, 194, 114));
        add(pnl1);
        
        lblTitle = new JLabel("LOGIN PETUGAS");
        lblTitle.setBounds(180, 1, 140, 30);
        lblTitle.setFont(new Font("Arial",Font.BOLD,16));
        pnl1.add(lblTitle);
        
        // JPanel
        pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setBounds(0, 0, 500, 220);
        pnl2.setBackground(new Color(183, 157, 73));
        add(pnl2);
        
        lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(100, 50, 110, 30);
        lblUsername.setFont(new Font("CONSOLAS",Font.BOLD,15));
        pnl2.add(lblUsername);
        
        txtUsername = new JTextField(12);
        txtUsername.setBounds(200, 52, 170, 25);
        pnl2.add(txtUsername);
        
        lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(100, 92, 110, 30);
        lblPassword.setFont(new Font("CONSOLAS",Font.BOLD,15));
        pnl2.add(lblPassword);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 92, 170, 25);
        pnl2.add(txtPassword);
        
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(130, 142, 100, 30);
        pnl2.add(btnSubmit);
        
        lblForgot = new JLabel("Forgot Password?");
        lblForgot.setBounds(250, 135, 100, 50);
        lblForgot.setFont(new Font("Serif",Font.PLAIN,12));
        pnl2.add(lblForgot);
        
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                onClickSubmit(ae);
            }
        });
        
        lblForgot.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String id = JOptionPane.showInputDialog("Enter Id Petugas..");
                String email = JOptionPane.showInputDialog("Enter Email Petugas..");
//                String newPass = JOptionPane.showInputDialog("Please Enter New Password..");
//                String newPassConfirm = JOptionPane.showInputDialog("Re-enter New Password..");
                
                ChangePassword(id, email);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }
    
    private JPanel pnl1 = new JPanel();
    private JPanel pnl2 = new JPanel();
    private JLabel lblTitle = new JLabel();
    private JLabel lblUsername = new JLabel();
    private JTextField txtUsername = new JTextField();
    private JLabel lblPassword = new JLabel();
    private JPasswordField txtPassword = new JPasswordField();
    private JButton btnSubmit = new JButton();
    private JLabel lblForgot = new JLabel();

    private void onClickSubmit(ActionEvent ev){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;    
        
        String username = txtUsername.getText() + "";
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Username");
        }
        else{
            String sql = "SELECT * FROM petugas WHERE id_petugas=? AND password=?";
            try{
                 con = DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan","root","");
                 pst = con.prepareStatement(sql);
                 pst.setString(1, txtUsername.getText());
                 pst.setString(2, new String(txtPassword.getPassword()));
                 
                 rs = pst.executeQuery();
                 if(rs.next()){
                    dispose(); // untuk close
                    JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
                    MainMenuFrame mmFrame = new MainMenuFrame();
                    mmFrame.setVisible(true);
                 } 
                 else{
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                 }
            } 
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public void ChangePassword(String id, String em){
        Connection con2 = null;
        PreparedStatement pst2 = null;
        ResultSet rs2 = null; 
        
        String sql = "SELECT * FROM petugas WHERE id_petugas=? AND email=?";
        try{
            con2 = DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan","root","");
            pst2 = con2.prepareStatement(sql);
            pst2.setString(1, id);
            pst2.setString(2, em);

            rs2 = pst2.executeQuery();
            if(rs2.next()){
                String newPass = JOptionPane.showInputDialog("Please Enter New Password..");
                String newPassConfirm = JOptionPane.showInputDialog("Re-enter New Password..");
                
//                if(newPass != newPassConfirm){
                if(newPass.equals(newPassConfirm)){
                    String sql2 = "UPDATE petugas SET password=? WHERE id_petugas=?";
                    con2 = DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan","root","");
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
}
