package net.newtouch.memcached;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.apache.log4j.Logger;

public class XmemcachedUtils
{
    private static MemcachedClient memcachedClient;

    private static Logger          logger = Logger.getLogger(XmemcachedUtils.class);

    private static MemcachedClient getMemcachedClient() throws Exception
    {
        if (null == memcachedClient)
        {
            // Properties properties = null;
            // String addresses = properties.getProperty("").trim();
            // if (logger.isInfoEnabled())
            // {
            // logger.info("Configure Properties:[addresses = " + addresses + "]");
            // }
            // MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(addresses));

            MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
            // 使用二进制文件
            builder.setCommandFactory(new BinaryCommandFactory());
            // 使用一致性哈希算法（Consistent Hash Strategy）
            builder.setSessionLocator(new KetamaMemcachedSessionLocator());
            // 使用序列化传输编码
            builder.setTranscoder(new SerializingTranscoder());
            // 进行数据压缩，大于1KB时进行压缩
            builder.getTranscoder().setCompressionThreshold(1024);

            builder.setConnectionPoolSize(10);

            memcachedClient = builder.build();
        }
        return memcachedClient;
    }

    public static void saveValue(String key, String value) throws Exception
    {
        getMemcachedClient().set(key, 0, value);
    }

    public static boolean casValue(String key, String value) throws Exception
    {
        long cas = 0;
        GetsResponse<Integer> result = memcachedClient.gets(key);
        if (null != result)
        {
            cas = result.getCas();
        }
        return getMemcachedClient().cas(key, 0, value, cas);
    }

    public static Object getValue(String key) throws Exception
    {
        return getMemcachedClient().get(key);
    }

    public static void delete(String key) throws Exception
    {
        getMemcachedClient().delete(key);
    }

    public static void main(String[] args)
    {
        XmemcachedUtils xmemcachedTest = new XmemcachedUtils();
        // MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
        try
        {
            memcachedClient = xmemcachedTest.getMemcachedClient();
            casValue("hello", "Hello,xmemcached");
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
