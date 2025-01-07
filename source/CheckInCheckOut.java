package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckInCheckOut extends JFrame implements ActionListener{
    Choice Cid;
    JLabel lroomnumber,lcheckintime,lcheckouttime;
    JButton checkout,check, back;
    
    CheckInCheckOut(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("CheckIn & CheckOut");
        text.setBounds(100,20,250,30);
//        text.setBackground(Color.BLACK);
        text.setForeground(Color.BLUE);
         text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel customerid = new JLabel("Customer ID");
        customerid.setBounds(30,80,100,30);
        add(customerid);
        
        Cid = new Choice();
        Cid.setBounds(140,80,170,30);
        add(Cid);
        
         
          ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(335,80,20,20);
        add(tick);
        
         JLabel croom = new JLabel("Room Number");
        croom.setBounds(30,120,100,30);
        add(croom);
        
        lroomnumber = new JLabel();
        lroomnumber.setBounds(200,120,100,30);
        add(lroomnumber);
        
        JLabel checkinn = new JLabel("CheckIn");
        checkinn.setBounds(30,160,100,30);
        add(checkinn);
        
        lcheckintime = new JLabel();
        lcheckintime.setBounds(140,160,180,30);
        add(lcheckintime);
       
        JLabel checkoutt = new JLabel("CheckOut");
        checkoutt.setBounds(30,200,100,30);
        add(checkoutt);
        
        Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Simple date format (yyyy-MM-dd)
            String formattedDate = sdf.format(date);
        lcheckouttime = new JLabel("" + date);
        lcheckouttime.setBounds(140,200,180,30);
        add(lcheckouttime);
        
         check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,280,90,30);
        check.addActionListener(this);
        add(check);
        
         checkout= new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(147,280,95,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,280,90,30);
        back.addActionListener(this);
        add(back);
        
         try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from customers");
            while(rs.next()){
                Cid.add(rs.getString("id_number"));
                lroomnumber.setText(rs.getString("allocated_room"));
                lcheckintime.setText(rs.getString("checkin_time"));
            }
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
         
         
        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel tick1 = new JLabel(i6);
        tick1.setBounds(380,50,370,250);
        add(tick1);
        
         setBounds(300,200,800,400);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
//         if(ae.getSource()==checkout){
////              String query1= "delete from customers where  id_number='"+Cid.getSelectedItem()+"'";
//              String query2= "update rooms set  availability='Available' where roomnumber='"+lroomnumber.getText()+"'";
//              try{
//                 Connectivity c = new Connectivity();
////                 c.s.executeUpdate(query1);
//                 c.s.executeUpdate(query2);
//                 
//                 JOptionPane.showMessageDialog(null, "Customer CheckOut Successfully");
////              etModel(DbUtils.resultSetToTableModel(rs));
//             }catch(Exception e){
//                 e.printStackTrace();
//             }
              
     
         if(ae.getSource()==check){
             String id= Cid.getSelectedItem();
             String query= "select * from customers where id_number ='"+id+"'";
             try{  
             Connectivity c = new Connectivity();
             ResultSet rs = c.s.executeQuery(query); 
             while(rs.next()){
                 lroomnumber.setText(rs.getString("allocated_room"));
             }
//             ResultSet rs2 = c.s.executeQuery("select * from rooms where roomnumber='"+roomno.getText()+"'"); 
//                   while(rs2.next()){
//                       availability.setText(rs2.getString("availability"));
//                       cleaningstatus.setText(rs2.getString("cleaning_status"));
//                   }
               
             }catch(Exception e){
                 e.printStackTrace();
              }
         }else if(ae.getSource()==checkout){
//                  String id_number= customer.getSelectedItem();
//                  String allocated_room= roomno.getText();
//                  String available = availability.getText();
//                  String cleaninstatus = cleaningstatus.getText(); 
                    String query2= "update rooms set  availability='Available' where roomnumber='"+lroomnumber.getText()+"'";

                     try{
                         Connectivity c = new Connectivity();
                         c.s.executeUpdate(query2); 
                         JOptionPane.showMessageDialog(null, "Customer CheckOut Successfully");
                         setVisible(false);
                         new Reception();
                        }catch(Exception e){
                             e.printStackTrace();
                            }
                     
                     
//            
                        }else if(ae.getSource()==back){
                        setVisible(false);
                        new Reception();
                       
         
              
         }else{
             setVisible(false);
            new Reception();
         }
         
     }
    public static void main(String[] args){
        new CheckInCheckOut();
    }
    
}
