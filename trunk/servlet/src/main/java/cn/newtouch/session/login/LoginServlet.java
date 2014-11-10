package cn.newtouch.session.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(120);

        String sessionName = (String) session.getAttribute("name");

        RequestDispatcher rd = null;

        if (null != sessionName)
        {

            rd = request.getRequestDispatcher("coursesservlet");

            rd.forward(request, response);

            return;
        }

        String paramName = request.getParameter("name");

        if (null == paramName || paramName.trim().equals(""))
        {

            out.println("请传递用户名!<br />");

            rd = request.getRequestDispatcher("index.jsp");

            rd.include(request, response);

        }
        else
        {

            session.setAttribute("name", paramName);

            rd = request.getRequestDispatcher("coursesservlet");

            rd.forward(request, response);
        }
    }
}
