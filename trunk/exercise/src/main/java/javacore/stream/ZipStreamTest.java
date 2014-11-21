package javacore.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamTest
{

    public static void main(String[] args)
    {
        zipInputStream();
        // scanner();
    }

    private static void zipInputStream()
    {
        try
        {
            ZipInputStream zis = new ZipInputStream(new FileInputStream("F:\\zipTest\\test.zip"));
            ZipEntry entry;
            while (null != (entry = zis.getNextEntry()))
            {
                System.out.println(entry.getName());
                System.out.println("===========" + entry.isDirectory());
                zis.closeEntry();
            }
            zis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void scanner()
    {
        try
        {
            ZipInputStream zis = new ZipInputStream(new FileInputStream("E:\\standard-1.1.2 - 副本.zip"));
            Scanner s = new Scanner(zis);
            while (s.hasNextLine())
            {
                System.out.println(s.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    private static void zipOutputStream()
    {
    }
}