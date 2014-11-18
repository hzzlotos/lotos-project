package cn.newtouch.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import cn.newtouch.sesstion.UserSession;
import cn.newtouch.util.PropertiesUtil;

public class AuthFilter implements Filter
{
    private Set<String> exclusions;

    private String      urlExclusions = PropertiesUtil.getProperties("mvc.properties").getProperty("url_exclusions");

    @Override
    public void init(FilterConfig config) throws ServletException
    {
        if (StringUtils.isNotEmpty(this.urlExclusions))
        {
            this.exclusions = new HashSet<String>();
            this.exclusions.addAll(Arrays.asList(this.urlExclusions.split(",|/\\*,|,/\\*")));
        }
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException
    {
        // 获取应用名之后的路径
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();
        if (uri.equals(contextPath) || uri.equals(contextPath + "/"))
        {
            chain.doFilter(request, response);
            return;
        }
        uri = uri.split(httpRequest.getContextPath())[1];

        // 排除需过滤路径
        if (null != this.exclusions && !this.exclusions.isEmpty())
        {
            for (String ex : this.exclusions)
            {
                if (uri.contains(ex))
                {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        this.loginCheck(request, response, chain);
    }

    private void loginCheck(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 权限控制
        UserSession userSession = (UserSession) httpRequest.getSession(true).getAttribute("userSession");
        if (userSession == null)
        {
            httpRequest.getRequestDispatcher(
                    "/" + PropertiesUtil.getProperties("mvc.properties").getProperty("jsp_package") + "/index.jsp")
                    .forward(request, response);
        }
        else
        {
            chain.doFilter(request, response);
        }
    }
}