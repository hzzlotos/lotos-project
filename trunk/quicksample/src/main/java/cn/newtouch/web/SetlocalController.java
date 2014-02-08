package cn.newtouch.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

@Controller
@RequestMapping(value = "/setlocal")
public class SetlocalController
{

    @RequestMapping()
    @ResponseBody
    public String getAttahList(HttpServletRequest request, @RequestParam("local") String local)
    {
        String result;
        if (local == null)
        {
            result = "error";

        }
        else
        {
            WebUtils.setSessionAttribute(request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                    new Locale(local));
            result = "success";
        }
        return result;
    }
}