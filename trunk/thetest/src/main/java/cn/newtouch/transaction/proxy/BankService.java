package cn.newtouch.transaction.proxy;

import java.sql.SQLException;

public interface BankService
{
    public void transfer(int fromId, int toId, int amount) throws Exception;

    public int getBankAmount(int bankId) throws SQLException;

    public int getInsuranceAmount(int insuranceId) throws SQLException;
}
