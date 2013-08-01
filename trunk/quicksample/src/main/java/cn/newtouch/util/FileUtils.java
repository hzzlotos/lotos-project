package cn.newtouch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.newtouch.contants.Contants;

public class FileUtils
{

    public static final String TEMP_PATH = "application_temp";

    /**
     * 复制单个文件
     * 
     * @param oldPath
     *            String 原文件路径 如：c:/fqf.txt
     * @param newPath
     *            String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public void copyFile(String oldPath, String newPath)
    {
        try
        {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists())
            { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1)
                {
                    bytesum += byteread; // 字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }

    public static File createTempFile(String fileExtension) throws IOException
    {
        String tempDir = System.getProperty("java.io.tmpdir");
        File tempFile = new File(tempDir + File.separator + TEMP_PATH
                + File.separator + System.currentTimeMillis()
                + Contants.UNDERLINE + CommonUtils.getRandomNumber(10000)
                + Contants.POINT + fileExtension);
        mkParent(tempFile.getParentFile());
        tempFile.createNewFile();
        return tempFile;
    }

    public static void mkParent(File parent)
    {
        if (!parent.exists())
        {
            if (!parent.getParentFile().exists())
            {
                mkParent(parent.getParentFile());
            }
            parent.mkdir();
        }
    }

    public static String getFileExtension(String fileName)
    {
        int idx = fileName.lastIndexOf(Contants.POINT);
        String result = fileName;
        if (idx >= 0)
        {
            result = fileName.substring(idx + 1).toLowerCase();
        }
        return result;
    }

    public static String getFileNameWithoutExtension(String fileName)
    {
        int idx = fileName.lastIndexOf(Contants.POINT);
        if (idx >= 0)
        {
            return fileName.substring(0, idx);
        }
        else
        {
            return fileName;
        }
    }
}
