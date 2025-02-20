package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    department(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(120,10,90,20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(400,10,100,20);
        add(l2);
                
        table = new JTable();
        table.setBounds(10,50,700,350);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }
    
    public static void main(String [] args){
        new department();
    }
    
}
