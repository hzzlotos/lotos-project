package cn.newtouch.mappger;

import java.util.Set;

public class ActionMapper extends BaseMapper
{
    private Class<?>          clazz;

    private Set<MethodMapper> methodSets;

    public ActionMapper(String name, Class<?> clazz)
    {
        this.name = name;
        this.clazz = clazz;
    }

    public Class<?> getClazz()
    {
        return this.clazz;
    }

    public void setClazz(Class<?> clazz)
    {
        this.clazz = clazz;
    }

    public Set<MethodMapper> getMethodSets()
    {
        return this.methodSets;
    }

    public void setMethodSets(Set<MethodMapper> methodSets)
    {
        this.methodSets = methodSets;
    }
}