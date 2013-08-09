package cn.newtouch.dao.impl;

import org.springframework.stereotype.Component;

import cn.newtouch.dao.UserDAO;
import cn.newtouch.model.User;

@Component
public class UserDAOImpl implements UserDAO
{

    public void save(User user)
    {
        // Hibernate
        // JDBC
        // XML
        // NetWork
        System.out.println("user saved!");
    }

}
