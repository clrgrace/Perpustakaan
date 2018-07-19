/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

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
    
    private JPanel panel4;
    private JPanel panel5;
    
    KonfirmasiPengembalian(Model.Buku buku){
        initComponent(buku);
    }
    
    void initComponent(Model.Buku buku){
        this.setTitle("Konfirmasi Pengembalian Buku");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(360,360);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.orange);
        panel1.setLayout(new GridLayout(5,2));
        
        label1pnl1 = new JLabel("Kode buku");
        label2pnl1 = new JLabel("Judul Buku");
        label3pnl1 = new JLabel("Kategori Buku");
        label4pnl1 = new JLabel("Tanggal Pinjam");
        label5pnl1 = new JLabel("Denda");
        label6pnl1 = new JLabel(buku.getKodeBuku());
        label7pnl1 = new JLabel(buku.getJudulBuku());
        label8pnl1 = new JLabel("");
        label9pnl1 = new JLabel("");
        label10pnl1 = new JLabel("Denda");
        
        panel1.add(label1pnl1);
        panel1.add(label6pnl1);
        panel1.add(label2pnl1);
        panel1.add(label7pnl1);
        panel1.add(label3pnl1);
        panel1.add(label8pnl1);
        panel1.add(label4pnl1);
        panel1.add(label9pnl1);
        panel1.add(label5pnl1);
        panel1.add(label10pnl1);
        
        add(panel1,BorderLayout.WEST);
        
        
        panel3 = new JPanel();
        panel3.setBackground(Color.orange);
        button1Pnl3 = new JButton("Confirm");
        button1Pnl3.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               DAO.DataAkses.deleteTranksaksi(Integer.parseInt(label6pnl1.getText()));
               DAO.DataAkses.updateAvaiblity("Y",label6pnl1.getText());
               dispose();
           }
        });
        button2Pnl3 = new JButton("Cancel");
        button2Pnl3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
        panel3.add(button1Pnl3);
        panel3.add(button2Pnl3);
        add(panel3,BorderLayout.SOUTH);
        
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel4.setBackground(Color.ORANGE);
        panel5.setBackground(Color.ORANGE);
        add(panel4,BorderLayout.CENTER);
        add(panel5,BorderLayout.EAST);
    }
    
}
