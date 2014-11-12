package cn.newtouch.framework.context;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//将request与response存储起来保证线程安全以供action实现类使用
public class ActionContext
{
    private static ThreadLocal<BaseContext> context = new ThreadLocal<BaseContext>();

    public static void setContext(ServletRequest request, ServletResponse response)
    {
        BaseContext baseContext = new BaseContext(request, response);
        context.set(baseContext);
    }

    public static HttpServletRequest getRequest()
    {
        return (HttpServletRequest) context.get().getRequest();
    }

    public static HttpServletResponse getResponse()
    {
        return (HttpServletResponse) context.get().getResponse();
    }
}