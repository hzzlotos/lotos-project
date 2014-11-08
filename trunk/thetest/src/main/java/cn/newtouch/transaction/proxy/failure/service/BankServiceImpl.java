package cn.newtouch.transaction.proxy.failure.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.failure.dao.BankDao;
import cn.newtouch.transaction.proxy.failure.dao.InsuranceDao;

public class BankServiceImpl implements BankService
{
    private DataSource   dataSource;

    private BankDao      failureBankDao;

    private InsuranceDao failureInsuranceDao;

    public BankServiceImpl(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.failureBankDao = new BankDao(this.dataSource);
        this.failureInsuranceDao = new InsuranceDao(this.dataSource);
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
        Connection connection = null;
        try
        {
            // 问题出在了这里在dao中又各自取了两次，三次getConnection()取得不是用一个connection，而事务是依赖于connection的，所以事务未能同步
            connection = this.dataSource.getConnection();
            connection.setAutoCommit(false);

            this.failureBankDao.withdraw(fromId, amount);
            this.failureInsuranceDao.deposit(toId, amount);

            connection.commit();
        }
        catch (Exception e)
        {
            try
            {
                if (null != connection)
                {
                    connection.rollback();
                }
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        }
        finally
        {
            try
            {
                if (null != connection)
                {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
