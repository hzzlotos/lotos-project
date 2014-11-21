package javacore.net.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 * This program demonstrates how to use the URLConnection class for a POST request.
 * 
 * @version 1.20 2007-06-25
 * @author Cay Horstmann
 */
public class PostTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new PostTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class PostTestFrame extends JFrame
{
    /**
     * Makes a POST request and returns the server response.
     * 
     * @param urlString the URL to post to
     * @param nameValuePairs a map of name/value pairs to supply in the request.
     * @return the server reply (either from the input stream or the error stream)
     */
    public static String doPost(String urlString, Map<String, String> nameValuePairs) throws IOException
    {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        /* 添加post参数 */
        PrintWriter out = new PrintWriter(connection.getOutputStream());

        boolean first = true;
        for (Map.Entry<String, String> pair : nameValuePairs.entrySet())
        {
            if (first)
            {
                first = false;
            }
            else
            {
                out.print('&');
            }
            String name = pair.getKey();
            String value = pair.getValue();
            out.print(name);
            out.print('=');
            out.print(URLEncoder.encode(value, "UTF-8"));
        }

        out.close();

        Scanner in;
        StringBuilder response = new StringBuilder();
        try
        {
            in = new Scanner(connection.getInputStream());
        }
        catch (IOException e)
        {
            if (!(connection instanceof HttpURLConnection))
            {
                throw e;
            }
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (err == null)
            {
                throw e;
            }
            in = new Scanner(err);
        }

        while (in.hasNextLine())
        {
            response.append(in.nextLine());
            response.append("\n");
        }

        in.close();
        return response.toString();
    }

    public PostTestFrame()
    {
        this.setTitle("PostTest");

        this.northPanel = new JPanel();
        this.add(this.northPanel, BorderLayout.NORTH);
        this.northPanel.setLayout(new GridLayout(0, 2));
        this.northPanel.add(new JLabel("Host: ", SwingConstants.TRAILING));
        final JTextField hostField = new JTextField();
        this.northPanel.add(hostField);
        this.northPanel.add(new JLabel("Action: ", SwingConstants.TRAILING));
        final JTextField actionField = new JTextField();
        this.northPanel.add(actionField);
        for (int i = 1; i <= 8; i++)
        {
            this.northPanel.add(new JTextField());
        }

        final JTextArea result = new JTextArea(20, 40);
        this.add(new JScrollPane(result));

        JPanel southPanel = new JPanel();
        this.add(southPanel, BorderLayout.SOUTH);
        JButton addButton = new JButton("More");
        southPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                PostTestFrame.this.northPanel.add(new JTextField());
                PostTestFrame.this.northPanel.add(new JTextField());
                PostTestFrame.this.pack();
            }
        });

        JButton getButton = new JButton("POST");
        southPanel.add(getButton);
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                result.setText("");
                final Map<String, String> post = new HashMap<String, String>();
                for (int i = 4; i < PostTestFrame.this.northPanel.getComponentCount(); i += 2)
                {
                    String name = ((JTextField) PostTestFrame.this.northPanel.getComponent(i)).getText();
                    if (name.length() > 0)
                    {
                        String value = ((JTextField) PostTestFrame.this.northPanel.getComponent(i + 1)).getText();
                        post.put(name, value);
                    }
                }
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception
                    {
                        try
                        {
                            String urlString = hostField.getText() + "/" + actionField.getText();
                            result.setText(doPost(urlString, post));
                        }
                        catch (IOException e)
                        {
                            result.setText("" + e);
                        }
                        return null;
                    }
                }.execute();
            }
        });

        this.pack();
    }

    private JPanel northPanel;
}
