package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addemp extends JFrame implements ActionListener {
    
    JTextField tname,tage,tpho,tem,tsal,tad;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    addemp(){
        setLayout(null);
        
        JLabel lname = new JLabel("NAME");
        lname.setBounds(60,30,120,30);
        lname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lname);
        
        tname = new JTextField();
        tname.setBounds(200,30,150,30);
        add(tname);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
        tage = new JTextField();
        tage.setBounds(200,80,150,30);
        add(tage);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,60,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbmale.setBackground(Color.orange);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,80,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,15));
        rbfemale.setBackground(Color.orange);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel ljob = new JLabel("JOB");
        ljob.setBounds(60,180,120,30);
        ljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(ljob);
        
        String str[] = {"Front Desk Cleark","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiteress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lsal = new JLabel("SALARY");
        lsal.setBounds(60,230,120,30);
        lsal.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lsal);
        
        tsal = new JTextField();
        tsal.setBounds(200,230,150,30);
        add(tsal);
        
        JLabel lpho = new JLabel("PHONE NO.");
        lpho.setBounds(60,280,120,30);
        lpho.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lpho);
        
        tpho = new JTextField();
        tpho.setBounds(200,280,150,30);
        add(tpho);
        
        JLabel lem = new JLabel("EMAIL");
        lem.setBounds(60,330,120,30);
        lem.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lem);
        
        tem = new JTextField();
        tem.setBounds(200,330,150,30);
        add(tem);
        
        JLabel lad = new JLabel("AADHAR NO.");
        lad.setBounds(60,380,120,30);
        lad.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lad);
        
        tad = new JTextField();
        tad.setBounds(200,380,150,30);
        add(tad);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.YELLOW);
        submit.setForeground(Color.BLACK);
        submit.setBounds(200, 430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,380);
        add(image);
        
        getContentPane().setBackground(Color.ORANGE);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tname.getText();
        String age = tage.getText();
        String salary = tsal.getText();
        String phone = tpho.getText();
        String email = tem.getText();
        String aadhar = tad.getText();
        String gender = null;
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }
        String job = (String)cbjob.getSelectedItem();
        
        try{
            conn c = new conn();
            String query = "insert into employee values('"+name+"', '"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new addemp();
    }
}
