package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class addcustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tnum,tname,tcon,tdep;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    addcustomer(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel id = new JLabel("ID");
        id.setBounds(35,80,300,30);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(id);
        
        String options[]={"Aadhar Card","Passport","Driving Licence","Voter-Id card","Ration Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel num = new JLabel("Number");
        num.setBounds(35,120,100,25);
        num.setFont(new Font("Raleway",Font.PLAIN,20));
        add(num);
        
        tnum = new JTextField();
        tnum.setBounds(200,120,150,25);
        add(tnum);
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(35,160,100,25);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,200,100,25);
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,200,60,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,200,80,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel country = new JLabel("Country");
        country.setBounds(35,240,100,25);
        country.setFont(new Font("Raleway",Font.PLAIN,20));
        add(country);
        
        tcon = new JTextField();
        tcon.setBounds(200,240,150,25);
        add(tcon);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(35,280,150,25);
        room.setFont(new Font("Raleway",Font.PLAIN,20));
        add(room);
        
        croom = new Choice();
        try{
            conn c = new conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel time = new JLabel("Checkin Time");
        time.setBounds(35,320,150,25);
        time.setFont(new Font("Raleway",Font.PLAIN,20));
        add(time);
        
        Date d = new Date();
        
        checkintime = new JLabel(""+d);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,10));
        add(checkintime);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35,360,150,25);
        deposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(deposit);
        
        tdep = new JTextField();
        tdep.setBounds(200,360,150,25);
        add(tdep);
        
        add = new JButton("Add");
        add.setBackground(Color.GRAY);
        add.setForeground(Color.white);
        add.setBounds(50,420,100,30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(200,420,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(350,200,800,550);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String id = (String)comboid.getSelectedItem();
            String number = tnum.getText();
            String name = tname.getText();
            String gender = null;
            if(rbmale.isSelected())
                gender="Male";
            else if(rbfemale.isSelected())
                gender="Female";
            String country = tcon.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tdep.getText();
            
            try{
                String query = "insert into customer values ('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"')";
                String query2 = "update room set availability = 'Occupied' where roomno = '"+room+"'";
                conn c = new conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new reception();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== back){
            setVisible(false);
            new reception();
        }
    }
    
    
    public static void main(String [] args){
        new addcustomer();
    }
    
}
