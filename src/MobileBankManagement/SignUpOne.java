
package MobileBankManagement;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author krunal dhavle kbd6
 */

public class SignUpOne extends JFrame implements ActionListener{
    //declaring global variable
    long random ,randomforuserid;
    JTextField textFirstname , textLastname,textPincode , agetext;
    JRadioButton male , female , othergender , single, married ,otherstatus , student , employee, business, otheroccupation;
    JButton next , back;
    String formno, age,firstname, lastname, userid;
    String gender, marital, occupation , pincode;
    
    //frontend start
    private void mainFrame(){
        //Genrating random number
         setLayout(null);

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
        
        // creating label and textfield for date of birth
        JLabel dob = new JLabel("Age");
        dob.setFont(new Font("Arial" , Font.PLAIN , 20));
        dob.setBounds(100,250,300,50);
        add(dob);
        
        agetext = new JTextField();
        agetext.setFont(new Font("Arial" , Font.PLAIN , 16));
        agetext.setBounds(300,250,200,30);
        add(agetext);
        
        
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
        
        //creating button
        next = new JButton("Next");
        next.setFont(new Font("Arial" , Font.BOLD , 20));
        next.setBounds(600, 580, 120, 40);
        next.setBackground(Color.GREEN);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        back = new JButton("Back");
        back.setFont(new Font("Arial" , Font.BOLD , 20));
        back.setBounds(460, 580, 120, 40);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
       
        
        getContentPane().setBackground(Color.white);
        setSize(1080 , 780);
        setVisible(true);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //frontedn ends
    }
    
    //constructor to build gui
    SignUpOne(){
        mainFrame();
        
    }
    
    //function to check which btn is clicked by user
    public void actionPerformed(ActionEvent ae){
        //if user click on next
        if(ae.getSource() == next){
        
         formno = random+"";  // long value
         userid = randomforuserid+"";
         
         firstname = textFirstname.getText().toLowerCase();
         lastname = textLastname.getText().toLowerCase();
         age = agetext.getText();
        
         //to check if new generated random number is 4 digit or not
        formno=checkRandomnumber(formno);
        userid=checkRandomnumber(userid);
        
         gender = "";
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (othergender.isSelected()){
            gender = "Ohter";
        }else{
            JOptionPane.showMessageDialog(null, "Please select gender");
        }
        
        marital = "";
        if(single.isSelected()){
            marital = "Single";
        } else if (married.isSelected()){
            marital = "Married";
        } else if(otherstatus.isSelected()){
            marital = "Ohter";
        }else{
            JOptionPane.showMessageDialog(null, "Please select marital status");
        }
        
         occupation = "";
        if(student.isSelected()){
            occupation = "Student";
        } else if (employee.isSelected()){
            occupation = "Employee";
        } else if (business.isSelected()){
            occupation = "Business";
        } else if(otheroccupation.isSelected()){
            occupation="Other";
        }else{
            JOptionPane.showMessageDialog(null, "Please select Occupation");
        }
        
         pincode = textPincode.getText().toLowerCase();
        
        // to check whether all details are filled or not
        boolean firstnamecheck= inputCheck(firstname , firstname.length());
        boolean lastnamecheck = inputCheck(lastname ,lastname.length());
        //boolean gendercheck = inputCheck(gender , 5);
        boolean agecheck = inputCheck(age,5);
        //boolean maritalcheck = inputCheck(marital , 5);
        //boolean occupationcheck = inputCheck(occupation,5);
        boolean pincodecheck = inputCheck(pincode, pincode.length());
        
        
        if(!firstnamecheck){  
            JOptionPane.showMessageDialog(null, "firstname cant be empty and minimum length should be greater than 3");
        }else if(!lastnamecheck){
            JOptionPane.showMessageDialog(null, "Lastname cant be empty and minimum length should be greater than 3");
        }
//        else if(!gendercheck){
//            JOptionPane.showMessageDialog(null, "Please Select gender");
//        }
        else if(!agecheck){
            JOptionPane.showMessageDialog(null, "age cant be empty");
        }
//        else if(!maritalcheck){
//            JOptionPane.showMessageDialog(null, "Please Select marital");
//        }else if(!occupationcheck){
//            JOptionPane.showMessageDialog(null, "occupation cant be empty");
//        }
         else if(!pincodecheck){
            JOptionPane.showMessageDialog(null, "pincode number cant be empty");
        }else if(!isString(firstname)){
            JOptionPane.showMessageDialog(null, "Firstname should be character");
        }else if(!isString(lastname)){
            JOptionPane.showMessageDialog(null, "Lastname should be character");
        }else if(!isNumber(age)){
            JOptionPane.showMessageDialog(null, "Age should be digit");
        }
        else{
         if(agecheck){
             int intAge = Integer.parseInt(age);
             boolean agecheck1 = ageCheck1(age,intAge);
             if(!agecheck1){
                 JOptionPane.showMessageDialog(null, "age should be above 18");
             }
             //if all the details are filled , then make connection with database ,and insert value
         else{
              if(checkConnection(firstname, lastname,  formno , userid , age, gender,  marital ,  occupation , pincode)){
                
                setVisible(false);
              }//if details are missing or database connection failed
              else{
                  JOptionPane.showMessageDialog(null, "Login again");
                  new SignUpOne();
              }
            }        
        }
        }
        
        }//if user click on back btn, then call backbtn funtion 
        else{
            backBtn();
            setVisible(false);

        }
    }
    //function to check validation of random number
    public String checkRandomnumber(String random){
        if(random.length() <=3){
            if(random.equals("")){
                random="2341";
            }else{
            int formnoInt = Integer.parseInt(random);
            formnoInt += 1000;
            random = formnoInt+"";
            }
        }
        return random;
    }
    //function to create new login frame, called when back btn is clicked
    public static boolean  backBtn(){
        new Login();
        return true;
    }
    //function to connect with database , if all values are correct and insert data into database
    public boolean checkConnection(String firstname, String lastname, String formno ,String userid ,String age,String gender, String marital , String occupation , String pincode){
        if(firstname.equals("") || lastname.equals("") || age.equals("") || gender.equals("") || marital.equals("") || occupation.equals("") || pincode.equals("")) {
        	JOptionPane.showMessageDialog(null, "Details are missing ");
        	return false;
        }else {
        try{
        	// before inserting , we are creating unique username for our user
            String username = createUser(firstname, lastname, formno,userid);
           
            Conn c = new Conn();
            String query = "insert into signup values('"+formno+"', '"+firstname+"', '"+lastname+"', '"+age+"','"+gender+"','"+marital+"','"+occupation+"','"+pincode+"','"+username+"')";    
            
            //validating inserted data
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Form completed succefully");
            setVisible(false);
            new SignUpTwo(formno,username).setVisible(true);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        }
    }
    
    //function to check if input has length equal or greater than 3
    public static boolean inputCheck(String text , int length) {
             if ( text.equals("") || length<3 || text.equals(null) || text==""){
                return false;
            }else{
                return true; 
             }
         }
    //function to check age is above 18 or no
    public static boolean ageCheck1(String text, int currAge) {
             int length =text.length();
             
             if ( text.equals("") || length>3 || currAge<18 || currAge>100) {
                return false;
            }else{
                try {
                     int i = Integer.parseInt(text);
                     if(i>=18 && length <=3) {
                    	 return true;
                     }else {return false;}
                }catch (NumberFormatException nf) {
                	System.out.println(nf);
                    return false;
                } 
                 
             }
         }
    
    //function to create unique username
    public static String createUser(String firstname, String lastname , String formno , String userid){
      String username = firstname.substring(0,2)+lastname.substring(0,1) +formno.substring(2) +userid.substring(2);
      if(userCheck(username , username.length())){
          return username;
      }else{
          new SignUpOne();
          return username;
      }
      
    }
    
    //function to check user and validate it in format [abc1234]
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
        
    //function to check is input is string or not
        public static boolean isString(String name) {
            return name.matches("[a-zA-Z]+");
        }
        //function to check if input is number or not
        public static boolean isNumber(String name) {
            return name.matches("[0-9]+");
        }
        
    public static void main(String args[]){
        new SignUpOne();
    }
}