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
}
