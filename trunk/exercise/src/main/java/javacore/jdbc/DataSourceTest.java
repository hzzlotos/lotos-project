package javacore.jdbc;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceTest
{
    public static void main(String[] args)
    {
        try
        {
            Context jndiContest = new InitialContext();
            DataSource source = (DataSource) jndiContest.lookup("java:comp/env/jdbc/corejava");
            Connection conn = source.getConnection();
            System.out.println(conn);
            // 需要做连接池
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}