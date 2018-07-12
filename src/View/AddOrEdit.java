package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AddOrEdit extends JFrame {

    public AddOrEdit() {
        initComponents();
    }

    private void onClickSubmit(MouseEvent evt) {
        if (evt.toString().equalsIgnoreCase("submit")) {
            JOptionPane.showMessageDialog(null, "Berhasil di submit");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal di submit");
        }
    }

    private void onClickCancel(MouseEvent evt) {
        if (evt.toString().equalsIgnoreCase("submit")) {
            JOptionPane.showMessageDialog(null, "Berhasil di cancel");
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);

        setTitle("Add or Edit Buku");

        getContentPane().setLayout(null);

        pnlPanel1 = new JPanel();
        pnlPanel1.setSize(700, 400);
        add(pnlPanel1);

        lblLabelKodeBuku = new JLabel("Kode Buku : ");
        pnlPanel1.add(lblLabelKodeBuku);
        txtTextFieldKodeBuku = new JTextField(10);
        pnlPanel1.add(txtTextFieldKodeBuku);

        lblLabelJudulBuku = new JLabel("Judul Buku : ");
        pnlPanel1.add(lblLabelJudulBuku);
        txtTextFieldJudulBuku = new JTextField(50);
        pnlPanel1.add(txtTextFieldJudulBuku);

        lblLabelNamaPengarang = new JLabel("Nama Pengarang : ");
        pnlPanel1.add(lblLabelNamaPengarang);
        txtTextFieldNamaPengarang = new JTextField(20);
        pnlPanel1.add(txtTextFieldNamaPengarang);

        lblLabelNamaPenerbit = new JLabel("Nama Penerbit : ");
        pnlPanel1.add(lblLabelNamaPenerbit);
        txtTextFieldJNamaPenerbit = new JTextField(20);
        pnlPanel1.add(txtTextFieldJNamaPenerbit);

        lblLabelTahunTerbit = new JLabel("Tahun Terbit : ");
        pnlPanel1.add(lblLabelTahunTerbit);
        txtTextFieldTahunTerbit = new JTextField(4);
        pnlPanel1.add(txtTextFieldTahunTerbit);

        lblLabelFiksiAtauNon = new JLabel("Fiksi/Non-Fiksi : ");
        pnlPanel1.add(lblLabelFiksiAtauNon);
        Object[] arrPilih1 = {"Fiksi", "Non-Fiksi"};
        pilihanFiksiAtauNon = new JComboBox(arrPilih1);
        pnlPanel1.add(pilihanFiksiAtauNon);

        lblLabelJenis = new JLabel("Jenis : ");
        pnlPanel1.add(lblLabelJenis);
        if (pilihanFiksiAtauNon.getSelectedItem().toString().equalsIgnoreCase("fiksi")) {
            Object[] arrPilih2 = {"Novel", "Cerpen", "Puisi", "Komik"};
            pilihanJenis = new JComboBox(arrPilih2);
        } else {
            Object[] arrPilih2 = {"Pelajaran", "Biografi", "Jurnal", "Berita"};
            pilihanJenis = new JComboBox(arrPilih2);
        }
        pnlPanel1.add(pilihanJenis);

        btnSubmit = new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(120, 20));
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickSubmit(e);
            }
        });
        pnlPanel1.add(btnSubmit);

        btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(120, 20));
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClickCancel(e);
            }
        });
        pnlPanel1.add(btnCancel);

    }

    public static void main(String[] args) {
        new AddOrEdit().setVisible(true);
    }

    private JPanel pnlPanel1;
    private JLabel lblLabelKodeBuku;
    private JTextField txtTextFieldKodeBuku;
    private JLabel lblLabelJudulBuku;
    private JTextField txtTextFieldJudulBuku;
    private JLabel lblLabelNamaPengarang;
    private JTextField txtTextFieldNamaPengarang;
    private JLabel lblLabelNamaPenerbit;
    private JTextField txtTextFieldJNamaPenerbit;
    private JLabel lblLabelTahunTerbit;
    private JTextField txtTextFieldTahunTerbit;
    private JLabel lblLabelFiksiAtauNon;
    private JComboBox pilihanFiksiAtauNon;
    private JLabel lblLabelJenis;
    private JComboBox pilihanJenis;
    private JButton btnSubmit;
    private JButton btnCancel;
}
