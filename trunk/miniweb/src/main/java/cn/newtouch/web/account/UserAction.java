package cn.newtouch.web.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.dao.HibernateUtils;
import cn.newtouch.entity.account.Role;
import cn.newtouch.entity.account.User;
import cn.newtouch.service.ServiceException;
import cn.newtouch.service.account.AccountManager;
import cn.newtouch.util.orm.Page;
import cn.newtouch.util.orm.PropertyFilter;
import cn.newtouch.util.utils.web.struts2.Struts2Utils;
import cn.newtouch.web.CrudActionSupport;

/**
 * 用户管理Action.
 * 
 * 使用Struts2 convention-plugin annotation定义Action参数. 演示带分页的管理界面.
 * 
 * @author calvin
 */
// 定义URL映射对应/account/user.action
@Namespace("/account")
// 定义名为reload的result重定向到user.action, 其他result则按照convention默认.
@Results({ @Result(name = CrudActionSupport.RELOAD, location = "user.action", type = "redirect") })
public class UserAction extends CrudActionSupport<User>
{

    private static final long serialVersionUID = 8683878162525847072L;

    private AccountManager    accountManager;

    // -- 页面属性 --//
    private Long              id;

    private User              entity;

    private Page<User>        page             = new Page<User>(5);   // 每页5条记录

    private List<Long>        checkedRoleIds;                         // 页面中钩选的角色id列表

    // -- ModelDriven 与 Preparable函数 --//
    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public User getModel()
    {
        return this.entity;
    }

    @Override
    protected void prepareModel() throws Exception
    {
        if (this.id != null)
        {
            this.entity = this.accountManager.getUser(this.id);
        }
        else
        {
            this.entity = new User();
        }
    }

    // -- CRUD Action 函数 --//
    @Override
    public String list() throws Exception
    {
        List<PropertyFilter> filters = PropertyFilter
                .buildFromHttpRequest(Struts2Utils.getRequest());
        // 设置默认排序方式
        if (!this.page.isOrderBySetted())
        {
            this.page.setOrderBy("id");
            this.page.setOrder(Page.ASC);
        }
        this.page = this.accountManager.searchUser(this.page, filters);
        return SUCCESS;
    }

    @Override
    public String input() throws Exception
    {
        this.checkedRoleIds = this.entity.getRoleIds();
        return INPUT;
    }

    @Override
    public String save() throws Exception
    {
        // 根据页面上的checkbox选择 整合User的Roles Set
        HibernateUtils.mergeByCheckedIds(this.entity.getRoleList(),
                this.checkedRoleIds, Role.class);

        this.accountManager.saveUser(this.entity);
        this.addActionMessage("保存用户成功");
        return RELOAD;
    }

    @Override
    public String delete() throws Exception
    {
        try
        {
            this.accountManager.deleteUser(this.id);
            this.addActionMessage("删除用户成功");
        }
        catch (ServiceException e)
        {
            this.logger.error(e.getMessage(), e);
            this.addActionMessage("删除用户失败");
        }
        return RELOAD;
    }

    // -- 其他Action函数 --//
    /**
     * 支持使用Jquery.validate Ajax检验用户名是否重复.
     */
    public String checkLoginName()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String newLoginName = request.getParameter("loginName");
        String oldLoginName = request.getParameter("oldLoginName");

        if (this.accountManager.isLoginNameUnique(newLoginName, oldLoginName))
        {
            Struts2Utils.renderText("true");
        }
        else
        {
            Struts2Utils.renderText("false");
        }
        // 因为直接输出内容而不经过jsp,因此返回null.
        return null;
    }

    // -- 页面属性访问函数 --//
    /**
     * list页面显示用户分页列表.
     */
    public Page<User> getPage()
    {
        return this.page;
    }

    /**
     * input页面显示所有角色列表.
     */
    public List<Role> getAllRoleList()
    {
        return this.accountManager.getAllRole();
    }

    /**
     * input页面显示用户拥有的角色.
     */
    public List<Long> getCheckedRoleIds()
    {
        return this.checkedRoleIds;
    }

    /**
     * input页面提交用户拥有的角色.
     */
    public void setCheckedRoleIds(List<Long> checkedRoleIds)
    {
        this.checkedRoleIds = checkedRoleIds;
    }

    @Autowired
    public void setAccountManager(AccountManager accountManager)
    {
        this.accountManager = accountManager;
    }
}
