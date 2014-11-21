package javacore.net.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class talkclient
{
    public static void main(String args[])
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 4700);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());

            String readline = sin.readLine();
            while (!readline.equals("bye"))
            {
                os.println(readline);
                os.flush();
                readline = sin.readLine();
            }
            socket.close();
            System.out.println("i'm out");
        }
        catch (Exception e)
        {
            System.out.println("Error" + e);
        }
    }
}
