package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel lblBuku;
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
        
        pnlTabel = new JPanel();
        pnlTabel.setBounds(0, 50, 800, 450);
        pnlTabel.setLayout(null);
        pnlTabel.setBackground(Color.orange);
        add(pnlTabel);
        
        lblBuku = new JLabel("Buku A");
        lblBuku.setBounds(375, 0, 100, 75);
        pnlTabel.add(lblBuku);
        
        tblBuku = new JTable(data, colNames);
        tblBuku.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblBuku);
        scrollPane.setBounds(15, 70, 755, 150);
        pnlTabel.add(scrollPane);
    }
    
    public static void main(String[] args) {
        new DetailHistory().setVisible(true);
    }
    
}
