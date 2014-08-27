package com.hnmmli.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CallTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            Statement stmt = conn.createStatement();
            // stmt.getMoreResults(); 获取更多结果集
            String maxsql = "SELECT MAX(ID) FROM test "; // 插入数据的sql语句
            ResultSet maxrs = stmt.executeQuery(maxsql);
            int index = 0;
            if (maxrs.next())
            {
                index = maxrs.getInt(1) + 1;
            }
            String strsql = "{CALL `test`(?)}";// 存储过程调用SQL语句
            CallableStatement callsm = conn.prepareCall(strsql);
            // 参数设置
            callsm.setInt(1, index);
            // 执行
            callsm.execute();

            // 获取第一个结果集
            ResultSet rs = callsm.getResultSet();
            // 判断是否有下一个结果集
            while (null != rs)
            {
                System.out.println("------------------------");
                while (rs.next())
                {
                    System.out.println(rs.getString(1));
                }
                // 如果还有更多结果集
                if (callsm.getMoreResults())
                {
                    rs = callsm.getResultSet();
                }
                else
                {
                    rs = null;
                }
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
