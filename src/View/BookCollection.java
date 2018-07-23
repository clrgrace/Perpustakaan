package View;

import DAO.BukuDAO;
import DAO.DataAkses;
import Model.BukuFiksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JC Krisna
 */
public class BookCollection extends JFrame{
    
    public BookCollection(){
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setBackground(new Color(168, 237, 183));
        this.setTitle("Book Collection");
        this.getContentPane().setLayout(null); // jpanel position
        
        lblTitle = new JLabel("BOOK LIST");
        lblTitle.setBounds(320,0,150,100);
        lblTitle.setFont(new Font("Arial",Font.BOLD,23));
        add(lblTitle);
        
        showToTable(BukuDAO.showBuku());
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(320,420,150,40);
        add(btnUpdate);
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int kode = Integer.parseInt(JOptionPane.showInputDialog(null,"Input Kode Buku"));
                BukuDAO.updateBuku(kode);
                showToTable(BukuDAO.showBuku());
                JOptionPane.showMessageDialog(null, "Table Refreshed!");
            }
        });
        
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(320, 520, 150, 40);
        add(btnDelete);
        
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int kd = Integer.parseInt(JOptionPane.showInputDialog(null,"Input Kode Buku"));
                BukuDAO.deleteBuku(kd);
                showToTable(BukuDAO.showBuku());
                JOptionPane.showMessageDialog(null, "Table Refreshed!");
            }
        });
        
        btnBack = new JButton("Back");
        btnBack.setBounds(320, 620, 150, 40);
        add(btnBack);
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new MainMenuFrame().setVisible(true);
            }
        });
    }
    
    private void showToTable(List<BukuFiksi> listBuku){
        Object[][] arrObj = new Object[listBuku.size()][8];
        String [] colNames = {"Kode Buku", "Judul Buku", "Pengarang", "Penerbit", "Tahun", "Jenis", "Spesifikasi", "Status"};
        
        int i = 0;
        for(BukuFiksi bF : listBuku){
            arrObj[i][0] = bF.getKodeBuku();
            arrObj[i][1] = bF.getJudulBuku();
            arrObj[i][2] = bF.getNamaPengarang();
            arrObj[i][3] = bF.getNamaPenerbit();
            arrObj[i][4] = bF.getTahunTerbit();
            arrObj[i][5] = bF.getJenisBuku();
            arrObj[i][6] = bF.getJenisFiksi();
            arrObj[i][7] = bF.getAvailable();
            i++;
        }
        
        tblListBuku = new JTable(arrObj, colNames);
        tblListBuku.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tblListBuku);
        scrollPane.setBounds(15, 100, 755, 200);
        add(scrollPane);
    }
    
    public static void main(String[] args) {
        new BookCollection().setVisible(true);
    }
    
    private JTable tblListBuku;
    private JLabel lblTitle;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnBack;
}
