
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author krunal
 */
public class SignUpTwo extends JFrame implements ActionListener {
        JRadioButton r1,r2;
        JCheckBox c1;
        JButton submit , cancel;
        String formno ,username;
        int balance = 0;
    
    SignUpTwo(String formno , String username){
        this.formno = formno;
        this.username=username;
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
        
        JLabel type2 = new JLabel("XXXXXXX");
        type2.setFont(new Font("Arial" , Font.CENTER_BASELINE , 16));
        type2.setBounds(100,200,200,30);
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
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Saving Account";
            } else if(r2.isSelected()){
                accountType = "Current Account";
            }
        
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextInt() % 90000000L)+ 1111111000000000L);
            String pinnumber = "" + Math.abs((random.nextInt() % 9000L)+ 1000L);
            //System.out.println(cardnumber);
            //System.out.println(pinnumber);
       
            try{
                if(accountType.equals("")){  //false && false , false || false
                   JOptionPane.showMessageDialog(null, "Details are missing");
                }
                else{
                    if(c1.isSelected()){
                    Conn conn = new Conn();
                    String query1 = "insert into balance values ('"+balance+"', '"+cardnumber+"', '"+pinnumber+"','"+username+"')";
                    String query2 = "insert into login values ('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+username+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"User name " + username + "\n Pin: " + pinnumber);
                        
                    }else {
                        JOptionPane.showMessageDialog(null, "Accept the terms and conditions");
                    } 
                    setVisible(false);
                    new Deposit(username,cardnumber, pinnumber).setVisible(true);
                }
                        
            } catch (Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }
    
    public static void main(String args[]){
     new SignUpTwo("","");   
    }
    
}
