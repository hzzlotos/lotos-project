package com.hnmmli.net.server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(6666);
        while (true)
        {
            Socket s = ss.accept();
            System.out.println("a client connect!");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());// 阻塞式的
            dis.close();
            s.close();
        }

    }
}