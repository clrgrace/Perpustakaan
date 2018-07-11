/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package UI;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author SAMUEL
 */
class AddAndEdit extends JFrame{
    
    private JPanel pnl1;
    private JLabel label1pnl1;
    private JTextField txt1pnl1;
    
    private JPanel pnl2;
    private JLabel label1pnl2;
    private JTextField txt1pnl2;
    
    private JPanel pnl3;
    private JLabel label1pnl3;
    private JTextField txt1pnl3;
    
    private JPanel pnl4;
    private JLabel label1pnl4;
    private JTextField txt1pnl4;
    
    private JPanel pnl5;
    private JLabel label1pnl5;
    
    private JPanel pnl6;
    private JLabel label1pnl6;
    
    private JPanel pnl7;
    private JLabel label1pnl7;
    private JTextField txt1pnl7;
    private JButton button1pnl7;
    private JButton button2pnl7;
    
    
    AddAndEdit(){
        initComponent();
    }
    void initComponent(){
        
        setSize(300,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7,2));
        
        pnl1 = new JPanel();
        label1pnl1 = new JLabel("Kode Buku");
        txt1pnl1 = new JTextField(6);
        pnl1.add(label1pnl1);
        pnl1.add(txt1pnl1);
        add(pnl1);
        
        pnl2 = new JPanel();
        label1pnl2 = new JLabel("Judul Buku");
        txt1pnl2 = new JTextField(6);
        pnl2.add(label1pnl2);
        pnl2.add(txt1pnl2);
        add(pnl2);
        
        pnl3 = new JPanel();
        label1pnl3 = new JLabel("Nama Pengarang");
        txt1pnl3 = new JTextField(6);
        pnl3.add(label1pnl3);
        pnl3.add(txt1pnl3);
        add(pnl3);
        
        pnl4 = new JPanel();
        label1pnl4 = new JLabel("Nama Penerbit");
        txt1pnl4 = new JTextField(6);
        pnl4.add(label1pnl4);
        pnl4.add(txt1pnl4);
        add(pnl4);
        
        pnl5 = new JPanel();
        label1pnl5 = new JLabel("Tahun Terbit");
        
        pnl5.add(label1pnl5);
        add(pnl5);
        
        pnl6 = new JPanel();
        
        
        pnl7 = new JPanel();
        button1pnl7= new JButton("Confirm");
        button2pnl7= new JButton("Cancel");
        pnl7.add(button1pnl7);
        pnl7.add(button2pnl7);
        add(pnl7);
        
    };
    
    public static void main(String[] args) {
        new AddAndEdit().setVisible(true);
    }
}
