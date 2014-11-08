package cn.newtouch.transaction.proxy.ugly.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.newtouch.transaction.proxy.ugly.dao.BankDao;
import cn.newtouch.transaction.proxy.ugly.dao.InsuranceDao;

public class BankServiceImpl implements BankService
{
    private BankDao      BankDao;

    private InsuranceDao insuranceDao;

    public BankServiceImpl()
    {
        this.BankDao = new BankDao();
        this.insuranceDao = new InsuranceDao();
    }

    @Override
    public int getBankAmount(Connection connection, int bankId) throws SQLException
    {
        return this.BankDao.getBankAmount(connection, bankId);
    }

    @Override
    public int getInsuranceAmount(Connection connection, int insuranceId) throws SQLException
    {
        return this.insuranceDao.getInsuranceAmount(connection, insuranceId);
    }

    @Override
    public void transfer(Connection connection, int fromId, int toId, int amount) throws Exception
    {
        try
        {
            connection.setAutoCommit(false);
            this.BankDao.withdraw(connection, fromId, amount);
            this.insuranceDao.deposit(connection, toId, amount);
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
            e.printStackTrace();
        }
    }
}
