
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



/**
 *
 * @author krunal
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
    
    String username, cardnumber, pinnumber;
    JButton back;

    public BalanceEnquiry(String username, String cardnumber , String pinnumber) {
        
        setLayout(null);
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        
        JLabel text = new JLabel("Balance Enquiry");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        JLabel card= new JLabel();
        card.setFont(new Font("Arial" , Font.CENTER_BASELINE , 24));
        card.setForeground(Color.green);
        card.setBounds(100,200,900,200);
        add(card);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 22));
        back.setBounds(100, 550, 100, 50);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select balance.* , login.* from balance , login where balance.username='"+username+"' and login.username='"+username+"'");
            
            if(rs.next()){

                         card.setText(rs.getString("username") + " Your " +rs.getString("accountType") + " has Balance of " +rs.getString("balance") + "pounds");
                        
            }
           
            
        } catch (Exception e){
            System.out.println(e);
        }
    
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1280 , 780);
        
        setLocation(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
            
          
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
                setVisible(false);
                new Transactions(username, cardnumber, pinnumber).setVisible(true);
                
            }
    }
    
    
    
    
    
    public static void main(String args[]){
        new BalanceEnquiry("","","");
    }
    
}
