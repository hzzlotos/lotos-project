package cn.newtouch.action;

import cn.newtouch.framework.anno.Path;

public class BaseAction
{
    @Path
    public String defaultPath()
    {
        return "redirect:";
    }
}