package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tfdrivername, tfage, tfcarcompany, tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    
    AddDrivers(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD, 18));
        heading.setBounds(150,15,200,20);
        add(heading);
        
        JLabel lbldrivername = new JLabel("Name");
        lbldrivername.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lbldrivername.setBounds(60,50,120,30);
        add(lbldrivername);
        
        tfdrivername = new JTextField();
        tfdrivername.setBounds(200,50,150,30);
        add(tfdrivername);
        
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lblage.setBounds(60,100,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,100,150,30);
        add(tfage);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);
        
        String genderOption[] = {"Select","Male","Female"};
        gendercombo = new JComboBox(genderOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        
        JLabel lblcarcompany = new JLabel("Car Company");
        lblcarcompany.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lblcarcompany.setBounds(60,200,120,30);
        add(lblcarcompany);
        
        tfcarcompany = new JTextField();
        tfcarcompany.setBounds(200,200,150,30);
        add(tfcarcompany);
        
        
        JLabel lblmodel= new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lblmodel.setBounds(60,250,120,30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,250,150,30);
        add(tfmodel);
        
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lblavailable.setBounds(60,300,120,30);
        add(lblavailable);
        
        String availableOption[] = {"Select","Available","Busy"};
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(200,300,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN, 15));
        lbllocation.setBounds(60,350,120,30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,350,150,30);
        add(tflocation);

        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(50,395,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,395,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,60,500,300);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String drivername = tfdrivername.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String carcompany = tfcarcompany.getText();
            String model = tfmodel.getText();
            String location = tflocation.getText();
            String available= (String) availablecombo.getSelectedItem();
            
            try {
                Connectivity c = new Connectivity();
                String str = "insert into driver values('"+drivername+"','"+age+"','"+gender+"','"+carcompany+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
             
                setVisible(false);

            } catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddDrivers();
    }
}

    
   
