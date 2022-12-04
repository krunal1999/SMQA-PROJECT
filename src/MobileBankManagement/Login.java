
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
    //Global variables
    JButton signin , signup , admin;
    JTextField accnumtext ;
    JPasswordField PasswordText;
    
    
   
    
    private void mainFreame(){
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
        
        
        //heading
        JLabel text = new JLabel("Welcome to Mobile Bank");
        text.setFont(new Font("Georgia" , Font.BOLD , 54));
        text.setBounds(250, 40, 800, 140);
        add(text);
        
        //adding username and password labels and text fields
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
    Login(){
       mainFreame();
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == signin){
            String username = accnumtext.getText();
            String pinnumber = PasswordText.getText(); //this method is deprecated 
            signIn(username, pinnumber);
            //setVisible(false);
        } else if (ae.getSource() == signup){
                setVisible(false); 
                signUp();
        }else if (ae.getSource() == admin){
            String username = accnumtext.getText();
            String pinnumber = PasswordText.getText(); //this method is deprecated 
            
            adminEvent(username, pinnumber);
        }
    }
    
    public static boolean signUp(){
            new SignUpOne().setVisible(true);
            return true;
    }
    public static boolean adminEvent(String username, String pinnumber){
            String cardnumber;
            //check if entered pin is valid or not and return true or false
            boolean pincheck = true; //pinCheck(pinnumber,pinnumber.length());
            boolean usercheck = true;//userCheck(username, username.length());
            
            if(!usercheck){
                JOptionPane.showMessageDialog(null, "Please Enter valid username");
            }else if(!pincheck) {
                 JOptionPane.showMessageDialog(null, "Please Enter 4 digit pin");   
            }
            else{
                
                    JOptionPane.showMessageDialog(null, "You are not admin");
                 
                
            }
            return false;
    }
    public boolean signIn(String username, String pinnumber){
            
            String cardnumber="";
            boolean check=false;
            //check if entered pin is valid or not and return true or false
            boolean pincheck = pinCheck(pinnumber,pinnumber.length());
            boolean usercheck = userCheck(username, username.length());
            
            if(!usercheck){
                JOptionPane.showMessageDialog(null, "Please enter valid username");
                
            }else if(!pincheck) {
                 JOptionPane.showMessageDialog(null, "Please Enter 4 digit pin");  
                 
            }
            else{ 
            
                if(checkConnection(username,pinnumber,cardnumber)){
                    JOptionPane.showMessageDialog(null, "login successfull");
                    setVisible(false);
                    check = true;
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Pin");
                    }
        }   
            //new Demo();
            return check;
    }  
    public  boolean checkConnection(String username,String pinnumber,String cardnumber){
        //mysql query to select username and pin from Login table
        try{    
                Conn conn = new Conn();
                String query = "select * from login where username = '"+username+"' and pin = '" +pinnumber+ "'";
                //to store result object return by mysql
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    cardnumber = rs.getString("cardnumber");
                    new Transactions(username ,cardnumber ,pinnumber).setVisible(true);
                    return true;
                }
                else{
                   return false;
                }
        }catch (Exception e){
            System.out.println(e);
        }
               return false;
    }
      
    //pin checking and return boolean true or false
        public static boolean pinCheck(String pinnumber,int length) {
             int i;
             String j;
             if (pinnumber == null || length<4 || length>4) {
                return false;
            }else{
                try {
                     i = Integer.parseInt(pinnumber);
                }catch (NumberFormatException nfe) {
                    return false;
                } 
                if(length == 4){
                    return true;
                }
                return true; 
             }
         }
        //username checking and return boolean true or false
        public static boolean userCheck(String username,int length) {
             if (username == null || length<7 || length>7) {
                return false;
            }else{
                if(length == 7){
                    String first3char = username.substring(0, 3);
                    String last4char = username.substring(3);
                    
                    if(isString(first3char) && first3char.length() == 3){
                        //System.out.println(first3char);
                        if(isNumber(last4char) && last4char.length() == 4){
                        //System.out.println(last4char);
                        return true;
                    }
                    }
                    else{
                        return false;
                    }
                }
               return false;
             }
         }
        
        public static boolean isString(String name) {
            return name.matches("[a-zA-Z]+");
        }
        public static boolean isNumber(String name) {
            return name.matches("[0-9]+");
        }

    public static void main(String args[]){
        new Login();
    }

    
}
