package cn.newtouch.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.entity.Role;
import cn.newtouch.entity.SubjectPool;
import cn.newtouch.entity.User;
import cn.newtouch.entity.UserRole;
import cn.newtouch.service.RoleService;
import cn.newtouch.service.SubjectPoolService;
import cn.newtouch.service.UserService;
import cn.newtouch.util.Struts2Utils;
import cn.newtouch.util.hibernate.Page;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/user")
@Results( { @Result(name = "reload", location = "user.action?subId=${subId}", type = "redirect") })
public class UserAction extends ActionSupport
{

    private static final long  serialVersionUID = 1L;

    private Page<User>         page             = new Page<User>(
                                                        Page.DEFAULT_PAGESIZE_10);

    private UserService        userService;

    private RoleService        roleService;

    private SubjectPoolService subjectPoolService;

    private List<Role>         roles;

    private List<SubjectPool>  subjectPools;

    private Long               roleId;

    private Long               id;

    private Long               subId;

    private User               user;

    @Override
    public String execute() throws Exception
    {
        if (!page.isOrderBySetted())
        {
            page.setOrderBy("id");
            page.setOrder(Page.ASC);
        }
        page = userService.findBySubjectPoolId(page, subId);
        return SUCCESS;
    }

    @Override
    public String input()
    {
        roles = roleService.getAll("level", false);
        subjectPools = subjectPoolService.getAll("id", false);
        if (id != null && id != 0)
        {
            user = userService.get(id);
        }
        else
        {
            user = new User();
        }
        return INPUT;
    }

    public String save()
    {
        roleService.get(roleId);
        List<UserRole> other = user.getRoleOtherBySubPoolId(0);
        user.setRoles(other);
        if (user.getId() == null)
        {
            user.setCreateTime(new Date());
        }
        userService.save(user);
        return "reload";
    }

    /**
     * 支持使用Jquery.validate Ajax检验用户名是否重复.
     */
    public String checkLoginName()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String newLoginName = request.getParameter("user.username");
        String oldLoginName = request.getParameter("oldUsername");

        if (userService.isLoginNameUnique(newLoginName, oldLoginName))
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

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService)
    {
        this.roleService = roleService;
    }

    @Autowired
    public void setSubjectPoolService(SubjectPoolService subjectPoolService)
    {
        this.subjectPoolService = subjectPoolService;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Page<User> getPage()
    {
        return page;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<SubjectPool> getSubjectPools()
    {
        return subjectPools;
    }

    public void setSubjectPools(List<SubjectPool> subjectPools)
    {
        this.subjectPools = subjectPools;
    }

    public void setPage(Page<User> page)
    {
        this.page = page;
    }

    public Long getSubId()
    {
        return subId;
    }

    public void setSubId(Long subId)
    {
        this.subId = subId;
    }
}