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
    private JLabel label6pnl1;
    private JLabel label7pnl1;
    private JLabel label8pnl1;
    private JLabel label9pnl1;
    private JLabel label10pnl1;
    
    private JPanel panel3;
    private JButton button1Pnl3;
    private JButton button2Pnl3;
    
    KonfirmasiPengembalian(Model.Buku buku){
        initComponent(buku);
    }
    
    void initComponent(Model.Buku buku){
        
        setSize(360,360);
        
        panel1 = new JPanel();
        
        panel1.setLayout(new GridLayout(5,2));
        
        label1pnl1 = new JLabel("Kode buku");
        label2pnl1 = new JLabel("Judul Buku");
        label3pnl1 = new JLabel("Kategori Buku");
        label4pnl1 = new JLabel("Tanggal Pinjam");
        label5pnl1 = new JLabel("Denda");
        label6pnl1 = new JLabel(buku.getKodeBuku());
        label7pnl1 = new JLabel(buku.getJudulBuku());
        label8pnl1 = new JLabel("Denda");
        label9pnl1 = new JLabel("Denda");
        label10pnl1 = new JLabel("Denda");
        
        panel1.add(label1pnl1);
        panel1.add(label2pnl1);
        panel1.add(label3pnl1);
        panel1.add(label4pnl1);
        panel1.add(label5pnl1);
        panel1.add(label6pnl1);
        panel1.add(label7pnl1);
        panel1.add(label8pnl1);
        panel1.add(label9pnl1);
        panel1.add(label10pnl1);
        
        add(panel1,BorderLayout.WEST);
        
        
        panel3 = new JPanel();
        button1Pnl3 = new JButton("Confirm");
        button2Pnl3 = new JButton("Cancel");
        panel3.add(button1Pnl3);
        panel3.add(button2Pnl3);
        add(panel3,BorderLayout.SOUTH);
        
    }
    
}
