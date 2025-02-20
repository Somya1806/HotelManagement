package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class searchroom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    searchroom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(50,100,100,20);
        add(bed);
        
        bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.white);
        add(bedtype);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.white);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(250,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Clean Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("price");
        l4.setBounds(650,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(850,160,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(10,200,1000,300);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
                String query1 = "select * from room where bedtype = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bedtype = '"+bedtype.getSelectedItem()+"'";
                
                conn c = new conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                }else{
                    rs = c.s.executeQuery(query1);
                }
                
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
        new searchroom();
    }
}
