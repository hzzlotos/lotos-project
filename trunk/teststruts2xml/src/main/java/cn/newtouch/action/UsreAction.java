package cn.newtouch.action;

import org.apache.struts2.ServletActionContext;

import cn.newtouch.Util.RequestUtils;
import cn.newtouch.vo.UserBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UsreAction extends ActionSupport implements ModelDriven<UserBean>
{

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private UserBean          bean             = new UserBean();

    public UserBean getBean()
    {

        return bean;
    }

    public void setBean(UserBean bean)
    {

        this.bean = bean;
    }

    @Override
    public String execute() throws Exception
    {

        System.out
                .println("======================execute======================");

        System.out.println(getBean().getBirth());

        ServletActionContext.getRequest().getSession().setAttribute("userName",
                getModel().getUserName());

        if ("ka".equals(getBean().getUserName())
                && "hzz".equals(getBean().getPassWord()))
        {

            ActionContext.getContext().getSession().put("userName",
                    getModel().getUserName());

            return SUCCESS;

        }
        else
        {

            return ERROR;
        }
    }

    public String test()
    {

        System.out.println("====================test====================");

        System.out.println(getBean().getBirth());

        ActionContext.getContext().getSession().put("userName", "kasousou");

        ActionContext.getContext().put("login", "login");

        ActionContext.getContext().put("userName", "asdzxc");

        ActionContext.getContext().put("asd", bean);

        return LOGIN;
    }

    public String test1() throws Exception
    {

        String aaa = RequestUtils.getWebURL(ServletActionContext.getRequest());

        System.out.println("====================test1===================="
                + aaa);

        System.out.println(bean.getBirth());

        super.addActionMessage("hahahahahahahahahahahahahahaha!");

        super.addActionError("hahahahahahahahahahahahahahaha!");

        throw new Exception("hahaha!");

    }

    public UserBean getModel()
    {
        return bean;
    }
}