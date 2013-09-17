package cn.newtouch.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub

        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        MyFirstSql sql = new MyFirstSql();
        int flag = sql.userCheck(userName, passWord);

        if (1 == flag)
        {
            request.setAttribute("userName", userName);
            request.setAttribute("passWord", passWord);
            RequestDispatcher aaa = request.getRequestDispatcher("/Jsp/ok.jsp");
            aaa.forward(request, response);
            // response.sendRedirect("../Jsp/ok.jsp");
        }
        else
        {
            response.sendRedirect("/index.html");
        }

        /*
         * PrintWriter out=response.getWriter() ; out.println("<html>");
         * out.println
         * ("<head><title>This is my first Servlet...</title></head>");
         * out.println("<body><h1>Hello World!</h1></body>");
         * out.println("</html>"); out.flush();
         */
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        // response.setContentType("text/html");

        doGet(request, response);
        response.setContentType("text/html");
    }
}