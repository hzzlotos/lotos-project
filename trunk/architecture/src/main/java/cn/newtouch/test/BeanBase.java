package cn.newtouch.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.test.DB.DataSourceFactory;

public class BeanBase
{
    public static DataSource dataSource = DataSourceFactory.createDataSource();

    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Boolean needCommit)
    {
        try
        {
            if (needCommit)
            {
                conn.commit();
            }
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}