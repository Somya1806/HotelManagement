package hotel.management;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");//register the driver
        c=DriverManager.getConnection("jdbc:mysql:///hotelmanagement","root","1234");//creating the connection
        s=c.createStatement();//creating statement
        
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
