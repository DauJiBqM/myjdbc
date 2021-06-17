package jdbctest;
import java.sql.*;
public class ConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/dbtest","root","123456");
        */
        Connection conn=ConnectionUtils.getConnection();

        if(conn==null){
            System.out.println("Error.");
        }else{
            System.out.println("Success.");
        }

        Statement statement=conn.createStatement();
        String sql="select * from user";
        ResultSet set=statement.executeQuery(sql);
        int i=0;
        while(set.next()){
            User user=new User();
            user.setId(set.getInt("id"));
            user.setUsername(set.getString("user_name"));
            user.setPassword(set.getString("password"));
            System.out.println(user);
            i++;
        }

        if(i<=1){
            System.out.println(i+" data found.");
        }else{
            System.out.println(i+" datas found.");
        }

        set.close();
        statement.close();
        conn.close();
    }
}
