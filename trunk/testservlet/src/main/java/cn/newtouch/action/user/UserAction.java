package cn.newtouch.action.user;

import cn.newtouch.annotation.Path;
import cn.newtouch.annotation.Path.PATH_TYPE;

@Path("user")
public class UserAction
{
    @Path("submit1")
    public String submit1()
    {
        return "user/submit1";
    }

    @Path(value = "submit2", type = PATH_TYPE.REDIRECT)
    public String submit2()
    {
        return "user/submit1";
    }

    @Path("submit3")
    public String submit3()
    {
        return "redirect:user/submit1";
    }
}