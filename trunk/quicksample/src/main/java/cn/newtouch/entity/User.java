package cn.newtouch.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "qs_user")
public class User extends IdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private Attach            attach;

    private int               auth;

    private String            loginName;

    private String            name;

    private String            password;

    private String            plainPassword;

    private Date              registerDate;

    private int               role;

    private String            salt;

    public User()
    {
    }

    public User(Long id)
    {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id")
    public Attach getAttach()
    {
        return attach;
    }

    public int getAuth()
    {
        return auth;
    }

    @NotBlank
    @Column(name = "login_name")
    public String getLoginName()
    {
        return loginName;
    }

    @NotBlank
    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    // 不持久化到数据库，也不显示在Restful接口的属性.
    @Transient
    @JsonIgnore
    public String getPlainPassword()
    {
        return plainPassword;
    }

    // 设定JSON序列化时的日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @Column(name = "register_date")
    public Date getRegisterDate()
    {
        return registerDate;
    }

    public int getRole()
    {
        return role;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setAttach(Attach attach)
    {
        this.attach = attach;
    }

    public void setAuth(int auth)
    {
        this.auth = auth;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPlainPassword(String plainPassword)
    {
        this.plainPassword = plainPassword;
    }

    public void setRegisterDate(Date registerDate)
    {
        this.registerDate = registerDate;
    }

    public void setRole(int role)
    {
        this.role = role;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}