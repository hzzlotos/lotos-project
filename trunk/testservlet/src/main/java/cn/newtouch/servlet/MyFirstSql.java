package cn.newtouch.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFirstSql
{

    @SuppressWarnings("finally")
    public int userCheck(String username, String password)
    {

        int flag = 0;

        Connection con = null;

        try
        {

            con = SQL_Connection.connece(con);

            String sql = "select password from user where username = ?";

            PreparedStatement cmd = con.prepareStatement(sql);

            cmd.setString(1, username);

            ResultSet rs = cmd.executeQuery();

            String DbPassWard = null;

            while (rs.next())
            {

                DbPassWard = rs.getString("password");
            }

            if (null != DbPassWard && null != password
                    && DbPassWard.equals(password))
            {

                flag = 1;
            }

        }
        catch (SQLException e)
        {

            e.printStackTrace();

        }
        finally
        {

            SQL_Connection.close(con);

            return flag;
        }
    }
}
