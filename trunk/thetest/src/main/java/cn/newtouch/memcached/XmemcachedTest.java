package cn.newtouch.memcached;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XmemcachedTest
{
    private static MemcachedClient memcachedClient;

    private static void setValue(String key, String value) throws Exception
    {
        memcachedClient.set(key, 0, value);
    }

    private static boolean casValue(String key, String value) throws Exception
    {
        GetsResponse<Integer> result = memcachedClient.gets(key);
        long cas = result.getCas();
        return memcachedClient.cas(key, 0, value, cas);
    }

    private static Object getValue(String key) throws Exception
    {
        return memcachedClient.get(key);
    }

    private static void delete(String key) throws Exception
    {
        memcachedClient.delete(key);
    }

    public static void main(String[] args)
    {
        XmemcachedTest xmemcachedTest = new XmemcachedTest();
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));

        try
        {
            memcachedClient = builder.build();
            setValue("hello", "Hello,xmemcached");
            Object value = getValue("hello");
            System.out.println("hello=" + value.toString());
            delete("hello");
            value = getValue("hello");
            if (null != value)
            {
                System.out.println("hello=" + value.toString());
            }
            else
            {
                System.out.println("is null");
            }
            System.out.println("===================================================================================");
            for (int i = 0; i < 10; i++)
            {
                xmemcachedTest.new TestTheard("key", "value" + i).start();
            }
            // memcachedClient.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static final class IncrmentOperation<T> implements CASOperation<T>
    {

        @Override
        public int getMaxTries()
        {
            return Integer.MAX_VALUE;
        }

        @Override
        public T getNewValue(long currentCAS, T currentValue)
        {
            currentCAS++;
            return currentValue;
        }
    }

    private class TestTheard extends Thread
    {
        private String key;

        private String value;

        public TestTheard(String key, String value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public void run()
        {
            try
            {
                if (casValue(this.key, this.value))
                {
                    System.out.println("this is " + this.value + "===============" + getValue("key"));
                }
            }
            catch (Exception e)
            {
                System.out.println("error: the value ======" + this.value);
                e.printStackTrace();
            }
        }

    }
}
