package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class updateroom extends JFrame implements ActionListener{
    
    Choice cus;
    JTextField troom,tav,tclean;
    JButton check,update,back;
    
    updateroom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.blue);
        add(text);
        
        JLabel id = new JLabel("Customer ID");
        id.setBounds(30,80,100,30);
        add(id);
        
        cus = new Choice();
        cus.setBounds(200,80,150,25);
        add(cus);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                cus.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel room = new JLabel("Room No.");
        room.setBounds(30,130,100,30);
        add(room);
        
        troom = new JTextField();
        troom.setBounds(200,130,150,25);
        add(troom);
        
        JLabel name = new JLabel("Availability");
        name.setBounds(30,180,150,30);
        add(name);
        
        tav = new JTextField();
        tav.setBounds(200,180,150,25);
        add(tav);
        
        JLabel checkin = new JLabel("Cleaning Status");
        checkin.setBounds(30,230,150,30);
        add(checkin);
        
        tclean = new JTextField();
        tclean.setBounds(200,230,150,25);
        add(tclean);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        check.setBounds(30,300,100,30);
        add(check);
        
        update = new JButton("Updatet");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBounds(150,300,100,30);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(270,300,100,30);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,450);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = cus.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    troom.setText(rs.getString("room"));
                    
                 
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '"+troom.getText()+"'");
                while(rs2.next()){
                    tav.setText(rs2.getString("availability"));
                    tclean.setText(rs2.getString("clean_status"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            String number = cus.getSelectedItem();
            String room = troom.getText();
            String ava = tav.getText();
            String status = tclean.getText();
            
            
            try{
                conn c = new conn();
                c.s.executeUpdate("update room set availability = '"+ava+"',clean_status = '"+status+"'where roomno ='"+room+"'");
       
                JOptionPane.showMessageDialog(null,"Data updated Successfully");
                setVisible(false);
                new reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new reception();
        }
    }
    public static void main (String[] args){
        new updateroom();
    }
}
