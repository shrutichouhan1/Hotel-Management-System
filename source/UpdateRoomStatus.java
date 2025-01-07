package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class UpdateRoomStatus extends JFrame implements ActionListener{
   Choice customer;
   JTextField roomno, availability,cleaningstatus;
    JButton check,update,back;
    
    UpdateRoomStatus(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setBounds(50,20,250,30);
         text.setFont(new Font("Tahoma",Font.PLAIN, 25));
         text.setForeground(Color.BLUE);
        add(text);
        
        JLabel cid = new JLabel("Customer ID");
        cid.setBounds(40,80,100,20);
        add(cid);
        
        customer = new Choice();
        customer.setBounds(200,80,150,25);
        add(customer);
        
        
         try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from customers");
            while(rs.next()){
                customer.add(rs.getString("id_number"));
            }
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
         
         JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(40,120,100,20);
        add(roomnum);
        
        roomno=new JTextField();
        roomno.setBounds(200,120,150,25);
        add(roomno);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(40,160,100,20);
        add(available);
        
        availability=new JTextField();
        availability.setBounds(200,160,150,25);
        add(availability);
                
        JLabel checkintime = new JLabel("Cleaning Status");
        checkintime.setBounds(40,200,100,20);
        add(checkintime);
        
        cleaningstatus=new JTextField();
        cleaningstatus.setBounds(200,200,150,25);
        add(cleaningstatus);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,280,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,280,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,280,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410,30,480,300);
        add(image);
        
         setBounds(300,200,960,410);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==check){
             String id= customer.getSelectedItem();
             String query= "select * from customers where id_number ='"+id+"'";
             try{  
             Connectivity c = new Connectivity();
             ResultSet rs = c.s.executeQuery(query); 
             while(rs.next()){
                 roomno.setText(rs.getString("allocated_room"));
             }
             ResultSet rs2 = c.s.executeQuery("select * from rooms where roomnumber='"+roomno.getText()+"'"); 
                   while(rs2.next()){
                       availability.setText(rs2.getString("availability"));
                       cleaningstatus.setText(rs2.getString("cleaning_status"));
                   }
               
             }catch(Exception e){
                 e.printStackTrace();
              }
         }else if(ae.getSource()==update){
                  String id_number= customer.getSelectedItem();
                  String allocated_room= roomno.getText();
                  String available = availability.getText();
                  String cleaninstatus = cleaningstatus.getText(); 
           
                     try{
                         Connectivity c = new Connectivity();
                         c.s.executeUpdate("update rooms set availability='"+available+"',cleaning_status='"+cleaninstatus+"' where roomnumber = '"+allocated_room+"'"); 
                         JOptionPane.showMessageDialog(null, "Room  Updated Successfully");
                         setVisible(false);
                         new Reception();
                        }catch(Exception e){
                             e.printStackTrace();
                            }
                        }else if(ae.getSource()==back){
                        setVisible(false);
                        new Reception();
                        }else{
                        setVisible(false);
                         new Reception();
         }
         
     }
         public static void main(String[] args){
        new UpdateRoomStatus();
    }
}
