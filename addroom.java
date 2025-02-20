package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addroom extends JFrame implements ActionListener {
    
    JButton add,cancle;
    JTextField tprice,troom;
    JComboBox c,a,btype;
    
    addroom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel h = new JLabel("Add Rooms");
        h.setFont(new Font("Tahoma",Font.BOLD,18));
        h.setBounds(150, 20,200,20);
        add(h);
        
        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        room.setBounds(60,60,120,30);
        add(room);
        
        troom = new JTextField();
        troom.setBounds(200,60, 150, 30);
        add(troom);
        
        JLabel lavailable = new JLabel("Available");
        lavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavailable.setBounds(60,110,200,30);
        add(lavailable);
        
        String ava[] ={"Available","Occupied"};
        a = new JComboBox(ava);
        a.setBounds(200,110,150,30);
        a.setBackground(Color.WHITE);
        add(a);
        
        JLabel lclean = new JLabel("Cleaning Status");
        lclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lclean.setBounds(60,160,200,30);
        add(lclean);
        
        String clean[] ={"Clean","Not clean"};
        c = new JComboBox(clean);
        c.setBounds(200,160,150,30);
        c.setBackground(Color.WHITE);
        add(c);
        
        JLabel lprice = new JLabel("Price");
        lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lprice.setBounds(60,210,200,30);
        add(lprice);
        
        tprice= new JTextField();
        tprice.setBounds(200,210, 150, 30);
        add(tprice);
        
        JLabel lbed = new JLabel("Bed Type");
        lbed.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbed.setBounds(60,260,200,30);
        add(lbed);
        
        String bed[] = {"Single bed","Double bed"};
        btype = new JComboBox(bed);
        btype.setBounds(200,260,150,30);
        btype.setBackground(Color.WHITE);
        add(btype);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.blue);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancle = new JButton("Cancle");
        cancle.setForeground(Color.WHITE);
        cancle.setBackground(Color.blue);
        cancle.setBounds(220,350,130,30);
        cancle.addActionListener(this);
        add(cancle);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String roomno=troom.getText();
            String ava = (String)a.getSelectedItem();
            String status =(String)c.getSelectedItem();
            String price = tprice.getText();
            String type = (String)btype.getSelectedItem();
            
            try{
                conn c = new conn();
                String str = "insert into room values ('"+roomno+"','"+ava+"','"+status+"','"+price+"','"+type+"')";
                c.s.execute(str);
                JOptionPane.showMessageDialog(null,"New room added successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new addroom();
    }
}
