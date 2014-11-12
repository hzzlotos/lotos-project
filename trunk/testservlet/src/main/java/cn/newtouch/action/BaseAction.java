package cn.newtouch.action;

import cn.newtouch.framework.anno.Path;
import cn.newtouch.framework.anno.Path.PATH_TYPE;

public class BaseAction
{
    @Path(value = "aaa", type = PATH_TYPE.REDIRECT)
    public String aaa()
    {
        return "login";
    }

    protected String aaa1()
    {
        return "aaa1";
    }
}
