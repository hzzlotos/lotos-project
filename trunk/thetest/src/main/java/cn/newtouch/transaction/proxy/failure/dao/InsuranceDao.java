package cn.newtouch.transaction.proxy.failure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class InsuranceDao
{
    private DataSource dataSource;

    public InsuranceDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void deposit(int insuranceId, int amount) throws SQLException
    {
        // 问题出在了这里
        Connection connection = this.dataSource.getConnection();
        PreparedStatement selectStatement = connection
                .prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
        selectStatement.setInt(1, insuranceId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int previousAmount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();

        int newAmount = previousAmount + amount;
        PreparedStatement updateStatement = connection
                .prepareStatement("UPDATE INSURANCE_ACCOUNT SET INSURANCE_AMOUNT = ? WHERE INSURANCE_ID = ?");
        updateStatement.setInt(1, newAmount);
        updateStatement.setInt(2, insuranceId);
        updateStatement.execute();

        updateStatement.close();
        connection.close();
    }

    public int getInsuranceAmount(int insuranceId) throws SQLException
    {
        Connection connection = this.dataSource.getConnection();
        PreparedStatement selectStatement = connection
                .prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
        selectStatement.setInt(1, insuranceId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int amount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();
        connection.close();
        return amount;
    }
}
