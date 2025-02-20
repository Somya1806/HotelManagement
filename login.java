package hotel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton log,cancle;
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        password = new  JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        log = new JButton("Login");
        log.setBounds(40,150,120,30);
        log.setBackground(Color.blue);
        log.setForeground(Color.white);
        log.addActionListener(this);
        add(log);
        
        cancle = new JButton("Cancle");
        cancle.setBounds(180,150,120,30);
        cancle.setBackground(Color.blue);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        add(cancle);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        setBounds(500,200,600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==log){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                conn c = new conn();
                String query = "select * from login where username = '"+ user +"' and password = '"+ pass+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new dashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "invalid username or password");
                    setVisible(false);
                }
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancle){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new login();
    }
}
