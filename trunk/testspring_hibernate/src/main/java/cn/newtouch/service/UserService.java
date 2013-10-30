package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.newtouch.dao.LogDAO;
import cn.newtouch.dao.UserDAO;
import cn.newtouch.model.Log;
import cn.newtouch.model.User;

@Component
public class UserService extends BaseService
{
    private LogDAO  logDAO;

    private UserDAO userDAO;

    // @Transactional
    public User doAdd(User user)
    {
        this.logger.debug("========================I'm going");
        user = this.userDAO.save(user);
        Log log = new Log();
        log.setMsg(user.getName() + " saved!");
        this.logDAO.save(log);
        return user;
    }

    @Autowired
    public void setLogDAO(LogDAO logDAO)
    {
        this.logDAO = logDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }
}
