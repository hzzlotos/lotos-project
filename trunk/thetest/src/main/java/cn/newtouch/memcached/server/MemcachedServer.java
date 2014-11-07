package cn.newtouch.memcached.server;

import java.util.Properties;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedServer implements ICacheServer<String, Object>
{
    private static MemcachedServer memcachedServer;

    private static MemcachedClient client;

    private static Properties      properties;

    private MemcachedServer()
    {
    }

    private static MemcachedClientBuilder getBuilder()
    {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(properties
                .getProperty("addresses")));
        // 进行数据压缩，大于1KB时进行压缩
        builder.getTranscoder().setCompressionThreshold(
                Integer.valueOf(properties.getProperty("compression.threshold")));
        // 开启10根池连接
        builder.setConnectionPoolSize(Integer.valueOf(properties.getProperty("connection.pool.size")));

        // 使用二进制文件
        builder.setCommandFactory(new BinaryCommandFactory());
        // 使用一致性哈希算法（Consistent Hash Strategy）
        builder.setSessionLocator(new KetamaMemcachedSessionLocator());
        // 使用序列化传输编码
        builder.setTranscoder(new SerializingTranscoder());

        return builder;
    }

    public static ICacheServer init() throws Exception
    {
        if (null == memcachedServer)
        {
            memcachedServer = new MemcachedServer();
            properties = PropertiesUtil.getProperties("memcached.properties");
            client = getBuilder().build();
        }
        return memcachedServer;
    }

    private void getClient() throws Exception
    {
        if (null == client || client.isShutdown())
        {
            for (int i = 0; i < 3; i++)
            {
                client = getBuilder().build();
                if (null != client && !client.isShutdown())
                {
                    break;
                }
                Thread.sleep(60 * 1000);
            }
        }
    }

    @Override
    public boolean save(String key, Object value)
    {
        try
        {
            this.getClient();
            long cas = 0;
            GetsResponse<Integer> casObj = client.gets(key);
            if (null != casObj)
            {
                cas = casObj.getCas();
            }
            return client.cas(key, 0, value, cas);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object get(String key)
    {
        try
        {
            this.getClient();
            // System.out.println(client.gets(key).getCas());
            return client.get(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String key)
    {
        try
        {
            this.getClient();
            long cas = 0;
            GetsResponse<Integer> casObj = client.gets(key);
            if (null != casObj)
            {
                cas = casObj.getCas();
            }
            return client.delete(key, cas, Integer.valueOf(properties.getProperty("timeout")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clear()
    {
        try
        {
            this.getClient();
            client.flushAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}