package com.hnmmli.net.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EmailTest
{
    private static Scanner     in;

    private static PrintWriter out;

    public static void main(String[] args)
    {
        try
        {
            Socket s = new Socket("mail.hnml.com", 25);

            s.getInputStream();
            s.getOutputStream();

            String hostName = InetAddress.getLocalHost().getHostName();

            send("HELO " + hostName);
            send("MAIL FROM: <" + "" + ">");
            send("RCPT TO: <" + "" + ">");
            send("DATA");
            send(".");
            s.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void send(String s) throws IOException
    {
        out.print(s.replaceAll("\n", "\r\n"));
        out.print("\r\n");
        out.flush();
    }
}