package com.hiaas.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class JDBCTest
{

    public static void main(String[] args)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CallableStatement statement = null;
        try
        {
            conn = JdbcUtils.getConnection();
            // String sql = "insert into DATA_DICTIONARYS(CODE,LANG,TYPE,VALUE,DATA_DESC,SORT) values (?,?,?,?,?,?) ";
            // ps = conn.prepareStatement(sql);
            // ps.setString(1, "hzztest");
            // ps.setString(2, "hzztest");
            // ps.setString(3, "hzztest");
            // ps.setString(4, "hzztest");
            // ps.setString(5, "hzztest");
            // ps.setLong(6, 1);
            // ps.executeUpdate();
            statement = conn.prepareCall("{call hzztest(?,?,?)}");
            statement.setLong(1, 5);
            statement.setLong(2, 2);
            statement.registerOutParameter(3, Types.NUMERIC);
            statement.execute();
            System.out.println("====" + statement.getInt(3));
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
