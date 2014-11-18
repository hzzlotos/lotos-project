package cn.newtouch.action;

import cn.newtouch.annotation.Path;
import cn.newtouch.annotation.PathParam;
import cn.newtouch.context.ActionContext;
import cn.newtouch.sesstion.UserSession;

@Path("login")
public class LoginAction extends BaseAction
{
    @Path(value = "index")
    public String login()
    {
        UserSession user = (UserSession) ActionContext.getRequest().getSession(true).getAttribute("userSession");
        if (null == user)
        {
            return "login/login";
        }
        return "login/ok";
    }

    @Path(value = "submit/{id}")
    public String submit(@PathParam Long id)
    {
        String userName = String.valueOf(ActionContext.getParams().get("username"));
        String passWord = String.valueOf(ActionContext.getParams().get("password"));
        if (userName.equals("hzz") && passWord.equals("123456"))
        {
            ActionContext.getRequest().setAttribute("userName", userName);
            ActionContext.getRequest().setAttribute("passWord", passWord);
            UserSession user = new UserSession();
            user.setUserName(userName);
            ActionContext.getRequest().getSession(true).setAttribute("userSession", user);
            String referer = ActionContext.getRequest().getHeader("Referer");
            String contextPath = ActionContext.getRequest().getContextPath();
            if (referer.endsWith(contextPath) || referer.endsWith(contextPath + "/")
                    || referer.contains("login/submit"))
            {
                return "login/ok";
            }
            return "redirect:" + referer.split(contextPath + "/")[1];
        }
        ActionContext.getRequest().setAttribute("errorMessage", "帐户密码不正确！");
        return "login/login";
    }
}