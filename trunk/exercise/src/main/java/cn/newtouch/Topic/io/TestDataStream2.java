package cn.newtouch.Topic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestDataStream2
{
    public static void main(String[] args) throws Exception
    {
        InputStream is = new FileInputStream("./src/cn/newtouch/io/12345.gif");
        OutputStream os = new FileOutputStream(
                "./src/cn/newtouch/io/aaa/12345.gif");
        try
        {
            int b;// 读取出来的是byte的字节数
            while ((b = is.read()) != -1)
            {
                System.out.println(b);
                os.write(b);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            is.close();
            os.close();
        }
        System.out.println("===================");
    }
}