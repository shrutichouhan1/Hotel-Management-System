package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class UpdateStatus extends JFrame implements ActionListener{
   Choice customer;
   JTextField roomno, name,checkin,camountpaid,camountpending;
    JButton check,update,back;
    
    UpdateStatus(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setBounds(210,20,200,30);
         text.setFont(new Font("Tahoma",Font.PLAIN, 20));
         text.setForeground(Color.BLUE);
        add(text);
        
        JLabel cid = new JLabel("Customer ID");
        cid.setBounds(30,80,100,20);
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
        roomnum.setBounds(30,120,100,20);
        add(roomnum);
        
        roomno=new JTextField();
        roomno.setBounds(200,120,150,25);
        add(roomno);
        
        JLabel cname = new JLabel("Name");
        cname.setBounds(30,160,100,20);
        add(cname);
        
        name=new JTextField();
        name.setBounds(200,160,150,25);
        add(name);
                
        JLabel checkintime = new JLabel("Checkin Time");
        checkintime.setBounds(30,200,100,20);
        add(checkintime);
        
        checkin=new JTextField();
        checkin.setBounds(200,200,150,25);
        add(checkin);
        
        JLabel amountpaid = new JLabel("Amount Paid");
        amountpaid.setBounds(30,240,100,20);
        add(amountpaid);
        
        camountpaid=new JTextField();
        camountpaid.setBounds(200,240,150,25);
        add(camountpaid);
        
        JLabel amountpending = new JLabel("Pending Amount");
        amountpending.setBounds(30,280,100,20);
        add(amountpending);
        
        camountpending=new JTextField();
        camountpending.setBounds(200,280,150,25);
        add(camountpending);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(380,50,500,300);
        add(image);
        
         setBounds(300,200,900,500);
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
                 name.setText(rs.getString("c_name"));
                 checkin.setText(rs.getString("checkin_time"));
                camountpaid.setText(rs.getString("amount_deposited"));
//                camountpending.setText(rs.getString("amount pending"));
//                roomno.setText(rs.getString("room"));
//                roomno.setText(rs.getString("room"));
             }
             ResultSet rs2 = c.s.executeQuery("select * from rooms where roomnumber='"+roomno.getText()+"'"); 
                   while(rs2.next()){
                      String price = rs2.getString("price");
                      int  amountpaid =Integer.parseInt(price)-Integer.parseInt(camountpaid.getText());
                      camountpending.setText(""+ amountpaid);
                   }
               
             }catch(Exception e){
                 e.printStackTrace();
              }
         }else if(ae.getSource()==update){
                 String id_number= customer.getSelectedItem();
                  String allocated_room= roomno.getText();
                  String c_name= name.getText();
                  String checkin_time = checkin.getText();
                   String amount_deposited= camountpaid.getText();
                     try{
                         Connectivity c = new Connectivity();
                     c.s.executeUpdate("update customers set allocated_room = '"+allocated_room+"',c_name='"+c_name+"',checkin_time='"+checkin_time+"',amount_deposited='"+amount_deposited+"'"); 
                   JOptionPane.showMessageDialog(null, "Data  Updated Successfully");
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
        new UpdateStatus();
    }
}
