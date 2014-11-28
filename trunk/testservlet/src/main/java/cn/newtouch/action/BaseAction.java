package cn.newtouch.action;

import com.google.gson.Gson;

public class BaseAction
{
    protected static String defaultPath = "redirect:";

    // 根据字符串输出JSON，返回null
    public String ajaxJson(Object object)
    {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}