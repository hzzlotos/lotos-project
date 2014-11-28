package cn.newtouch.mappger;

import java.lang.reflect.Method;
import java.util.List;

import cn.newtouch.enums.Content_Type;
import cn.newtouch.enums.PATH_TYPE;

public class MethodMapper extends BaseMapper
{
    private Content_Type      contentType;

    private Method            method;

    private List<ParamMapper> params;

    private PATH_TYPE         type;

    public MethodMapper(String name, Content_Type contentType, Method method, List<ParamMapper> params, PATH_TYPE type)
    {
        this.name = name;
        this.contentType = contentType;
        this.method = method;
        this.params = params;
        this.type = type;
    }

    public Content_Type getContentType()
    {
        return this.contentType;
    }

    public Method getMethod()
    {
        return this.method;
    }

    public List<ParamMapper> getParams()
    {
        return this.params;
    }

    public PATH_TYPE getType()
    {
        return this.type;
    }

    public void setContentType(Content_Type contentType)
    {
        this.contentType = contentType;
    }

    public void setMethod(Method method)
    {
        this.method = method;
    }

    public void setParams(List<ParamMapper> params)
    {
        this.params = params;
    }

    public void setType(PATH_TYPE type)
    {
        this.type = type;
    }
}