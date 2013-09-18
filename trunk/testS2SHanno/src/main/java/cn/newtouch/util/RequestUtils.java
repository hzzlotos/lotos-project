package cn.newtouch.util;


import javax.servlet.http.HttpServletRequest;

public class RequestUtils
{
    public static String getWebURL(HttpServletRequest request)
    {
        StringBuffer url = new StringBuffer();
        // 端口号
        int port = request.getServerPort();
        if (port < 0)
        {
            port = 80; // Work around java.net.URL bug
        }
        //
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        // 域名
        url.append(request.getServerName());

        if ((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 8443)))
        {
            url.append(':');
            url.append(port);
        }
        // 应用名字
        url.append(request.getContextPath());
        return url.toString();
    }
}
