
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author krunal dhavle kbd6
 */
public class PinChange extends JFrame implements ActionListener{
	//global declaration 
    String pinnumber , username, cardnumber;
    JPasswordField currpintext, newpintext , repintext;
    JButton update , back;
    
    //frontend start
    private void mainFrame(){
        setLayout(null); 
       
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
        
        currpintext = new JPasswordField();
        currpintext.setFont(new Font("Arial" , Font.BOLD , 22));
        currpintext.setBounds(500,200,200,50);
        add(currpintext);
        
        JLabel newpin = new JLabel("Enter new pin");
        newpin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 22));
        newpin.setForeground(Color.green);
        newpin.setBounds(100,300,300,50);
        add(newpin);
        
        newpintext = new JPasswordField();
        newpintext.setFont(new Font("Arial" , Font.BOLD , 22));
        newpintext.setBounds(500,300,200,50);
        add(newpintext);
        
        
        JLabel repin = new JLabel("Reenter new pin");
        repin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 22));
        repin.setForeground(Color.green);
        repin.setBounds(100,400,300,50);
        add(repin);
        
        repintext = new JPasswordField();
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
        
        //frontend end
    }
    
    
    //contructor to build gui
    PinChange(String username,String cardnumber , String pinnumber){
       
       this.pinnumber = pinnumber;
       this.username = username;
       this.cardnumber = cardnumber;
       
       mainFrame();
    }
    
    
    //funtion to check which btn is clicked by user
    public void actionPerformed(ActionEvent ae){
    	//if update is click, then check currentpin , new pin and reenter pin matches 
        if(ae.getSource() == update){
            String checkpin = currpintext.getText();
            String nextpin = newpintext.getText();
            String repin = repintext.getText();
            //to check if entered pin is valid number or not
            boolean pincheck = pinCheck(checkpin, checkpin.length());
            boolean nextcheck = pinCheck(nextpin, nextpin.length());
            boolean recheck = pinCheck(repin, repin.length());
            
            if(!pincheck){
                JOptionPane.showMessageDialog(null, "Please Enter 4 digit pin in current pin");
            }else if(!nextcheck){
                JOptionPane.showMessageDialog(null, "Please Enter 4 digit pin in new pin");
            }else if(!recheck){
                JOptionPane.showMessageDialog(null, "Please Enter 4 digit pin reenter pin");
            }//if entered pin is valid then create connection with datbase to check current pin linked with username
            else{
            if(checkpin.equals(pinnumber)){
                if(nextpin.equals(repin)){
                	//if all condition are statisfied then change pin of user 
                    if(checkConnection(nextpin, checkpin)){
                        
                        setVisible(false);
                        new Transactions(username,cardnumber, nextpin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Pin change failed");
                        setVisible(false);
                        new Transactions(username,cardnumber,pinnumber).setVisible(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "New Pin and Reenter pin does not match");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Current pin does not match");
            }
        }
        }// if back btn is clicked 
        else{
            setVisible(false);
            new Transactions(username,cardnumber,pinnumber).setVisible(true);
            
        }
        
    }
    //function to check validation of entered input
    public static boolean pinCheck(String pinnumber,int length) {
             int i;
             
             if (pinnumber == null || length<4 || length>4) {
                return false;
            }else{
                try {
                     i = Integer.parseInt(pinnumber);
                     if(i>-1 && length == 4) {
                    	 return true;
                     }
                     else {
                    	 return false;
                     }
                }catch (NumberFormatException nfe) {
                    return false;
                } 
             }
         }
    
    //function to make connection with database and change pin
    public boolean checkConnection(String nextpin , String checkpin){
        if(nextpin.equals("") || checkpin.equals("")){
            return false;
        }else{
        try{
                        Conn conn = new Conn();
                        String query1= "update login set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        String query2= "update bank set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        String query3= "update balance set pin = '"+nextpin+"' where pin = '"+checkpin+"'";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        conn.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "Pin changed successfully");
                        return true;
                    } catch (Exception er){
                        System.out.println(er);
                        
                    }
        return false;
        }
    }
    
    //main function
    public static void main(String args[]){
        new PinChange("","","");
    }
    
    
}
