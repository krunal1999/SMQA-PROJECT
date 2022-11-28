
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author krunal
 */
public class Deposit extends JFrame implements ActionListener{ 
    JTextField amountText;
    JButton deposit, back;
    String pinnumber , cardnumber;
    
    Deposit(String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
        setLayout(null);
        
        JLabel text = new JLabel("Enter the amount to deposit");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(300,60,900,50);
        add(text);
        
        amountText = new JTextField();
        amountText.setFont(new Font("Arial" , Font.BOLD , 22));
        amountText.setBounds(400,210,400,50);
        add(amountText);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial" , Font.BOLD , 22));
        deposit.setBounds(400, 280, 400, 50);
        deposit.setBackground(Color.green);
        deposit.setForeground(Color.white);
        deposit.setFocusPainted(false);
        deposit.addActionListener(this);
        add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 22));
        back.setBounds(400, 350, 400, 50);
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
            if(ae.getSource() == deposit){
                String depositamount = amountText.getText();
                Date date = new Date();
                if(depositamount.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter the amount to deposit");
                } else {
                    try{
                        Conn conn = new Conn();
                        String query = "insert into bank values('"+cardnumber+"' ,'"+pinnumber+"','" +date+ "' ,'Deposit','" + depositamount+"')";
                        conn.s.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, ""+depositamount+ " Cash deposited successfully to account " +cardnumber);
                        setVisible(false);
                        new Transactions(cardnumber, pinnumber).setVisible(true);  
                    } catch (Exception er){
                        System.out.println(er);
                    }
                    
                }
                
            } else if (ae.getSource() == back){
                setVisible(false);
                new Transactions(cardnumber, pinnumber).setVisible(true);
                
            }
        }

        
    
    
    public static void main(String args[]){
        new Deposit("","");
        
    }
    
    
    
}
