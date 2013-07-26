package cn.newtouch.Topic.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader
{
    public static void main(String[] args)
    {
        FileReader fr = null;
        int c = 0;
        try
        {
            fr = new FileReader("d:\\share\\java\\io\\TestFileReader.java");
            while ((c = fr.read()) != -1)
            {
                // char ch = (char) fr.read();
                System.out.print((char) c);
                // if (++ln >= 100) { System.out.println(); ln = 0;}
            }
            fr.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("�Ҳ���ָ���ļ�");
        }
        catch (IOException e)
        {
            System.out.println("�ļ���ȡ����");
        }

    }
}