package cn.newtouch.test.service;

import java.util.List;

import cn.newtouch.test.BeanBase;
import cn.newtouch.test.DBHandleAnnotationProxyManager;
import cn.newtouch.test.transactional.TransactionManager;

public class StoreBean extends BeanBase
{
    StoreService proxyStoreManager;

    public StoreBean()
    {
        StoreService storeManger = new StoreManager(dataSource);
        TransactionManager transactionManager = new TransactionManager(dataSource);
        DBHandleAnnotationProxyManager transactionEnabledProxyManager = new DBHandleAnnotationProxyManager(
                transactionManager);
        this.proxyStoreManager = (StoreService) transactionEnabledProxyManager.proxyFor(storeManger);
    }

    public List<Store> getAll()
    {
        return this.proxyStoreManager.getAll();
    }
}
