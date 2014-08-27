package com.hnmmli.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest
{
    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            String sql = "select a.Price, a.Title from books as a,publishers as b where "
                    + "a.Publisher_Id = b.Publisher_Id and b.name = ?";
            PreparedStatement query = conn.prepareStatement(sql);
            query.setString(1, "O'Reilly");
            ResultSet rs = query.executeQuery();
            // query.executeUpdate(); //更新时使用
            while (rs.next())
            {
                System.out.println(rs.getString("Price"));
                System.out.println(rs.getString("Title"));
                // Blob blob = rs.getBlob(0);
                // Image img = ImageIO.read(blob.getBinaryStream());
                // Clob clob = rs.getClob(0);
                // String str = clob.getSubString(0, 0);
                System.out.println("================================");
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