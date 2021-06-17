package jdbctest;
import java.sql.*;
public class ConnectionUtils {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/dbtest","root","123456");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
