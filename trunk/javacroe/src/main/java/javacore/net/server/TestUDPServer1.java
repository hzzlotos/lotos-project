package javacore.net.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer1
{
    public static void main(String args[]) throws Exception
    {
        byte buf[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        DatagramSocket ds = new DatagramSocket(234);
        while (true)
        {
            ds.receive(dp);
            System.out.println(new String(buf, 0, dp.getLength()));
        }
    }
}