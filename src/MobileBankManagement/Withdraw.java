
package MobileBankManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author krunal dhavle kbd6
 */
public class Withdraw extends JFrame implements ActionListener{ 
	//global declaration
    JTextField amountText;
    JButton withdraw, back;
    String pinnumber , username , cardnumber;
    int balance=0 , interestamt=0;
    String withdrawamount;
    Date date;
    
    //frontend start here
    private void mainFrame(){
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
        //frontend ends

    }
    
    //constructor to build gui
    Withdraw(String username,String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.username = username;
        this.cardnumber = cardnumber;
        mainFrame();
    }
    
    //function to check which btn is clicked
    public void actionPerformed(ActionEvent ae){
    	//if withdraw is clicked, validate amount and withdraw
            if(ae.getSource() == withdraw){
                withdrawamount = amountText.getText();
                date = new Date();
                
                boolean withdrawcheck = withdrawCheck(withdrawamount, 7);
                
                //amount should be integer number only
                if(!withdrawcheck){
                    JOptionPane.showMessageDialog(null, "Withdraw cant be empty or Please enter digits");
                    amountText.setText("");
                } //minimumbalance to withdraw is 30 pounds and multiple of 10
                else {
                    if(!minimumWithdraw(withdrawamount) || !checkMultiple(withdrawamount)){
                        JOptionPane.showMessageDialog(null, "Minimum withdraw is 30 pounds and Multiple of 10");
                    }//if all conditions satisfy then make connection with database
                    else{
                        if(checkConnection(username, withdrawamount, balance, date, cardnumber, pinnumber ,interestamt)){
                            JOptionPane.showMessageDialog(null, "Money withdraw successfully");
                        }else{
                            JOptionPane.showMessageDialog(null, "Money withdraw failed");
                        }
                        
                    }
                }
                
            }//if back btn is pressed, go to transaction frame 
            else if (ae.getSource() == back){
                setVisible(false);
                new Transactions(username, cardnumber, pinnumber).setVisible(true);
                
            }
        }
        	//function to check is amount is valid or not
            public static boolean withdrawCheck(String amount,int length) {
             int i;
             if (amount == null || amount.length()>length) {
                return false;
            }else{
                try {
                     i = Integer.parseInt(amount);
                     if(i<=0){
                         return false;
                     }
                }catch (NumberFormatException nfe) {
                    return false;
                } 
                if(length <= 7 && minimumWithdraw(amount) && checkMultiple(amount)){
                    
                    return true;
                }
                return false; 
             }
         }
        
        //function to check if amount is above minimum limit or not
        public static boolean minimumWithdraw(String amount){
            int value = Integer.parseInt(amount);
            if(value < 30){
                return false;
            }else{
                return true;

            }

        }
        //function to check if amount is in multiple of 10 or not
        public static boolean checkMultiple(String amount){
            int value = Integer.parseInt(amount);
            if(value%10 != 0){
                return false;
            }else{
                return true;
            }
        }
        
        //function to make connection with database , and check balance , if conditions match then withdraw amount
        public boolean checkConnection(String username, String withdrawamount , int balance, Date date , String cardnumber ,String pinnumber , int interestamt){
            if(username.equals("")) {
            	return false;
            }else {
        	try{
                        Conn conn = new Conn();
                        
                        ResultSet rs = conn.s.executeQuery("select balance.* , login.* from balance , login where balance.username='"+username+"' and login.username='"+username+"'");
                        if(rs.next()){
                            if(rs.getString("username").equals(username)){
                                
                            	//to check user has which type of account
                                balance = Integer.parseInt(rs.getString("balance"));
                                if(rs.getString("accountType").equals("Saving Account")){
                                    interestamt = interest("Saving Account");
                                    balance -= interestamt;
                 
                                }else{
                                    interestamt = interest("Current Account");
                                    balance -= interestamt;
                                }
                                
                            }
                        }else{
                            return false;
                        }
                        
                        //to check withdrawing amount is then balanc then withdraw , otherwise dont
                        if(balance < Integer.parseInt(withdrawamount) ){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            return false;
                            
                        }else{
                            balance -= Integer.parseInt(withdrawamount);
                            String query = "insert into bank values('"+cardnumber+"' ,'"+pinnumber+"','" +date+ "' ,'Withdraw','"+withdrawamount+"' ,'" +balance+"','"+username+"' , '"+interestamt+"')";
                            String query2= "update balance set balance = '"+balance+"' where username = '"+username+"'";
                            conn.s.executeUpdate(query);
                            conn.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null, ""+withdrawamount+ " Cash withdraw successfully from account " +username);
                        setVisible(false);
                        new Transactions(username, cardnumber,pinnumber).setVisible(true); 
                        return true;
                        }
                        
                        
                    } catch (Exception er){
                        System.out.println(er);
                        return false;
                    }}
            
            
        }
        
        //function to check interest cut per withdraw for saving and current account
        public int interest(String acctype){
            int inter = 0;
            if(acctype == "Saving Account" ){
                inter = 20;
            }else if(acctype == "Current Account"){
                inter = 5;
            }else{
                inter = 0;
            }
            
            return inter;
        }
    
    //main
    public static void main(String args[]){
        new Withdraw("","","");
        
    }
    
    
    
}
