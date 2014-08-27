package com.hnmmli.stream.javacore;

import java.io.File;
import java.io.IOException;

public class FindDirectories
{
    public static void main(String[] args)
    {
        // if no arguments provided, start at the parent directory
        if (args.length == 0)
        {
            args = new String[] { ".." }; // 上上级目录
        }

        try
        {
            File pathName = new File(args[0]);
            String[] fileNames = pathName.list();

            // enumerate all files in the directory
            for (String fileName : fileNames)
            {
                File f = new File(pathName.getPath(), fileName);

                // if the file is again a directory, call the main method recursively
                if (f.isDirectory())
                {
                    System.out.println(f.getCanonicalPath());
                    main(new String[] { f.getPath() });
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
