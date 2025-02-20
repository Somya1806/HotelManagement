package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class checkout extends JFrame implements ActionListener{
    
    Choice cus;
    JLabel roomno,checkin,checkouttime;
    JButton checkOut,back,Check;
    
    checkout(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.blue);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel id = new JLabel("Customer id");
        id.setBounds(30,80,100,30);
        add(id);
        
        cus = new Choice();
        cus.setBounds(150,80,150,25);
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
        
        JLabel room = new JLabel("Room No");
        room.setBounds(30,130,100,30);
        add(room);
        
        roomno = new JLabel();
        roomno.setBounds(150,130,100,30);
        add(roomno);
        
        JLabel check = new JLabel("Checkin Time");
        check.setBounds(30,180,100,30);
        add(check);
        
        checkin = new JLabel();
        checkin.setBounds(150,180,180,30);
        add(checkin);
        
        JLabel checkout = new JLabel("Checkout Time");
        checkout.setBounds(30,230,100,30);
        add(checkout);
        
        Date d = new Date();
        
        checkouttime = new JLabel(""+d);
        checkouttime.setBounds(150,230,180,30);
        add(checkouttime);
        
        checkOut = new JButton("Checkout");
        checkOut.setBackground(Color.black);
        checkOut.setForeground(Color.white);
        checkOut.addActionListener(this);
        checkOut.setBounds(30,320,120,30);
        add(checkOut);
        
        Check = new JButton("Check");
        Check.setBackground(Color.black);
        Check.setForeground(Color.white);
        Check.addActionListener(this);
        Check.setBounds(170,320,120,30);
        add(Check);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(300,320,120,30);
        add(back);
        
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel imag = new JLabel(i6);
        imag.setBounds(350,50,400,250);
        add(imag);
        
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkOut){
            String query1 = "delete from customer where number = '"+cus.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomno = '"+roomno.getText()+"'";
            try{
                conn c = new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"checkout done");
                setVisible(false);
                new reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==Check){
            try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where number ='"+cus.getSelectedItem()+"'");
            while(rs.next()){
                roomno.setText(rs.getString("room"));
                checkin.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            setVisible(false);
            new reception();
        }
    }
    public static void main (String[] args){
        new checkout();
    }
}
