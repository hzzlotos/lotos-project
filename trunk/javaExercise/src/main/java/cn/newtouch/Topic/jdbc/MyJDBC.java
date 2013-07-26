//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.Topic.jdbc;

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
