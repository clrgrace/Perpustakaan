package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author JC Krisna
 */
public class AddEditFrame extends JFrame{
    
    public AddEditFrame(){
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        
        this.setTitle("Add or Edit?");
        this.setBackground(Color.GRAY);
        this.getContentPane().setLayout(null);
        
        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBounds(0,25,400,100);
        pnl1.setBackground(Color.darkGray);
        add(pnl1);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(35, 30, 100, 40);
        pnl1.add(btnAdd);
        
        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new AddBuku().setVisible(true);
            }
        });
        
        btnEdit = new JButton("Book Collection");
        btnEdit.setBounds(200, 30, 150, 40);
        pnl1.add(btnEdit);
        
            btnEdit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    dispose();
                    new BookCollection().setVisible(true);
                }
            });
    }
    
    public static void main(String[] args) {
        new AddEditFrame().setVisible(true);
    }
    
    private JPanel pnl1 = new JPanel();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    
}
