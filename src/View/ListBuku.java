package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class ListBuku extends JFrame {

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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);

        setTitle("List Buku");

        getContentPane().setLayout(null);

        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(700, 200);
        add(pnlPanel1);

        String[] arrTitle = {
            "Kode Buku", "Nama Buku", "Nama Pengarang", "Nama Penerbit", "Tahun Terbit", "Fiksi/Non-Fiksi", "Jenis"
        };

        String[][] isiPerRow = {
            {"01", "Pemrograman Java", "Alan S.", "Pustaka", "2010", "Non-Fiksi", "Pelajaran"},
            {"02", "Pemrograman C", "Alan S.", "Pustaka", "2010", "Non-Fiksi", "Pelajaran"}
        };

        tblTabelList = new JTable(isiPerRow, arrTitle);

        jSrcoll = new JScrollPane(tblTabelList);
        tblTabelList.setFillsViewportHeight(true);
        pnlPanel1.add(jSrcoll);

        jSrcoll.setLocation(0, 0);
        jSrcoll.setSize(new Dimension(200, 100));

        pnlPanel2 = new JPanel();
        pnlPanel2.setSize(700, 200);
        add(pnlPanel2);

        btnAdd = new JButton("Submit");
        btnAdd.setPreferredSize(new Dimension(120, 20));
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlPanel2.add(btnAdd);

        btnEdit = new JButton("Submit");
        btnEdit.setPreferredSize(new Dimension(120, 20));
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlPanel2.add(btnEdit);

        btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(120, 20));
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlPanel2.add(btnCancel);
    }

    public static void main(String[] args) {
        new ListBuku().setVisible(true);
    }

    private JPanel pnlPanel1;
    private JTable tblTabelList;
    private JScrollPane jSrcoll;
    private JPanel pnlPanel2;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnCancel;
}
