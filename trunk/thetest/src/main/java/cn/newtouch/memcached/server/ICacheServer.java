package cn.newtouch.memcached.server;

/**
 * 缓存
 * 
 * @author hezhengzheng
 * @version 1.0
 * @since 2014年5月5日
 */
public interface ICacheServer<K, V>
{

    /**
     * 保存cache
     * 
     * @since 2014年5月5日
     * @author hezhengzheng
     * @param key 键
     * @param value 值
     * @return 返回是否保存成功
     */
    public boolean save(K key, V value);

    /**
     * 获取cache
     * 
     * @since 2014年5月5日
     * @author hezhengzheng
     * @param key 键
     * @return 值
     */
    public V get(K key);

    /**
     * 删除cache
     * 
     * @since 2014年5月5日
     * @author hezhengzheng
     * @param key 键
     * @return
     */
    public boolean delete(K key);

    /**
     * 清除cache
     * 
     * @since 2014年5月27日
     * @author hezhengzheng
     */
    public boolean clear();
}