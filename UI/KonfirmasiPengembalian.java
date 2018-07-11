/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author SAMUEL
 */
class KonfirmasiPengembalian extends JFrame {
    
    private JPanel panel1;
    private JLabel label1pnl1;
    private JLabel label2pnl1;
    private JLabel label3pnl1;
    private JLabel label4pnl1;
    private JLabel label5pnl1;
    
    private JPanel panel2;
    private JButton button1Pnl2;
    private JButton button2Pnl2;
    
    KonfirmasiPengembalian(){
        initComponent();
    }
    void initComponent(){
        
        setSize(360,360);
        
        panel1 = new JPanel();
        
        panel1.setLayout(new GridLayout(5,1));
        
        label1pnl1 = new JLabel("Kode buku");
        label2pnl1 = new JLabel("Judul Buku");
        label3pnl1 = new JLabel("Kategori Buku");
        label4pnl1 = new JLabel("Tanggal Pinjam");
        label5pnl1 = new JLabel("Denda");
        
        panel1.add(label1pnl1);
        panel1.add(label2pnl1);
        panel1.add(label3pnl1);
        panel1.add(label4pnl1);
        panel1.add(label5pnl1);
        
        add(panel1,BorderLayout.WEST);
        
        panel2 = new JPanel();
        button1Pnl2 = new JButton("Confirm");
        button2Pnl2 = new JButton("Cancel");
        panel2.add(button1Pnl2);
        panel2.add(button2Pnl2);
        add(panel2,BorderLayout.SOUTH);
        
    }
    
    public static void main(String[] args) {
        new KonfirmasiPengembalian().setVisible(true);
    }
}
