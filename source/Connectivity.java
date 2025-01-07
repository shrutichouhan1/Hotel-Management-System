package hotel.management.system;
import java.sql.*;

public class Connectivity {
    
    Statement s;
    Connection c; // step 2 create connection
    Connectivity(){  //step 1 create connectivity
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///HOTEL_MANAGEMENT_SYSTEM","root","shruti");
            s = c.createStatement(); //step third create statement
        
        }
        catch(Exception e) {
           e.printStackTrace();
    }
    }

public static void main(String[] args) {
        new Connectivity();
    }
}
