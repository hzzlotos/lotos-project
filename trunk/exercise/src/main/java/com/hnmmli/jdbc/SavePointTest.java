package com.hnmmli.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "SELECT MAX(ID) FROM test ";
            ResultSet rs = stmt.executeQuery(sql);
            int index = 0;
            if (rs.next())
            {
                index = rs.getInt(1) + 1;
            }
            PreparedStatement insert = conn.prepareStatement("insert into test (ID,NAME) values (?,?)");
            insert.setInt(1, index);
            insert.setString(2, "TEST" + index);
            insert.executeUpdate();
            Savepoint save = conn.setSavepoint();
            sql = "update test set name = 'leif' where id = ?";
            insert = conn.prepareStatement("update test set name = 'leif' where id = ?");
            insert.setInt(1, index);
            insert.executeUpdate();
            // ----------------------------------
            conn.rollback(save);
            conn.commit();
            conn.releaseSavepoint(save);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            ConnectionUtils.close(conn);
        }
    }
}