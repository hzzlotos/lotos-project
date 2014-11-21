package javacore.net.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class talkserver
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket server = new ServerSocket(4700);
            Socket socket = server.accept();

            InputStream in = socket.getInputStream();

            Scanner ins = new Scanner(in);
            while (ins.hasNext())
            {
                String line = ins.nextLine();
                if (line.equals("bye"))
                {
                    break;
                }
                System.out.println("client->server" + line);
            }
            ins.close();
            in.close();
            socket.close();
            server.close();
            System.out.println("i'm out");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
