package javacore.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

public class RowSetTest
{

    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            Statement stmt = conn.createStatement();
            String sql = "select * from test";
            ResultSet rs = stmt.executeQuery(sql);
            CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();
            crs.populate(rs);
            conn.close();
            crs.setUrl("jdbc:mysql://localhost/javacore?useUnicode=true&characterEncoding=utf-8");
            crs.setUsername("root");
            crs.setPassword("root");
            crs.setCommand("select * from test");
            crs.setString(1, "");
            // 只获取20行数据
            crs.setPageSize(20);
            crs.execute();
            // 获取下一批数据
            crs.nextPage();

            crs.getString(0);
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

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
    }
}
