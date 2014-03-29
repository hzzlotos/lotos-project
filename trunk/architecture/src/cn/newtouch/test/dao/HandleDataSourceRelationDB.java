package cn.newtouch.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import cn.newtouch.test.SingleThreadConnectionHolder;
import cn.newtouch.test.DB.Constants;

public abstract class HandleDataSourceRelationDB<T, V> extends HandleDataSources<T, V>
{

    private DataSource   dataSource;

    protected Connection connection = null;

    public HandleDataSourceRelationDB(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    protected boolean handleData(T t, V v, int actionCode) throws NullPointerException
    {
        this.ifSuccess = false;
        this.getConnection();

        switch (actionCode)
        {
        // case Constants.INSERTDATA:
        // this.ifSuccess = this.addObject(t, v);
        // break;
        //
        // case Constants.DELETEDATA:
        // this.ifSuccess = this.deleteObject(t, v);
        // break;
        //
        // case Constants.UPDATEDATA:
        // this.ifSuccess = this.updateObject(t, v);
        // break;

        case Constants.QUERYDATA:
            this.ifSuccess = this.queryObjects(t, v);
            break;
        }

        return this.ifSuccess;
    }

    @Override
    public boolean close()
    {
        if ((this.ts != null) && (this.ts.size() > 0))
        {
            this.ts.clear();
        }

        return true;
    }

    private boolean getConnection()
    {
        if (this.connection != null)
        {
            return true;
        }

        try
        {
            this.connection = SingleThreadConnectionHolder.getConnection(this.dataSource);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        if (this.connection == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // private boolean saveOrUpdateOrDeleteObjectBySQL(String sqlStatement)
    // {
    // this.ifSuccess = false;
    //
    // try
    // {
    // PreparedStatement saveOrUpdateOrDeleteStatement = null;
    //
    // saveOrUpdateOrDeleteStatement = this.connection.prepareStatement(sqlStatement);
    // saveOrUpdateOrDeleteStatement.executeUpdate();
    // saveOrUpdateOrDeleteStatement.close();
    //
    // this.ifSuccess = true;
    // }
    // catch (SQLException e)
    // {
    // e.printStackTrace();
    // }
    //
    // return this.ifSuccess;
    // }
    //
    // private boolean addObject(T t, V v)
    // {
    // if (v == null)
    // {
    // if (t == null)
    // {
    // return false;
    // }
    // else
    // {
    // return this.saveOrUpdateObject(t);
    // }
    // }
    // else
    // {
    // if (v.getClass().getName().equals("java.lang.String"))
    // {
    // return this.saveOrUpdateOrDeleteObjectBySQL((String) v);
    // }
    // else
    // {
    // return true;
    // }
    // }
    // }
    //
    // private boolean deleteObject(T t, V v)
    // {
    // if (v == null)
    // {
    // if (t == null)
    // {
    // return false;
    // }
    // else
    // {
    // return this.deleteObject(t);
    // }
    // }
    // else
    // {
    // if (v.getClass().getName().equals("java.lang.String"))
    // {
    // return this.saveOrUpdateOrDeleteObjectBySQL((String) v);
    // }
    // else
    // {
    // return true;
    // }
    // }
    // }
    //
    // private boolean updateObject(T t, V v)
    // {
    // return this.addObject(t, v);
    // }

    private boolean queryObjects(T t, V v)
    {
        this.ts = new ArrayList<T>();

        if (v == null)
        {
            if (t == null)
            {
                return this.getObjects(null);
            }
            else
            {
                this.ts.add(this.getObject(t));
                return true;
            }
        }
        else
        {
            if (v.getClass().getName().equals("java.lang.String"))
            {

                if (t == null)
                {
                    return this.getObjects((String) v);
                }
                else
                {
                    this.ts.add(this.getObject(t));
                    return true;
                }
            }
            else
            {
                return true;
            }
        }
    }

    protected void setPStmtParas(PreparedStatement ps, int pStatementSequence, Object value)
    {
        if ((ps == null))
        {
            return;
        }

        // It's a section of imperfect code. Maybe cannot work on some DBMS(s).
        // Tested on Oracle. It works well.
        try
        {
            ps.setObject(pStatementSequence, null);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        // End the imperfect section.
    }

    abstract protected boolean saveOrUpdateObject(T t);

    abstract protected boolean deleteObject(T t);

    abstract protected T getObject(T t);

    abstract protected boolean getObjects(String sqlStatement);
}