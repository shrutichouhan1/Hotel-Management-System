package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton newcustomer,searchRoom,rooms,allemployee,customers,update,managerInfo,pickup,roomStatus,checkincheckout;
    
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(10,20,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
         rooms = new JButton("Rooms");
        rooms.setBounds(10,60,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
         allemployee = new JButton("All Employees");
        allemployee.setBounds(10,100,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        add(allemployee);
        
         customers = new JButton("Customers");
        customers.setBounds(10,140,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
         managerInfo = new JButton("Manager Information");
        managerInfo.setBounds(10,180,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkincheckout = new JButton("CheckIn & CheckOut");
        checkincheckout.setBounds(10,220,200,30);
        checkincheckout.setBackground(Color.BLACK);
        checkincheckout.setForeground(Color.WHITE);
        checkincheckout.addActionListener(this);
        add(checkincheckout);
        
        
         update = new JButton("Update Status");
        update.setBounds(10,260,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,300,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
         pickup = new JButton("Pickup Services");
        pickup.setBounds(10,340,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
         searchRoom= new JButton("Search Room");
        searchRoom.setBounds(10,380,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        JButton logout = new JButton("Logout");
        logout.setBounds(10,460,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,150,800,570);
        setVisible(true);       
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newcustomer) {
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource() == rooms) {
            setVisible(false);
            new Rooms();
          }else if (ae.getSource() == allemployee) {
            setVisible(false);
            new EmployeesInfo();  
            }else if (ae.getSource() == customers) {
            setVisible(false);
            new Customers(); 
            }else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
            }else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
            }else if (ae.getSource() ==update ) {
            setVisible(false);
            new UpdateStatus();
            }else if (ae.getSource() ==roomStatus ) {
            setVisible(false);
            new UpdateRoomStatus();
            }else if (ae.getSource() == pickup) {
            setVisible(false);
            new PickupServices();
            }else if (ae.getSource() == checkincheckout) {
            setVisible(false);
            new CheckInCheckOut();
       
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Reception();
    }
    
}
