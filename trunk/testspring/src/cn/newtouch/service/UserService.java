package cn.newtouch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.newtouch.dao.UserDAO;
import cn.newtouch.model.User;

@Component
public class UserService
{
    private UserDAO userDAO;

    public void doAdd(User user)
    {
        userDAO.save(user);
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }
}
