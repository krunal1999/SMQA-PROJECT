
package MobileBankManagement;
import java.sql.*;
/**
 *
 * @author krunal
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
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement" , "root" , "root");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
