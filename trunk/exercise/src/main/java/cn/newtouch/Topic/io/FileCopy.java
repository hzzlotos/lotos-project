package cn.newtouch.Topic.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy
{
    public static void main(String[] args)
    {
        int b = 0;
        FileReader in = null;
        FileWriter out = null;
        try
        {
            in = new FileReader("d:/share/java/HelloWorld.java");
            out = new FileWriter("d:/share/java/io/HW.java");
            while ((b = in.read()) != -1)
            {
                out.write(b);
            }
            out.close();
            in.close();

        }
        catch (FileNotFoundException e2)
        {
            System.out.println("�Ҳ���ָ���ļ�");
            System.exit(-1);
        }
        catch (IOException e1)
        {
            System.out.println("�ļ����ƴ���");
            System.exit(-1);
        }
        System.out.println("�ļ��Ѹ���");
    }
}
