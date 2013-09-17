package cn.newtouch.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtils
{
    private static final Logger            logger        = LoggerFactory
                                                                 .getLogger(PropertyUtils.class);

    private static final String            LOCALPATH     = "";

    private static Properties              properties    = null;

    private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

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
            logger.error("无指定的配置文件:" + fileName + "！");
            return null;
        }

        return properties.getProperty(name);
    }

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
