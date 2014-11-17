package cn.newtouch.action;

import cn.newtouch.annotation.Path;

public class BaseAction
{
    @Path
    public String defaultPath()
    {
        return "redirect:";
    }
}