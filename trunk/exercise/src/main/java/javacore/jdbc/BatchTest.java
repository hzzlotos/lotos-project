package javacore.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            boolean autoCommit = conn.getAutoCommit();
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
            // 添加至批量处理中
            insert.addBatch();
            sql = "update test set name = 'leif' where id = ?";
            insert = conn.prepareStatement("update test set name = ? where id = ?");
            insert.setString(1, "leif" + index);
            insert.setInt(2, index - 1);
            // 添加至批量处理中
            insert.addBatch();
            // 提交批量处理
            insert.executeBatch();
            // 批量处理时需事务一并提交
            conn.commit();
            // 恢复最初提交模式
            conn.setAutoCommit(autoCommit);
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