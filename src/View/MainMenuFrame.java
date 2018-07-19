package View;

import DAO.DataAkses;
import Model.Petugas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        lblUser.setBounds(35, 2, 450, 100);
        lblUser.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUser);
        
        lblTitle = new JLabel("MENU");
        lblTitle.setBounds(380, 100, 200, 100);
        lblTitle.setFont(new Font("Broadway",Font.BOLD,40));
        add(lblTitle);
        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(750, 25, 100, 50); // x, y, width, height
        add(btnLogout);
        
        btnLogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(DataAkses.logOut()){
                    dispose();
                    JOptionPane.showMessageDialog(null, "Thankyou for using this program");
                    LoginFrame loginf = new LoginFrame();
                    loginf.setVisible(true);
                }
            }
        });
        
        lblIcon1 = new JLabel();
        lblIcon1.setBounds(90, 250, 80, 90);
        lblIcon1.setIcon(new ImageIcon(resizeImage("icon/a.png")));
        lblIcon1.setToolTipText("<HTML><H3>Add Book<H3></HTML>");
        add(lblIcon1);
        
        lblDesc1 = new JLabel("Add Book");
        lblDesc1.setBounds(80, 262, 200, 200);
        lblDesc1.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc1);
        
        lblIcon1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                dispose();
                new AddEditFrame().setVisible(true);
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
        
        lblIcon2= new JLabel();
        lblIcon2.setBounds(250, 255, 80, 90);
        lblIcon2.setIcon(new ImageIcon(resizeImage("icon/b.png")));
        lblIcon2.setToolTipText("<HTML><H3>Register<H3></HTML>");
        add(lblIcon2);
        
        lblDesc2 = new JLabel("Register");
        lblDesc2.setBounds(240, 262, 200, 200);
        lblDesc2.setFont(new Font("Britannic Bold",Font.BOLD,21));
        add(lblDesc2);
        
        lblIcon2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "Please Input Person's Name");
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
        
        lblIcon3 = new JLabel();
        lblIcon3.setBounds(400, 250, 80, 90);
        lblIcon3.setIcon(new ImageIcon(resizeImage("icon/c.png")));
        lblIcon3.setToolTipText("<HTML><H3>Borrow a book<H3></HTML>");
        add(lblIcon3);
        
        lblDesc3 = new JLabel("Borrow Book");
        lblDesc3.setBounds(373, 262, 200, 200);
        lblDesc3.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc3);
        
        lblIcon3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "Please Input Date of Borrows");
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
        
        lblIcon4 = new JLabel();
        lblIcon4.setBounds(560, 250, 80, 90);
        lblIcon4.setIcon(new ImageIcon(resizeImage("icon/d.png")));
        lblIcon4.setToolTipText("<HTML><H3>Return Book<H3></HTML>");
        add(lblIcon4);
        
        lblDesc4 = new JLabel("Return Book");
        lblDesc4.setBounds(540, 262, 200, 200);
        lblDesc4.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc4);
        
        lblIcon4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "Please Input Date of Returns");
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
        
        lblIcon5 = new JLabel();
        lblIcon5.setBounds(710, 250, 80, 90);
        lblIcon5.setIcon(new ImageIcon(resizeImage("icon/e.png")));
        lblIcon5.setToolTipText("<HTML><H3>History<H3></HTML>");
        add(lblIcon5);
        
        lblDesc5 = new JLabel("History");
        lblDesc5.setBounds(710, 262, 200, 200);
        lblDesc5.setFont(new Font("Britannic Bold",Font.BOLD,20));
        add(lblDesc5);
        
        lblIcon5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JOptionPane.showMessageDialog(null, "This is the History Page");
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
    
//    public static void main(String[] args) {
//        new MainMenuFrame().setVisible(true);
//    }
    
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
