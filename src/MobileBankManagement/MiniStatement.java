
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

    public MiniStatement(String username, String cardnumber , String pinnumber) {
        
        setLayout(null);
        
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        this.username=username;
        
        JLabel text = new JLabel("Mini Statement");
        text.setFont(new Font("Arial" , Font.CENTER_BASELINE , 44));
        text.setForeground(Color.green);
        text.setBounds(500,60,900,50);
        add(text);
        
        JLabel text1 = new JLabel("cardnumber                   Date                                                   type           amount         balance");
        text1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        text1.setForeground(Color.white);
        text1.setBounds(60,130,900,90);
        add(text1);
        
        card= new JLabel();
        card.setFont(new Font("Arial" , Font.CENTER_BASELINE , 20));
        card.setForeground(Color.green);
        card.setBounds(60,200,1200,200);
        add(card);
        
        update = new JButton("Update");
        update.setFont(new Font("Arial" , Font.BOLD , 20));
        update.setBounds(60, 650, 200, 50);
        update.setBackground(Color.white);
        update.setForeground(Color.black);
        update.setFocusPainted(false);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 20));
        back.setBounds(280, 650, 100, 50);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
        
//        try{
//            Conn conn = new Conn();
//            ResultSet rs = conn.s.executeQuery("select * from bank  where username='"+username+"' order by date desc limit 2");
//            while(rs.next()){
//                card.setText(card.getText()+ "<html>" +rs.getString("cardnumber")+"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
//                        +rs.getString("date")+" &nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
//                        + rs.getString("amount")+"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("balance") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>"
//                        );
//                
//                
//            }
//            
//        } catch (Exception e){
//            System.out.println(e);
//        }
    
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
                
            }else if(ae.getSource() == update){
                card.setText("");
                try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank  where username='"+username+"' order by date desc limit 5");
            while(rs.next()){
                card.setText(card.getText()+ "<html>" +rs.getString("cardnumber")+"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        +rs.getString("date")+" &nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount")+"&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("balance") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>"
                        );
                
                
            }
            
        } catch (Exception e){
            System.out.println(e);
        }
            }
    }
    
    
    
    
    
    public static void main(String args[]){
        new MiniStatement("","","");
    }
    
}
