package cn.newtouch.test.DB;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import cn.newtouch.test.utils.GetProperties;

//单例
public final class DataSourceFactory
{
    private DataSourceFactory()
    {
    }

    private static final BasicDataSource dataSource = new BasicDataSource();

    static
    {
        try
        {
            Properties dbProperties = (new GetProperties("RDB.properties", "properties").getProps());
            dataSource.setDriverClassName(dbProperties.getProperty("DBDriver", "org.hsqldb.jdbcDriver"));
            dataSource.setUrl(dbProperties.getProperty("DBURL", "jdbc:hsqldb:hsql://localhost/"));
            dataSource.setUsername(dbProperties.getProperty("DBUserName", "sa"));
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