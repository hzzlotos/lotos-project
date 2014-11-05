package cn.newtouch.test.service;

import java.util.List;

import javax.sql.DataSource;

public class StoreManager implements StoreService
{
    private StoreDAO<Store> dao;

    public StoreManager(DataSource dataSource)
    {
        this.dao = new StoreDAO<Store>(dataSource);
    }

    @Override
    public List<Store> getAll()
    {
        return this.dao.getData(null, null);
    }
}