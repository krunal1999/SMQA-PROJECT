
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
public class MiniStatement extends JFrame implements ActionListener {
    
    String username, cardnumber, pinnumber;
    JButton back , update;
    JLabel card;
    
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
        card.setBounds(60,200,1200,300);
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
    }

    MiniStatement(String username, String cardnumber , String pinnumber) {
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        mainFrame();
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
                backBtn();
                
            }else if(ae.getSource() == update){
                if(checkConnection(username)){
                    JOptionPane.showMessageDialog(null, "user details found");
                }else{
                      JOptionPane.showMessageDialog(null, "user not found");
                }
        }
    }
    
    public boolean backBtn(){
        setVisible(false);
        new Transactions(username, cardnumber, pinnumber).setVisible(true);
        return true;
    }
    
    public boolean checkConnection(String username){
            card.setText("");
            if(username.equals("")){
                return false;
            }else{
            try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank  where username='"+username+"' order by date desc limit 5");
            if(rs.next()){
            while(rs.next()){
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
            }
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
