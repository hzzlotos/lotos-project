package com.hnmmli.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AutoTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO test (name) VALUES ('leif')";
            // 当前数据库提供ID子自增长时可用该方法
            int count = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("======" + count);
            // 执行select方法并返回ResultSet
            ResultSet rs = stmt.getGeneratedKeys();
            // 取出自增长的ID
            if (rs.next())
            {
                int key = rs.getInt(1);
                System.out.println(key);
            }
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