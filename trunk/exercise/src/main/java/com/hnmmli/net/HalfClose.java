package com.hnmmli.net;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HalfClose
{

    public static void main(String[] args)
    {
        try
        {
            ServerSocket ss = new ServerSocket(8189);
            Socket socket = ss.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(".....");
            writer.flush();
            socket.shutdownOutput();
            String line = in.nextLine();
            while (null != line && !"".equals(line) && !"bye".equals(line))
            {
                System.out.println(line);
                line = in.nextLine();
            }
            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
