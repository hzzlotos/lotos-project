package com.hnmmli.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnmmli.RecoverTicket;
import com.hnmmli.bean.Ticket;
import com.hnmmli.util.DESUtils;

public class SSOServer extends HttpServlet
{

    private static final long          serialVersionUID = 1L;

    /** 账户信息 */
    private static Map<String, String> accounts;

    /** 单点登录标记 */
    private static Map<String, Ticket> tickets;

    /** cookie名称 */
    private String                     cookieName;

    /** 是否安全协议 */
    private boolean                    secure;

    /** 密钥 */
    private String                     secretKey;

    /** ticket有效时间 */
    private int                        ticketTimeout;

    /** 回收ticket线程池 */
    private ScheduledExecutorService   schedulePool;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        accounts = new HashMap<String, String>();
        accounts.put("zhangsan", "zhangsan");
        accounts.put("lisi", "lisi");
        accounts.put("wangwu", "wangwu");

        tickets = new ConcurrentHashMap<String, Ticket>();

        this.cookieName = config.getInitParameter("cookieName");
        this.secure = Boolean.parseBoolean(config.getInitParameter("secure"));
        this.secretKey = config.getInitParameter("secretKey");
        this.ticketTimeout = Integer.parseInt(config.getInitParameter("ticketTimeout"));

        this.schedulePool = Executors.newScheduledThreadPool(1);
        this.schedulePool.scheduleAtFixedRate(new RecoverTicket(tickets), this.ticketTimeout * 60, 1, TimeUnit.MINUTES);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if ("preLogin".equals(action))
        {
            this.preLogin(request, response);
        }
        else
            if ("login".equals(action))
            {
                this.doLogin(request, response);
            }
            else
                if ("logout".equals(action))
                {
                    this.doLogout(request, response);
                }
                else
                    if ("authTicket".equals(action))
                    {
                        this.authTicket(request, response);
                    }
                    else
                    {
                        System.err.println("指令错误");
                        out.print("Action can not be empty！");
                    }
        out.close();
    }

    @Override
    public void destroy()
    {
        if (this.schedulePool != null)
        {
            this.schedulePool.shutdown();
        }
    }

    private void preLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
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
        if (ticket == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        {
            String encodedTicket = ticket.getValue();
            String decodedTicket = DESUtils.decrypt(encodedTicket, this.secretKey);
            if (tickets.containsKey(decodedTicket))
            {
                String setCookieURL = request.getParameter("setCookieURL");
                String gotoURL = request.getParameter("gotoURL");
                if (setCookieURL != null)
                {
                    response.sendRedirect(setCookieURL + "?ticket=" + encodedTicket + "&expiry=" + ticket.getMaxAge()
                            + "&gotoURL=" + gotoURL);
                }
            }
            else
            {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    private void authTicket(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        StringBuilder result = new StringBuilder("{");
        PrintWriter out = response.getWriter();
        String encodedTicket = request.getParameter("cookieName");
        if (encodedTicket == null)
        {
            result.append("\"error\":\"true\",\"errorInfo\":\"Ticket can not be empty!\"");
        }
        else
        {
            String decodedTicket = DESUtils.decrypt(encodedTicket, this.secretKey);
            if (tickets.containsKey(decodedTicket))
            {
                result.append("\"error\":\"false\",\"username\":\"").append(
                        tickets.get(decodedTicket).getUsername() + "\"");
            }
            else
            {
                result.append("\"error\":\"true\",\"errorInfo\":\"Ticket is not found!\"");
            }
        }
        result.append("}");
        out.print(result);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        StringBuilder result = new StringBuilder("{");
        PrintWriter out = response.getWriter();
        String encodedTicket = request.getParameter("cookieName");
        if (encodedTicket == null)
        {
            result.append("\"error\":\"true\",\"errorInfo\":\"Ticket can not be empty!\"");
        }
        else
        {
            String decodedTicket = DESUtils.decrypt(encodedTicket, this.secretKey);
            tickets.remove(decodedTicket);
            result.append("\"error\":\"false\"");
        }
        result.append("}");
        out.print(result);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pass = accounts.get(username);
        if (pass == null || !pass.equals(password))
        {
            request.getRequestDispatcher("login.jsp?errorInfo=username or password is wrong!").forward(request,
                    response);
        }
        else
        {
            String ticketKey = UUID.randomUUID().toString().replace("-", "");
            String encodedticketKey = DESUtils.encrypt(ticketKey, this.secretKey);

            Date now = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            cal.add(Calendar.MINUTE, this.ticketTimeout);
            Timestamp recoverTime = new Timestamp(cal.getTimeInMillis());
            Ticket ticket = new Ticket(username, now, recoverTime);

            tickets.put(ticketKey, ticket);

            String[] checks = request.getParameterValues("autoAuth");
            int expiry = -1;
            if (checks != null && "1".equals(checks[0]))
            {
                expiry = 7 * 24 * 3600;
            }
            Cookie cookie = new Cookie(this.cookieName, encodedticketKey);
            cookie.setSecure(this.secure);// 为true时用于https
            cookie.setMaxAge(expiry);
            cookie.setPath("/");
            response.addCookie(cookie);

            String setCookieURL = request.getParameter("setCookieURL");
            String gotoURL = request.getParameter("gotoURL");

            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript'>");
            out.print("document.write(\"<form id='url' method='post' action='" + setCookieURL + "'>\");");
            out.print("document.write(\"<input type='hidden' name='gotoURL' value='" + gotoURL + "' />\");");
            out.print("document.write(\"<input type='hidden' name='ticket' value='" + encodedticketKey + "' />\");");
            out.print("document.write(\"<input type='hidden' name='expiry' value='" + expiry + "' />\");");
            out.print("document.write('</form>');");
            out.print("document.getElementById('url').submit();");
            out.print("</script>");
        }
    }

}
