package View;

import DAO.BukuDAO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class AddBuku extends JFrame {

    public AddBuku() {
        initComponents();
    }

    private void initComponents() {
        //frame
        this.setSize(720, 640);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Add Buku");
        
        //panel
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.orange);
        getContentPane().setLayout(null);

        //Kode Buku
        pnlKode = new JPanel();
        pnlKode.setBounds(5, 10, 750, 100);
        pnlKode.setLayout(null);
        pnlKode.setBackground(Color.orange);
        add(pnlKode);
        
        lblJudul = new JLabel("ADD BUKU PERPUSTAKAAN");
        lblJudul.setBounds(275, 0, 400, 30);
        pnlKode.add(lblJudul);
        
        lblLabelKodeBuku = new JLabel("Kode Buku");
        lblLabelKodeBuku.setBounds(10, 45, 100, 35);
        pnlKode.add(lblLabelKodeBuku);
        
        txtTextFieldKodeBuku = new JTextField(20);
        txtTextFieldKodeBuku.setBounds(100, 45, 300, 35);
        pnlKode.add(txtTextFieldKodeBuku);

        //Judul Buku
        pnlJudul = new JPanel();
        pnlJudul.setBounds(5, 60, 500, 100);
        pnlJudul.setLayout(null);
        pnlJudul.setBackground(Color.orange);
        add(pnlJudul);
        
        lblLabelJudulBuku = new JLabel("Judul Buku");
        lblLabelJudulBuku.setBounds(10, 45, 100, 35);
        pnlJudul.add(lblLabelJudulBuku);
        
        txtTextFieldJudulBuku = new JTextField(20);
        txtTextFieldJudulBuku.setBounds(100, 45, 300, 35);
        pnlJudul.add(txtTextFieldJudulBuku);

        //Nama Pengarang
        pnlPengarang = new JPanel();
        pnlPengarang.setBounds(5, 110, 500, 100);
        pnlPengarang.setLayout(null);
        pnlPengarang.setBackground(Color.orange);
        add(pnlPengarang);
        
        lblLabelNamaPengarang = new JLabel("<html>Nama<br />Pengarang<html>");
        lblLabelNamaPengarang.setBounds(10, 45, 100, 35);
        pnlPengarang.add(lblLabelNamaPengarang);
        
        txtTextFieldNamaPengarang = new JTextField(20);
        txtTextFieldNamaPengarang.setBounds(100, 45, 300, 35);
        pnlPengarang.add(txtTextFieldNamaPengarang);

        //Nama Penerbit
        pnlPenerbit = new JPanel();
        pnlPenerbit.setBounds(5, 160, 500, 100);
        pnlPenerbit.setLayout(null);
        pnlPenerbit.setBackground(Color.orange);
        add(pnlPenerbit);
        
        lblLabelNamaPenerbit = new JLabel("Nama Penerbit");
        lblLabelNamaPenerbit.setBounds(10, 45, 100, 35);
        pnlPenerbit.add(lblLabelNamaPenerbit);
        
        txtTextFieldJNamaPenerbit = new JTextField(20);
        txtTextFieldJNamaPenerbit.setBounds(100, 45, 300, 35);
        pnlPenerbit.add(txtTextFieldJNamaPenerbit);

        //Tahun Terbit
        pnlThnTerbit = new JPanel();
        pnlThnTerbit.setBounds(5, 210, 500, 100);
        pnlThnTerbit.setLayout(null);
        pnlThnTerbit.setBackground(Color.orange);
        add(pnlThnTerbit);
        
        lblLabelTahunTerbit = new JLabel("Tahun Terbit");
        lblLabelTahunTerbit.setBounds(10, 45, 100, 35);
        pnlThnTerbit.add(lblLabelTahunTerbit);
        
        txtTextFieldTahunTerbit = new JTextField(20);
        txtTextFieldTahunTerbit.setBounds(100, 45, 300, 35);
        pnlThnTerbit.add(txtTextFieldTahunTerbit);

        //Pilih Fiksi / Non Fiksi
        pnlFiksiOrNon = new JPanel();
        pnlFiksiOrNon.setBounds(5, 260, 500, 100);
        pnlFiksiOrNon.setLayout(null);
        pnlFiksiOrNon.setBackground(Color.orange);
        add(pnlFiksiOrNon);
        
        lblLabelFiksiAtauNon = new JLabel("Fiksi/NonFiksi");
        lblLabelFiksiAtauNon.setBounds(10, 45, 100, 35);
        pnlFiksiOrNon.add(lblLabelFiksiAtauNon);
        
        Object[] arrPilih1 = {"Fiksi", "NonFiksi"};
        pilihanFiksiAtauNon = new JComboBox(arrPilih1);
        pilihanFiksiAtauNon.setBounds(100, 45, 300, 35);
        pnlFiksiOrNon.add(pilihanFiksiAtauNon);

        //Jenis Buku
        pnlJenis = new JPanel();
        pnlJenis.setBounds(5, 310, 500, 100);
        pnlJenis.setLayout(null);
        pnlJenis.setBackground(Color.orange);
        add(pnlJenis);
        
        lblLabelJenis = new JLabel("Jenis");
        lblLabelJenis.setBounds(10, 45, 100, 35);
        pnlJenis.add(lblLabelJenis);
        
        txtJenis = new JTextField(20);
        txtJenis.setBounds(100, 45, 300, 35);
        pnlJenis.add(txtJenis);

        
        //BUTTONS
        //Submit
        pnlBtnSubmit = new JPanel();
        pnlBtnSubmit.setBounds(5, 370, 500, 100);
        pnlBtnSubmit.setLayout(null);
        pnlBtnSubmit.setBackground(Color.orange);
        add(pnlBtnSubmit);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(175, 45, 100, 30);
        btnSubmit.setMnemonic('S');
        btnSubmit.setToolTipText("Submit book's data.");
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String kdB = txtTextFieldKodeBuku.getText();
                String jdlB = txtTextFieldJudulBuku.getText();
                String nmPgr = txtTextFieldNamaPengarang.getText();
                String nmPbt = txtTextFieldJNamaPenerbit.getText();
                String thnTbt = txtTextFieldTahunTerbit.getText();
                String genre = pilihanFiksiAtauNon.getSelectedItem().toString();
                String jenis = txtJenis.getText();
                
                if(BukuDAO.addBuku(kdB,jdlB,nmPgr,nmPbt,thnTbt,genre,jenis)){
                    JOptionPane.showMessageDialog(null, "Add Buku Sukses!");
                    dispose();
                    new MainMenuFrame().setVisible(true);
                }
            }
        });
        pnlBtnSubmit.add(btnSubmit);

        //Cancel
        pnlBtnCancel = new JPanel();
        pnlBtnCancel.setBounds(105, 370, 500, 100);
        pnlBtnCancel.setLayout(null);
        pnlBtnCancel.setBackground(Color.orange);
        add(pnlBtnCancel);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(400, 45, 100, 30);
        btnCancel.setMnemonic('C');
        btnCancel.setToolTipText("Cancel to add / edit book's data.");
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new MainMenuFrame().setVisible(true);
            }
        });
        pnlBtnCancel.add(btnCancel);

    }
    
    private JPanel pnlKode;
    private JPanel pnlJudul;
    private JPanel pnlPengarang;
    private JPanel pnlPenerbit;
    private JPanel pnlThnTerbit;
    private JPanel pnlFiksiOrNon;
    private JPanel pnlJenis;
    private JPanel pnlBtnSubmit;
    private JPanel pnlBtnCancel;
    private JLabel lblJudul;
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
    private JTextField txtJenis;
//    private JComboBox pilihanJenis;
    private JButton btnSubmit;
    private JButton btnCancel;
}
