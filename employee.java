package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class employee extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    employee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(160,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(420,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone No.");
        l6.setBounds(660,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(780,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar No.");
        l8.setBounds(900,10,100,20);
        add(l8);
        
        
                
        table = new JTable();
        table.setBounds(10,50,1000,350);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(400,500,120,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }
    
    public static void main(String [] args){
        new employee();
    }
    
}
