package cn.newtouch.session.Check;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSubmitServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (null == session)
        {
            out.println("验证码异常!");
            return;
        }

        String savedCode = (String) session.getAttribute("checkCode");

        if (null == savedCode)
        {
            out.println("验证码异常!");
            return;
        }

        String checkCode = request.getParameter("checkCode");

        if (null == checkCode || !savedCode.equals(checkCode))
        {

            out.println("验证码不正确!");
            return;
        }

        session.removeAttribute("checkCode");
        out.println("验证码正确!");
    }
}