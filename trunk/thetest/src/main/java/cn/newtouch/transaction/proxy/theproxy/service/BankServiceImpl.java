package cn.newtouch.transaction.proxy.theproxy.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.annotation.Transactional;
import cn.newtouch.transaction.proxy.BankService;
import cn.newtouch.transaction.proxy.success.dao.BankDao;
import cn.newtouch.transaction.proxy.success.dao.InsuranceDao;

public class BankServiceImpl implements BankService
{
    private BankDao      failureBankDao;

    private InsuranceDao failureInsuranceDao;

    public BankServiceImpl(DataSource dataSource)
    {
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
    @Transactional
    public void transfer(int fromId, int toId, int amount) throws Exception
    {
        this.failureBankDao.withdraw(fromId, amount);
        this.failureInsuranceDao.deposit(toId, amount);
    }
}