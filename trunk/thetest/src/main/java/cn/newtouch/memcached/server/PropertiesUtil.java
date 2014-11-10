package cn.newtouch.memcached.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil
{
    private static String userhome = "user.home";

    private static String path     = "configers";

    public static Properties getProperties(String fileName, String fileType)
    {
        StringBuilder dbConfiger = new StringBuilder(System.getProperty(userhome)).append(File.separator).append(path)
                .append(File.separator).append(fileName);
        Properties defaults = new Properties();
        try
        {
            InputStream is = new FileInputStream(dbConfiger.toString());
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