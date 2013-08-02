package cn.newtouch.service.account;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.User;
import cn.newtouch.repository.UserDao;
import cn.newtouch.service.BaseService;
import cn.newtouch.service.account.ShiroDbRealm.ShiroUser;
import cn.newtouch.util.security.utils.Digests;
import cn.newtouch.util.utils.Encodes;

/**
 * 用户管理类.
 * 
 * @author calvin
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService extends BaseService<User, Long>
{

    public static final int  HASH_INTERATIONS = 1024;

    private static final int SALT_SIZE        = 8;

    private static Logger    logger           = LoggerFactory
                                                      .getLogger(AccountService.class);

    private UserDao          userDao;

    public User findUserByLoginName(String loginName)
    {
        return userDao.findByLoginName(loginName);
    }

    @Transactional(readOnly = false)
    public void registerUser(User user)
    {
        entryptPassword(user);
        user.setRegisterDate(new Date());

        userDao.save(user);
    }

    @Transactional(readOnly = false)
    public void updateUser(User user)
    {
        if (StringUtils.isNotBlank(user.getPlainPassword()))
        {
            entryptPassword(user);
        }
        userDao.save(user);
    }

    /**
     * 取出Shiro中的当前用户LoginName.
     */
    private String getCurrentUserName()
    {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user)
    {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),
                salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Autowired
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    protected Class getEntityClass()
    {
        return User.class;
    }

    @Override
    protected UserDao getEntityDao()
    {
        return userDao;
    }
}
