package cn.newtouch.framework.mappger;

public class ParamMapper extends BaseMapper
{
    private int      index;

    private Class<?> type;

    private Object   value;

    private boolean  required;

    public int getIndex()
    {
        return this.index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public Class<?> getType()
    {
        return this.type;
    }

    public void setType(Class<?> type)
    {
        this.type = type;
    }

    public Object getValue()
    {
        return this.value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public boolean isRequired()
    {
        return this.required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }
}