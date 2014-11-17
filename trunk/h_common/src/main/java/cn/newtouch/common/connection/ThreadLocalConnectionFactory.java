package cn.newtouch.common.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

//线程安全的取链接的类
public class ThreadLocalConnectionFactory
{
    private static ThreadLocal<HashMap<DataSource, Connection>> connections = new ThreadLocal<HashMap<DataSource, Connection>>();

    private static HashMap<DataSource, Connection> getlocalMap()
    {
        HashMap<DataSource, Connection> map = connections.get();
        if (null == map)
        {
            map = new HashMap<DataSource, Connection>();
        }
        connections.set(map);
        return map;
    }

    public static Connection getConnection(DataSource dataSource) throws SQLException
    {
        Connection connection = getlocalMap().get(dataSource);
        if (null == connection || connection.isClosed())
        {
            connection = dataSource.getConnection();
            getlocalMap().put(dataSource, connection);
        }
        return connection;
    }

    public static void removeConnection(DataSource dataSource)
    {
        getlocalMap().remove(dataSource);
    }
}
