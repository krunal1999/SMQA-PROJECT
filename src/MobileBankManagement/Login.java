
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author krunal
 */
public class Login extends JFrame implements ActionListener{
    JButton signin , signup , admin;
    JTextField accnumtext ;
    JPasswordField PasswordText;
    
    
    Login(){
        setTitle("Money Bank");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        //Adding and resizing Bank logo
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo1.JPG"));
        Image logosize = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon Banklogo = new ImageIcon(logosize);
        JLabel logolabel = new JLabel(Banklogo);
        logolabel.setBounds(80,40,100,100);
        add(logolabel);
        
        
        //adding username and password labels and text fields
        JLabel text = new JLabel("Welcome to Mobile Bank");
        text.setFont(new Font("Georgia" , Font.BOLD , 54));
        text.setBounds(250, 40, 800, 140);
        add(text);
        
        JLabel accnum = new JLabel("Username");
        accnum.setFont(new Font("Arial" , Font.BOLD , 32));
        accnum.setBounds(200, 240, 400, 30);
        add(accnum);
        
        accnumtext = new JTextField();
        accnumtext.setFont(new Font("Arial" , Font.PLAIN , 20));
        accnumtext.setBounds(400, 240, 270, 30);
        add(accnumtext);
        
        JLabel Password = new JLabel("Password");
        Password.setFont(new Font("Arial" , Font.BOLD , 32));
        Password.setBounds(200, 320, 400, 30);
        add(Password);
        
        PasswordText = new JPasswordField();
        PasswordText.setFont(new Font("Arial" , Font.PLAIN , 20));
        PasswordText.setBounds(400, 320, 270, 30);
        add(PasswordText);
   
        //adding signIn , SignUp , Admin buttons
        signin = new JButton("SIGN IN");
        signin.setFont(new Font("Arial" , Font.BOLD , 20));
        signin.setBounds(400, 380, 120, 40);
        signin.setBackground(Color.GREEN);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        signup = new JButton("SIGN UP");
        signup.setFont(new Font("Arial" , Font.BOLD , 20));
        signup.setBounds(550, 380, 120, 40);
        signup.setBackground(Color.GREEN);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        admin = new JButton("ADMIN LOGIN");
        admin.setFont(new Font("Arial" , Font.BOLD , 20));
        admin.setBounds(400, 450, 270, 40);
        admin.setBackground(Color.RED);
        admin.setForeground(Color.white);
        admin.addActionListener(this);
        add(admin);
       
        setSize(1080 , 780);
        setVisible(true);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signin){
            Conn conn = new Conn();
            String username = accnumtext.getText();
            String pinnumber = PasswordText.getText();
            String cardnumber;
            
            String query = "select * from login where username = '"+username+"' and pin = '" +pinnumber+ "'";
            
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    cardnumber = rs.getString("cardnumber");
                    setVisible(false);
                    new Transactions(username ,cardnumber ,pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Pin");
                }
                
            }catch (Exception er){
                System.out.println(er);
            }
            
        } else if(e.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        } else if(e.getSource() == admin){
            
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
            
    
}
