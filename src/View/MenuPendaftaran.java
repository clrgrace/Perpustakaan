package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author Grace
 */
public class MenuPendaftaran extends JFrame {
    
    private JPanel pnlBtnBack;
    private JPanel pnlDosen;
    private JPanel pnlMhs;
    private JPanel pnlTamu;
    private JButton btnBack;
    private JLabel lblDosen;
    private JLabel lblMahasiswa;
    private JLabel lblTamu;
    private JLabel lblIconDosen;
    private JLabel lblIconMhs;
    private JLabel lblIconTamu;
    
    public MenuPendaftaran(){
        initComponents();
    }
    
    private void initComponents(){
        //frame
        this.setSize(640, 480);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Menu Pendaftaran");
        
        //panel
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.gray);
        getContentPane().setLayout(null);
        
        pnlBtnBack = new JPanel();
        pnlBtnBack.setBounds(0, 0, 800, 50);
        pnlBtnBack.setLayout(null);
        pnlBtnBack.setBackground(Color.white);
        add(pnlBtnBack);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(15, 10, 100, 30);
        btnBack.setMnemonic('B');
        btnBack.setToolTipText("Back to previous menu.");
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        pnlBtnBack.add(btnBack);
  
        pnlDosen = new JPanel();
        pnlDosen.setBounds(0, 50, 262, 450);
        pnlDosen.setLayout(null);
        pnlDosen.setBackground(Color.yellow);
        add(pnlDosen);
        
        lblDosen = new JLabel("DOSEN");
        lblDosen.setBounds(110, 10, 75, 75);
        pnlDosen.add(lblDosen);
        
        lblIconDosen = new JLabel();
        lblIconDosen.setBounds(30, 110, 200, 200);
        lblIconDosen.setIcon(new ImageIcon(resizeImage("img/dosen.png")));
        pnlDosen.add(lblIconDosen);
        
        pnlMhs = new JPanel();
        pnlMhs.setBounds(262, 50, 262, 450);
        pnlMhs.setLayout(null);
        pnlMhs.setBackground(Color.orange);
        add(pnlMhs);
        
        lblMahasiswa = new JLabel("MAHASISWA");
        lblMahasiswa.setBounds(92, 10, 75, 75);
        pnlMhs.add(lblMahasiswa);
        
        lblIconMhs = new JLabel();
        lblIconMhs.setBounds(30, 110, 200, 200);
        lblIconMhs.setIcon(new ImageIcon(resizeImage("img/mahasiswa.png")));
        pnlMhs.add(lblIconMhs);
        
        pnlTamu = new JPanel();
        pnlTamu.setBounds(524, 50, 262, 450);
        pnlTamu.setLayout(null);
        pnlTamu.setBackground(Color.yellow);
        add(pnlTamu);
        
        lblTamu = new JLabel("TAMU");
        lblTamu.setBounds(115, 10, 75, 75);
        pnlTamu.add(lblTamu);
        
        lblIconTamu = new JLabel();
        lblIconTamu.setBounds(30, 110, 200, 200);
        lblIconTamu.setIcon(new ImageIcon(resizeImage("img/tamu.png")));
        pnlTamu.add(lblIconTamu);
    }
    
    public static void main(String[] args) {
        new MenuPendaftaran().setVisible(true);
    }
    
    private Image resizeImage(String url){
        Image dimg = null;
        try{
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        } catch(IOException ex){
            ex.printStackTrace(System.err);
        }
        return dimg;
    }
    
}
