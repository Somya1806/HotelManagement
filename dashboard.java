package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {
    dashboard(){
        setBounds(0,0,1500,1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1500,1000);
        add(image);
        
        JLabel text = new JLabel("Welcome to Hotel Taj Mahal");
        text.setBounds(400,80,1000,80);
        text.setFont(new Font("tahoma",Font.PLAIN,56));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,50);
        image.add(mb);
        
        JMenu h = new JMenu("Hotel Management");
        h.setFont(new Font("serif",Font.PLAIN,25));
        h.setForeground(Color.red);
        mb.add(h);
        
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        h.add(reception);
        
        JMenu admin = new JMenu("Admin");
        admin.setFont(new Font("serif",Font.PLAIN,25));
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        JMenuItem emp = new JMenuItem("Add Employee");
        emp.addActionListener(this);
        admin.add(emp);
        
        JMenuItem driver = new JMenuItem("Drivers");
        driver.addActionListener(this);
        admin.add(driver);
        
        JMenuItem ar = new JMenuItem("Add Rooms");
        ar.addActionListener(this);
        admin.add(ar);
                
        setVisible(true);        
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee"))
            new addemp();
        else if(ae.getActionCommand().equals("Add Rooms"))
            new addroom();
        else if(ae.getActionCommand().equals("Drivers"))
            new driver();
        else if(ae.getActionCommand().equals("Reception"))
            new reception();
    }

    
public static void main(String[] args){
    new dashboard();

}
}
