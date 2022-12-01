
package MobileBankManagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author krunal
 */
public class Transactions extends JFrame implements ActionListener{
         //global declaration
         JButton deposit, withdraw,Balance , accdet,pinch,ministatement,exit;
         String username , pinnumber, cardnumber;
    
    
        Transactions(String username , String cardnumber, String pinnumber){
        this.username = username;
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
        
        setLayout(null);
        setTitle("Transactions Menu");
        
        JLabel text = new JLabel("Please select your Transactions");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(300,60,900,50);
        add(text);
        
        deposit = new JButton("Deposit Money");
        deposit.setFont(new Font("Arial" , Font.BOLD , 28));
        deposit.setBounds(60, 200, 290, 60);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.green);
        deposit.setFocusPainted(false);
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("Withdraw Cash");
        withdraw.setFont(new Font("Arial" , Font.BOLD , 28));
        withdraw.setBounds(60, 300, 290, 60);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.green);
        withdraw.setFocusPainted(false);
        withdraw.addActionListener(this);
        add(withdraw);
        
        Balance = new JButton("Balance Enquiry");
        Balance.setFont(new Font("Arial" , Font.BOLD , 28));
        Balance.setBounds(60, 400, 290, 60);
        Balance.setBackground(Color.white);
        Balance.setForeground(Color.green);
        Balance.setFocusPainted(false);
        Balance.addActionListener(this);
        add(Balance);
        
        accdet = new JButton("Account Details");
        accdet.setFont(new Font("Arial" , Font.BOLD , 28));
        accdet.setBounds(900, 200, 290, 60);
        accdet.setBackground(Color.white);
        accdet.setForeground(Color.green);
        accdet.setFocusPainted(false);
        accdet.addActionListener(this);
        add(accdet);
        
        pinch = new JButton("Pin Change");
        pinch.setFont(new Font("Arial" , Font.BOLD , 28));
        pinch.setBounds(900, 300, 290, 60);
        pinch.setBackground(Color.white);
        pinch.setForeground(Color.green);
        pinch.setFocusPainted(false);
        pinch.addActionListener(this);
        add(pinch);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setFont(new Font("Arial" , Font.BOLD , 28));
        ministatement.setBounds(900, 400, 290, 60);
        ministatement.setBackground(Color.white);
        ministatement.setForeground(Color.green);
        ministatement.setFocusPainted(false);
        ministatement.addActionListener(this);
        add(ministatement);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial" , Font.BOLD , 28));
        exit.setBounds(900, 500, 290, 60);
        exit.setBackground(Color.red);
        exit.setForeground(Color.white);
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        add(exit);
            
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1280 , 780);
        
        setLocation(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
            
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == exit){
                setVisible(false);
                new Login().setVisible(true);
                
            } else if (ae.getSource() == deposit){
                setVisible(false);
                new Deposit(username,cardnumber, pinnumber).setVisible(true);
                
            }else if (ae.getSource() == withdraw){
                setVisible(false);
                new Withdraw(username, cardnumber, pinnumber).setVisible(true);
                
            }else if (ae.getSource() == pinch){
                setVisible(false);
                new PinChange(username,cardnumber,pinnumber).setVisible(true);
                
            }
            else if (ae.getSource() == accdet){
                setVisible(false);
                new AccDetails(username,cardnumber,pinnumber).setVisible(true);
                
            }else if (ae.getSource() == ministatement){
                setVisible(false);
                new MiniStatement(username,cardnumber,pinnumber).setVisible(true);
                
            }else if (ae.getSource() == Balance){
                setVisible(false);
                new BalanceEnquiry(username,cardnumber,pinnumber).setVisible(true);
                
            }
            
        }

        
    
    
    public static void main(String args[]){
        new Transactions("" , "","");
        
    }
    
}
