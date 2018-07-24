package View;

import DAO.GenerateHistoryDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class HistoryPeminjaman extends JFrame {
    
    private JPanel pnlBtnBack;
    private JPanel pnlTabel;
    private JButton btnBack;
    private JButton btnSubmit;
    private JLabel lblJudul;
    private JLabel lblIcon;
    private JLabel lblKode;
    protected static JTextField txtKode;
    private JTable tblListBuku;
    
    String [] colNames = {"Kode Buku", "Judul Buku", "Pengarang"};
    
    public HistoryPeminjaman(){
        initComponents();
    }
    
    private void initComponents(){
        //frame
        this.setSize(640, 480);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("History Peminjaman");
        
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
        
        pnlTabel = new JPanel();
        pnlTabel.setBounds(0, 50, 800, 450);
        pnlTabel.setLayout(null);
        pnlTabel.setBackground(Color.orange);
        add(pnlTabel);
        
        lblJudul = new JLabel("List Buku Perpustakaan");
        lblJudul.setBounds(215, 10, 500, 50);
        lblJudul.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        pnlTabel.add(lblJudul);
        
        //TABLES
        tblListBuku = new JTable(DAO.GenerateHistoryDAO.genDataTableList(), colNames);
        tblListBuku.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblListBuku);
        scrollPane.setBounds(15, 70, 755, 70);
        pnlTabel.add(scrollPane);
        
        lblKode = new JLabel("Kode Buku");
        lblKode.setBounds(15, 165, 100, 30);
        pnlTabel.add(lblKode);
        
        txtKode = new JTextField(20);
        txtKode.setBounds(120, 165, 150, 30);
        pnlTabel.add(txtKode);
        
        lblIcon = new JLabel();
        lblIcon.setBounds(15, 165, 300, 300);
        lblIcon.setIcon(new ImageIcon(resizeImage("img/library4.png")));
        pnlTabel.add(lblIcon);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(650, 350, 100, 30);
        btnSubmit.setMnemonic('S');
        btnSubmit.setToolTipText("Click to submit.");
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] invoke = {"test", "run"};
                View.DetailHistory.main(invoke);
            }
        });
        pnlTabel.add(btnSubmit);
    }
    
    public static void main(String[] args) {
        new HistoryPeminjaman().setVisible(true);
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
