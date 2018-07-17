package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListBuku extends JFrame {

    String[] arrTitle = {
            "Kode Buku", "Nama Buku", "Nama Pengarang", "Nama Penerbit", "Tahun Terbit", "Fiksi/Non-Fiksi", "Jenis"
        };

    String[][] isiPerRow = {
        {"01", "Pemrograman Java", "Alan S.", "Pustaka", "2010", "Non-Fiksi", "Pelajaran"},
        {"02", "Pemrograman C", "Alan S.", "Pustaka", "2010", "Non-Fiksi", "Pelajaran"}
    };
    
    public ListBuku() {
        initComponents();
    }

    private void onClickSubmit(MouseEvent evt) {
        if (evt.toString().equalsIgnoreCase("submit")) {
            JOptionPane.showMessageDialog(null, "Berhasil di submit");
        } else if (evt.toString().equalsIgnoreCase("edit")) {
            JOptionPane.showMessageDialog(null, "Berhasil di edit");
        } else {
            JOptionPane.showMessageDialog(null, "Berhasil di cancel");
        }
    }

    private void initComponents() {
        //frame
        this.setSize(640, 480);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("List Buku : Add or Edit");
        
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
                String[] invoke = {"test", "run"};
                MainMenuFrame.main(invoke);
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
        
        tblTabelList = new JTable(isiPerRow, arrTitle);
        jSrcoll = new JScrollPane(tblTabelList);
        tblTabelList.setFillsViewportHeight(true);
        jSrcoll.setBounds(15, 70, 755, 70);
        pnlTabel.add(jSrcoll);

        //BUTTONS
        //Add
        btnAdd = new JButton("Add");
        btnAdd.setBounds(220, 340, 100, 30); //225
        btnAdd.setMnemonic('A');
        btnAdd.setToolTipText("Click to add book's data.");
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlTabel.add(btnAdd);

        //Edit
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(450, 340, 100, 30);
        btnEdit.setMnemonic('C');
        btnEdit.setToolTipText("Click to edit book's data.");
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlTabel.add(btnEdit);
    }

    public static void main(String[] args) {
        new ListBuku().setVisible(true);
    }

    private JPanel pnlTabel;
    private JPanel pnlBtnBack;
    private JTable tblTabelList;
    private JScrollPane jSrcoll;
    private JLabel lblJudul;
    private JButton btnBack;
    private JButton btnAdd;
    private JButton btnEdit;
}
