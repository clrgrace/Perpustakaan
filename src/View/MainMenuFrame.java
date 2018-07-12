package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author JC Krisna
 */
public class MainMenuFrame extends JFrame{
    
     public MainMenuFrame(){
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setBackground(new Color(183, 157, 73));
        this.setTitle("Perpustakaan");
        this.getContentPane().setLayout(null); // jpanel position
    
        lblUser = new JLabel("Welcome to Library, ");
        lblUser.setBounds(35, 2, 200, 100);
        lblUser.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUser);
        
        lblTitle = new JLabel("MENU");
        lblTitle.setBounds(380, 100, 200, 100);
        lblTitle.setFont(new Font("Broadway",Font.BOLD,40));
        add(lblTitle);
        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(750, 25, 100, 50); // x, y, width, height
        add(btnLogout);
        
        lblIcon1 = new JLabel();
        lblIcon1.setBounds(90, 200, 200, 200);
        lblIcon1.setIcon(new ImageIcon(resizeImage("icon/a.png")));
        add(lblIcon1);
        
        lblDesc1 = new JLabel("Add Book");
        lblDesc1.setBounds(80, 262, 200, 200);
        lblDesc1.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc1);
        
        lblIcon2= new JLabel();
        lblIcon2.setBounds(250, 200, 200, 200);
        lblIcon2.setIcon(new ImageIcon(resizeImage("icon/b.png")));
        add(lblIcon2);
        
        lblDesc2 = new JLabel("Register");
        lblDesc2.setBounds(240, 262, 200, 200);
        lblDesc2.setFont(new Font("Britannic Bold",Font.BOLD,21));
        add(lblDesc2);
        
        lblIcon3 = new JLabel();
        lblIcon3.setBounds(400, 200, 200, 200);
        lblIcon3.setIcon(new ImageIcon(resizeImage("icon/c.png")));
        add(lblIcon3);
        
        lblDesc3 = new JLabel("Borrow Book");
        lblDesc3.setBounds(373, 262, 200, 200);
        lblDesc3.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc3);
        
        lblIcon4 = new JLabel();
        lblIcon4.setBounds(560, 200, 200, 200);
        lblIcon4.setIcon(new ImageIcon(resizeImage("icon/d.png")));
        add(lblIcon4);
        
        lblDesc4 = new JLabel("Return Book");
        lblDesc4.setBounds(540, 262, 200, 200);
        lblDesc4.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc4);
        
        lblIcon5 = new JLabel();
        lblIcon5.setBounds(710, 200, 200, 200);
        lblIcon5.setIcon(new ImageIcon(resizeImage("icon/e.png")));
        add(lblIcon5);
        
        lblDesc5 = new JLabel("History");
        lblDesc5.setBounds(710, 262, 200, 200);
        lblDesc5.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc5);
    }
    
    public static void main(String[] args) {
        new MainMenuFrame().setVisible(true);
    }
    
    private JLabel lblUser = new JLabel();
    private JLabel lblTitle = new JLabel();
    private JButton btnLogout = new JButton();
    private JLabel lblIcon1 = new JLabel();
    private JLabel lblIcon2 = new JLabel();
    private JLabel lblIcon3 = new JLabel();
    private JLabel lblIcon4 = new JLabel();
    private JLabel lblIcon5 = new JLabel();
    private JLabel lblDesc1 = new JLabel();
    private JLabel lblDesc2 = new JLabel();
    private JLabel lblDesc3 = new JLabel();
    private JLabel lblDesc4 = new JLabel();
    private JLabel lblDesc5 = new JLabel();
    
    private Image resizeImage(String url){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        } catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
}
