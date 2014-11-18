package cn.newtouch.context;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BaseContext
{
    private ServletRequest      request;

    private ServletResponse     response;

    private Map<String, Object> params;

    public BaseContext(ServletRequest request, ServletResponse response)
    {
        this.request = request;
        this.response = response;
    }

    public ServletRequest getRequest()
    {
        return this.request;
    }

    public void setRequest(ServletRequest request)
    {
        this.request = request;
    }

    public ServletResponse getResponse()
    {
        return this.response;
    }

    public void setResponse(ServletResponse response)
    {
        this.response = response;
    }

    public Map<String, Object> getParams()
    {
        return this.params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

}