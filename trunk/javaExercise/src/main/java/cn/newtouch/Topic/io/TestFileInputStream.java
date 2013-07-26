package cn.newtouch.Topic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream
{
    public static void main(String[] args)
    {
        int b = 0;
        InputStream in = null;
        try
        {
            in = new FileInputStream(
                    "./src/cn/newtouch/io/TestFileOutputStream.java");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("找不到指定文件");
            System.exit(-1);
        }

        try
        {
            long num = 0;
            while ((b = in.read()) != -1)
            {
                System.out.print((char) b);
                num++;
            }
            in.close();
            System.out.println();
            System.out.println("共读取了 " + num + " 个字节");
        }
        catch (IOException e1)
        {
            System.out.println("文件读取出错了");
            System.exit(-1);
        }
    }
}