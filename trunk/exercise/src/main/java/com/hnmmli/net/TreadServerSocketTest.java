package com.hnmmli.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TreadServerSocketTest
{

    public static void main(String[] args)
    {
        ServerSocket ss = null;
        try
        {
            ss = new ServerSocket(8189);

            while (true)
            {
                Socket incoming = ss.accept();
                Runnable r = new ThreadedEchoHandler(incoming);

                Thread t = new Thread(r);
                t.start();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable
{

    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming)
    {
        this.incoming = incoming;
    }

    @Override
    public void run()
    {
        try
        {
            InputStream in = this.incoming.getInputStream();

            // OutputStream out = incoming.getOutputStream();

            Scanner ins = new Scanner(in);

            // new PrintWriter(out, true);

            while (ins.hasNext())
            {
                System.out.println(Thread.currentThread() + "============" + ins.nextLine());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}