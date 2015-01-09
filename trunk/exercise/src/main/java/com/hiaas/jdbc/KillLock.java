package com.hiaas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 杀锁
 */
public class KillLock
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("=========================start");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.227:1521:GENERALDBDEV", "system",
                "qweQWE123");
        int i = 0;
        do
        {
            i = 0;
            PreparedStatement ps = conn
                    .prepareStatement("SELECT l.session_id sid, s.serial# sessionid FROM v$locked_object l, v$session s where l.session_id = s.sid");
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                ps.execute("ALTER system KILL session '" + rs.getString(1) + "," + rs.getString(2) + "'");
                i++;
            }
            ps.close();
        }
        while (i > 0);
        System.out.println("=========================end");
    }
}