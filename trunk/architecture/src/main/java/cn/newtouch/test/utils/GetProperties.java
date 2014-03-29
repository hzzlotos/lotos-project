package cn.newtouch.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties
{
    private Properties props;

    public GetProperties(String fileName, String fileType) throws IOException
    {
        this.props = new Properties();
        InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
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