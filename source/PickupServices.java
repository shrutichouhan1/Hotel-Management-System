package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupServices extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice cartype;
     JCheckBox       available;
    
    PickupServices(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400,20,200,30);
         text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel bedtypes = new JLabel("Car Types");
        bedtypes.setBounds(50,100,100,20);
        add(bedtypes);
        
        cartype = new Choice();
        cartype.setBounds(150,100,150,25);
        add(cartype);
        
         try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                cartype.add(rs.getString("car_model"));
            }
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1 = new JLabel("Name ");
        l1.setBounds(70,170,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(220,170,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(350,170,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Car Company");
        l4.setBounds(480,170,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Car Model");
        l5.setBounds(630,170,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Available");
        l6.setBounds(780,170,100,20);
        add(l6);
        
         JLabel l7 = new JLabel("Pickup Location");
        l7.setBounds(900,170,100,20);
        add(l7);
        
        
        
        table = new JTable();
        table.setBounds(20,200,1000,300);
        add (table);
        
        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(320,500,120,30);
        submit.addActionListener(this);
        add(submit);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(520,500,120,30);
        back.addActionListener(this);
        add(back);
       
         setBounds(300,200,1100,600);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
             try{
                 String query1= "select * from driver where car_model ='"+cartype.getSelectedItem()+"'";
                 String query2= "select * from driver where  available='Available' AND car_model='"+cartype.getSelectedItem()+"'";
                 Connectivity c = new Connectivity();
                  ResultSet rs; //= c.s.executeQuery("select * from customers");
                 if(available.isSelected()){
                 rs= c.s.executeQuery(query2);
                 }else{
                    rs= c.s.executeQuery(query1);
                }
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                 e.printStackTrace();
              }
         }else{
             setVisible(false);
            new Reception();
         }
         
     }
     
     
     
     public static void main(String[] args){
        new PickupServices();
    }
}
