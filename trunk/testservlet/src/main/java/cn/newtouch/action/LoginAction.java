package cn.newtouch.action;

import cn.newtouch.annotation.Path;
import cn.newtouch.annotation.PathParam;
import cn.newtouch.annotation.RequestParam;
import cn.newtouch.context.ActionContext;

@Path("login")
public class LoginAction extends BaseAction
{
    @Path("submit/{id}")
    public String submit(@PathParam Long id, @RequestParam(paramName = "username", required = true) String userName,
            @RequestParam(paramName = "password", required = true) String passWord)
    {
        if (userName.equals("hzz") && passWord.equals("123456"))
        {
            ActionContext.getRequest().setAttribute("userName", userName);
            ActionContext.getRequest().setAttribute("passWord", passWord);
            return "login/ok";
        }
        ActionContext.getRequest().setAttribute("errorMessage", "帐户密码不正确！");
        return "index";
    }
}
