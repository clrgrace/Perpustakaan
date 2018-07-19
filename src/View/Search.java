/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package View;

import java.awt.BorderLayout;
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
    
    private static List <Model.BukuFiksi> bookList;
    
    public Search(){
        initComponent();
    }
    
    public void initComponent(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Search");
        
        bookList = DAO.DataAkses.showBuku();
        
        panel1 = new JPanel();
        panel1.setSize(1366,200);
        labelPnl1 = new JLabel("Search Keyword");
        panel1.add(labelPnl1,BorderLayout.CENTER);
        textFieldPnl1= new JTextField(32);
        panel1.add(textFieldPnl1);
        add(panel1,BorderLayout.NORTH);
        
        panel2 = new JPanel();
        button1Pnl2 = new JButton("Title");
        button2Pnl2 = new JButton("Author");
        button3Pnl2 = new JButton("ISBN");
        button4Pnl2 = new JButton("Penerbit");
        button5Pnl2 = new JButton("Default");
        
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
        
        String book [] = {"Kode Buku","Judul Buku","Penulis","Penerbit","Tahun Terbit"};
        String bookTable[][] = new String[bookList.size()][5];
        int i = 0;
        for(Model.BukuFiksi buku : bookList){
            bookTable[i][0]= buku.getKodeBuku();
            bookTable[i][1]= buku.getJudulBuku();
            bookTable[i][2]= buku.getNamaPengarang();
            bookTable[i][3]= buku.getNamaPenerbit();
            bookTable[i][4]= String.valueOf(buku.getTahunTerbit());
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(bookTable,book);
        table1Pnl3 = new JTable();
        table1Pnl3.setModel(dtm);
        panel3 = new JScrollPane(table1Pnl3);
        panel3.setViewportView(table1Pnl3);
        add(panel3,BorderLayout.CENTER);
        
        panel4 = new JPanel();
        button1Pnl4 = new JButton("Pinjam");
        button2Pnl4 = new JButton("Find");
        panel4.add(button1Pnl4,BorderLayout.EAST);
        panel4.add(button2Pnl4,BorderLayout.EAST);
        add(panel4,BorderLayout.SOUTH);
        
    };
    
    public static void main(String[] args) {
        new Search().setVisible(true);
    }
}
