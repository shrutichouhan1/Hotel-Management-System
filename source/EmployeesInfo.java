package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeesInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeesInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(60,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(280,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Post");
        l4.setBounds(400,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(510,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone No.");
        l6.setBounds(610,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(730,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Adhar No");
        l8.setBounds(840,10,100,20);
        add(l8);
        
        table = new JTable();
        table.setBounds(20,40,900,400);
        add (table);
        
        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from employee");
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
       
         setBounds(300,150,1000,600);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
            new Reception();
     }
     public static void main(String[] args){
        new EmployeesInfo();
    }
}

//public class  {
   
