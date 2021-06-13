package jdbctest;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
public class InsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/dbtest","root","123456");
        if(conn==null){
            System.out.println("Error.");
        }else{
            System.out.println("Success.");
        }

        Statement statement=conn.createStatement();
        String sql="insert into user values (8,'Wangwu','12456'),(9,'Zhaoliu','456789')";
        int set=statement.executeUpdate(sql);
        System.out.println(set+" data has been inserted.");

        statement.close();
        conn.close();
    }
}
