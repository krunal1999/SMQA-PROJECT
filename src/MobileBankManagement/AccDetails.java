
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



/**
 *
 * @author  krunal dhavle kbd6
 */
public class AccDetails extends JFrame implements ActionListener {
    
	//Global vaiables 
    String username, cardnumber, pinnumber;
    JButton back;
    JLabel card;
    
    //frontend start 
    private void mainFrame(){
        
        JLabel text = new JLabel("Account Details");
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
        
        //frontend end
    }
    
    //constructor to build gui, perform task
     AccDetails(String username, String cardnumber , String pinnumber) {
        
        setLayout(null);
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        
        mainFrame();
        
        	//checking if user has account in bank or not, if yes then show acc detials , otherwise "user not found"
            if(checkConnection(username)){
                JOptionPane.showMessageDialog(null, "User detials fetched");
            }
            else{
                JOptionPane.showMessageDialog(null, "User not found");
            }
          
    }
    
     //checking which button is clicked by user, here we only have one btn
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
        	//back button is clicked , drop current frame and open new transaction frame
                setVisible(false);
                new Transactions(username, cardnumber, pinnumber).setVisible(true); 
            }
    }
    
    //making connection with databasae and giving result out
    public boolean checkConnection(String Username){
    	if(username.equals("")) {
    		return false;
    	}else {
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from signup where username='"+username+"'");  
            if(rs.next()){

                         card.setText(card.getText()+ "<html> <table style=\"border: 1px solid white;\"> <tr> <th style=\"border: 1px solid white;\">Firstname </th><th style=\"border: 1px solid white;\">Lastname </th><th style=\"border: 1px solid white;\">Age </th><th style=\"border: 1px solid white;\">Gender </th><th style=\"border: 1px solid white;\">Marital </th><th style=\"border: 1px solid white;\">Occupation </th><th style=\"border: 1px solid white;\">pincode </th></tr> "
                        + "<tr> <td style=\"border: 1px solid white;\">"
                        +rs.getString("firstname")+"</td>"+"<td style=\"border: 1px solid white;\">"
                        +rs.getString("lastname")+"</td>"+ "<td style=\"border: 1px solid white;\">"
                        +rs.getString("age")+"</td> <td style=\"border: 1px solid white;\">"
                        +rs.getString("gender")+"</td> <td style=\"border: 1px solid white;\">" 
                        + rs.getString("marital")+"</td> <td style=\"border: 1px solid white;\">" 
                        + rs.getString("occupation")+"</td> <td style=\"border: 1px solid white;\">" 
                        + rs.getString("pincode")+ "</td></tr></table></html>"
                        );
                        return true;
       
            }else {
            	return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }}
      
    }
    
    //main function
    public static void main(String args[]){
        new AccDetails("","","");
    }
    
}
