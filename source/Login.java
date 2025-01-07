package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);//used to set frame 500 left se 200 upper se anf frame size 600 and 300
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
       
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);//used to set frame 500 left se 200 upper se anf frame size 600 and 300
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("Login");
       login.setBounds(40, 150, 120, 30);
       login.addActionListener(this);
       add(login);
       
        cancel = new JButton("Cancel");
       cancel.setBounds(200, 150, 120, 30);
       cancel.addActionListener(this);
       add(cancel);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
       
        setBounds(500, 200, 600, 300);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource()==login) {
             String user = username.getText();
             String pass = password.getText();
              
             try {
                 Connectivity c = new Connectivity();
                 String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                 ResultSet rs = c.s.executeQuery(query);
                 
                 if (rs.next()){
                     setVisible(false);
                     new Dashboard();
                 }else {
                     JOptionPane.showMessageDialog(null,"Invalid username or password");
                     setVisible(false);
                 }
                 
             } catch(Exception e){
                 e.printStackTrace();
             }
         }else if (ae.getSource()==cancel){
             setVisible(false);
         }
        
       
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void main(String[] args){
        new Login();
    }
}