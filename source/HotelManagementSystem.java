package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem() {
//        setSize(1366,565);
//        setLocation(100, 100);
        setBounds(100, 100, 1366, 565);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        JLabel text = new JLabel("Hotel Shree Satyam Guest House");
        text.setBounds(20, 430, 1000, 90 );
        text.setFont(new Font("serit", Font.BOLD, 50));
        text.setForeground(Color.WHITE); // to set text button forground color
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 100, 50);
        next.setBackground(Color.LIGHT_GRAY); // to set next button background color
        next.setForeground(Color.RED); // to set next button Foreground color
        next.addActionListener(this);
        next.setFont(new Font("serit",Font.PLAIN, 18));
        image.add(next);
        
        
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
             try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
        }
    } 
    @Override
    public void actionPerformed(ActionEvent ae) {
          setVisible(false);
          new Login();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
            
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
