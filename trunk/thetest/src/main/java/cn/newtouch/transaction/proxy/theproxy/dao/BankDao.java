package cn.newtouch.transaction.proxy.theproxy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.transaction.proxy.commonutils.connection.threadlocal.ThreadLocalConnectionManager;

public class BankDao
{
    private DataSource dataSource;

    public BankDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void withdraw(int bankId, int amount) throws SQLException
    {
        PreparedStatement selectStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
        selectStatement.setInt(1, bankId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int previousAmount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();

        int newAmount = previousAmount - amount;
        PreparedStatement updateStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("UPDATE BANK_ACCOUNT SET BANK_AMOUNT = ? WHERE BANK_ID = ?");
        updateStatement.setInt(1, newAmount);
        updateStatement.setInt(2, bankId);
        updateStatement.execute();
        updateStatement.close();
    }

    public int getBankAmount(int bankId) throws SQLException
    {
        PreparedStatement selectStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
        selectStatement.setInt(1, bankId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int amount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();
        return amount;
    }
}