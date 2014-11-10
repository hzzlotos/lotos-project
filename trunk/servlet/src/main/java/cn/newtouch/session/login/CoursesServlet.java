package cn.newtouch.session.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CoursesServlet extends HttpServlet
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

        String sessionName = (String) session.getAttribute("name");

        if (null == sessionName)
        {

            response.sendRedirect("index.jsp");

            return;

        }

        String courseSelect = request.getParameter("course");

        if (null != courseSelect)
        {

            Vector<String> vCourses = (Vector<String>) session.getAttribute("courses");

            if (null == vCourses)
            {

                vCourses = new Vector<String>();

                vCourses.add(courseSelect);

                session.setAttribute("courses", vCourses);

            }
            else
            {

                if (vCourses.contains(courseSelect))
                {

                    out.println(sessionName + ", 你已经选择过" + courseSelect + "<hr />");

                }
                else
                {

                    vCourses.add(courseSelect);
                }
            }
        }

        String[] courses = { "c", "c++", "vc++", "java" };

        out.println(sessionName + ", 请选择你要选修的课程: <br />");

        for (String course : courses)
        {

            out.println(course + "&nbsp;&nbsp;&nbsp;&nbsp;<a href='./coursesservlet?course="
                    + URLEncoder.encode(course, "UTF-8") + "'>选修</a><br>");
        }

        out.println("<hr />");

        Vector vCourses = (Vector) session.getAttribute("courses");

        out.println(sessionName + ", 你已经选择了以下课程: <br />");

        if (null != vCourses)
        {

            for (Enumeration e = vCourses.elements(); e.hasMoreElements();)
            {

                out.println((String) e.nextElement() + "<br />");
            }
        }
    }
}