package com.hnmmli.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;

public class JDBCTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT MAX(ID) FROM test "; // 插入数据的sql语句
            ResultSet rs = stmt.executeQuery(sql);
            int index = 0;
            if (rs.next())
            {
                index = rs.getInt(1) + 1;
            }
            sql = "INSERT INTO test VALUES (" + index + ", 'leif')"; // 插入数据的sql语句
            // 执行insert,update,delete,还可执行create table等方法
            int count = stmt.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数
            System.out.println("======" + count);
            sql = "select * from test";
            // 执行select方法并返回ResultSet
            rs = stmt.executeQuery(sql);
            // 取值时使用如下方式
            while (rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString("name"));
            }
            // 获取SQL警告信息
            SQLWarning w = stmt.getWarnings();
            while (null != w)
            {
                System.out.println(w.getMessage());
                w = w.getNextWarning();
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