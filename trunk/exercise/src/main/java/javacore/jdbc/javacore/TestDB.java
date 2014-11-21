package javacore.jdbc.javacore;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This program tests that the database and the JDBC driver are correctly configured.
 * 
 * @version 1.01 2004-09-24
 * @author Cay Horstmann
 */
class TestDB
{
    public static void main(String args[])
    {
        try
        {
            runTest();
        }
        catch (SQLException ex)
        {
            for (Throwable t : ex)
            {
                t.printStackTrace();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Runs a test by creating a table, adding a value, showing the table contents, and removing the
     * table.
     */
    public static void runTest() throws SQLException, IOException
    {
        Connection conn = getConnection();
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SHOW TABLES LIKE '%Greetings%'");
            String name = null;
            if (result.next())
            {
                name = result.getString(1);
            }
            if (null == name || "".equals(name))
            {
                stmt.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");
            }
            result = stmt.executeQuery("SELECT * FROM Greetings");
            if (result.next())
            {
                System.out.println(result.getString(1));
            }
            result.close();
            stmt.executeUpdate("DROP TABLE Greetings");
        }
        finally
        {
            conn.close();
        }
    }

    /**
     * Gets a connection from the properties specified in the file database.properties
     * 
     * @return the database connection
     */
    public static Connection getConnection() throws SQLException, IOException
    {
        Properties props = new Properties();
        // FileInputStream in = new FileInputStream("database.properties");
        FileInputStream in = new FileInputStream(TestDB.class.getClassLoader().getResource("database.properties")
                .getPath());

        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null)
        {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }
}
