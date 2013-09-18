package cn.newtouch.userSSimpl;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import cn.newtouch.constant.Constants;
import cn.newtouch.entity.User;
import cn.newtouch.service.UserService;

public class UserSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
    protected final Log  logger       = LogFactory.getLog(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private Properties   customTargetUrl;

    private UserService  userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException
    {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findUserByUserName(userDetails.getUsername());
        request.getSession().setAttribute("loginUser", user);
        String roleName = "";
        if (!user.isSuper())
        {
            long subPoolId = Long.valueOf(request.getSession().getAttribute(
                    "subjectPoolId").toString());
            roleName = user.getRoleTypeNameBySubPoolId(subPoolId);
        }
        else
        {
            roleName = Constants.LEVEL_SYSTEM_STRING;
        }
        getRedirectStrategy().sendRedirect(request, response,
                customTargetUrl.getProperty(roleName));
        return;

    }

    public void setRequestCache(RequestCache requestCache)
    {
        this.requestCache = requestCache;
    }

    public Properties getCustomTargetUrl()
    {
        return customTargetUrl;
    }

    public void setCustomTargetUrl(Properties customTargetUrl)
    {
        this.customTargetUrl = customTargetUrl;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
}
