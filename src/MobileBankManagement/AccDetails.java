
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



/**
 *
 * @author krunal
 */
public class AccDetails extends JFrame implements ActionListener {
    
    String username, cardnumber, pinnumber;
    JButton back;

    public AccDetails(String username, String cardnumber , String pinnumber) {
        
        setLayout(null);
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        
        JLabel text = new JLabel("Account Details");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        JLabel card= new JLabel();
        card.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        card.setForeground(Color.green);
        card.setBounds(100,200,600,200);
        add(card);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 22));
        back.setBounds(400, 550, 100, 50);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from signup where username='"+username+"'");
            
            if(rs.next()){
                card.setText(card.getText()+ "<html> <span> Firstname:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>" +rs.getString("firstname")+"<br> <span> Lastname:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"
                        +rs.getString("lastname")+"<br> <span> Date of birth:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+rs.getString("dob") +"<br> <span> Gender:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"
                        + rs.getString("gender")+"<br> <span> Marital:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+rs.getString("marital") +"<br> <span> Occupation:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"
                        + rs.getString("occupation")+"<br> <span> Pincode:- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+ rs.getString("pincode")+"</html"
                        ); 
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
        new AccDetails("","","");
    }
    
}
