package View;

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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class DetailHistory extends JFrame {
    
    private JPanel pnlBtnBack;
    private JPanel pnlTabel;
    private JButton btnBack;
    private JButton btnOk;
    private JLabel lblBuku;
    private JLabel lblIcon;
    private JTable tblBuku;
    
    Object [][] data = {
        {"1", "1217001", "X", "2 Maret 2018"},
        {"2", "1315025", "Y", "3 Mei 2018"},
        {"3", "1114007", "Z", "16 Mei 2018"}
    };
    String [] colNames = {"No.", "ID Peminjam", "Nama Peminjam", "Tanggal Pinjam"};
    
    public DetailHistory(){
        initComponents();
    }
    
    private void initComponents(){
        //frame
        this.setSize(640, 480);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("History Peminjaman");
        
        //panel
        setSize(800, 550);
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
                String[] invoke = {"test", "run"};
                View.HistoryPeminjaman.main(invoke);
            }
        });
        pnlBtnBack.add(btnBack);
        
        pnlTabel = new JPanel();
        pnlTabel.setBounds(0, 50, 800, 500);
        pnlTabel.setLayout(null);
        pnlTabel.setBackground(Color.orange);
        add(pnlTabel);
        
        lblBuku = new JLabel("Buku A");
        lblBuku.setBounds(320, 0, 200, 70);
        lblBuku.setFont(new Font("Kristen ITC", Font.BOLD, 32));
        pnlTabel.add(lblBuku);
        
        tblBuku = new JTable(data, colNames);
        tblBuku.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblBuku);
        scrollPane.setBounds(15, 70, 755, 70);
        pnlTabel.add(scrollPane);
        
        lblIcon = new JLabel();
        lblIcon.setBounds(15, 195, 300, 300);
        lblIcon.setIcon(new ImageIcon(resizeImage("img/boxes.jpg")));
        pnlTabel.add(lblIcon);
        
        btnOk = new JButton("OK");
        btnOk.setBounds(650, 400, 100, 30);
        btnOk.setMnemonic('O');
        btnOk.setToolTipText("Click OK to return to the list of books.");
        btnOk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] invoke = {"test", "run"};
                MainMenuFrame.main(invoke);
            }
        });
        pnlTabel.add(btnOk);
    }
    
    public static void main(String[] args) {
        new DetailHistory().setVisible(true);
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
