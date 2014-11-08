package cn.newtouch.transaction.proxy.success.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.newtouch.transaction.proxy.commonutils.connection.threadlocal.ThreadLocalConnectionManager;

public class InsuranceDao
{

    private DataSource dataSource;

    public InsuranceDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void deposit(int insuranceId, int amount) throws SQLException
    {
        PreparedStatement selectStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
        selectStatement.setInt(1, insuranceId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int previousAmount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();

        int newAmount = previousAmount + amount;
        PreparedStatement updateStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("UPDATE INSURANCE_ACCOUNT SET INSURANCE_AMOUNT = ? WHERE INSURANCE_ID = ?");
        updateStatement.setInt(1, newAmount);
        updateStatement.setInt(2, insuranceId);
        updateStatement.execute();
        updateStatement.close();
    }

    public int getInsuranceAmount(int insuranceId) throws SQLException
    {
        PreparedStatement selectStatement = ThreadLocalConnectionManager.getConnection(this.dataSource)
                .prepareStatement("SELECT INSURANCE_AMOUNT FROM INSURANCE_ACCOUNT WHERE INSURANCE_ID = ?");
        selectStatement.setInt(1, insuranceId);
        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int amount = resultSet.getInt(1);
        resultSet.close();
        selectStatement.close();
        return amount;
    }
}
