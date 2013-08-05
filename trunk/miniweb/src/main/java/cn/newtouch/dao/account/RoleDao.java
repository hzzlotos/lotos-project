package cn.newtouch.dao.account;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.newtouch.entity.account.Role;
import cn.newtouch.entity.account.User;
import cn.newtouch.util.orm.hibernate.HibernateDao;

/**
 * 角色对象的泛型DAO.
 * 
 * @author calvin
 */
@Component
public class RoleDao extends HibernateDao<Role, Long>
{

    private static final String QUERY_USER_BY_ROLEID = "select u from User u left join u.roleList r where r.id=?";

    /**
     * 重载函数,因为Role中没有建立与User的关联,因此需要以较低效率的方式进行删除User与Role的多对多中间表.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void delete(Long id)
    {
        Role role = this.get(id);
        // 查询出拥有该角色的用户,并删除该用户的角色.
        List<User> users = this.createQuery(QUERY_USER_BY_ROLEID, role.getId())
                .list();
        for (User u : users)
        {
            u.getRoleList().remove(role);
        }
        super.delete(role);
    }
}
