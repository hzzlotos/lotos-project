package net.newtouch.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

public class SpymemcachedTest
{

    private static MemcachedClient client = null;

    static
    {
        try
        {
            client = new MemcachedClient(new InetSocketAddress("192.168.100.112", 11211), new InetSocketAddress(
                    "localhost", 11211));
        }
        catch (Exception ex)
        {

            ex.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception
    {

        client.set("numberss", 1800, 1);

        SpymemcachedTest testObj = new SpymemcachedTest();
        for (int i = 0; i < 10; i++)
        {
            testObj.new ThreadTest("Thread-" + (i + 1)).start();
        }
    }

    private class ThreadTest extends Thread
    {

        private MemcachedClient client = null;

        ThreadTest(String name) throws IOException
        {
            super(name);
            this.client = new MemcachedClient(new InetSocketAddress("localhost", 11211));
        }

        @Override
        public void run()
        {
            int i = 0;
            int success = 0;
            while (i < 10)
            {
                i++;
                CASValue<Object> uniqueValue = this.client.gets("numberss");
                CASResponse response = this.client.cas("numberss", uniqueValue.getCas(),
                        (Integer) uniqueValue.getValue() + 1);

                if (response.toString().equals("OK"))
                {
                    success++;
                }

                if (i == 10)
                {
                    System.out.println(Thread.currentThread().getName() + " " + i + " time " + " update oldValue : "
                            + uniqueValue.getValue() + " , result : " + response);
                }
            }

            if (success < 10)
            {
                Count.incr(10 - success);
                System.out.println("Test counter: " + Count.get());
            }
        }
    }

    public static class Count
    {
        private static int counter = 0;

        public static void incr(int x)
        {
            counter += x;
        }

        public static int get()
        {
            return counter;
        }
    }
}