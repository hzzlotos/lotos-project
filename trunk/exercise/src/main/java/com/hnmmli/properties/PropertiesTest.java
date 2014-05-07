package com.hnmmli.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest
{
    private Properties props;

    public PropertiesTest(String fileName, String fileType) throws IOException
    {
        this.props = new Properties();
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        // StringBuilder configFilePath = new StringBuilder(System.getProperties().getProperty("user.home"));
        if ("xml".equals(fileType))
        {
            this.props.loadFromXML(inStream);

        }
        else
        {
            this.props.load(inStream);
        }
    }

    public Properties getProps()
    {
        return this.props;
    }
}