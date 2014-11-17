package cn.newtouch.common.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TransactionManager
{
    private DataSource dataSource;

    public TransactionManager(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public final void start() throws SQLException
    {
        Connection connection = this.getConnection();
        connection.setAutoCommit(false);
    }

    public final void commit() throws SQLException
    {
        Connection connection = this.getConnection();
        connection.commit();
    }

    public final void rollback()
    {
        Connection connection = null;
        try
        {
            connection = this.getConnection();
            connection.rollback();
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Couldn't rollback on connection[" + connection + "].", e);
        }
    }

    public final void close()
    {
        Connection connection = null;
        try
        {
            connection = this.getConnection();
            connection.setAutoCommit(true);
            connection.setReadOnly(false);
            connection.close();
            ThreadLocalConnectionFactory.removeConnection(this.dataSource);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Couldn't close connection[" + connection + "].", e);
        }
    }

    private Connection getConnection() throws SQLException
    {
        return ThreadLocalConnectionFactory.getConnection(this.dataSource);
    }
}
