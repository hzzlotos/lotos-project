package cn.newtouch.Topic.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient1
{
    public static void main(String args[]) throws Exception
    {
        byte[] buf = (new String("Hello")).getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length,
                new InetSocketAddress("127.0.0.1", 234));
        DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);
        ds.close();
    }
}