
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
     JCheckBox       available;
    
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search For Room");
        text.setBounds(400,20,200,30);
         text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel bedtypes = new JLabel("Bed Types");
        bedtypes.setBounds(50,100,100,20);
        add(bedtypes);
        
        bedtype = new JComboBox(new String[]{"Select","Single Bed","Double Bed","Queen Size","King Size"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(70,170,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(250,170,100,20);
        add(l2);
        
        JLabel l3 = new JLabel(" Cleaning Status");
        l3.setBounds(460,170,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(680,170,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,170,100,20);
        add(l5);
        
        
        
        table = new JTable();
        table.setBounds(20,200,1000,300);
        add (table);
        
        try{
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("select * from rooms");
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
       
         setBounds(300,200,1000,600);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
             try{
                 String query1= "select * from rooms where bed_type ='"+bedtype.getSelectedItem()+"'";
                 String query2= "select * from rooms where  availability='Available' AND bed_type='"+bedtype.getSelectedItem()+"'";
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
        new SearchRoom();
    }
}

