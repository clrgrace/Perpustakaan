/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author SAMUEL
 */
class Pengembalian extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1pnl1;
    private JButton button1pnl1;
    private JButton button2pnl1;
    private JTextField txt1pnl1;
    
    Pengembalian(){
        initComponent();
    }
    
    void initComponent(){
        this.setSize(300,150);
        this.setLocationRelativeTo(null);
        this.setTitle("Search Buku : Pengembalian");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.yellow);
        label1pnl1= new JLabel("Kode Buku");
        button1pnl1 = new JButton("Confirm");
        button2pnl1 = new JButton("Cancel");
        txt1pnl1 = new JTextField(16);
        
        panel1.add(label1pnl1);
        panel1.add(txt1pnl1);
        
        panel2 = new JPanel();
        panel2.setBackground(Color.yellow);
        button1pnl1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Function.Function_PengembalianBuku pengembalian = new Function.Function_PengembalianBuku();
                Model.Buku buku = pengembalian.Pengembalian(txt1pnl1.getText());
                if(buku.getKodeBuku() == null){
                    JOptionPane.showMessageDialog(null,"Kode Buku Tidak Ada");
                }
                else{
                    KonfirmasiPengembalian confirm = new KonfirmasiPengembalian(buku);
                    confirm.setVisible(true);
                    dispose();
                }
            }
        });
        button2pnl1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                dispose();
            }
        });
        panel2.add(button1pnl1);
        panel2.add(button2pnl1);
        add(panel1);
        add(panel2,BorderLayout.SOUTH);
    }

}
