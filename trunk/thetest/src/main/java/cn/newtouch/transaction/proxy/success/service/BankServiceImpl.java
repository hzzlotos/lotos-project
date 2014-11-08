package cn.newtouch.transaction.proxy.success.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.commonutils.connection.threadlocal.TransactionManager;
import cn.newtouch.transaction.proxy.success.dao.BankDao;
import cn.newtouch.transaction.proxy.success.dao.InsuranceDao;

public class BankServiceImpl implements BankService
{
    private TransactionManager transaction;

    private BankDao            failureBankDao;

    private InsuranceDao       failureInsuranceDao;

    public BankServiceImpl(DataSource dataSource)
    {
        this.transaction = new TransactionManager(dataSource);
        this.failureBankDao = new BankDao(dataSource);
        this.failureInsuranceDao = new InsuranceDao(dataSource);
    }

    @Override
    public int getBankAmount(int bankId) throws SQLException
    {
        return this.failureBankDao.getBankAmount(bankId);
    }

    @Override
    public int getInsuranceAmount(int insuranceId) throws SQLException
    {
        return this.failureInsuranceDao.getInsuranceAmount(insuranceId);
    }

    @Override
    public void transfer(int fromId, int toId, int amount)
    {
        try
        {
            this.transaction.start();
            this.failureBankDao.withdraw(fromId, amount);
            this.failureInsuranceDao.deposit(toId, amount);
        }
        catch (Exception e)
        {
            this.transaction.rollback();
            e.printStackTrace();
        }
        finally
        {
            this.transaction.close();
        }
    }
}