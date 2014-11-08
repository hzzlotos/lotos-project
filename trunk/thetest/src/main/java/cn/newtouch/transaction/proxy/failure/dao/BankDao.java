package cn.newtouch.transaction.proxy.failure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class BankDao
{
    private DataSource dataSource;

    public BankDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void withdraw(int bankId, int amount) throws SQLException
    {
        // 问题出在了这里
        Connection connection = this.dataSource.getConnection();
        PreparedStatement selectStatement = connection
                .prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
        selectStatement.setInt(1, bankId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int previousAmount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();

        int newAmount = previousAmount - amount;
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE BANK_ACCOUNT SET BANK_AMOUNT = ? WHERE BANK_ID = ?");
        updateStatement.setInt(1, newAmount);
        updateStatement.setInt(2, bankId);
        updateStatement.execute();

        updateStatement.close();
        connection.close();
    }

    public int getBankAmount(int bankId) throws SQLException
    {
        Connection connection = this.dataSource.getConnection();
        PreparedStatement selectStatement = connection
                .prepareStatement("SELECT BANK_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ID = ?");
        selectStatement.setInt(1, bankId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int amount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();
        connection.close();
        return amount;
    }
}