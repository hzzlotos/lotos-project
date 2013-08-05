package cn.newtouch.dao.account;

import org.springframework.stereotype.Component;

import cn.newtouch.entity.account.User;
import cn.newtouch.util.orm.hibernate.HibernateDao;

/**
 * 用户对象的泛型DAO类.
 * 
 * @author calvin
 */
@Component
public class UserDao extends HibernateDao<User, Long>
{
    // -- 统一定义所有以用户为主体的HQL --//
    private static final String COUNT_BY_LNAME_PASSWD = "select count(u) from User u where u.loginName=? and u.password=?";

    public Long countUserByLoginNamePassword(String loginName, String password)
    {
        return (Long) this.findUnique(COUNT_BY_LNAME_PASSWD, loginName,
                password);
    }

    /**
     * 初始化User的延迟加载关联roleList.
     */
    public void initUser(User user)
    {
        this.initProxyObject(user.getRoleList());
    }
}
