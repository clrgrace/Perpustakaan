package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class HistoryPeminjaman extends JFrame {
    
    private JPanel pnlBtnBack;
    private JPanel pnlTabel;
    private JButton btnBack;
    private JLabel lblJudul;
    private JTable tblListBuku;
    
    Object [][] data = {
        {"1", "Buku A", "3"},
        {"2", "Buku B", "2"},
        {"3", "Buku C", "1"}
    };
    String [] colNames = {"No.", "List Buku", "Qty."};
    
    public HistoryPeminjaman(){
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
        
        lblJudul = new JLabel("List Buku Perpustakaan");
        lblJudul.setBounds(325, 10, 150, 50);
        pnlTabel.add(lblJudul);
        
        tblListBuku = new JTable(data, colNames);
        tblListBuku.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblListBuku);
        scrollPane.setBounds(15, 70, 755, 150);
        pnlTabel.add(scrollPane);
    }
    
    public static void main(String[] args) {
        new HistoryPeminjaman().setVisible(true);
    }
    
}
