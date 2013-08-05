package cn.newtouch.service.account;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.dao.account.AuthorityDao;
import cn.newtouch.dao.account.RoleDao;
import cn.newtouch.dao.account.UserDao;
import cn.newtouch.entity.account.Authority;
import cn.newtouch.entity.account.Role;
import cn.newtouch.entity.account.User;
import cn.newtouch.service.ServiceException;
import cn.newtouch.util.orm.Page;
import cn.newtouch.util.orm.PropertyFilter;
import cn.newtouch.util.security.springsecurity.SpringSecurityUtils;

/**
 * 安全相关实体的管理类, 包括用户,角色,资源与授权类.
 * 
 * @author calvin
 */
// Spring Bean的标识.
@Component
// 默认将类中的所有函数纳入事务管理.
@Transactional
public class AccountManager
{

    private static Logger logger = LoggerFactory
                                         .getLogger(AccountManager.class);

    private UserDao       userDao;

    private RoleDao       roleDao;

    private AuthorityDao  authorityDao;

    /**
     * 获取全部用户, 并对用户的延迟加载关联进行初始化.
     */
    @Transactional(readOnly = true)
    public List<User> getAllInitedUser()
    {
        List<User> userList = this.userDao.getAll("id", true);
        for (User user : userList)
        {
            this.userDao.initUser(user);
        }
        return userList;
    }

    /**
     * 获取用户, 并对用户的延迟加载关联进行初始化.
     */
    @Transactional(readOnly = true)
    public User getInitedUser(Long id)
    {
        User user = this.userDao.get(id);
        this.userDao.initUser(user);
        return user;
    }

    /**
     * 验证用户名密码.
     * 
     * @return 验证通过时返回true.用户名或密码错误时返回false.
     */
    @Transactional(readOnly = true)
    public boolean authenticate(String loginName, String password)
    {
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password))
        {
            return false;
        }

        return (this.userDao.countUserByLoginNamePassword(loginName, password) == 1);
    }

    // -- User Manager --//
    @Transactional(readOnly = true)
    public User getUser(Long id)
    {
        return this.userDao.get(id);
    }

    public void saveUser(User entity)
    {
        this.userDao.save(entity);
    }

    /**
     * 删除用户,如果尝试删除超级管理员将抛出异常.
     */
    public void deleteUser(Long id)
    {
        if (this.isSupervisor(id))
        {
            logger.warn("操作员{}尝试删除超级管理员用户",
                    SpringSecurityUtils.getCurrentUserName());
            throw new ServiceException("不能删除超级管理员用户");
        }
        this.userDao.delete(id);
    }

    /**
     * 判断是否超级管理员.
     */
    private boolean isSupervisor(Long id)
    {
        return id == 1;
    }

    /**
     * 使用属性过滤条件查询用户.
     */
    @Transactional(readOnly = true)
    public Page<User> searchUser(final Page<User> page,
            final List<PropertyFilter> filters)
    {
        return this.userDao.findPage(page, filters);
    }

    @Transactional(readOnly = true)
    public User findUserByLoginName(String loginName)
    {
        return this.userDao.findUniqueBy("loginName", loginName);
    }

    /**
     * 检查用户名是否唯一.
     * 
     * @return loginName在数据库中唯一或等于oldLoginName时返回true.
     */
    @Transactional(readOnly = true)
    public boolean isLoginNameUnique(String newLoginName, String oldLoginName)
    {
        return this.userDao.isPropertyUnique("loginName", newLoginName,
                oldLoginName);
    }

    // -- Role Manager --//
    @Transactional(readOnly = true)
    public Role getRole(Long id)
    {
        return this.roleDao.get(id);
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRole()
    {
        return this.roleDao.getAll("id", true);
    }

    public void saveRole(Role entity)
    {
        this.roleDao.save(entity);
    }

    public void deleteRole(Long id)
    {
        this.roleDao.delete(id);
    }

    // -- Authority Manager --//
    @Transactional(readOnly = true)
    public List<Authority> getAllAuthority()
    {
        return this.authorityDao.getAll();
    }

    @Autowired
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao)
    {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setAuthorityDao(AuthorityDao authorityDao)
    {
        this.authorityDao = authorityDao;
    }

    public String testStr(String str)
    {
        logger.debug("=======|||=======" + str + "=========\\\\\\=======");
        return this.getClass().toString();
    }
}
