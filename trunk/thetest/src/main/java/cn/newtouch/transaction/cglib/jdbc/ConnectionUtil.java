package cn.newtouch.transaction.cglib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
    private final static String jdbc     = "com.mysql.jdbc.Driver";

    private final static String sqlHome  = "jdbc:mysql://localhost:3306/test";

    private final static String other    = "?useUnicode=true&characterEncoding=utf-8";

    private final static String userName = "root";

    private final static String passWord = "123456";

    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName(jdbc);

            con = DriverManager.getConnection(sqlHome + other, userName, passWord);

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

    public static void closeConnection(Connection con)
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
