
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author krunal dhavle kbd6
 */

public class SignUpTwo extends JFrame implements ActionListener {
		//decalaring global variable
        JRadioButton r1,r2;
        JCheckBox c1;
        JButton submit , cancel;
        String formno ,username;
        int balance = 0;
        String cardnumber , pinnumber ,  accountType;
        String checkcardnumber,checkpinnumber;

        //frontend start
        private void mainFrame(){
        setTitle("Money Bank");
        setLayout(null);
        //just text line 
        JLabel Page2 = new JLabel("Page 2 : Account Details");
        Page2.setFont(new Font("Arial" , Font.CENTER_BASELINE , 24));
        Page2.setBounds(350,90,500,50);
        add(Page2);
        
        JLabel type1 = new JLabel("username");
        type1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        type1.setBounds(100,200,200,30);
        add(type1);
        
        JLabel type2 = new JLabel(username);
        type2.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        type2.setBounds(300,200,200,30);
        add(type2);
        
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        type.setBounds(100,250,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        r1.setBackground(Color.white);
        r1.setBounds(300,250,150,30);
        add(r1);
        
        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        r2.setBackground(Color.white);
        r2.setBounds(550,250,200,30);
        add(r2);
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel cardnumber = new JLabel("XXXX-XXXX");
        cardnumber.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        cardnumber.setBounds(300,300,500,30);
        add(cardnumber);
        
        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        JLabel pinnumber = new JLabel("X-X-X-X");
        pinnumber.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        pinnumber.setBounds(300,350,500,30);
        add(pinnumber);
        
        c1 = new JCheckBox("Agree terms and condition");
        c1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        c1.setBounds(100,450,600,30);
        c1.setBackground(Color.white);
        add(c1);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial" , Font.BOLD , 20));
        submit.setBounds(100, 500, 120, 40);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("cancel");
        cancel.setFont(new Font("Arial" , Font.BOLD , 20));
        cancel.setBounds(240, 500, 120, 40);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        setSize(1080 , 780);
        setVisible(true);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //frontend ends
        }
    
        //constructor
        SignUpTwo(String formno , String username){
        this.formno = formno;
        this.username=username;
        mainFrame();
        }
        
        //function to check which btn is clicked
        public void actionPerformed(ActionEvent ae){
        	
        	//i submit is clicked , then check and create cardnumber and pin
        	if(ae.getSource() == submit){
            
            accountType = "";
            boolean checkbox=false;
            
            if(r1.isSelected()){
                accountType = "Saving Account";
            } else{
                accountType = "Current Account";
            }
            if(c1.isSelected()){
                checkbox = true;
            }else {
            	checkbox = false;
            }
            
            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Please select type of account");
            }else if(!checkbox){
                JOptionPane.showMessageDialog(null, "Accept the terms and conditions");
            }else{
                
            Random random = new Random();
            
            //sometimes random function give one digit less in card number and pin so we are validating it.
            checkcardnumber =""+ Math.abs((random.nextInt() % 90000000L)+ 1111111000000000L);
            cardnumber = checkCardNumber(checkcardnumber);
            
            checkpinnumber= "" + Math.abs((random.nextInt() % 9000L)+ 1000L);
            pinnumber = checkPinNumber(checkpinnumber);
            
            if(accountType.equals("")){ 
                   JOptionPane.showMessageDialog(null, "Details are missing");
             }//if all data is filled and checkbox is ticked then make connection with database and create new user
            else if(c1.isSelected()){
                if(checkConnection(balance, username, formno, cardnumber, pinnumber, accountType)){
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                }else{
                    JOptionPane.showMessageDialog(null, "Please login again");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Accept the terms and conditions");
            }
            }
        } else {
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }
    //function to check random pin number is valid or not
    public String checkPinNumber(String pinnumber){
        if(pinnumber.length() <=3){
            if(pinnumber.equals("")){
                pinnumber="2341";
            }else{
            int randomInt = Integer.parseInt(pinnumber);
            randomInt += 1000;
            pinnumber = randomInt+"";
            }
        }
        return pinnumber;
    }
    //fuction to check if random card number valid or not
    public String checkCardNumber(String cardnumber){
        Random random = new Random();
        if(cardnumber.length() <=15){
            if(cardnumber.equals("")){
                cardnumber= ""+ Math.abs((random.nextInt() % 90000000L)+ 1111111000000000L);
            }else{
                cardnumber= ""+ Math.abs((random.nextInt() % 90000000L)+ 1111111000000000L);
            }
        }
        return cardnumber;
    }
    
    //function to make connection with database and insert value into it
    public boolean checkConnection(int balance , String username, String formno, String cardnumber , String pinnumber , String accountType){
        try{
                    Conn conn = new Conn();
                    String query1 = "insert into balance values ('"+balance+"', '"+cardnumber+"', '"+pinnumber+"','"+username+"')";
                    String query2 = "insert into login values ('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+username+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"User name " + username + "\n Pin: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(username,cardnumber, pinnumber).setVisible(true);
                    return true;
                        
            } catch (Exception e){
                System.out.println(e);
                return false;
            }
        
    }
    
    //main
    public static void main(String args[]){
     new SignUpTwo("","");   
    }
    
}
