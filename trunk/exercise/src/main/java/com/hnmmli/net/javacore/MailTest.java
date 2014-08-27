package com.hnmmli.net.javacore;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 * This program shows how to use sockets to send plain text mail messages.
 * 
 * @author Cay Horstmann
 * @version 1.11 2007-06-25
 */
public class MailTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new MailTestFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * The frame for the mail GUI.
 */
class MailTestFrame extends JFrame
{
    public MailTestFrame()
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setTitle("MailTest");

        this.setLayout(new GridBagLayout());

        // we use the GBC convenience class of Core Java Volume 1 Chapter 9
        this.add(new JLabel("From:"), new GBC(0, 0).setFill(GBC.HORIZONTAL));

        this.from = new JTextField(20);
        this.add(this.from, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0));

        this.add(new JLabel("To:"), new GBC(0, 1).setFill(GBC.HORIZONTAL));

        this.to = new JTextField(20);
        this.add(this.to, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0));

        this.add(new JLabel("SMTP server:"), new GBC(0, 2).setFill(GBC.HORIZONTAL));

        this.smtpServer = new JTextField(20);
        this.add(this.smtpServer, new GBC(1, 2).setFill(GBC.HORIZONTAL).setWeight(100, 0));

        this.message = new JTextArea();
        this.add(new JScrollPane(this.message), new GBC(0, 3, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));

        this.comm = new JTextArea();
        this.add(new JScrollPane(this.comm), new GBC(0, 4, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));

        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, new GBC(0, 5, 2, 1));

        JButton sendButton = new JButton("Send");
        buttonPanel.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception
                    {
                        MailTestFrame.this.comm.setText("");
                        MailTestFrame.this.sendMail();
                        return null;
                    }
                }.execute();
            }
        });
    }

    /**
     * Sends the mail message that has been authored in the GUI.
     */
    public void sendMail()
    {
        try
        {
            Socket s = new Socket(this.smtpServer.getText(), 25);

            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();

            this.in = new Scanner(inStream);
            this.out = new PrintWriter(outStream, true /* autoFlush */);

            String hostName = InetAddress.getLocalHost().getHostName();

            this.receive();
            this.send("HELO " + hostName);
            this.receive();
            this.send("MAIL FROM: <" + this.from.getText() + ">");
            this.receive();
            this.send("RCPT TO: <" + this.to.getText() + ">");
            this.receive();
            this.send("DATA");
            this.receive();
            this.send(this.message.getText());
            this.send(".");
            this.receive();
            s.close();
        }
        catch (IOException e)
        {
            this.comm.append("Error: " + e);
        }
    }

    /**
     * Sends a string to the socket and echoes it in the comm text area.
     * 
     * @param s the string to send.
     */
    public void send(String s) throws IOException
    {
        this.comm.append(s);
        this.comm.append("\n");
        this.out.print(s.replaceAll("\n", "\r\n"));
        this.out.print("\r\n");
        this.out.flush();
    }

    /**
     * Receives a string from the socket and displays it in the comm text area.
     */
    public void receive() throws IOException
    {
        String line = this.in.nextLine();
        this.comm.append(line);
        this.comm.append("\n");
    }

    private Scanner         in;

    private PrintWriter     out;

    private JTextField      from;

    private JTextField      to;

    private JTextField      smtpServer;

    private JTextArea       message;

    private JTextArea       comm;

    public static final int DEFAULT_WIDTH  = 300;

    public static final int DEFAULT_HEIGHT = 300;
}
