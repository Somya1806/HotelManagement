package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  driver extends JFrame implements ActionListener {
    
    JButton add,cancle;
    JTextField tname,tage,tcompany,tmodel,tloc;
    JRadioButton rbmale,rbfemale;
    JComboBox a;
    
    driver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel h = new JLabel("Add Driver");
        h.setFont(new Font("Tahoma",Font.BOLD,18));
        h.setBounds(150, 20,200,20);
        add(h);
        
        JLabel room = new JLabel("Name");
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        room.setBounds(60,60,120,30);
        add(room);
        
        tname = new JTextField();
        tname.setBounds(200,60, 150, 30);
        add(tname);
        
        JLabel lavailable = new JLabel("Age");
        lavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavailable.setBounds(60,110,200,30);
        add(lavailable);
        
        tage = new JTextField();
        tage.setBounds(200,110, 150, 30);
        add(tage);
        
        JLabel lclean = new JLabel("Gender");
        lclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lclean.setBounds(60,160,200,30);
        add(lclean);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,160,60,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,160,80,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lprice = new JLabel("Car Company");
        lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lprice.setBounds(60,210,200,30);
        add(lprice);
        
        tcompany= new JTextField();
        tcompany.setBounds(200,210, 150, 30);
        add(tcompany);
        
        JLabel lbed = new JLabel("Model");
        lbed.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbed.setBounds(60,260,200,30);
        add(lbed);
        
        tmodel= new JTextField();
        tmodel.setBounds(200,260, 150, 30);
        add(tmodel);
        
        JLabel lava = new JLabel("Available");
        lava.setFont(new Font("Tahoma",Font.PLAIN,16));
        lava.setBounds(60,310,200,30);
        add(lava);
        
        String ava[] ={"Available","Occupied"};
        a = new JComboBox(ava);
        a.setBounds(200,310,150,30);
        a.setBackground(Color.WHITE);
        add(a);
        
        JLabel lloc = new JLabel("Location");
        lloc.setFont(new Font("Tahoma",Font.PLAIN,16));
        lloc.setBounds(60,360,200,30);
        add(lloc);
        
        tloc= new JTextField();
        tloc.setBounds(200,360, 150, 30);
        add(tloc);
        
        
        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.blue);
        add.setBounds(60,410,130,30);
        add.addActionListener(this);
        add(add);
        
        cancle = new JButton("Cancle");
        cancle.setForeground(Color.WHITE);
        cancle.setBackground(Color.blue);
        cancle.setBounds(220,410,130,30);
        cancle.addActionListener(this);
        add(cancle);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(300,200,980,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name=tname.getText();
            String age = tage.getText();
            String gender =null;
            String company = tcompany.getText();
            String brand = tmodel.getText();
            String available = (String)a.getSelectedItem();
            String location = tloc.getText();
            
            if(rbmale.isSelected()){
            gender = "Male";
            }else if(rbfemale.isSelected()){
            gender = "Female";
            }
            
            try{
                conn c = new conn();
                String str = "insert into driver values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                c.s.execute(str);
                JOptionPane.showMessageDialog(null,"New driver added successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new driver();
    }
}
