package cn.newtouch.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class JDBCTest
{

    public static void main(String[] args)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user(name,birthday, money) values (?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "11");
            ps.setDate(2, new java.sql.Date(new Date().getTime()));
            ps.setFloat(3, 3.0F);
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            JdbcUtils.free(rs, ps, conn);
        }
    }
}
