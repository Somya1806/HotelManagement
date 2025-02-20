package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class updatecheck extends JFrame implements ActionListener{
    
    Choice cus;
    JTextField troom,tname,tcheckin,tpaid,tpending;
    JButton check,update,back;
    
    updatecheck(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        room.setBounds(30,120,100,30);
        add(room);
        
        troom = new JTextField();
        troom.setBounds(200,120,150,25);
        add(troom);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,160,150,30);
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
        JLabel checkin = new JLabel("Check In Time");
        checkin.setBounds(30,200,150,30);
        add(checkin);
        
        tcheckin = new JTextField();
        tcheckin.setBounds(200,200,150,25);
        add(tcheckin);
        
        JLabel paid = new JLabel("Amount Paid");
        paid.setBounds(30,240,150,30);
        add(paid);
        
        tpaid = new JTextField();
        tpaid.setBounds(200,240,150,25);
        add(tpaid);
        
        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(30,280,150,30);
        add(pending);
        
        tpending = new JTextField();
        tpending.setBounds(200,280,150,25);
        add(tpending);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        check.setBounds(30,340,100,30);
        add(check);
        
        update = new JButton("Updatet");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        update.setBounds(150,340,100,30);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(270,340,100,30);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
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
                    tname.setText(rs.getString("name"));
                    tcheckin.setText(rs.getString("checkintime"));
                    tpaid.setText(rs.getString("deposite"));
                 
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '"+troom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price)-Integer.parseInt(tpaid.getText());
                    tpending.setText(""+amountpaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            String number = cus.getSelectedItem();
            String room = troom.getText();
            String name = tname.getText();
            String checkin = tcheckin.getText();
            String deposit = tpaid.getText();
            
            try{
                conn c = new conn();
                c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"',checkintime = '"+checkin+"',deposite = '"+deposit+"'where number ='"+number+"'");
                
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
        new updatecheck();
    }
}
