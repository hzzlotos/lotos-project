package cn.newtouch.util;

import java.util.Locale;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import cn.newtouch.util.utils.web.struts2.Struts2Utils;

import com.opensymphony.xwork2.ActionContext;

public class CommonUtils
{
    /**
     * MD5加密
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptMD5(String data) throws Exception
    {

        Md5PasswordEncoder encode = new Md5PasswordEncoder();
        return encode.encodePassword(data, null);
    }

    public static Locale getLocal()
    {
        Object obj = null;
        if (ActionContext.getContext() != null)
        {
            obj = Struts2Utils.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        }
        return (Locale) obj;
    }
}
