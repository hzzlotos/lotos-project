package cn.newtouch.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class ResourceBundleMessageSource extends org.springframework.context.support.ResourceBundleMessageSource
{

    @Override
    protected ResourceBundle getResourceBundle(String basename, Locale locale)
    {
        Object obj = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        if (request.getSession() != null)
        {
            obj = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        }
        if (obj == null)
        {
            obj = locale;
        }
        return super.getResourceBundle(basename, (Locale) obj);
    }

}
