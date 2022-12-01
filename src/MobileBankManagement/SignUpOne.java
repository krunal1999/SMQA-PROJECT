
package MobileBankManagement;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.event.*;
import java.time.*;
/**
 *
 * @author krunal
 */


public class SignUpOne extends JFrame implements ActionListener{
    long random ,randomforuserid;
    JTextField textFirstname , textLastname,textPincode;
    JDateChooser date;
    JRadioButton male , female , othergender , single, married ,otherstatus , student , employee, business, otheroccupation;
    JButton next;
    SignUpOne(){
        setLayout(null);
        
        //Genrating random number
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        randomforuserid = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        //creating and adding Form no
        JLabel Formno = new JLabel("Form Number :- ' " + random + " '");
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
        textFirstname.setBounds(300,160,200,30);
        add(textFirstname);
        
        // creating label and textfield for lastname
        JLabel Lastname = new JLabel("Lastname");
        Lastname.setFont(new Font("Arial" , Font.PLAIN , 20));
        Lastname.setBounds(100,200,100,50);
        add(Lastname);
        
        textLastname = new JTextField();
        textLastname.setFont(new Font("Arial" , Font.PLAIN , 16));
        textLastname.setBounds(300,210,200,30);
        add(textLastname);
        
        // creating label and textfield for dob
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial" , Font.PLAIN , 20));
        dob.setBounds(100,250,300,50);
        add(dob);
        
        date  = new JDateChooser();
        date.setFont(new Font("Arial" , Font.PLAIN , 18));
        date.setBounds(300,260,200,30);
        add(date);
        
        // creating label and textfield for gender
        JLabel gender  = new JLabel("Gender");
        gender.setFont(new Font("Arial" , Font.PLAIN , 20));
        gender.setBounds(100,300,100,50);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setFont(new Font("Arial" , Font.PLAIN , 20));
        male.setBounds(300,310,100,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setFont(new Font("Arial" , Font.PLAIN , 20));
        female.setBounds(420,310,100,30);
        female.setBackground(Color.white);
        add(female);
        
        othergender = new JRadioButton("Other");
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
        
        single = new JRadioButton("Single");
        single.setFont(new Font("Arial" , Font.PLAIN , 20));
        single.setBounds(300,360,100,30);
        single.setBackground(Color.white);
        add(single);
        
        married = new JRadioButton("Married");
        married.setFont(new Font("Arial" , Font.PLAIN , 20));
        married.setBounds(420,360,100,30);
        married.setBackground(Color.white);
        add(married);
        
        otherstatus = new JRadioButton("Other");
        otherstatus.setFont(new Font("Arial" , Font.PLAIN , 20));
        otherstatus.setBounds(540,360,100,30);
        otherstatus.setBackground(Color.white);
        add(otherstatus);
            
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(single);
        maritialgroup.add(married);
        maritialgroup.add(otherstatus);
        
        //creating label and textfield for occupation
        JLabel occupationstatus  = new JLabel("Occupation Status");
        occupationstatus.setFont(new Font("Arial" , Font.PLAIN , 20));
        occupationstatus.setBounds(100,400,200,50);
        add(occupationstatus);
        
        student = new JRadioButton("Student");
        student.setFont(new Font("Arial" , Font.PLAIN , 20));
        student.setBounds(300,410,120,30);
        student.setBackground(Color.white);
        add(student);
        
        employee = new JRadioButton("Employee");
        employee.setFont(new Font("Arial" , Font.PLAIN , 20));
        employee.setBounds(420,410,120,30);
        employee.setBackground(Color.white);
        add(employee);
        
        business = new JRadioButton("Business");
        business.setFont(new Font("Arial" , Font.PLAIN , 20));
        business.setBounds(540,410,140,30);
        business.setBackground(Color.white);
        add(business);
        
        otheroccupation = new JRadioButton("Other");
        otheroccupation.setFont(new Font("Arial" , Font.PLAIN , 20));
        otheroccupation.setBounds(680,410,140,30);
        otheroccupation.setBackground(Color.white);
        add(otheroccupation);
        
        ButtonGroup occupationalgroup = new ButtonGroup();
        occupationalgroup.add(student);
        occupationalgroup.add(employee);
        occupationalgroup.add(business);
        occupationalgroup.add(otheroccupation);
        
        // creating label and textfield for Pincode
        JLabel Pincode  = new JLabel("Pincode");
        Pincode.setFont(new Font("Arial" , Font.PLAIN , 20));
        Pincode.setBounds(100,450,100,50);
        add(Pincode);
        
        textPincode = new JTextField();
        textPincode.setFont(new Font("Arial" , Font.PLAIN , 16));
        textPincode.setBounds(300,460,200,30);
        add(textPincode);
        
        
        next = new JButton("Next");
        next.setFont(new Font("Arial" , Font.BOLD , 20));
        next.setBounds(600, 580, 120, 40);
        next.setBackground(Color.GREEN);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
       
        
        getContentPane().setBackground(Color.white);
        setSize(1080 , 780);
        setVisible(true);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        
    public void actionPerformed(ActionEvent e){
        String formno = random+"";  // long vlaue
        String userid = randomforuserid+"";
        String firstname = textFirstname.getText();
        String lastname = textLastname.getText();
        String dob =((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (othergender.isSelected()){
            gender = "Ohter";
        }
        
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        } else if (married.isSelected()){
            marital = "Married";
        } else if (otherstatus.isSelected()){
            marital = "Ohter";
        }
        
        String occupation = null;
        if(student.isSelected()){
            occupation = "Student";
        } else if (employee.isSelected()){
            occupation = "Employee";
        } else if (business.isSelected()){
            occupation = "Business";
        } else if (otheroccupation.isSelected()){
            occupation="Other";
        }
        
        String pincode = textPincode.getText();
        System.out.println(formno);
        
        String username = firstname.substring(0,2)+lastname.substring(0,1) +formno.substring(2) +userid.substring(2);
                
        //validating inserted data
        try{
            if(firstname.equals("") || lastname.equals("") || dob.equals("") || gender.equals("") || marital.equals("") || occupation.equals("") || pincode.equals("") ){
            JOptionPane.showMessageDialog(null, "Please fill all details");
        } else{
            Conn c = new Conn();
            
            
            String query = "insert into signup values('"+formno+"', '"+firstname+"', '"+lastname+"', '"+dob+"','"+gender+"','"+marital+"','"+occupation+"','"+pincode+"','"+username+"')";
            c.s.executeUpdate(query);
            
            //signuptwo object
            setVisible(false);
            new SignUpTwo(formno,username).setVisible(true);
            
            
            }  
        } catch (Exception ae){
            System.out.println(ae);
        }
        
    }

    public static void main(String args[]){
        new SignUpOne();
    }
}
