package cn.newtouch.common.connection;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import cn.newtouch.common.GetProperties;

public final class DataSourceFactory
{
    private static final BasicDataSource dataSource = new BasicDataSource();

    private DataSourceFactory()
    {
    }

    static
    {
        try
        {
            Properties dbProperties = (new GetProperties("DBConfig.properties", "properties").getProps());
            dataSource.setDriverClassName(dbProperties.getProperty("DBDriver", "com.mysql.jdbc.Driver"));
            dataSource.setUrl(dbProperties.getProperty("DBURL",
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8"));
            dataSource.setUsername(dbProperties.getProperty("DBUserName", "root"));
            dataSource.setPassword(dbProperties.getProperty("DBPassword", "123456"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static DataSource createDataSource()
    {
        return dataSource;
    }
}