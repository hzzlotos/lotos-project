package cn.newtouch.struts2.user.action;

import cn.newtouch.struts2.user.vo.UserVO;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private int               type;

    private int               t;

    public int getT()
    {
        return t;
    }

    public void setT(int t)
    {
        this.t = t;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    private UserVO userVO;

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String global() throws Exception
    {
        if (type == 1)
        {
            return "global";
        }
        else
            if (type == 2)
            {
                return "error";
            }
            else
            {
                return "mainpage";
            }
    }

    public String add()
    {
        // HttpServletRequest request = ServletActionContext.getRequest();
        if (null != userVO)
        {
            System.out.println("userVO.name=" + userVO.getName());
        }
        this.addActionMessage("嘿嘿嘿!");
        System.out.println("=============================");
        System.out.println("name=" + name);
        return SUCCESS;
    }

    public UserVO getUserVO()
    {
        return userVO;
    }

    public void setUserVO(UserVO userVO)
    {
        this.userVO = userVO;
    }
}