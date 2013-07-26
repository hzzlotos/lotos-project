﻿package cn.newtouch.base.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest
{

    /**
     * 复制整个文件夹内容
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf
     * @param newPath
     *            String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    private static void copyFolder(String oldPath, String newPath)
    {

        try
        {
            (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] fileNmArry = a.list();
            File temp = null;
            for (String element : fileNmArry)
            {

                if (oldPath.endsWith(File.separator))
                {
                    temp = new File(oldPath + element);
                }
                else
                {
                    temp = new File(oldPath + File.separator + element);
                }

                if (temp.isFile())
                {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath
                            + File.separator + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1)
                    {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                else
                    if (temp.isDirectory())
                    {// 如果是子文件夹
                        copyFolder(oldPath + File.separator + element, newPath
                                + File.separator + element);
                    }
            }
        }
        catch (Exception e)
        {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        copyFolder("C:\\test1", "C:\\test2");
    }

}
