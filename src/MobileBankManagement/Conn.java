
package MobileBankManagement;
import java.sql.*;
/**
 *
 * @author krunal dhavle kbd6
 */
public class Conn {
    //creating jdbc
    //1. create connection
    //2. creating connection
    //3. create statement
   
    Connection c;
    Statement s;
    
    public Conn(){
        try{
        	//change first "root" to your sql username and second "root" to sql password 
        	//Otherwise it will be not connected with local system.
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement" , "root" , "root");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
