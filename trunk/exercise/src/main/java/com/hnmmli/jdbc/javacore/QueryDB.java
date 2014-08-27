package com.hnmmli.jdbc.javacore;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This program demonstrates several complex database queries.
 * 
 * @version 1.23 2007-06-28
 * @author Cay Horstmann
 */
public class QueryDB
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new QueryDBFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame displays combo boxes for query parameters, a text area for command results, and
 * buttons to launch a query and an update.
 */
class QueryDBFrame extends JFrame
{
    public QueryDBFrame()
    {
        this.setTitle("QueryDB");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setLayout(new GridBagLayout());

        this.authors = new JComboBox();
        this.authors.setEditable(false);
        this.authors.addItem("Any");

        this.publishers = new JComboBox();
        this.publishers.setEditable(false);
        this.publishers.addItem("Any");

        this.result = new JTextArea(4, 50);
        this.result.setEditable(false);

        this.priceChange = new JTextField(8);
        this.priceChange.setText("-5.00");

        try
        {
            this.conn = getConnection();
            Statement stat = this.conn.createStatement();

            String query = "SELECT Name FROM Authors";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next())
            {
                this.authors.addItem(rs.getString(1));
            }
            rs.close();

            query = "SELECT Name FROM Publishers";
            rs = stat.executeQuery(query);
            while (rs.next())
            {
                this.publishers.addItem(rs.getString(1));
            }
            rs.close();
            stat.close();
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                this.result.append(t.getMessage());
            }
        }
        catch (IOException e)
        {
            this.result.setText("" + e);
        }

        // we use the GBC convenience class of Core Java Volume 1 Chapter 9
        this.add(this.authors, new GBC(0, 0, 2, 1));

        this.add(this.publishers, new GBC(2, 0, 2, 1));

        JButton queryButton = new JButton("Query");
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                QueryDBFrame.this.executeQuery();
            }
        });
        this.add(queryButton, new GBC(0, 1, 1, 1).setInsets(3));

        JButton changeButton = new JButton("Change prices");
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                QueryDBFrame.this.changePrices();
            }
        });
        this.add(changeButton, new GBC(2, 1, 1, 1).setInsets(3));

        this.add(this.priceChange, new GBC(3, 1, 1, 1).setFill(GBC.HORIZONTAL));

        this.add(new JScrollPane(this.result), new GBC(0, 2, 4, 1).setFill(GBC.BOTH).setWeight(100, 100));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event)
            {
                try
                {
                    if (QueryDBFrame.this.conn != null)
                    {
                        QueryDBFrame.this.conn.close();
                    }
                }
                catch (SQLException e)
                {
                    for (Throwable t : e)
                    {
                        t.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Executes the selected query.
     */
    private void executeQuery()
    {
        ResultSet rs = null;
        try
        {
            String author = (String) this.authors.getSelectedItem();
            String publisher = (String) this.publishers.getSelectedItem();
            if (!author.equals("Any") && !publisher.equals("Any"))
            {
                if (this.authorPublisherQueryStmt == null)
                {
                    this.authorPublisherQueryStmt = this.conn.prepareStatement(authorPublisherQuery);
                }
                this.authorPublisherQueryStmt.setString(1, author);
                this.authorPublisherQueryStmt.setString(2, publisher);
                rs = this.authorPublisherQueryStmt.executeQuery();
            }
            else
                if (!author.equals("Any") && publisher.equals("Any"))
                {
                    if (this.authorQueryStmt == null)
                    {
                        this.authorQueryStmt = this.conn.prepareStatement(authorQuery);
                    }
                    this.authorQueryStmt.setString(1, author);
                    rs = this.authorQueryStmt.executeQuery();
                }
                else
                    if (author.equals("Any") && !publisher.equals("Any"))
                    {
                        if (this.publisherQueryStmt == null)
                        {
                            this.publisherQueryStmt = this.conn.prepareStatement(publisherQuery);
                        }
                        this.publisherQueryStmt.setString(1, publisher);
                        rs = this.publisherQueryStmt.executeQuery();
                    }
                    else
                    {
                        if (this.allQueryStmt == null)
                        {
                            this.allQueryStmt = this.conn.prepareStatement(allQuery);
                        }
                        rs = this.allQueryStmt.executeQuery();
                    }

            this.result.setText("");
            while (rs.next())
            {
                this.result.append(rs.getString(1));
                this.result.append(", ");
                this.result.append(rs.getString(2));
                this.result.append("\n");
            }
            rs.close();
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                this.result.append(t.getMessage());
            }
        }
    }

    /**
     * Executes an update statement to change prices.
     */
    public void changePrices()
    {
        String publisher = (String) this.publishers.getSelectedItem();
        if (publisher.equals("Any"))
        {
            this.result.setText("I am sorry, but I cannot do that.");
            return;
        }
        try
        {
            if (this.priceUpdateStmt == null)
            {
                this.priceUpdateStmt = this.conn.prepareStatement(priceUpdate);
            }
            this.priceUpdateStmt.setString(1, this.priceChange.getText());
            this.priceUpdateStmt.setString(2, publisher);
            int r = this.priceUpdateStmt.executeUpdate();
            this.result.setText(r + " records updated.");
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
            {
                this.result.append(t.getMessage());
            }
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

    public static final int     DEFAULT_WIDTH        = 400;

    public static final int     DEFAULT_HEIGHT       = 400;

    private JComboBox           authors;

    private JComboBox           publishers;

    private JTextField          priceChange;

    private JTextArea           result;

    private Connection          conn;

    private PreparedStatement   authorQueryStmt;

    private PreparedStatement   authorPublisherQueryStmt;

    private PreparedStatement   publisherQueryStmt;

    private PreparedStatement   allQueryStmt;

    private PreparedStatement   priceUpdateStmt;

    private static final String authorPublisherQuery = "SELECT Books.Price, Books.Title FROM Books, BooksAuthors, Authors, Publishers"
                                                             + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
                                                             + " AND Books.Publisher_Id = Publishers.Publisher_Id AND Authors.Name = ?"
                                                             + " AND Publishers.Name = ?";

    private static final String authorQuery          = "SELECT Books.Price, Books.Title FROM Books, BooksAuthors, Authors"
                                                             + " WHERE Authors.Author_Id = BooksAuthors.Author_Id AND BooksAuthors.ISBN = Books.ISBN"
                                                             + " AND Authors.Name = ?";

    private static final String publisherQuery       = "SELECT Books.Price, Books.Title FROM Books, Publishers"
                                                             + " WHERE Books.Publisher_Id = Publishers.Publisher_Id AND Publishers.Name = ?";

    private static final String allQuery             = "SELECT Books.Price, Books.Title FROM Books";

    private static final String priceUpdate          = "UPDATE Books "
                                                             + "SET Price = Price + ? "
                                                             + " WHERE Books.Publisher_Id = (SELECT Publisher_Id FROM Publishers WHERE Name = ?)";
}
