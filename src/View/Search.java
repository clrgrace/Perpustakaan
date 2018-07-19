/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMUEL
 */

class Search extends JFrame{
    
    private JPanel panel1;
    private JLabel labelPnl1;
    private JTextField textFieldPnl1;
    
    private JPanel panel2;
    private JButton button1Pnl2;
    private JButton button2Pnl2;
    private JButton button3Pnl2;
    private JButton button4Pnl2;
    private JButton button5Pnl2;
    
    private JScrollPane panel3;
    private JTable table1Pnl3;
    
    private JPanel panel4;
    private JButton button1Pnl4;
    private JButton button2Pnl4;
    
    private JPanel panel5;
    
    private static List <Model.BukuFiksi> bookList;
    
    public Search(List <Model.BukuFiksi> bookList){
        this.bookList = bookList;
        initComponent(bookList);
    }
    
    void bookTable(List <Model.BukuFiksi> bookList){
        String book [] = {"Kode Buku","Judul Buku","Penulis","Penerbit","Avaibility"};
        String buku[][] = new String[bookList.size()][5];
        
        int i = 0;
        for(Model.BukuFiksi bookL : bookList){
            buku[i][0]= bookL.getKodeBuku();
            buku[i][1]= bookL.getJudulBuku();
            buku[i][2]= bookL.getNamaPengarang();
            buku[i][3]= bookL.getNamaPenerbit();
            buku[i][4]= DAO.DataAkses.checkAvaiblity(bookL.getKodeBuku());
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(buku,book);
        
        table1Pnl3 = new JTable();
        table1Pnl3.setModel(dtm);
        panel3 = new JScrollPane(table1Pnl3);
        panel3.setViewportView(table1Pnl3);
        panel3.setBackground(Color.ORANGE);
        add(panel3,BorderLayout.CENTER);
        
    }
    
    public void initComponent(List <Model.BukuFiksi> BookList){
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Search");
        
        panel1 = new JPanel();
        panel1.setSize(1366,200);
        labelPnl1 = new JLabel("Search Keyword");
        panel1.add(labelPnl1,BorderLayout.CENTER);
        textFieldPnl1= new JTextField(32);
        panel1.add(textFieldPnl1);
        panel1.setBackground(Color.ORANGE);
        add(panel1,BorderLayout.NORTH);
        
        panel2 = new JPanel();
        button1Pnl2 = new JButton("Title");
        button2Pnl2 = new JButton("Author");
        button3Pnl2 = new JButton("Kode Buku");
        button4Pnl2 = new JButton("Penerbit");
        button5Pnl2 = new JButton("Default");
        
        panel2.setBackground(Color.ORANGE);
        button1Pnl2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList = DAO.DataAkses.showBuku("judul_buku",textFieldPnl1.getText());
                
            }
        });
        button2Pnl2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList = DAO.DataAkses.showBuku("nama_pengarang",textFieldPnl1.getText());
                
            }
        });
        button3Pnl2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList = DAO.DataAkses.showBuku("kode_buku",textFieldPnl1.getText());
                
            }
        });
        button4Pnl2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList = DAO.DataAkses.showBuku("nama_penerbit",textFieldPnl1.getText());
                
            }
        });
        button5Pnl2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bookList = DAO.DataAkses.showBuku();
                
            }
        });
        
        panel2.setLayout(new GridLayout(5,1));
        panel2.add(button1Pnl2);
        panel2.add(button2Pnl2);
        panel2.add(button3Pnl2);
        panel2.add(button4Pnl2);
        panel2.add(button5Pnl2);
        add(panel2,BorderLayout.WEST);
        
        bookTable(bookList);
        
        panel4 = new JPanel();
        button1Pnl4 = new JButton("Pinjam");
        button1Pnl4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Pinjam lend = new Pinjam();
                lend.setVisible(true);
            }
        });
        button2Pnl4 = new JButton("Find");
        button2Pnl4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Search(bookList).setVisible(true);
                dispose();
            }
        });
        panel4.add(button1Pnl4);
        panel4.add(button2Pnl4);
        panel4.setBackground(Color.ORANGE);
        add(panel4,BorderLayout.SOUTH);
        
        panel5 = new JPanel();
        panel5.setBackground(Color.ORANGE);
        add(panel5,BorderLayout.EAST);
    }
    
}
