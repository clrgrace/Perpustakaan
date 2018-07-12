package View;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Pendaftaran extends JFrame {
    
    private JPanel pnlId;
    private JPanel pnlNama;
    private JPanel pnlJK;
    private JPanel pnlTgLahir;
    private JPanel pnlAlamat;
    private JPanel pnlNoTelp;
    private JPanel pnlEmail;
    private JPanel pnlBtnBack;
    private JPanel pnlBtnSub;
    private JButton btnBack;
    private JButton btnSubmit;
    private JLabel lblJudulForm;
    private JLabel lblId;
    private JLabel lblNama;
    private JLabel lblJK;
    private JLabel lblTgLahir;
    private JLabel lblAlamat;
    private JLabel lblNoTelp;
    private JLabel lblEmail;
    private JTextField txtId;
    private JTextField txtNama;
    private JTextField txtJK;
    private JTextField txtTgLahir;
    private JTextField txtAlamat;
    private JTextField txtNoTelp;
    private JTextField txtEmail;
    
    public Pendaftaran(){
        initComponents();
    }
    
    private void initComponents(){
        //frame
        this.setSize(720, 640);
        this.setBounds(100, 200, 200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Pendaftaran Anggota Perpustakaan");
        
        //panel
        setSize(800, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(null);
        
        //ID
        pnlId = new JPanel();
        pnlId.setBounds(5, 10, 750, 100);
        pnlId.setLayout(null);
        pnlId.setBackground(Color.white);
        add(pnlId);
        
        lblJudulForm = new JLabel("FORM PENDAFTARAN ANGGOTA PERPUSTAKAAN");
        lblJudulForm.setBounds(250, 0, 400, 30);
        pnlId.add(lblJudulForm);
        
        lblId = new JLabel("ID");
        lblId.setBounds(10, 45, 100, 35);
        pnlId.add(lblId);
        
        txtId = new JTextField(20);
        txtId.setBounds(100, 45, 300, 35);
        pnlId.add(txtId);
        
        //Nama
        pnlNama = new JPanel();
        pnlNama.setBounds(5, 60, 750, 100);
        pnlNama.setLayout(null);
        pnlNama.setBackground(Color.white);
        add(pnlNama);
        
        lblNama = new JLabel("Nama");
        lblNama.setBounds(10, 45, 100, 35);
        pnlNama.add(lblNama);
        
        txtNama = new JTextField(20);
        txtNama.setBounds(100, 45, 300, 35);
        pnlNama.add(txtNama);
        
        //Jenis Kelamin
        pnlJK = new JPanel();
        pnlJK.setBounds(5, 110, 750, 100);
        pnlJK.setLayout(null);
        pnlJK.setBackground(Color.white);
        add(pnlJK);
        
        lblJK = new JLabel("Jenis Kelamin");
        lblJK.setBounds(10, 45, 100, 35);
        pnlJK.add(lblJK);
        
        txtJK = new JTextField(20);
        txtJK.setBounds(100, 45, 300, 35);
        pnlJK.add(txtJK);
        
        //Tanggal Lahir
        pnlTgLahir = new JPanel();
        pnlTgLahir.setBounds(5, 160, 500, 100);
        pnlTgLahir.setLayout(null);
        pnlTgLahir.setBackground(Color.white);
        add(pnlTgLahir);
        
        lblTgLahir = new JLabel("<html>Tanggal Lahir<br/>(dd-mm-yyyy)<html>");
        lblTgLahir.setBounds(10, 45, 100, 35);
        pnlTgLahir.add(lblTgLahir);
        
        txtTgLahir = new JTextField(20);
        txtTgLahir.setBounds(100, 45, 300, 35);
        pnlTgLahir.add(txtTgLahir);
        
        //Alamat
        pnlAlamat = new JPanel();
        pnlAlamat.setBounds(5, 210, 750, 100);
        pnlAlamat.setLayout(null);
        pnlAlamat.setBackground(Color.white);
        add(pnlAlamat);
        
        lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(10, 45, 100, 35);
        pnlAlamat.add(lblAlamat);
        
        txtAlamat = new JTextField(20);
        txtAlamat.setBounds(100, 45, 300, 35);
        pnlAlamat.add(txtAlamat);
        
        //No. Telepon
        pnlNoTelp = new JPanel();
        pnlNoTelp.setBounds(5, 260, 750, 100);
        pnlNoTelp.setLayout(null);
        pnlNoTelp.setBackground(Color.white);
        add(pnlNoTelp);
        
        lblNoTelp = new JLabel("No. Telepon");
        lblNoTelp.setBounds(10, 45, 100, 35);
        pnlNoTelp.add(lblNoTelp);
        
        txtNoTelp = new JTextField(20);
        txtNoTelp.setBounds(100, 45, 300, 35);
        pnlNoTelp.add(txtNoTelp);
        
        //Email
        pnlEmail = new JPanel();
        pnlEmail.setBounds(5, 310, 750, 100);
        pnlEmail.setLayout(null);
        pnlEmail.setBackground(Color.white);
        add(pnlEmail);
        
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 45, 100, 35);
        pnlEmail.add(lblEmail);
        
        txtEmail = new JTextField(20);
        txtEmail.setBounds(100, 45, 300, 35);
        pnlEmail.add(txtEmail);
        
        
        //BUTTONS
        //Back
        pnlBtnBack = new JPanel();
        pnlBtnBack.setBounds(5, 370, 500, 100);
        pnlBtnBack.setLayout(null);
        pnlBtnBack.setBackground(Color.white);
        add(pnlBtnBack);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(175, 45, 100, 30);
        btnBack.setMnemonic('B');
        btnBack.setToolTipText("Back to previous menu.");
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] invoke = {"Menu", "Person"};
                View.MenuPendaftaran.main(invoke);
            }
        });
        pnlBtnBack.add(btnBack);
        
        //Submit
        pnlBtnSub = new JPanel();
        pnlBtnSub.setBounds(105, 370, 500, 100);
        pnlBtnSub.setLayout(null);
        pnlBtnSub.setBackground(Color.white);
        add(pnlBtnSub);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(400, 45, 100, 30);
        btnSubmit.setMnemonic('S');
        btnSubmit.setToolTipText("Click this button to submit your registration.");
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Data has been successfully submitted!");
            }
        });
        pnlBtnSub.add(btnSubmit);
    }
    
    public static void main(String[] args) {
        new Pendaftaran().setVisible(true);
    }
    
}
