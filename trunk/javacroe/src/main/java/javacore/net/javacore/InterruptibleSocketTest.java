package javacore.net.javacore;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This program shows how to interrupt a socket channel.
 * 
 * @author Cay Horstmann
 * @version 1.01 2007-06-25
 */
public class InterruptibleSocketTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new InterruptibleSocketFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class InterruptibleSocketFrame extends JFrame
{
    public InterruptibleSocketFrame()
    {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("InterruptibleSocketTest");

        JPanel northPanel = new JPanel();
        this.add(northPanel, BorderLayout.NORTH);

        this.messages = new JTextArea();
        this.add(new JScrollPane(this.messages));

        this.interruptibleButton = new JButton("Interruptible");
        this.blockingButton = new JButton("Blocking");

        northPanel.add(this.interruptibleButton);
        northPanel.add(this.blockingButton);

        this.interruptibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                InterruptibleSocketFrame.this.interruptibleButton.setEnabled(false);
                InterruptibleSocketFrame.this.blockingButton.setEnabled(false);
                InterruptibleSocketFrame.this.cancelButton.setEnabled(true);
                InterruptibleSocketFrame.this.connectThread = new Thread(new Runnable() {
                    @Override
                    public void run()
                    {
                        try
                        {
                            InterruptibleSocketFrame.this.connectInterruptibly();
                        }
                        catch (IOException e)
                        {
                            InterruptibleSocketFrame.this.messages
                                    .append("\nInterruptibleSocketTest.connectInterruptibly: " + e);
                        }
                    }
                });
                InterruptibleSocketFrame.this.connectThread.start();
            }
        });

        this.blockingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                InterruptibleSocketFrame.this.interruptibleButton.setEnabled(false);
                InterruptibleSocketFrame.this.blockingButton.setEnabled(false);
                InterruptibleSocketFrame.this.cancelButton.setEnabled(true);
                InterruptibleSocketFrame.this.connectThread = new Thread(new Runnable() {
                    @Override
                    public void run()
                    {
                        try
                        {
                            InterruptibleSocketFrame.this.connectBlocking();
                        }
                        catch (IOException e)
                        {
                            InterruptibleSocketFrame.this.messages.append("\nInterruptibleSocketTest.connectBlocking: "
                                    + e);
                        }
                    }
                });
                InterruptibleSocketFrame.this.connectThread.start();
            }
        });

        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setEnabled(false);
        northPanel.add(this.cancelButton);
        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                InterruptibleSocketFrame.this.connectThread.interrupt();
                InterruptibleSocketFrame.this.cancelButton.setEnabled(false);
            }
        });
        this.server = new TestServer();
        new Thread(this.server).start();
    }

    /**
     * Connects to the test server, using interruptible I/O
     */
    public void connectInterruptibly() throws IOException
    {
        this.messages.append("Interruptible:\n");
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
        try
        {
            this.in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted())
            {
                this.messages.append("Reading ");
                if (this.in.hasNextLine())
                {
                    String line = this.in.nextLine();
                    this.messages.append(line);
                    this.messages.append("\n");
                }
            }
        }
        finally
        {
            channel.close();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    InterruptibleSocketFrame.this.messages.append("Channel closed\n");
                    InterruptibleSocketFrame.this.interruptibleButton.setEnabled(true);
                    InterruptibleSocketFrame.this.blockingButton.setEnabled(true);
                }
            });
        }
    }

    /**
     * Connects to the test server, using blocking I/O
     */
    public void connectBlocking() throws IOException
    {
        this.messages.append("Blocking:\n");
        Socket sock = new Socket("localhost", 8189);
        try
        {
            this.in = new Scanner(sock.getInputStream());
            while (!Thread.currentThread().isInterrupted())
            {
                this.messages.append("Reading ");
                if (this.in.hasNextLine())
                {
                    String line = this.in.nextLine();
                    this.messages.append(line);
                    this.messages.append("\n");
                }
            }
        }
        finally
        {
            sock.close();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run()
                {
                    InterruptibleSocketFrame.this.messages.append("Socket closed\n");
                    InterruptibleSocketFrame.this.interruptibleButton.setEnabled(true);
                    InterruptibleSocketFrame.this.blockingButton.setEnabled(true);
                }
            });
        }
    }

    /**
     * A multithreaded server that listens to port 8189 and sends numbers to the client, simulating a
     * hanging server after 10 numbers.
     */
    class TestServer implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                ServerSocket s = new ServerSocket(8189);

                while (true)
                {
                    Socket incoming = s.accept();
                    Runnable r = new TestServerHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }
            }
            catch (IOException e)
            {
                InterruptibleSocketFrame.this.messages.append("\nTestServer.run: " + e);
            }
        }
    }

    /**
     * This class handles the client input for one server socket connection.
     */
    class TestServerHandler implements Runnable
    {
        /**
         * Constructs a handler.
         * 
         * @param i the incoming socket
         */
        public TestServerHandler(Socket i)
        {
            this.incoming = i;
        }

        @Override
        public void run()
        {
            try
            {
                OutputStream outStream = this.incoming.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
                while (this.counter < 100)
                {
                    this.counter++;
                    if (this.counter <= 10)
                    {
                        out.println(this.counter);
                    }
                    Thread.sleep(100);
                }
                this.incoming.close();
                InterruptibleSocketFrame.this.messages.append("Closing server\n");
            }
            catch (Exception e)
            {
                InterruptibleSocketFrame.this.messages.append("\nTestServerHandler.run: " + e);
            }
        }

        private Socket incoming;

        private int    counter;
    }

    private Scanner         in;

    private JButton         interruptibleButton;

    private JButton         blockingButton;

    private JButton         cancelButton;

    private JTextArea       messages;

    private TestServer      server;

    private Thread          connectThread;

    public static final int WIDTH  = 300;

    public static final int HEIGHT = 300;
}
