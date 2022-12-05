
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
    String depositamount;
    Date date;
            
    private void mainFrame(){
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
    
    Deposit(String username,String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.username = username;
        this.cardnumber = cardnumber;
        mainFrame();
        
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == deposit){
                
                depositamount = amountText.getText();
                date = new Date();
                
                boolean depocheck = depoCheck(depositamount, 7);
                
                if(!depocheck){
                    JOptionPane.showMessageDialog(null, "Deposit cant be empty or Please enter digits");
                } else {
                    if(!minimumBalance(depositamount) || !checkMultiple(depositamount)){
                        JOptionPane.showMessageDialog(null, "Minimum Deposit is 50 pounds and Please enter amount in multiple of 5");
                    }else{
                        if(checkConnection(username, balance, depositamount, cardnumber, pinnumber, date)){
                            JOptionPane.showMessageDialog(null, "Amount has been deposited");
                        }else{
                            JOptionPane.showMessageDialog(null, "Amount has not been deposited");
                        }
                    }
                }
            } else if (ae.getSource() == back){
                backBtn();
            }
        }
        
        public  boolean backBtn(){
            setVisible(false);
            new Transactions(username,cardnumber, pinnumber).setVisible(true);
            return true;
        }
    
        public boolean checkConnection(String username, int balance, String depositamount , String cardnumber, String pinnumber , Date date ){
            try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery("select balance.* , login.* from balance , login where balance.username='"+username+"' and login.username='"+username+"'");
                        if(rs.next()){
                            
                            if(rs.getString("username").equals(username)){
                                if(rs.getString("accountType").equals("Saving Account")){
                                    balance = Integer.parseInt(rs.getString("balance"));
                                    balance += Integer.parseInt(depositamount);
                                    balance += interest("Saving Account");
                                
                            }else{
                                    balance = Integer.parseInt(rs.getString("balance"));
                                    balance += Integer.parseInt(depositamount);
                                    balance += interest("Current Account");                                     
                                }
                                
                            }
                        }

                        String query = "insert into bank values('"+cardnumber+"' ,'"+pinnumber+"','" +date+ "' ,'Deposit','"+depositamount+"','" +balance+"','"+username+"')";
                        String query2= "update balance set balance = '"+balance+"' where username= '"+username+"'";
                        
                        conn.s.executeUpdate(query);
                        conn.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, ""+depositamount+ " Cash deposited successfully to account " +username + " total balance is " +balance);
                        setVisible(false);
                        new Transactions(username,cardnumber, pinnumber).setVisible(true);  
                        return true;
                    } catch (Exception er){
                        System.out.println(er);
                        return false;
                    }
        }
        public int interest(String acctype){
            int inter = 0;
            if(acctype == "Saving Account" ){
                inter = 30;
            }else{
                inter = 10;
            }
            
            return inter;
        }

        public static boolean depoCheck(String amount,int length) {
             int i;
             String j;
             if (amount == null || amount.length()>length || length == 0) {
                return false;
            }else{
                try {
                     i = Integer.parseInt(amount);
                     if(!minimumBalance(amount)){
                         return false;
                     }
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
