package cn.newtouch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.newtouch.util.hibernate.AutoIdEntity;

/**
 * 
 * 用色角色类
 * 
 * @author fangyong
 * @version 1.0
 * @since 2011-11-10
 */
@Entity
@Table(name = "user_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserRole extends AutoIdEntity
{
    private static final long serialVersionUID = 1L;

    private User              user;                 // 用户

    private Role              role;                 // 角色

    private SubjectPool       subjectPool;          // 科目

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "user_id")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "role_id")
    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "sub_id")
    public SubjectPool getSubjectPool()
    {
        return subjectPool;
    }

    public void setSubjectPool(SubjectPool subjectPool)
    {
        this.subjectPool = subjectPool;
    }

}
