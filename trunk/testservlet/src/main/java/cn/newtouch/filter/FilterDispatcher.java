package cn.newtouch.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDispatcher implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        System.out.println("我只是过滤下！");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // controller = ActionController.getInstance();
        // controller.init(exWebConfig.clone().config(filterConfig, WebConfig.ConfigType.FilterConfig));
    }

    @Override
    public void destroy()
    {
    }
}