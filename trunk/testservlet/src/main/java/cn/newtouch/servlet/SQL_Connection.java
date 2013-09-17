package cn.newtouch.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Connection
{

    public static Connection connece(Connection con)
    {

        String foeName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/testservlet";

        String user = "root";

        String password = "";

        try
        {
            Class.forName(foeName);

            con = DriverManager.getConnection(url, user, password);

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return con;
    }

    public static void close(Connection con)
    {
        if (null != con)
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
