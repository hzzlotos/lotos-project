package cn.newtouch.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{

    @Override
    public void sessionCreated(HttpSessionEvent evt)
    {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent evt)
    {
        if (evt != null && evt.getSession() != null)
        {
            HttpSession s = evt.getSession();
            try
            {
                s.removeAttribute("userSession");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}