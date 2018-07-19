package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
                dispose();
                new MainMenuFrame().setVisible(true);
            }
        });
        pnlBtnBack.add(btnBack);
  
        pnlDosen = new JPanel();
        pnlDosen.setBounds(0, 50, 262, 450);
        pnlDosen.setLayout(null);
        pnlDosen.setBackground(Color.yellow);
        add(pnlDosen);
        
        lblDosen = new JLabel("DOSEN");
        lblDosen.setBounds(100, 10, 75, 75);
        lblDosen.setFont(new Font("Impact", Font.PLAIN, 24));
        pnlDosen.add(lblDosen);
        
        lblIconDosen = new JLabel();
        lblIconDosen.setBounds(30, 110, 200, 200);
        lblIconDosen.setIcon(new ImageIcon(resizeImage("img/dosen.png")));
        lblIconDosen.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                String[] invoke = {"test", "run"};
                View.PendaftaranDosen.main(invoke);
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
        pnlDosen.add(lblIconDosen);
        
        pnlMhs = new JPanel();
        pnlMhs.setBounds(262, 50, 262, 450);
        pnlMhs.setLayout(null);
        pnlMhs.setBackground(Color.orange);
        add(pnlMhs);
        
        lblMahasiswa = new JLabel("MAHASISWA");
        lblMahasiswa.setBounds(70, 10, 125, 75);
        lblMahasiswa.setFont(new Font("Impact", Font.PLAIN, 24));
        pnlMhs.add(lblMahasiswa);
        
        lblIconMhs = new JLabel();
        lblIconMhs.setBounds(30, 110, 200, 200);
        lblIconMhs.setIcon(new ImageIcon(resizeImage("img/mahasiswa.png")));
        lblIconMhs.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                String[] invoke = {"test", "run"};
                View.PendaftaranMahasiswa.main(invoke);
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
        pnlMhs.add(lblIconMhs);
        
        pnlTamu = new JPanel();
        pnlTamu.setBounds(524, 50, 262, 450);
        pnlTamu.setLayout(null);
        pnlTamu.setBackground(Color.yellow);
        add(pnlTamu);
        
        lblTamu = new JLabel("TAMU");
        lblTamu.setBounds(100, 10, 75, 75);
        lblTamu.setFont(new Font("Impact", Font.PLAIN, 24));
        pnlTamu.add(lblTamu);
        
        lblIconTamu = new JLabel();
        lblIconTamu.setBounds(30, 110, 200, 200);
        lblIconTamu.setIcon(new ImageIcon(resizeImage("img/tamu.png")));
        lblIconTamu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                String[] invoke = {"test", "run"};
                View.PendaftaranTamu.main(invoke);
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
