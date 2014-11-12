package cn.newtouch.framework.mappger;

public class BaseMapper
{
    protected String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (null == obj)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        BaseMapper temp = (BaseMapper) obj;
        if (this.name.equals(temp.getName()))
        {
            return true;
        }
        return false;
    }
}