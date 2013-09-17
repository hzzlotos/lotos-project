package cn.newtouch.base.file.stream;

import java.io.File;
import java.io.IOException;

public class Main
{

    public static void main(String[] args)
    {
        // test();
        File flie = new File("d:\\one\\two\\three");
        if (!flie.exists())
        {
            System.out.println(flie.mkdirs());
        }
        File[] chideFiles = flie.listFiles();
        for (File fliee : chideFiles)
        {
            System.out.println(fliee.toURI());
            System.out.println(fliee.toString());
            System.out.println(fliee.getParentFile().toString());
            System.out.println("====================");
        }
    }

    private static void test()
    {
        MyStream ms = new MyStream();

        try
        {

            ms.output();

            System.out.println("=====================================");

            ms.input();

        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }
}
