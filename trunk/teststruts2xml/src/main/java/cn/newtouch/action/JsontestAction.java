package cn.newtouch.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class JsontestAction extends ActionSupport
{
    /**
     * serialVersionUID long
     */
    private static final long   serialVersionUID = 1L;

    private String              username;

    private String              pass;

    private Map<String, String> hashMap          = new HashMap<String, String>();

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Map<String, String> getHashMap()
    {
        return hashMap;
    }

    public void setHashMap(Map<String, String> hashMap)
    {
        this.hashMap = hashMap;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    @Override
    public String execute() throws Exception
    {
        hashMap.put("name", this.getUsername());
        hashMap.put("pass", "qihuan");
        this.setPass("这是密码啊Password");
        return "jsonres";
    }
}