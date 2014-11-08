package cn.newtouch.transaction.proxy.failure;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.InitSQL;
import cn.newtouch.transaction.proxy.commonutils.connection.general.DataSourceFactory;
import cn.newtouch.transaction.proxy.failure.service.BankServiceImpl;

public class FailureBankServiceTest
{
    private DataSource dataSource = DataSourceFactory.createDataSource();

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
            BankService bankService = new BankServiceImpl(this.dataSource);
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
    public void transferFailure()
    {
        try
        {
            BankServiceImpl bankService = new BankServiceImpl(this.dataSource);
            int toNonExistId = 3333;
            bankService.transfer(1111, toNonExistId, 200);
            System.out.println(bankService.getInsuranceAmount(2222));
            System.out.println(bankService.getBankAmount(1111));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}