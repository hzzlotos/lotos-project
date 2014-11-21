package javacore.security.javacore.classloader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Encrypts a file using the Caesar cipher.
 * 
 * @version 1.00 1997-09-10
 * @author Cay Horstmann
 */
public class Caesar
{
    public static void main(String[] args)
    {
        // if (args.length != 3)
        // {
        // System.out.println("USAGE: java Caesar in out key");
        // return;
        // }

        try
        {
            // TODO 此处为路径添加代码
            String path = ClassLoaderTest.class.getClassLoader().getResource("").getPath()
                    + ("javacore/security/javacore/classloader");

            // FileInputStream in = new FileInputStream(args[0]);
            // FileOutputStream out = new FileOutputStream(args[1]);
            // int key = Integer.parseInt(args[2]);
            FileInputStream in = new FileInputStream("G:/eclipse/workspace/exercise/java/ClassEncryptionTest.class");
            FileOutputStream out = new FileOutputStream(path + "/ClassEncryptionTest.caesar");
            int key = 123;
            int ch;
            while ((ch = in.read()) != -1)
            {
                byte c = (byte) (ch + key);
                out.write(c);
            }
            in.close();
            out.close();
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
