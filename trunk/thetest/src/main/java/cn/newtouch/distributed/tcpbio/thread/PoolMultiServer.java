package cn.newtouch.distributed.tcpbio.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PoolMultiServer
{
    // private int maxConnections; // 最大连接数
    //
    // private int listenerPort; // 监听端口号
    //
    // private ServerSocket serverSocket;

    public PoolMultiServer(int maxConnections, int listenerPort)
    {
        for (int i = 0; i < maxConnections; i++)
        {
            ConnectionPoolHandler connectionPoolHandler = new ConnectionPoolHandler("处理器" + i);
            new Thread(connectionPoolHandler, "处理器" + i).start();
        }

        try
        {
            ServerSocket serverSocket = new ServerSocket(listenerPort, maxConnections);
            while (true)
            {
                Socket socket = serverSocket.accept();
                ConnectionPoolHandler.processRequest(socket);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new PoolMultiServer(5, 9999);
    }
}