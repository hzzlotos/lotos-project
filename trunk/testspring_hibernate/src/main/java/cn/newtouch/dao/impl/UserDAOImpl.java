package cn.newtouch.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.newtouch.dao.UserDAO;
import cn.newtouch.model.User;

@Component
public class UserDAOImpl implements UserDAO
{

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void connSave(User user)
    {
        try
        {
            Connection conn = this.dataSource.getConnection();
            String sql = "insert into user values(null,'" + user.getName() + "')";
            System.out.println(sql);
            conn.createStatement().execute(sql);
            conn.close();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("user saved!");
    }

    public User hiberSave(User user)
    {
        System.out.println("session factory class:" + this.sessionFactory.getClass());
        Session s = this.sessionFactory.getCurrentSession();
        // s.beginTransaction();
        s.save(user);
        // s.getTransaction().commit();
        System.out.println("user saved!");
        return user;
        // throw new RuntimeException("exeption!");
    }

    public User save(User user)
    {
        this.hibernateTemplate.save(user);
        // throw new RuntimeException("exeption!");
        return user;
    }
}