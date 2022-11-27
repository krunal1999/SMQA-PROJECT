
package MobileBankManagement;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
/**
 *
 * @author krunal
 */


public class SignUpOne extends JFrame {
    long random;
    JTextField textFirstname , textLastname,textPincode;
    JDateChooser date;
    JRadioButton male;
    
    JButton next;
    SignUpOne(){
        setLayout(null);
        
        //Genrating random number
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 7000L) + 1000L);
        
        //creating and adding Form no
        JLabel Formno = new JLabel("Account Number :- ' " + random + " '");
        Formno.setFont(new Font("Arial" , Font.BOLD , 34));
        Formno.setBounds(300,40,500,50);
        add(Formno);
        
        //just text line 
        JLabel Page1 = new JLabel("Page 1 : Personal Details");
        Page1.setFont(new Font("Arial" , Font.CENTER_BASELINE , 24));
        Page1.setBounds(350,90,500,50);
        add(Page1);
        
        // creating label and textfield for firstname
        JLabel Firstname = new JLabel("Firstname");
        Firstname.setFont(new Font("Arial" , Font.PLAIN , 20));
        Firstname.setBounds(100,150,100,50);
        add(Firstname);
        
        textFirstname = new JTextField();
        textFirstname.setFont(new Font("Arial" , Font.PLAIN , 16));
        textFirstname.setBounds(300,160,400,30);
        add(textFirstname);
        
        // creating label and textfield for lastname
        JLabel Lastname = new JLabel("Lastname");
        Lastname.setFont(new Font("Arial" , Font.PLAIN , 20));
        Lastname.setBounds(100,200,100,50);
        add(Lastname);
        
        textLastname = new JTextField();
        textLastname.setFont(new Font("Arial" , Font.PLAIN , 16));
        textLastname.setBounds(300,210,400,30);
        add(textLastname);
        
        // creating label and textfield for dob
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial" , Font.PLAIN , 20));
        dob.setBounds(100,250,300,50);
        add(dob);
        
        JDateChooser date  = new JDateChooser();
        date.setFont(new Font("Arial" , Font.PLAIN , 18));
        date.setBounds(300,260,300,30);
        add(date);
        
        // creating label and textfield for gender
        JLabel gender  = new JLabel("Gender");
        gender.setFont(new Font("Arial" , Font.PLAIN , 20));
        gender.setBounds(100,300,100,50);
        add(gender);
        
        JRadioButton male = new JRadioButton("Male");
        male.setFont(new Font("Arial" , Font.PLAIN , 20));
        male.setBounds(300,310,100,30);
        male.setBackground(Color.white);
        add(male);
        
        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial" , Font.PLAIN , 20));
        female.setBounds(420,310,100,30);
        female.setBackground(Color.white);
        add(female);
        
        JRadioButton othergender = new JRadioButton("Other");
        othergender.setFont(new Font("Arial" , Font.PLAIN , 20));
        othergender.setBounds(540,310,100,30);
        othergender.setBackground(Color.white);
        add(othergender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(othergender);
        
        // creating label and textfield for Maritial status
        JLabel maritalstatus  = new JLabel("Marital Status");
        maritalstatus.setFont(new Font("Arial" , Font.PLAIN , 20));
        maritalstatus.setBounds(100,350,200,50);
        add(maritalstatus);
        
        JRadioButton single = new JRadioButton("Single");
        single.setFont(new Font("Arial" , Font.PLAIN , 20));
        single.setBounds(300,360,100,30);
        single.setBackground(Color.white);
        add(single);
        
        JRadioButton married = new JRadioButton("Married");
        married.setFont(new Font("Arial" , Font.PLAIN , 20));
        married.setBounds(420,360,100,30);
        married.setBackground(Color.white);
        add(married);
        
        JRadioButton otherstatus = new JRadioButton("Other");
        otherstatus.setFont(new Font("Arial" , Font.PLAIN , 20));
        otherstatus.setBounds(540,360,100,30);
        otherstatus.setBackground(Color.white);
        add(otherstatus);
            
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(single);
        maritialgroup.add(married);
        maritialgroup.add(otherstatus);
        
        
        // creating label and textfield for Pincode
        JLabel Pincode  = new JLabel("Pincode");
        Pincode.setFont(new Font("Arial" , Font.PLAIN , 20));
        Pincode.setBounds(100,400,100,50);
        add(Pincode);
        
        textPincode = new JTextField();
        textPincode.setFont(new Font("Arial" , Font.PLAIN , 16));
        textPincode.setBounds(300,410,400,30);
        add(textPincode);
        
        
        next = new JButton("Next");
        next.setFont(new Font("Arial" , Font.BOLD , 20));
        next.setBounds(600, 580, 120, 40);
        next.setBackground(Color.GREEN);
        next.setForeground(Color.white);
        //next.addActionListener(this);
        add(next);
       
        
        getContentPane().setBackground(Color.white);
        setSize(1080 , 780);
        setVisible(true);
        setLocation(200, 200);
    }
        
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == next){
            // to do this
        }
    }

    public static void main(String args[]){
        new SignUpOne();
    }
}
