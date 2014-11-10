package cn.newtouch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    public FirstServlet()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        if (userName.equals("hzz") && passWord.equals("123456"))
        {
            request.setAttribute("userName", userName);
            request.setAttribute("passWord", passWord);
            RequestDispatcher aaa = request.getRequestDispatcher("/jsp/ok.jsp");
            aaa.forward(request, response);
            // response.sendRedirect("../jsp/ok.jsp");
        }
        else
        {
            response.sendRedirect("./index.jsp");
        }

        /*
         * PrintWriter out=response.getWriter() ; out.println("<html>");
         * out.println
         * ("<head><title>This is my first Servlet...</title></head>");
         * out.println("<body><h1>Hello World!</h1></body>");
         * out.println("</html>"); out.flush();
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        this.doGet(request, response);
        response.setContentType("text/html");
    }
}