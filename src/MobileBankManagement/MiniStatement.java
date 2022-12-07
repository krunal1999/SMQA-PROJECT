
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;




/**
 *
 * @author krunal dhavle kbd6
 */
public class MiniStatement extends JFrame implements ActionListener {
    
	//global decalaration
    String username, cardnumber, pinnumber;
    JButton back , update;
    JLabel card;
    
    //frontend start
    private void mainFrame(){
        setLayout(null);
        JLabel text = new JLabel("Mini Statement");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        JLabel text1 = new JLabel("  Cardnumber                   Date                                               Type           Amount           Interest    Balance");
        text1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        text1.setForeground(Color.white);
        text1.setBounds(60,130,1100,90);
        add(text1);
        
        card= new JLabel();
        card.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        card.setForeground(Color.green);
        card.setBounds(60,200,1200,400);
        add(card);
        
        update = new JButton("Update");
        update.setFont(new Font("Arial" , Font.BOLD , 20));
        update.setBounds(60, 650, 200, 50);
        update.setBackground(Color.green);
        update.setForeground(Color.white);
        update.setFocusPainted(false);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 20));
        back.setBounds(280, 650, 100, 50);
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
        
        //frontend ends
    }
    
    
    //constructor to call frontend
    MiniStatement(String username, String cardnumber , String pinnumber) {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        mainFrame();
    }
    
    //function to check which btn is pressed by user
    public void actionPerformed(ActionEvent ae){
         //if update is pressed , and need to press to view statement
         if(ae.getSource() == update){
        	 //check if username has account or not
                if(checkConnection(username)){
                    JOptionPane.showMessageDialog(null, "user details found");
                }else{
                      JOptionPane.showMessageDialog(null, "user not found");
                }
        }//if back btn is pressed ,call backbtn function
         else {
        	backBtn();
        }
         
    }
    
    //function to open previous frame
    public boolean backBtn(){
        setVisible(false);
        new Transactions(username, cardnumber, pinnumber).setVisible(true);
        return true;
    }
    
    //function to check connection with database , if successful then return true and ministatement of last 8 transcations
    public boolean checkConnection(String username){
            card.setText("");
            if(username.equals("")){
                return false;
            }else{
            try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where username='"+username+"' order by date desc limit 8");
            if(rs.next()){
            do{
                    card.setText(card.getText()+ "<html> <table> "
                        + "<tr> <td style=\"border: 1px solid white;\">"
                        +rs.getString("cardnumber")+"</td>"+"<td style=\"border: 1px solid white;\">"
                        +rs.getString("date")+"</td>"+ "<td width=\"150\"style=\"border: 1px solid white;\">"
                        +rs.getString("type")+"</td> <td width=\"150\" style=\"border: 1px solid white;\">"
                        +rs.getString("amount")+"</td> <td width=\"150\"style=\"border: 1px solid white;\">" 
                        +rs.getString("interestamt")+"</td> <td width=\"150\"style=\"border: 1px solid white;\">"     
                        + rs.getString("balance") 
                        +"</td></tr></table>"
                        );       
            }while(rs.next());
            
            return true;
            }
            else{
                return false;
            }
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
           
        }
    }
    
    
    
    public static void main(String args[]){
        new MiniStatement("","","");
    }
    
}
