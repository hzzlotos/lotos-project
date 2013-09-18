package cn.newtouch.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.newtouch.constant.Constants;
import cn.newtouch.util.ConvertUtils;
import cn.newtouch.util.hibernate.AutoIdEntity;

import com.google.common.collect.Lists;

/**
 * 
 * 角色.
 * 
 * @author fangyong
 * @version 1.0
 * @since 2011-11-16
 */
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends AutoIdEntity
{
    private static final long serialVersionUID = 1L;

    private List<Authority>   authorityList    = Lists.newArrayList();

    private String            name;

    private int               level;

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public Role()
    {
        super();
    }

    public Role(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Transient
    public String getTypeName()
    {
        if (level == 1)
        {
            return Constants.LEVEL_SYSTEM_STRING;
        }
        else
            if (level == 2)
            {
                return Constants.LEVEL_SUBJECT_STRING;
            }
            else
                if (level == 3)
                {
                    return Constants.LEVEL_SPECIAL_STRING;
                }
        return null;

    }

    @Column(nullable = false, unique = true)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "role_auth", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "auth_id") })
    @OrderBy("id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Authority> getAuthorityList()
    {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList)
    {
        this.authorityList = authorityList;
    }

    @Transient
    @SuppressWarnings("unchecked")
    public List<Long> getAuthIds()
    {
        return ConvertUtils.convertElementPropertyToList(authorityList, "id");
    }
}
