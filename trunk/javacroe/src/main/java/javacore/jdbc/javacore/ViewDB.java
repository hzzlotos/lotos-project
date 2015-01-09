package javacore.jdbc.javacore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.sun.rowset.CachedRowSetImpl;

/**
 * This program uses metadata to display arbitrary tables in a database.
 * 
 * @version 1.31 2007-06-28
 * @author Cay Horstmann
 */
public class ViewDB
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new ViewDBFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * The frame that holds the data panel and the navigation buttons.
 */
class ViewDBFrame extends JFrame
{
    public ViewDBFrame()
    {
        this.setTitle("ViewDB");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.tableNames = new JComboBox();
        this.tableNames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ViewDBFrame.this.showTable((String) ViewDBFrame.this.tableNames.getSelectedItem());
            }
        });
        this.add(this.tableNames, BorderLayout.NORTH);

        try
        {
            this.readDatabaseProperties();
            Connection conn = this.getConnection();
            try
            {
                DatabaseMetaData meta = conn.getMetaData();
                ResultSet mrs = meta.getTables(null, null, null, new String[] { "TABLE" });
                while (mrs.next())
                {
                    this.tableNames.addItem(mrs.getString(3));
                }
            }
            finally
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }

        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.previousButton = new JButton("Previous");
        this.previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ViewDBFrame.this.showPreviousRow();
            }
        });
        buttonPanel.add(this.previousButton);

        this.nextButton = new JButton("Next");
        this.nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ViewDBFrame.this.showNextRow();
            }
        });
        buttonPanel.add(this.nextButton);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ViewDBFrame.this.deleteRow();
            }
        });
        buttonPanel.add(this.deleteButton);

        this.saveButton = new JButton("Save");
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ViewDBFrame.this.saveChanges();
            }
        });
        buttonPanel.add(this.saveButton);
    }

    /**
     * Prepares the text fields for showing a new table, and shows the first row.
     * 
     * @param tableName the name of the table to display
     */
    public void showTable(String tableName)
    {
        try
        {
            // open connection
            Connection conn = this.getConnection();
            try
            {
                // get result set
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
                // copy into cached row set
                this.crs = new CachedRowSetImpl();
                this.crs.setTableName(tableName);
                this.crs.populate(result);
            }
            finally
            {
                conn.close();
            }

            if (this.scrollPane != null)
            {
                this.remove(this.scrollPane);
            }
            this.dataPanel = new DataPanel(this.crs);
            this.scrollPane = new JScrollPane(this.dataPanel);
            this.add(this.scrollPane, BorderLayout.CENTER);
            this.validate();
            this.showNextRow();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * Moves to the previous table row.
     */
    public void showPreviousRow()
    {
        try
        {
            if (this.crs == null || this.crs.isFirst())
            {
                return;
            }
            this.crs.previous();
            this.dataPanel.showRow(this.crs);
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                t.printStackTrace();
            }
        }
    }

    /**
     * Moves to the next table row.
     */
    public void showNextRow()
    {
        try
        {
            if (this.crs == null || this.crs.isLast())
            {
                return;
            }
            this.crs.next();
            this.dataPanel.showRow(this.crs);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * Deletes current table row.
     */
    public void deleteRow()
    {
        try
        {
            Connection conn = this.getConnection();
            try
            {
                this.crs.deleteRow();
                this.crs.acceptChanges(conn);
                if (!this.crs.isLast())
                {
                    this.crs.next();
                }
                else
                    if (!this.crs.isFirst())
                    {
                        this.crs.previous();
                    }
                    else
                    {
                        this.crs = null;
                    }
                this.dataPanel.showRow(this.crs);
            }
            finally
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    /**
     * Saves all changes.
     */
    public void saveChanges()
    {
        try
        {
            Connection conn = this.getConnection();
            try
            {
                this.dataPanel.setRow(this.crs);
                this.crs.acceptChanges(conn);
            }
            finally
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void readDatabaseProperties() throws IOException
    {
        this.props = new Properties();
        // FileInputStream in = new FileInputStream("database.properties");
        FileInputStream in = new FileInputStream(TestDB.class.getClassLoader().getResource("database.properties")
                .getPath());
        this.props.load(in);
        in.close();
        String drivers = this.props.getProperty("jdbc.drivers");
        if (drivers != null)
        {
            System.setProperty("jdbc.drivers", drivers);
        }
    }

    /**
     * Gets a connection from the properties specified in the file database.properties
     * 
     * @return the database connection
     */
    private Connection getConnection() throws SQLException
    {
        String url = this.props.getProperty("jdbc.url");
        String username = this.props.getProperty("jdbc.username");
        String password = this.props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

    public static final int DEFAULT_WIDTH  = 400;

    public static final int DEFAULT_HEIGHT = 200;

    private JButton         previousButton;

    private JButton         nextButton;

    private JButton         deleteButton;

    private JButton         saveButton;

    private DataPanel       dataPanel;

    private Component       scrollPane;

    private JComboBox       tableNames;

    private Properties      props;

    private CachedRowSet    crs;
}

/**
 * This panel displays the contents of a result set.
 */
class DataPanel extends JPanel
{
    /**
     * Constructs the data panel.
     * 
     * @param rs the result set whose contents this panel displays
     */
    public DataPanel(RowSet rs) throws SQLException
    {
        this.fields = new ArrayList<JTextField>();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
        {
            gbc.gridy = i - 1;

            String columnName = rsmd.getColumnLabel(i);
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            this.add(new JLabel(columnName), gbc);

            int columnWidth = rsmd.getColumnDisplaySize(i);
            JTextField tb = new JTextField(columnWidth);
            if (!rsmd.getColumnClassName(i).equals("java.lang.String"))
            {
                tb.setEditable(false);
            }

            this.fields.add(tb);

            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            this.add(tb, gbc);
        }
    }

    /**
     * Shows a database row by populating all text fields with the column values.
     */
    public void showRow(ResultSet rs) throws SQLException
    {
        for (int i = 1; i <= this.fields.size(); i++)
        {
            String field = rs.getString(i);
            JTextField tb = this.fields.get(i - 1);
            tb.setText(field);
        }
    }

    /**
     * Updates changed data into the current row of the row set
     */
    public void setRow(RowSet rs) throws SQLException
    {
        for (int i = 1; i <= this.fields.size(); i++)
        {
            String field = rs.getString(i);
            JTextField tb = this.fields.get(i - 1);
            if (!field.equals(tb.getText()))
            {
                rs.updateString(i, tb.getText());
            }
        }
        rs.updateRow();
    }

    private ArrayList<JTextField> fields;
}