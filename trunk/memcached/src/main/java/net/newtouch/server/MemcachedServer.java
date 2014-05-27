package net.newtouch.server;

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
    private static MemcachedServer        memcachedServer;

    private static MemcachedClientBuilder builder;

    private static Properties             properties;

    private MemcachedServer()
    {
    }

    private MemcachedClient client;

    public static ICacheServer init()
    {
        if (null == memcachedServer)
        {
            memcachedServer = new MemcachedServer();
            Properties properties = PropertiesUtil.getProperties("memcached.properties");
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
        }
        return memcachedServer;
    }

    private void getClient() throws Exception
    {
        this.client = builder.build();
    }

    private void closeClient() throws Exception
    {
        this.client.shutdown();
    }

    @Override
    public boolean save(String key, Object value)
    {
        try
        {
            this.getClient();
            long cas = 0;
            GetsResponse<Integer> casObj = this.client.gets(key);
            if (null != casObj)
            {
                cas = casObj.getCas();
            }
            boolean result = this.client.cas(key, 0, value, cas);
            this.closeClient();
            return result;
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
            Object result = this.client.get(key);
            this.closeClient();
            return result;
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
            GetsResponse<Integer> casObj = this.client.gets(key);
            if (null != casObj)
            {
                cas = casObj.getCas();
            }
            boolean result = this.client.delete(key, cas, Integer.valueOf(properties.getProperty("timeout")));
            this.closeClient();
            return result;
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
            this.client.flushAll();
            this.closeClient();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}