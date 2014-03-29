package cn.newtouch.test.dao;

import java.util.List;

import cn.newtouch.test.DB.Constants;

public abstract class HandleDataSources<T, V> implements IHandleDataSources<T, V>
{
    protected List<T> ts;

    protected boolean ifSuccess;

    //
    // @Override
    // public abstract boolean close();

    protected abstract boolean handleData(T t, V v, int actionCode) throws NullPointerException;

    //
    // @Override
    // public boolean insertData(T t, V v)
    // {
    // return this.handleData(t, v, Constants.INSERTDATA);
    // }
    //
    // @Override
    // public boolean deleteData(T t, V v)
    // {
    // return this.handleData(t, v, Constants.DELETEDATA);
    // }
    //
    // @Override
    // public boolean updateData(T t, V v)
    // {
    // return this.handleData(t, v, Constants.UPDATEDATA);
    // }

    @Override
    public List<T> getData(T t, V v)
    {
        if (this.handleData(t, v, Constants.QUERYDATA))
        {
            return this.ts;
        }
        else
        {
            return null;
        }
    }
}
