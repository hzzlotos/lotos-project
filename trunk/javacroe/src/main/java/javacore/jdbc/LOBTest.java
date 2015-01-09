package javacore.jdbc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LOBTest
{

    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            conn = ConnectionUtils.connection();
            // 设置数据
            Statement stmt = conn.createStatement();
            String maxsql = "SELECT MAX(ID) FROM test "; // 插入数据的sql语句
            ResultSet maxrs = stmt.executeQuery(maxsql);
            int index = 0;
            if (maxrs.next())
            {
                index = maxrs.getInt(1) + 1;
            }
            InputStream in = new FileInputStream(new File("g:/DSC_0275.jpg"));
            PreparedStatement insert = conn.prepareStatement("insert into test (ID,NAME,blobtest) values (?,?,?)");
            insert.setInt(1, index);
            insert.setString(2, "blob" + index);
            insert.setBlob(3, in);
            insert.executeUpdate();
            // 读取数据
            String sql = "select * from test";
            PreparedStatement query = conn.prepareStatement(sql);
            // query.setString(1, "O'Reilly");
            ResultSet rs = query.executeQuery();
            byte[] b = new byte[1024];
            int length = 0;
            while (rs.next())
            {
                InputStream intemp = rs.getBinaryStream("blobtest");// InputStream是字节输入流的所有类的超类
                if (null != intemp)
                {
                    // System.out.println(intemp.available());
                    String name = rs.getString("NAME");
                    File file = new File("g:/" + name + ".jpg");
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));// BufferedOutputStream是缓冲的输出流
                    while ((length = intemp.read(b)) > 0)
                    {
                        out.write(b, 0, length);
                    }
                    out.close();// 关闭此输出流并释放与此流有关的所有系统资源。
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
