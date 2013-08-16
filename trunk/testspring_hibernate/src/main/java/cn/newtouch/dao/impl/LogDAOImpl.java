package cn.newtouch.dao.impl;

import org.springframework.stereotype.Component;

import cn.newtouch.dao.LogDAO;
import cn.newtouch.model.Log;

@Component
public class LogDAOImpl extends SuperDAO implements LogDAO
{
    public void save(Log log)
    {
        hibernateTemplate.save(log);
        System.out.println("log saved!");
        // throw new RuntimeException("error!");
    }

}
