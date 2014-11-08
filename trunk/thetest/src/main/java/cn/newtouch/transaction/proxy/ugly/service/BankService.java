package cn.newtouch.transaction.proxy.ugly.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface BankService
{
    public void transfer(Connection connection, int fromId, int toId, int amount) throws Exception;

    public int getBankAmount(Connection connection, int bankId) throws SQLException;

    public int getInsuranceAmount(Connection connection, int insuranceId) throws SQLException;
}
