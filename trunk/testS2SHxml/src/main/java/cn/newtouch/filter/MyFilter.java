package cn.newtouch.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter
{
    private ServletContext context;

    public void destroy()
    {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        httpRequest.getSession().setAttribute("trialid", "1123131");

        System.out
                .println("==============doFilterdoFilterdoFilter=================");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
        context = filterConfig.getServletContext();
    }

}
