package cn.newtouch.test.dao;

import java.util.List;

public interface IHandleDataSources<T, V>
{
    // public boolean insertData(T t, V v);

    // public boolean deleteData(T t, V v);

    // public boolean updateData(T t, V v);

    public List<T> getData(T t, V v);

    public boolean close();
}