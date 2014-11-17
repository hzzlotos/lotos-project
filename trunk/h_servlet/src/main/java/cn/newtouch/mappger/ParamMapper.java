package cn.newtouch.mappger;

public class ParamMapper extends BaseMapper
{
    private int      index;

    private Class<?> classType;

    private Class<?> AnnoType;

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

    public Class<?> getClassType()
    {
        return this.classType;
    }

    public void setClassType(Class<?> classType)
    {
        this.classType = classType;
    }

    public Class<?> getAnnoType()
    {
        return this.AnnoType;
    }

    public void setAnnoType(Class<?> annoType)
    {
        this.AnnoType = annoType;
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