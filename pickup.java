package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    
    pickup(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Pick Up Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel bed = new JLabel("Car Type");
        bed.setBounds(50,100,100,20);
        add(bed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
                
            }
}
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("gender");
        l3.setBounds(350,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        table = new JTable();
        table.setBounds(10,200,1000,300);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String query1 = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs;
                rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new reception();
        }
    }
    
    public static void main (String[] args){
        new pickup();
    }
}
