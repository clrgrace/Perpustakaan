package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * @author user
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
        
        pnlMhs = new JPanel();
        pnlMhs.setBounds(262, 50, 262, 450);
        pnlMhs.setLayout(null);
        pnlMhs.setBackground(Color.orange);
        add(pnlMhs);
        
        lblMahasiswa = new JLabel("MAHASISWA");
        lblMahasiswa.setBounds(92, 10, 75, 75);
        pnlMhs.add(lblMahasiswa);
        
        pnlTamu = new JPanel();
        pnlTamu.setBounds(524, 50, 262, 450);
        pnlTamu.setLayout(null);
        pnlTamu.setBackground(Color.yellow);
        add(pnlTamu);
        
        lblTamu = new JLabel("TAMU");
        lblTamu.setBounds(115, 10, 75, 75);
        pnlTamu.add(lblTamu);
    }
    
    public static void main(String[] args) {
        new MenuPendaftaran().setVisible(true);
    }
    
}
