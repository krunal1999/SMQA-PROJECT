
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author krunal
 */
public class Withdraw extends JFrame implements ActionListener{ 
    JTextField amountText;
    JButton withdraw, back;
    String pinnumber , username , cardnumber;
    int balance=0;
    
    private void mainFrame(){
        
    }
    
    Withdraw(String username,String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.username = username;
        this.cardnumber = cardnumber;
        mainFrame();
        
        setLayout(null);
        
        JLabel text = new JLabel("Enter the amount to withdraw");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(300,60,900,50);
        add(text);
        
        amountText = new JTextField();
        amountText.setFont(new Font("Arial" , Font.BOLD , 22));
        amountText.setBounds(400,210,400,50);
        add(amountText);
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Arial" , Font.BOLD , 22));
        withdraw.setBounds(400, 280, 400, 50);
        withdraw.setBackground(Color.red);
        withdraw.setForeground(Color.white);
        withdraw.setFocusPainted(false);
        withdraw.addActionListener(this);
        add(withdraw);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 22));
        back.setBounds(400, 350, 400, 50);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
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
            if(ae.getSource() == withdraw){
                String withdrawamount = amountText.getText();
                Date date = new Date();
                
                boolean withdrawcheck = withdrawCheck(withdrawamount, 7);
                
                if(!withdrawcheck){
                    JOptionPane.showMessageDialog(null, "Withdraw cant be empty or Please enter digits");
                } else {
                    if(!minimumWithdraw(withdrawamount) || !checkMultiple(withdrawamount)){
                        JOptionPane.showMessageDialog(null, "Minimum withdraw is 20 pounds and Multiple of 10");
                    }else{
                        try{
                        Conn conn = new Conn();
                        
                        ResultSet rs = conn.s.executeQuery("select * from balance where username = '" +username+ "'");
                        if(rs.next()){
                            if(rs.getString("username").equals(username)){
                                balance = Integer.parseInt(rs.getString("balance"));
                                
                            }
                        }
                        if(ae.getSource() != back &&  balance < Integer.parseInt(withdrawamount) ){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            return;
                            
                        }else{
                            balance -= Integer.parseInt(withdrawamount);
                        }
                        
                        String query = "insert into bank values('"+cardnumber+"' ,'"+pinnumber+"','" +date+ "' ,'Withdraw','"+withdrawamount+"' ,'" +balance+"','"+username+"')";
                        String query2= "update balance set balance = '"+balance+"' where username = '"+username+"'";
                        conn.s.executeUpdate(query);
                        conn.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, ""+withdrawamount+ " Cash withdraw successfully to account " +username);
                        setVisible(false);
                        new Transactions(username, cardnumber,pinnumber).setVisible(true);  
                    } catch (Exception er){
                        System.out.println(er);
                    }
                    }
                }
                
            } else if (ae.getSource() == back){
                setVisible(false);
                new Transactions(username, cardnumber, pinnumber).setVisible(true);
                
            }
        }
        
            public static boolean withdrawCheck(String amount,int length) {
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
        
        
        public static boolean minimumWithdraw(String amount){
            int value = Integer.parseInt(amount);
            if(value <= 20){
                return false;
            }else{
                return true;

            }

        }
        public static boolean checkMultiple(String amount){
            int value = Integer.parseInt(amount);
            if(value%10 != 0){
                return false;
            }else{
                return true;
            }
        }
    
    
    public static void main(String args[]){
        new Withdraw("","","");
        
    }
    
    
    
}
