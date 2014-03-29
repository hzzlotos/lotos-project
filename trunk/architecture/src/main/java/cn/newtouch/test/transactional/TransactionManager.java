package cn.newtouch.test.transactional;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.test.SingleThreadConnectionHolder;

public class TransactionManager
{
    private DataSource dataSource;

    private Connection connection = null;

    public TransactionManager(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public final void start()
    {
        try
        {
            this.connection = this.getConnection();
            this.connection.setAutoCommit(false);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public final void commit() throws SQLException
    {
        this.connection = this.getConnection();
        this.connection.commit();
    }

    public final void rollback()
    {
        try
        {
            this.connection = this.getConnection();
            this.connection.rollback();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public final void close()
    {
        try
        {
            this.connection = this.getConnection();
            this.connection.setAutoCommit(true);
            this.connection.setReadOnly(false);
            this.connection.close();
            SingleThreadConnectionHolder.removeConnection(this.dataSource);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException
    {
        return SingleThreadConnectionHolder.getConnection(this.dataSource);
    }
}