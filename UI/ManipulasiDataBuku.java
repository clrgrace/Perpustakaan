/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author SAMUEL
 */
class ManipulasiDataBuku extends JFrame {
    
    private JPanel pnl1;
    private JButton button1pnl1;
    
    private JPanel pnl2;
    private JTable table1pnl2;
    
    private JPanel pnl3;
    private JButton button1pnl3;
    private JButton button2pnl3;
    
    ManipulasiDataBuku(){
        initComponent();
    }
    
    void initComponent(){
        setSize(500,500);
        setLocationRelativeTo(null);
        
        pnl1 = new JPanel();
        button1pnl1 = new JButton("Back");
        pnl1.add(button1pnl1);
        add(pnl1,BorderLayout.NORTH);
        
        pnl2 = new JPanel();
        table1pnl2 = new JTable(20,5);
        pnl2.add(table1pnl2);
        add(pnl2,BorderLayout.CENTER);
        
        pnl3 = new JPanel();
        button1pnl3 = new JButton("Add");
        button2pnl3 = new JButton("Edit");
        pnl3.add(button1pnl3);
        pnl3.add(button2pnl3);
        add(pnl3,BorderLayout.SOUTH);
        
    }
    
    public static void main(String[] args) {
        new ManipulasiDataBuku().setVisible(true);
    }
    
    
}
