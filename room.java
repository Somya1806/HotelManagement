package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    room(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,0,600,600);
        add(image);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10,10,90,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(105,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Clean Status");
        l3.setBounds(210,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("price");
        l4.setBounds(320,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(430,10,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(10,40,500,400);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }
    
    public static void main(String [] args){
        new room();
    }
    
}
