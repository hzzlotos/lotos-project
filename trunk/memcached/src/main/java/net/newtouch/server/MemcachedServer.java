package net.newtouch.server;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedServer implements CacheServer<String, Object>
{
    private static MemcachedServer memcachedServer;

    private static MemcachedClient memcachedClient;

    private MemcachedServer()
    {
    }

    public static CacheServer initServer() throws Exception
    {
        if (null == memcachedServer)
        {
            memcachedServer = new MemcachedServer();

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
                // 开启10根池连接
                builder.setConnectionPoolSize(10);

                memcachedClient = builder.build();
            }
        }
        return memcachedServer;
    }

    @Override
    public boolean save(String key, Object value)
    {
        try
        {
            long cas = 0;
            GetsResponse<Integer> result = this.memcachedClient.gets(key);
            if (null != result)
            {
                cas = result.getCas();
            }
            return this.memcachedClient.cas(key, 0, value, cas);
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
            // System.out.println(this.memcachedClient.gets(key).getCas());
            return this.memcachedClient.get(key);
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
            this.memcachedClient.delete(key);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

}