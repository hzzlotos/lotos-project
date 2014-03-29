package cn.newtouch.test.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.test.dao.HandleDataSourceRelationDB;

public class StoreDAO<V> extends HandleDataSourceRelationDB<Store, V>
{

    public StoreDAO(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    protected boolean saveOrUpdateObject(Store store)
    {
        return false;
    }

    @Override
    protected boolean deleteObject(Store store)
    {
        return false;
    }

    @Override
    protected Store getObject(Store store)
    {
        return null;
    }

    @Override
    protected boolean getObjects(String sql)
    {
        this.ifSuccess = false;

        if (sql == null)
        {
            sql = "SELECT * FROM STORES";
        }
        try
        {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rsStore = ps.executeQuery();

            while (rsStore.next())
            {
                Store store = new Store();
                store.setStoreID(rsStore.getInt("STR_ID"));
                this.ts.add(store);
            }
            rsStore.close();
            ps.close();
            this.ifSuccess = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this.ifSuccess;
    }
}
