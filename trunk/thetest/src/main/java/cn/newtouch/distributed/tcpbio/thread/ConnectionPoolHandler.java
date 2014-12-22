/**
 * 
 */
package cn.newtouch.distributed.tcpbio.thread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shyboy(chao.shen@duoguo.cn)
 * 
 */
public class ConnectionPoolHandler implements Runnable
{
    private ThreadLocal<String> name = new ThreadLocal<String>();

    public ConnectionPoolHandler(String name)
    {
        System.out.println(name);
        this.name.set(name);
    }

    private Socket       socket;

    @SuppressWarnings("unchecked")
    private static Queue pool = new LinkedList();

    @SuppressWarnings("unchecked")
    public static void processRequest(Socket socket)
    {
        synchronized (pool)
        {
            pool.add(socket);
            pool.notifyAll();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (pool)
            {
                while (pool.isEmpty())
                {
                    try
                    {
                        pool.wait();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                this.socket = (Socket) pool.poll();
            }
            try
            {
                System.out.println("----" + this.name.get());
                PrintWriter out = new PrintWriter(this.socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String line = in.readLine();
                System.out.println("文件名为===" + line);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(line));
                String value = null;
                while ((value = bufferedReader.readLine()) != null)
                {
                    System.out.println("-------------------");
                    System.out.println("文件内容为===" + value);
                    out.println(value);
                    System.out.println("-------------------");
                }
                bufferedReader.close();
                out.close();
                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}