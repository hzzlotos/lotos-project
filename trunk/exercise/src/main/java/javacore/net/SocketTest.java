package javacore.net;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest
{
    public static void main(String[] args)
    {
        Socket s = null;
        try
        {
            InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
            byte[] addressBytes = address.getAddress();
            System.out.println("--------------------------");
            for (byte b : addressBytes)
            {
                System.out.println(b);
            }
            System.out.println("--------------------------");
            InetAddress[] ias = address.getAllByName("time-A.timefreq.bldrdoc.gov");
            System.out.println("=========================================");
            for (InetAddress ia : ias)
            {
                System.out.println(ia.getHostName());
            }
            System.out.println("=========================================");
            System.out.println("*****************************" + InetAddress.getLocalHost());

            s = new Socket();
            s.connect(new InetSocketAddress(address, 13), 10000);
            // s.setSoTimeout(20000);
            System.out.println("==============" + s.isClosed());
            System.out.println("==============" + s.isConnected());

            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                s.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
