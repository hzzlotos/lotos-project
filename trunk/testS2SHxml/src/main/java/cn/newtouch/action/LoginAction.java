package cn.newtouch.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.newtouch.Util.LabelValue;
import cn.newtouch.Util.PropertyUtils;
import cn.newtouch.Util.URLUtils;
import cn.newtouch.model.User;
import cn.newtouch.service.BookService;
import cn.newtouch.service.UserManager;
import cn.newtouch.vo.UserBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserBean>
{

    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private UserBean          bean             = new UserBean();

    private List<LabelValue>  books            = new ArrayList<LabelValue>();

    private List<User>        users            = new ArrayList<User>();

    private int               size;

    private BookService       bookService;

    private UserManager       userManager;

    public UserManager getUserManager()
    {
        return userManager;
    }

    public void setUserManager(UserManager userManager)
    {
        this.userManager = userManager;
    }

    public BookService getBookService()
    {
        return bookService;
    }

    public void setBookService(BookService bookService)
    {
        this.bookService = bookService;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public List<LabelValue> getBooks()
    {

        return books;
    }

    public void setBooks(List<LabelValue> books)
    {

        this.books = books;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public UserBean getBean()
    {

        return bean;
    }

    public void setBean(UserBean bean)
    {

        this.bean = bean;
    }

    // private String userName;
    //
    // private String passWord;
    //
    // public String getPassWord()
    // {
    // return passWord;
    // }
    //
    // public void setPassWord(String passWord)
    // {
    // this.passWord = passWord;
    // }
    //
    // public String getUserName()
    // {
    // return userName;
    // }
    //
    // public void setUserName(String userName)
    // {
    // this.userName = userName;
    // }

    @Override
    public String execute()
    {

        System.out.println("======RealPath======"
                + ServletActionContext.getServletContext().getRealPath("")
                + "============");

        System.out.println("=====super.getText======"
                + super.getText("welcome") + "=============");

        String name = null;

        name = PropertyUtils.getPropertyWithConfigName("windows.properties",
                "aaaa", "123123");

        // try
        // {
        // configuration = new PropertiesConfiguration("windows.properties");
        // name = configuration.getString("aaaa");
        // }
        // catch (ConfigurationException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        System.out.println("====Propertie======" + name + "=================");

        if ("hzz".equals(bean.getUserName())
                && "asd".equals(bean.getPassWord()))
        {
        	HttpServletRequest request = ServletActionContext.getRequest();
        	System.out.println("DomainName==="+URLUtils.getDomainName(request));
        	System.out.println("RealURL==="+URLUtils.getRealURL(request));
            // ApplicationContext app = WebApplicationContextUtils
            // .getWebApplicationContext(ServletActionContext
            // .getServletContext()); // 获取spring上下文！
            // BookService bookService = (BookService)
            // app.getBean("bookService");
            // System.out.println("====bookService======" +
            // bookService.hashCode()
            // + "=================");

            ActionContext.getContext().getSession().put("userName",
                    bean.getUserName() + "Session");

            books.addAll(bookService.getBooks());

            size = books.size();

            User user = new User();
            user.setId(12321312);
            user.setName("asdasd");
            userManager.insertUser(user);
            users = userManager.getAll();

            return "info";

        }
        else
        {

            return ERROR;
        }
    }

    public String test()
    {

        ActionContext.getContext().getSession().put("userName", "kasousou");

        ActionContext.getContext().put("login", "login");

        return LOGIN;
    }

    // public void validate() {
    //		
    // if ( null == getUserName() || "".equals(getUserName().trim())) {
    //			
    // addFieldError("userName", getText("userName")+" is required.");
    // }
    //
    // if ( null == getPassWord() || "".equals(getPassWord().trim())) {
    //			
    // addFieldError("passWord", "PassWord is required.");
    // }
    // }

    public UserBean getModel()
    {
        return bean;
    }
}