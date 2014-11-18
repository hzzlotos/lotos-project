package cn.newtouch.context;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
        baseContext.setParams(setParams((HttpServletRequest) request));
        context.set(baseContext);
    }

    public static Map<String, Object> setParams(HttpServletRequest request)
    {
        Map<String, Object> params = new HashMap<String, Object>();

        Enumeration<?> parameternames = request.getParameterNames();
        while (parameternames.hasMoreElements())
        {
            String name = (String) parameternames.nextElement();
            params.put(name, request.getParameter(name));
        }

        Enumeration<?> names = request.getAttributeNames();
        while (names.hasMoreElements())
        {
            String name = (String) names.nextElement();
            params.put(name, request.getAttribute(name));
        }

        return params;
    }

    public static String trim(String s)
    {
        return s == null ? s : s.trim();
    }

    public static HttpServletRequest getRequest()
    {
        return (HttpServletRequest) context.get().getRequest();
    }

    public static HttpServletResponse getResponse()
    {
        return (HttpServletResponse) context.get().getResponse();
    }

    public static Map<String, Object> getParams()
    {
        return context.get().getParams();
    }
}