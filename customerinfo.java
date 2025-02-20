package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class customerinfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    customerinfo(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Document");
        l1.setBounds(30,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(300,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(420,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room No.");
        l6.setBounds(660,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("CheckinTime");
        l7.setBounds(780,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposite");
        l8.setBounds(900,10,100,20);
        add(l8);
        
        
                
        table = new JTable();
        table.setBounds(10,50,1000,350);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
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
        new customerinfo();
    }
    
}
