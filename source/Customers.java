package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Customers extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Customers(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Customer ID");
        l1.setBounds(30,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("ID Number");
        l2.setBounds(130,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(320,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(410,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel(" State");
        l6.setBounds(510,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("City");
        l7.setBounds(610,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Pincode");
        l8.setBounds(690,10,100,20);
        add(l8);
        
        JLabel l9 = new JLabel(" Room Number");
        l9.setBounds(760,10,100,20);
        add(l9);
        
        JLabel l10 = new JLabel("Checkin Time");
        l10.setBounds(860,10,100,20);
        add(l10);
        
        JLabel l11 = new JLabel("Price");
        l11.setBounds(980,10,100,20);
        add(l11);
        
         JLabel l12 = new JLabel("Phone No.");
        l12.setBounds(1060,10,100,20);
        add(l12);
        
        table = new JTable();
        table.setBounds(20,40,1120,400);
        add (table);
        
        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from customers");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);
       
         setBounds(200,150,1200,600);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
            new Reception();
     }
     public static void main(String[] args){
        new Customers();
    }
}

//public class  {
   


    

