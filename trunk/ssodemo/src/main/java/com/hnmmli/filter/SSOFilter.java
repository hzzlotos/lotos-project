package com.hnmmli.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hnmmli.utils.HttpClientUtils;
import com.hnmmli.vo.SSOVO;

public class SSOFilter implements Filter
{

    private String ssoService;

    private String cookieName;

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException
    {
        this.ssoService = fConfig.getInitParameter("SSOService");
        this.cookieName = fConfig.getInitParameter("cookieName");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getContextPath();
        String gotoURL = request.getParameter("gotoURL");
        if (gotoURL == null)
        {
            gotoURL = request.getRequestURL().toString();
        }
        String URL = this.ssoService + "?action=preLogin&setCookieURL=" + request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path + "/setCookie&gotoURL=" + gotoURL;

        Cookie ticket = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals(this.cookieName))
                {
                    ticket = cookie;
                    break;
                }
            }
        }
        if (request.getRequestURI().equals(path + "/logout"))
        {
            this.doLogout(request, response, chain, ticket, URL);
        }
        else
            if (request.getRequestURI().equals(path + "/setCookie"))
            {
                this.setCookie(request, response);
            }
            else
                if (ticket != null)
                {
                    this.authCookie(request, response, chain, ticket, URL);
                }
                else
                {
                    response.sendRedirect(URL);
                }
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    private void setCookie(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Cookie ticket = new Cookie(this.cookieName, request.getParameter("ticket"));
        ticket.setPath("/");
        ticket.setMaxAge(Integer.parseInt(request.getParameter("expiry")));
        response.addCookie(ticket);

        String gotoURL = request.getParameter("gotoURL");
        if (gotoURL != null)
        {
            response.sendRedirect(gotoURL);
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Cookie ticket,
            String URL) throws IOException, ServletException
    {
        Map<String, String> params = Maps.newHashMap();
        params.put("action", "logout");
        params.put("cookieName", ticket.getValue());
        try
        {
            this.post(request, response, chain, params);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            response.sendRedirect(URL);
        }
    }

    private void authCookie(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Cookie ticket,
            String URL) throws IOException, ServletException
    {
        Map<String, String> params = Maps.newHashMap();
        params.put("action", "authTicket");
        params.put("cookieName", ticket.getValue());
        try
        {
            String result = this.post(request, response, chain, params);
            SSOVO jsonResult = JSONObject.parseObject(result, SSOVO.class);
            if (jsonResult.getError())
            {
                response.sendRedirect(URL);
            }
            else
            {
                request.setAttribute("username", jsonResult.getUsername());
                chain.doFilter(request, response);
            }
        }
        catch (Exception e)
        {
            response.sendRedirect(URL);
            throw new RuntimeException(e);
        }
    }

    private String post(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Map<String, String> params) throws Exception
    {
        return HttpClientUtils.simplePostInvoke(this.ssoService, params);
    }
}
