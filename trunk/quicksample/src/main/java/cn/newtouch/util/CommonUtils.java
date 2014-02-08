package cn.newtouch.util;

import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class CommonUtils
{
    public static int getRandomNumber(int number)
    {
        if (number <= 0)
        {
            return 0;
        }
        Random random = new Random();
        return random.nextInt(number);
    }

    public static Locale getLocal()
    {
        Object obj = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        if (request.getSession() != null)
        {
            obj = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        }
        return (Locale) obj;
    }
}