package cn.newtouch.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public DownloadServlet()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        try
        {
            String downFilename = request.getParameter("filename");
            String filepath = request.getParameter("path");
            response.setContentType("text/plain");
            response.setHeader("Location", downFilename);
            response.setHeader("Content-Disposition", "attachment; filename=" + downFilename);
            OutputStream out = response.getOutputStream();
            InputStream in = new FileInputStream(filepath + downFilename);
            byte[] buffer = new byte[1024];
            int i = -1;
            while ((i = in.read(buffer)) != -1)
            {
                out.write(buffer, 0, i);
            }
            in.close();
            out.close();
        }
        catch (Exception e)
        {
            System.out.println("系统错误，请及时与管理员联系");
        }
    }

}
