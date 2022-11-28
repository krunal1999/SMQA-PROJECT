
package MobileBankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author krunal
 */
public class Login extends JFrame implements ActionListener{
    JButton signin , signup , admin;
    JTextField UserNameText ;
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
        
        JLabel UserName = new JLabel("Username");
        UserName.setFont(new Font("Arial" , Font.BOLD , 32));
        UserName.setBounds(200, 240, 400, 30);
        add(UserName);
        
        UserNameText = new JTextField();
        UserNameText.setFont(new Font("Arial" , Font.PLAIN , 20));
        UserNameText.setBounds(400, 240, 270, 30);
        add(UserNameText);
        
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
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signin){
            
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
