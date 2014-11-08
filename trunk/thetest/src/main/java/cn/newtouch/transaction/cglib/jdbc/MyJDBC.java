package cn.newtouch.transaction.cglib.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC
{
    public static void main(String[] args)
    {
        Connection conn = ConnectionUtil.getConnection();

        Statement stmt = null;
        ResultSet rs = null;
        int id = 0;
        try
        {
            stmt = conn.createStatement();
            String sql = "select max(id) from user";
            rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                id = rs.getInt(1) + 1;
            }
            sql = "insert into user values(" + id + ",'张三" + id + "')";
            stmt.executeUpdate(sql);// 执行sql语句

            sql = "select * from user";
            rs = stmt.executeQuery(sql);

            while (rs.next())
            {// 从结果集中取出数据
                System.out.println("id=" + rs.getInt(1));
                System.out.println("name=" + rs.getString(2));
                System.out.println("================================");
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (rs != null)
                {

                    rs.close();
                }
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ConnectionUtil.getConnection();
        }
    }
}
