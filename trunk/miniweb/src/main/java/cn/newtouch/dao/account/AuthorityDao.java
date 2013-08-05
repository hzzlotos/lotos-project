package cn.newtouch.dao.account;

import org.springframework.stereotype.Component;

import cn.newtouch.entity.account.Authority;
import cn.newtouch.util.orm.hibernate.HibernateDao;

/**
 * 授权对象的泛型DAO.
 * 
 * @author calvin
 */
@Component
public class AuthorityDao extends HibernateDao<Authority, Long>
{
}
