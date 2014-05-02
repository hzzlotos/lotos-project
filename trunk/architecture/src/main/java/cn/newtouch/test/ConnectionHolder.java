package cn.newtouch.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class ConnectionHolder
{
    // 多数据源
    private Map<DataSource, Connection> connectionMap = new HashMap<DataSource, Connection>();

    public Connection getConnection(DataSource dataSource) throws SQLException
    {
        Connection connection = this.connectionMap.get(dataSource);
        if (connection == null || connection.isClosed())
        {
            connection = dataSource.getConnection();
            this.connectionMap.put(dataSource, connection);
        }

        return connection;
    }

    public void removeConnection(DataSource dataSource)
    {
        this.connectionMap.remove(dataSource);
    }
}