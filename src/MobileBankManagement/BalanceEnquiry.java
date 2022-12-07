
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

/**
 *
 * @author krunal dhavle kbd6
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
    
	//global variable declaration
    String username, cardnumber, pinnumber;
    JButton back;
    JLabel card;
    
    //frontend start
    private void mainFrame(){
        JLabel text = new JLabel("Balance Enquiry");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        card= new JLabel();
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
        
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(1280 , 780);
        
        setLocation(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //frontend ends
    }
    
    //constructor to build gui , perform task
    public BalanceEnquiry(String username, String cardnumber , String pinnumber) {
        
        setLayout(null);
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        
        mainFrame();
        
        //check if user has account, if yes then fetch balance from account , otherwise "user not found"
        if(checkConnection(username)){
            JOptionPane.showMessageDialog(null, "Balance fetch for username "+username);
        }else{
            JOptionPane.showMessageDialog(null, "user not found");
        }   
    }
    
    //here also we have only back button, when pressed go to previous window
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
                setVisible(false);
                new Transactions(username, cardnumber, pinnumber).setVisible(true);
            }
    }
    
    //connection with database , and fetching values from account
    public boolean checkConnection(String username){
    	if(username.equals("")) {
    		return false;
    	}else {
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select balance.* , login.* from balance , login where balance.username='"+username+"' and login.username='"+username+"'");
            if(rs.next()){

                         card.setText(rs.getString("username") + "  has " 
                                 +rs.getString("accountType") + " and current blance is " 
                                 +rs.getString("balance") + " pounds");
                         return true;
                        
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }}
        
        return false;
    }
    
    
    public static void main(String args[]){
        new BalanceEnquiry("","","");
    }
    
}
