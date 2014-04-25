package net.newtouch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemCachedClientTest
{
    // 创建全局的唯一实例
    protected static MemCachedClient mcc       = new MemCachedClient();

    protected static MemCachedClientTest   memCached = new MemCachedClientTest();

    // 设置与缓存服务器的连接池
    static
    {
        // 服务器列表和其权重
        String[] servers = { "127.0.0.1:11211" };
        Integer[] weights = { 3 };

        // 获取socke连接池的实例对象
        SockIOPool pool = SockIOPool.getInstance();

        // 设置服务器信息
        pool.setServers(servers);
        pool.setWeights(weights);

        // 设置初始连接数、最小和最大连接数以及最大处理时间
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000 * 60 * 60 * 6);

        // 设置主线程的睡眠时间
        pool.setMaintSleep(30);

        // 设置TCP的参数，连接超时等
        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);

        // 初始化连接池
        pool.initialize();
    }

    /**
     * 保护型构造方法，不允许实例化！
     * 
     */
    protected MemCachedClientTest()
    {

    }

    /**
     * 获取唯一实例.
     * 
     * @return
     */
    public static MemCachedClientTest getInstance()
    {
        return memCached;
    }

    /**
     * 添加一个指定的值到缓存中.
     * 
     * @param key
     * @param value
     * @return
     */
    public boolean add(String key, Object value)
    {
        return mcc.add(key, value);
    }

    public boolean add(String key, Object value, Date expiry)
    {
        return mcc.add(key, value, expiry);
    }

    public boolean replace(String key, Object value)
    {
        return mcc.replace(key, value);
    }

    public boolean replace(String key, Object value, Date expiry)
    {
        return mcc.replace(key, value, expiry);
    }

    /**
     * 根据指定的关键字获取对象.
     * 
     * @param key
     * @return
     */
    public Object get(String key)
    {
        return mcc.get(key);
    }

    public static void main(String[] args)
    {
        MemCachedClientTest cache = MemCachedClientTest.getInstance();
        cache.add("hello0", 1);
        cache.add("hello1", 2);
        cache.add("hello2", 3);
        cache.add("hello3", 4);
        cache.add("hello4", 5);
        getAllKeys();// ??? 嘛玩意嘛
    }

    /**
     * 
     * 获取某台memcached的所有key
     * 
     * @param memcachedNo
     * @return
     */
    public static List<String> getAllKeys()
    {
        List<String> list = new ArrayList<String>();

        Map<String, Map<String, String>> items = mcc.statsItems();
        for (String itemKey : items.keySet())
        {

            System.out.println("----------------------------");
            System.out.println("items:" + itemKey);// items:127.0.0.1:11211
            System.out.println("============================");

            Map<String, String> maps = items.get(itemKey);
            for (String mapsKey : maps.keySet())
            {
                String mapsValue = maps.get(mapsKey);

                System.out.println("----------------------------");
                System.out.println("maps:" + mapsKey);// items:15:number
                System.out.println("maps:" + mapsValue);// 50
                System.out.println("============================");

                if (mapsKey.endsWith("number"))
                {// memcached key 类型 item_str:integer:number_str
                    String[] arr = mapsKey.split(":");
                    int slabNumber = Integer.valueOf(arr[1].trim());
                    int limit = Integer.valueOf(mapsValue.trim());

                    Map<String, Map<String, String>> dumpMaps = mcc.statsCacheDump(slabNumber, limit);
                    for (String dumpKey : dumpMaps.keySet())
                    {

                        System.out.println("----------------------------");
                        System.out.println("dumpMaps:" + dumpKey);// 127.0.0.1:11211
                        System.out.println("============================");

                        Map<String, String> allMap = dumpMaps.get(dumpKey);
                        for (String allKey : allMap.keySet())
                        {
                            list.add(allKey.trim());
                        }
                    }
                }
            }
        }
        return list;
    }
}