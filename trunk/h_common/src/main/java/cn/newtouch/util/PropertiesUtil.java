package cn.newtouch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil
{
    private static String userhome = "user.home";

    private static String path     = "configers";

    public static Properties getProperties(String fileName)
    {
        return getProperties(fileName, "properties");
    }

    public static Properties getProperties(String fileName, String fileType)
    {

        Properties defaults = new Properties();
        InputStream is;
        boolean local = true;
        try
        {
            if (local)
            {
                is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            }
            else
            {
                StringBuilder dbConfiger = new StringBuilder(System.getProperty(userhome)).append(File.separator)
                        .append(path).append(File.separator).append(fileName);
                is = new FileInputStream(dbConfiger.toString());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        try
        {
            if ("xml".equals(fileType))
            {
                defaults.loadFromXML(is);
            }
            else
            {
                defaults.load(is);
            }
            is.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return defaults;
    }
}