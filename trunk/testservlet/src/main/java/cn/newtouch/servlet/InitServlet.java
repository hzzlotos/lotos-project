package cn.newtouch.servlet;

import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public InitServlet()
    {
        super();
        System.out.println("InitServlet要初始化了");
    }
}
