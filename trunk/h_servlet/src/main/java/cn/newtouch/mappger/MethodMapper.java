package cn.newtouch.mappger;

import java.lang.reflect.Method;
import java.util.List;

import cn.newtouch.annotation.Path;

public class MethodMapper extends BaseMapper
{
    private Method            method;

    private Path.PATH_TYPE    type;

    private List<ParamMapper> params;

    public List<ParamMapper> getParams()
    {
        return this.params;
    }

    public void setParams(List<ParamMapper> params)
    {
        this.params = params;
    }

    public MethodMapper(String name, Method method, Path.PATH_TYPE type, List<ParamMapper> params)
    {
        this.name = name;
        this.method = method;
        this.type = type;
        this.params = params;
    }

    public Method getMethod()
    {
        return this.method;
    }

    public void setMethod(Method method)
    {
        this.method = method;
    }

    public Path.PATH_TYPE getType()
    {
        return this.type;
    }

    public void setType(Path.PATH_TYPE type)
    {
        this.type = type;
    }
}