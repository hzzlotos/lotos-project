package org.springside.examples.quickstart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 某个用户可以对某个归属地可以操作的权限(查看和修改)
 * 
 * @author zzHe
 * @version 1.0
 * @since 2013-7-25
 */
@Entity
@Table(name = "ss_user_attach_auth")
public class UserAttachAuth extends IdEntity
{
    private static final long serialVersionUID = 1L;

    private User              user;

    private Authority         auth;

    private Attach            attach;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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
    @JoinColumn(name = "auth_id")
    public Authority getAuth()
    {
        return auth;
    }

    public void setAuth(Authority auth)
    {
        this.auth = auth;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id")
    public Attach getAttach()
    {
        return attach;
    }

    public void setAttach(Attach attach)
    {
        this.attach = attach;
    }

}