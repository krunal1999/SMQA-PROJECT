
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author krunal
 */
public class PinChange extends JFrame implements ActionListener{
    String pinnumber , username, cardnumber;
    JTextField currpintext, newpintext , repintext;
    JButton update , back;
    
    PinChange(String username,String cardnumber , String pinnumber){
       setLayout(null); 
       
       this.pinnumber = pinnumber;
       this.username = username;
       this.cardnumber = cardnumber;
       
        JLabel text = new JLabel("Change Pin");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        JLabel currpin = new JLabel("Enter current pin");
        currpin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 22));
        currpin.setForeground(Color.green);
        currpin.setBounds(100,200,300,50);
        add(currpin);
        
        currpintext = new JTextField();
        currpintext.setFont(new Font("Arial" , Font.BOLD , 22));
        currpintext.setBounds(500,200,200,50);
        add(currpintext);
        
        JLabel newpin = new JLabel("Enter new pin");
        newpin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 22));
        newpin.setForeground(Color.green);
        newpin.setBounds(100,300,300,50);
        add(newpin);
        
        newpintext = new JTextField();
        newpintext.setFont(new Font("Arial" , Font.BOLD , 22));
        newpintext.setBounds(500,300,200,50);
        add(newpintext);
        
        
        JLabel repin = new JLabel("Enter current pin");
        repin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 22));
        repin.setForeground(Color.green);
        repin.setBounds(100,400,300,50);
        add(repin);
        
        repintext = new JTextField();
        repintext.setFont(new Font("Arial" , Font.BOLD , 22));
        repintext.setBounds(500,400,200,50);
        add(repintext);
        
        
        update = new JButton("Update");
        update.setFont(new Font("Arial" , Font.BOLD , 22));
        update.setBounds(200, 600, 400, 50);
        update.setBackground(Color.green);
        update.setForeground(Color.white);
        update.setFocusPainted(false);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 22));
        back.setBounds(650, 600, 400, 50);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
       
       
       
       
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1280 , 780);
        
        setLocation(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String checkpin = currpintext.getText();
            String nextpin = newpintext.getText();
            String repin = repintext.getText();
            System.out.println(pinnumber);
            if(checkpin.equals(pinnumber)){
                if(nextpin.equals(repin)){
                    //to do
                    try{
                        Conn conn = new Conn();
                        String query1= "update login set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        String query2= "update bank set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        String query3= "update balance set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        conn.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "Pin changed successfully");
                        setVisible(false);
                        new Transactions(username,cardnumber, nextpin).setVisible(true);

                    } catch (Exception er){
                        System.out.println(er);
                    }
                                        
                }else{
                    JOptionPane.showMessageDialog(null, "New Pin and Reenter pin does not match");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Current pin does not match");
            }
            
        } else{
            setVisible(false);
            new Transactions(username,cardnumber,pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[]){
        new PinChange("","","");
    }
    
    
}
