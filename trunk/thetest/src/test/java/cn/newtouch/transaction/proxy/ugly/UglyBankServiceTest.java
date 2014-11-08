package cn.newtouch.transaction.proxy.ugly;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import cn.newtouch.transaction.proxy.InitSQL;
import cn.newtouch.transaction.proxy.commonutils.connection.general.DataSourceFactory;
import cn.newtouch.transaction.proxy.ugly.service.BankService;
import cn.newtouch.transaction.proxy.ugly.service.BankServiceImpl;

public class UglyBankServiceTest
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
            BankService bankService = new BankServiceImpl();
            Connection connection = this.dataSource.getConnection();
            bankService.transfer(connection, 1111, 2222, 200);
            System.out.println(bankService.getBankAmount(connection, 1111));
            System.out.println(bankService.getInsuranceAmount(connection, 2222));
            connection.close();
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
            BankServiceImpl bankService = new BankServiceImpl();
            Connection connection = this.dataSource.getConnection();
            int toNonExistId = 3333;
            bankService.transfer(connection, 1111, toNonExistId, 200);
            System.out.println(bankService.getInsuranceAmount(connection, 2222));
            System.out.println(bankService.getBankAmount(connection, 1111));
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}