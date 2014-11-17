package cn.newtouch.transaction.proxy.theproxy;

import org.junit.Before;
import org.junit.Test;

import cn.newtouch.common.TransactionProxyManager;
import cn.newtouch.common.connection.DataSourceFactory;
import cn.newtouch.common.connection.TransactionManager;
import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.InitSQL;
import cn.newtouch.transaction.proxy.theproxy.service.BankServiceImpl;

public class ProxyBankServiceTest
{
    private BankService bankService;

    @Before
    public void before()
    {
        InitSQL.init();
        TransactionManager transactionManager = new TransactionManager(DataSourceFactory.createDataSource());
        TransactionProxyManager proxy = new TransactionProxyManager(transactionManager);
        this.bankService = (BankService) proxy.proxyFor(new BankServiceImpl(DataSourceFactory.createDataSource()));
    }

    @Test
    public void transferSuccess()
    {
        try
        {

            this.bankService.transfer(1111, 2222, 200);
            System.out.println(this.bankService.getBankAmount(1111));
            System.out.println(this.bankService.getInsuranceAmount(2222));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void transferRollback()
    {
        try
        {
            // ID为3333不存在 所以应该报错导致回滚
            this.bankService.transfer(1111, 3333, 200);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            System.out.println(this.bankService.getInsuranceAmount(2222));
            System.out.println(this.bankService.getBankAmount(1111));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}