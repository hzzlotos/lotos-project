package javacore.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils
{
    public static Connection connection() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/javacore?useUnicode=true&characterEncoding=utf-8";
        return DriverManager.getConnection(url, "root", "root");
    }

    public static void rollback(Connection conn)
    {
        try
        {
            if (null != conn && !conn.isClosed())
            {
                conn.rollback();
            }
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                System.out.println(t.getMessage());
            }
        }

    }

    public static void close(Connection conn)
    {
        try
        {
            if (null != conn && !conn.isClosed())
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                System.out.println(t.getMessage());
            }
        }

    }
}
