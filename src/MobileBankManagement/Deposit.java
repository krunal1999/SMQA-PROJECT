
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
/**
 *
 * @author krunal
 */
public class Deposit extends JFrame implements ActionListener{ 
    JTextField amountText;
    JButton deposit, back;
    String pinnumber , username, cardnumber;
    int balance=0;
    
    Deposit(String username,String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.username = username;
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
                
                boolean depocheck = depoCheck(depositamount, 7);
                
                if(!depocheck){
                    JOptionPane.showMessageDialog(null, "Deposit cant be empty or Please enter digits");
                } else {
                    if(!minimumBalance(depositamount) || !checkMultiple(depositamount)){
                        JOptionPane.showMessageDialog(null, "Minimum Deposit is 50 pounds and Please enter amount in multiple of 5");
                    }else{
                        try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery("select * from balance where username = '" +username+ "'");
                        if(rs.next()){
                            if(rs.getString("username").equals(username)){
                                balance = Integer.parseInt(rs.getString("balance"));
                                balance += Integer.parseInt(depositamount);
                            }
                        }

                        String query = "insert into bank values('"+cardnumber+"' ,'"+pinnumber+"','" +date+ "' ,'Deposit','"+depositamount+"','" +balance+"','"+username+"')";
                        String query2= "update balance set balance = '"+balance+"' where username= '"+username+"'";
                        
                        conn.s.executeUpdate(query);
                        conn.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, ""+depositamount+ " Cash deposited successfully to account " +username);
                        setVisible(false);
                        new Transactions(username,cardnumber, pinnumber).setVisible(true);  
                        
                    } catch (Exception er){
                        System.out.println(er);
                    }
                    }
                    
                    
                }
                
            } else if (ae.getSource() == back){
                setVisible(false);
                new Transactions(username,cardnumber, pinnumber).setVisible(true);
                
            }
        }

        public static boolean depoCheck(String amount,int length) {
             int i;
             String j;
             if (amount == null || amount.length()>length) {
                return false;
            }else{
                try {
                     i = Integer.parseInt(amount);
                }catch (NumberFormatException nfe) {
                    return false;
                } 
                if(length <= 7){
                    
                    return true;
                }
                return true; 
             }
         }
        
        
        public static boolean minimumBalance(String amount){
            int value = Integer.parseInt(amount);
           
            if(value < 50){
                return false;
            }else{
                return true;

            }
        }
        
        public static boolean checkMultiple(String amount){
            int value = Integer.parseInt(amount);
            if(value%5 != 0){
                return false;
            }else{
                return true;
            }
        }
    
    public static void main(String args[]){
        new Deposit("","","");
        
    }
    
    
    
}
