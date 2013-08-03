package cn.newtouch.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;

@Entity
@Table(name = "qs_attach")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Attach extends IdEntity
{
    private static final long serialVersionUID = 1L;

    private List<Attach>      children         = Lists.newArrayList();

    private String            name;

    private Attach            parent;

    private int               type;

    private List<Project>     projects         = Lists.newArrayList();

    private List<User>        users            = Lists.newArrayList();

    @OneToMany(mappedBy = "attach", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    @OneToMany(mappedBy = "attach", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public List<Project> getProjects()
    {
        return projects;
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public List<Attach> getChildren()
    {
        return children;
    }

    public String getName()
    {
        return name;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public Attach getParent()
    {
        return parent;
    }

    public int getType()
    {
        return type;
    }

    public void setChildren(List<Attach> children)
    {
        this.children = children;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setParent(Attach parent)
    {
        this.parent = parent;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Attach))
        {
            return false;
        }
        Attach now = (Attach) obj;
        if (this.id.equals(now.getId()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}