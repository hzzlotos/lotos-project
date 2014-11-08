package cn.newtouch.transaction.proxy.theproxy;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.InitSQL;
import cn.newtouch.transaction.proxy.commonutils.TransactionProxyManager;
import cn.newtouch.transaction.proxy.commonutils.connection.general.DataSourceFactory;
import cn.newtouch.transaction.proxy.commonutils.connection.threadlocal.TransactionManager;
import cn.newtouch.transaction.proxy.theproxy.service.BankServiceImpl;

public class ProxyBankServiceTest
{
    private DataSource         dataSource         = DataSourceFactory.createDataSource();

    private TransactionManager transactionManager = new TransactionManager(this.dataSource);

    @Before
    public void before()
    {
        InitSQL.init();
    }

    @Test
    public void transferSuccess()
    {
        try
        {
            TransactionProxyManager proxy = new TransactionProxyManager(this.transactionManager);
            BankService bankService = (BankService) proxy.proxyFor(new BankServiceImpl(this.dataSource));
            bankService.transfer(1111, 2222, 200);
            System.out.println(bankService.getBankAmount(1111));
            System.out.println(bankService.getInsuranceAmount(2222));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void transferRollback()
    {
        TransactionProxyManager proxy = new TransactionProxyManager(this.transactionManager);
        BankService bankService = (BankService) proxy.proxyFor(new BankServiceImpl(this.dataSource));
        try
        {
            int toNonExistId = 3333;
            bankService.transfer(1111, toNonExistId, 200);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            System.out.println(bankService.getInsuranceAmount(2222));
            System.out.println(bankService.getBankAmount(1111));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}