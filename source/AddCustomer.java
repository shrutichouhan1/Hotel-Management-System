package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfphonenumber,tfname,tfcountry,tfstate,tfcity,tfpincode,tfamountdeposited;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkin;
    JButton add , back;
    
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,10,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN, 20));
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,60,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblid);
        String options[] = {"Select","Aadhar Card","Passport","Driving License","PAN Card","Voter ID Card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,60,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber = new JLabel("ID Number.");
        lblnumber.setBounds(35,90,120,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblnumber);
        tfnumber = new JTextField();
        tfnumber.setBounds(200,90,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setFont(new Font("Raleway",Font.PLAIN, 16));
        lblname.setBounds(35,120,150,20);
        add(lblname);
        tfname = new JTextField();
        tfname.setBounds(200,120,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,150,100,20);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,150,60,25);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270,150,100,25); //isse male female ek line m hoge
//         rbfemale.setBounds(200,160,70,30); isse male female uppar niche hoge
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,180,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblcountry);
        tfcountry = new JTextField();
        tfcountry.setBounds(200,180,150,25);
        add(tfcountry);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(35,210,100,20);
        lblstate.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblstate);
        tfstate = new JTextField();
        tfstate.setBounds(200,210,150,25);
        add(tfstate);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(35,240,100,20);
        lblcity.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblcity);
        tfcity = new JTextField();
        tfcity.setBounds(200,240,150,25);
        add(tfcity);
        
        JLabel lblpincode = new JLabel("Pin Code");
        lblpincode.setBounds(35,270,100,20);
        lblpincode.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblpincode);
        tfpincode = new JTextField();
        tfpincode.setBounds(200,270,150,25);
        add(tfpincode);
        
         JLabel lblroom = new JLabel("Allocated Room");
        lblroom.setFont(new Font("Raleway",Font.PLAIN, 16));
        lblroom.setBounds(35,300,150,20);
        add(lblroom);
        
        croom = new Choice();
        try{
            Connectivity c = new Connectivity();
            String query = "select * from rooms  where availability ='Available'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,300,150,25);
        add(croom);
        
        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setFont(new Font("Raleway",Font.PLAIN, 16));
        lbltime.setBounds(35,330,150,20);
        add(lbltime);
        
//        Date date = new Date();
//        
//        checkin = new JLabel(""+ date);
//        checkin.setBounds(200,330,150,25);
//        checkin.setFont(new Font("Raleway",Font.PLAIN, 13));
//        checkin.setBackground(Color.BLACK);
//        checkin.setForeground(Color.WHITE);
//        add(checkin);
        
//             Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");  // Simple date format (yyyy-MM-dd)
//            String formattedDate = sdf.format(date);  // Format the date
//            checkin = new JLabel(formattedDate);  // Display formatted date
//            checkin.setBounds(210, 330, 150, 25);
//            checkin.setFont(new Font("Raleway", Font.PLAIN, 13));
//            checkin.setBackground(Color.BLACK);
//            checkin.setForeground(Color.BLACK);
//            add(checkin);
            
            
              Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Simple date format (yyyy-MM-dd)
            String formattedDate = sdf.format(date);
            checkin = new JLabel("" + date);
             checkin.setBounds(200,330,150,25);
             add(checkin);
        
        JLabel lbldeposite = new JLabel("Amount Deposited");
        lbldeposite.setBounds(35,360,130,20);
        lbldeposite.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lbldeposite);
        
        tfamountdeposited = new JTextField();
        tfamountdeposited.setBounds(200,360,150,25);
        add(tfamountdeposited);
      

        JLabel lblphonenumber = new JLabel("Phone Number.");
        lblphonenumber.setBounds(35,390,150,20);
        lblphonenumber.setFont(new Font("Raleway",Font.PLAIN, 16));
        add(lblphonenumber);
        
        tfphonenumber = new JTextField();
        tfphonenumber.setBounds(200,390,150,25);
        add(tfphonenumber);
        
        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(50,460,130,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(220,460,130,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        setBounds(350,150,800,550);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String) comboid.getSelectedItem();
            String idnumber = tfnumber.getText();
            String name = tfname.getText();
            
            String gender = null;
            if(rbmale.isSelected()){ gender = "Male";
            }else { gender = "Female";
            }
            String country = tfcountry.getText();
            String state = tfstate.getText();
            String city = tfcity.getText();
             String pincode = tfpincode.getText();
            String room = croom.getSelectedItem();
            String checkintime = checkin.getText();
            String deposit= tfamountdeposited.getText();
            String phonenumber= tfphonenumber.getText();
            
            try {
                Connectivity c = new Connectivity();
                String query = "insert into customers values('"+id+"','"+idnumber+"','"+name+"','"+gender+"','"+country+"','"+state+"','"+city+"','"+pincode+"','"+room+"','"+checkintime+"','"+deposit+"','"+phonenumber+"')";
                String query2="update rooms set availability ='Occupied' where roomnumber = '"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
             
                setVisible(false);
                new Reception();

            } catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
