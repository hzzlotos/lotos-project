package cn.newtouch.Topic.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestTransForm1
{
    public static void main(String[] args)
    {
        try
        {
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream("./src/cn/newtouch/io/char.txt"));
            osw.write("mircosoftibmsunapplehp   ");
            System.out.println(osw.getEncoding());
            osw.close();
            // true表示在原文件后累加
            // false表示原内容删除 重新添加内容
            osw = new OutputStreamWriter(new FileOutputStream(
                    "./src/cn/newtouch/io/char.txt", true), "ISO8859_1"); // latin-1
            osw.write("mircosoftibmsunapplehp");
            System.out.println(osw.getEncoding());
            osw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}