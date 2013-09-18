package cn.newtouch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils
{

    private static final String            LOCALPATH     = "";

    private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

    /**
     * 读取fileName的配置文件中的name属性
     * 
     * @since 2012-2-9
     * @author zzHe
     * @param fileName
     * @param name
     * @return
     */
    public static String getPropertyWithConfigName(String fileName, String name)
    {
        Properties properties = propertiesMap.get(fileName);
        if (properties == null)
        {
            loadPropertiesBelowClasses(fileName);
            properties = propertiesMap.get(fileName);
        }

        if (properties == null)
        {
            return null;
        }

        return properties.getProperty(name);
    }

    public static String getPropertyWithName(String name)
    {
        String fileName = "sysconfig.properties";
        Properties properties = propertiesMap.get(fileName);
        if (properties == null)
        {
            loadPropertiesBelowClasses(fileName);
            properties = propertiesMap.get(fileName);
        }

        if (properties == null)
        {
            return null;
        }

        return properties.getProperty(name);
    }

    /**
     * 
     * 读取fileName的配置文件中的name属性，如果获取不到则返回defaultValue默认值
     * 
     * @since 2012-2-9
     * @author zzHe
     * @param fileName
     * @param name
     * @param defaultValue
     * @return
     */
    public static String getPropertyWithConfigName(String fileName,
            String name, String defaultValue)
    {
        String value = getPropertyWithConfigName(fileName, name);
        if (value == null)
        {
            value = defaultValue;
        }
        return value;
    }

    private static String getHomeDirectory()
    {
        URL url = PropertyUtils.class.getClassLoader().getResource("/");
        if (url == null)
        {
            return System.getProperty("user.dir") + File.separator + LOCALPATH;
        }
        else
        {
            return url.getPath();
        }
    }

    private synchronized static void loadPropertiesBelowClasses(String filename)
    {
        try
        {
            String proFile = getHomeDirectory() + File.separator + filename;
            Properties properties = new Properties();
            properties.load(new FileInputStream(proFile));
            propertiesMap.put(filename, properties);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
