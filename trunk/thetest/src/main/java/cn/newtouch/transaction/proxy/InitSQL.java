package cn.newtouch.transaction.proxy;

import java.sql.Connection;
import java.sql.Statement;

import cn.newtouch.transaction.proxy.commonutils.connection.general.DataSourceFactory;

public class InitSQL
{
    public static void init()
    {
        try
        {
            Connection connection = DataSourceFactory.createDataSource().getConnection();
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS BANK_ACCOUNT ");
            statement.execute("DROP TABLE IF EXISTS INSURANCE_ACCOUNT");

            statement.execute("CREATE TABLE BANK_ACCOUNT (BANK_ID INT,BANK_AMOUNT INT, PRIMARY KEY(BANK_ID))");
            statement
                    .execute("CREATE TABLE INSURANCE_ACCOUNT (INSURANCE_ID INT,INSURANCE_AMOUNT INT,PRIMARY KEY(INSURANCE_ID))");

            statement.execute("INSERT INTO BANK_ACCOUNT VALUES (1111, 1000);");
            statement.execute("INSERT INTO INSURANCE_ACCOUNT VALUES (2222, 1000);");

            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
