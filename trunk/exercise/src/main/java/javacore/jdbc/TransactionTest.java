package javacore.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TransactionTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update test set name = 'updatetest1' where id = 1");
            // String str = null;
            // str.split("");
            stmt.executeUpdate("update test set name = 'updatetest2' where id = 2");
            conn.commit();
            System.out.println("update ok!");
        }
        catch (Exception e)
        {
            ConnectionUtils.rollback(conn);
            e.printStackTrace();
        }
        finally
        {
            ConnectionUtils.close(conn);
        }
    }
}
