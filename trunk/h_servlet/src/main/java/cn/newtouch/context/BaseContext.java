package cn.newtouch.context;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BaseContext
{
    private ServletRequest  request;

    private ServletResponse response;

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
}