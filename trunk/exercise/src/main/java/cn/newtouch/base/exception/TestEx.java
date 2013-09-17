package cn.newtouch.base.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//抛错
public class TestEx
{
    public static void main(String[] args)
    {

        try
        {
            new TestEx().f2();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        FileInputStream in = null;

        try
        {
            in = new FileInputStream("mydir1/mydir2/myfile.txt");
            int b;
            b = in.read();
            while (b != -1)
            {
                System.out.print((char) b);
                b = in.read();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }

        finally
        {
            try
            {
                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    void m(int i) throws ArithmeticException
    {
        if (i == 0)
        {
            throw new ArithmeticException("i为0");
        }
    }

    void f() throws FileNotFoundException, IOException
    {
        FileInputStream in = new FileInputStream("mydir1/mydir2/myfile.txt");
        int b;
        b = in.read();
        while (b != -1)
        {
            System.out.print((char) b);
            b = in.read();
        }
    }

    void f2() throws IOException
    {
        f();
    }

}
