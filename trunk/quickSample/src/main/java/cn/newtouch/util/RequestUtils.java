package cn.newtouch.util;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class RequestUtils
{

    public static String getAppURL(HttpServletRequest request)
    {
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0)
        {
            port = 80;
        }
        String scheme = request.getScheme();

        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());

        if ((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 8443)))
        {
            url.append(':');
            url.append(port);
        }

        url.append(request.getContextPath());
        System.out.println("================== the url is : " + url.toString());
        return url.toString();
    }

    public static String getRealPath(ServletContext servletContext, String path)
            throws FileNotFoundException
    {
        // Interpret location as relative to the web application root directory.
        if (!path.startsWith("/"))
        {
            path = "/" + path;
        }
        String realPath = servletContext.getRealPath(path);
        if (realPath == null)
        {
            throw new FileNotFoundException("ServletContext resource [" + path
                    + "] cannot be resolved to absolute file path - "
                    + "web application archive not expanded?");
        }
        return realPath;
    }
}