package cn.newtouch.level;

public class KeyValue<K, V>
{
    private K key;

    private V value;

    public KeyValue()
    {
    }

    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return this.key;
    }

    public V getValue()
    {
        return this.value;
    }

    public void setKey(K key)
    {
        this.key = key;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (null == obj)
        {
            return false;
        }
        if (!(obj instanceof KeyValue))
        {
            return false;
        }
        if (!this.key.equals(((KeyValue) obj).getKey()))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        return this.key.hashCode();
    }
}
