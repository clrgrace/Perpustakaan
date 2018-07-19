/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author SAMUEL
 */
class Pinjam extends JFrame {
    
    private JPanel panel1;
    private JLabel label1pnl1;
    private JLabel label2pnl1;
    private JLabel label3pnl1;
    private JLabel label4pnl1;
    private JTextField txt1pnl1;
    private JTextField txt2pnl1;
    private JTextField txt3pnl1;
    private JTextField txt4pnl1;
    private JButton button1pnl1;
    private JButton button2pnl1;
    
    private JPanel panel2;
    
    Pinjam(){
        initComponent();
    }
    
    void initComponent(){
        setSize(400,200);
        setLocationRelativeTo(null);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,1));
        
        label1pnl1 = new JLabel("Kode Buku");
        txt1pnl1 = new JTextField(1);
        panel1.add(label1pnl1);
        panel1.add(txt1pnl1);
        
        label2pnl1 = new JLabel("Judul");
        txt2pnl1= new JTextField(1);
        panel1.add(label2pnl1);
        panel1.add(txt2pnl1);
        
        label3pnl1 = new JLabel("ID");
        txt3pnl1= new JTextField(1);
        panel1.add(label3pnl1);
        panel1.add(txt3pnl1);
        
        label4pnl1 = new JLabel("Tanggal Pinjam");
        txt4pnl1= new JTextField(1);
        panel1.add(label4pnl1);
        panel1.add(txt4pnl1);
        
        panel2 = new JPanel();
        
        button1pnl1 = new JButton("Confirm");
        button2pnl1 = new JButton("Cancel");
        panel2.add(button1pnl1);
        panel2.add(button2pnl1);
        
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        new Pinjam().setVisible(true);
    }
}
