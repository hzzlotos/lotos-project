package cn.newtouch.proxy.generics;

public abstract class Generics<K, V>
{
    public void test(K k)
    {
        System.out.println(k.getClass().toString());
    }

    public V init()
    {
        try
        {
            return this.getTheClass().newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    protected abstract Class<V> getTheClass();
}
