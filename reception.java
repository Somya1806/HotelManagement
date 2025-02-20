package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame implements ActionListener {
    
    JButton n,room,dept,emp,cus,manager,checkout,us,rs,ps,sr,lo;
    
    reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        n = new JButton("New customer Form");
        n.setBounds(10,30,200,30);
        n.setBackground(Color.DARK_GRAY);
        n.setForeground(Color.white);
        n.addActionListener(this);
        add(n);
        
        room = new JButton("Rooms");
        room.setBounds(10,80,200,30);
        room.setBackground(Color.DARK_GRAY);
        room.setForeground(Color.white);
        room.addActionListener(this);
        add(room);
        
        dept = new JButton("Department");
        dept.setBounds(10,130,200,30);
        dept.setBackground(Color.DARK_GRAY);
        dept.setForeground(Color.white);
        dept.addActionListener(this);
        add(dept);
        
        emp = new JButton("All Employees");
        emp.setBounds(10,180,200,30);
        emp.setBackground(Color.DARK_GRAY);
        emp.setForeground(Color.white);
        emp.addActionListener(this);
        add(emp);
        
        cus = new JButton("Customer Info");
        cus.setBounds(10,230,200,30);
        cus.setBackground(Color.DARK_GRAY);
        cus.setForeground(Color.white);
        cus.addActionListener(this);
        add(cus);
        
        manager = new JButton("Manager Info");
        manager.setBounds(10,280,200,30);
        manager.setBackground(Color.DARK_GRAY);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,330,200,30);
        checkout.setBackground(Color.DARK_GRAY);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        us = new JButton("Update Status");
        us.setBounds(10,380,200,30);
        us.setBackground(Color.DARK_GRAY);
        us.setForeground(Color.white);
        us.addActionListener(this);
        add(us);
        
        rs = new JButton("Update Room Status");
        rs.setBounds(10,430,200,30);
        rs.setBackground(Color.DARK_GRAY);
        rs.setForeground(Color.white);
        rs.addActionListener(this);
        add(rs);
        
        ps = new JButton("Pickup Service");
        ps.setBounds(10,480,200,30);
        ps.setBackground(Color.DARK_GRAY);
        ps.setForeground(Color.white);
        ps.addActionListener(this);
        add(ps);
        
        sr = new JButton("Search Room");
        sr.setBounds(10,530,200,30);
        sr.setBackground(Color.DARK_GRAY);
        sr.setForeground(Color.white);
        sr.addActionListener(this);
        add(sr);
        
        lo = new JButton("Logout");
        lo.setBounds(10,580,200,30);
        lo.setBackground(Color.DARK_GRAY);
        lo.setForeground(Color.white);
        lo.addActionListener(this);
        add(lo);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,570);
        add(image);
        
        setBounds(350,150,800,670);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== n){
            setVisible(false);
            new addcustomer();
     }else if(ae.getSource()== room){
            setVisible(false);
            new room();
     }
      else if(ae.getSource()== dept){
            setVisible(false);
            new department();
     }else if(ae.getSource()== emp){
            setVisible(false);
            new employee();
     }else if(ae.getSource()== cus){
            setVisible(false);
            new customerinfo();
     }else if(ae.getSource()== manager){
            setVisible(false);
            new managerinfo();
     }else if(ae.getSource()== sr){
            setVisible(false);
            new searchroom();
     }else if(ae.getSource()== us){
            setVisible(false);
            new updatecheck();
     }else if(ae.getSource()== rs){
            setVisible(false);
            new updateroom();
     }else if(ae.getSource()== ps){
            setVisible(false);
            new pickup();
     }else if(ae.getSource()== checkout){
            setVisible(false);
            new checkout();
     }else if(ae.getSource()== lo){
            setVisible(false);
            System.exit(0);
     }
        
      
    }
    
    public static void main(String [] args){
        new reception();
    }
}
