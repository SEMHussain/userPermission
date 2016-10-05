package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MyDb {
    public static Connection con;
    
    public static void getConnection() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/att", "root", "1234");
    }
    public static void set(String sql) throws Exception
    {   
            if(con==null)
            {
            getConnection();
            }
            con.createStatement().executeUpdate(sql);
    }
    public static ResultSet search(String sql) throws Exception
    {
        if(con==null)
        {
          getConnection();
        }
        return con.createStatement().executeQuery(sql);
    }
}
