package cn.newtouch.util;

import java.io.File;
import java.io.IOException;

import cn.newtouch.contants.Contants;

public class FileUtils
{

    public static final String TEMP_PATH = "application_temp";

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
