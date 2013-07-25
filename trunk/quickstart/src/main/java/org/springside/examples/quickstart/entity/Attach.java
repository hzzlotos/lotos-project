package org.springside.examples.quickstart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

@Entity
@Table(name = "ss_attach")
public class Attach extends IdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private String            name;

    private List<Attach>      children         = Lists.newArrayList();

    private Attach            parent;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @OneToMany(mappedBy = "parent")
    public List<Attach> getChildren()
    {
        return children;
    }

    public void setChildren(List<Attach> children)
    {
        this.children = children;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public Attach getParent()
    {
        return parent;
    }

    public void setParent(Attach parent)
    {
        this.parent = parent;
    }
}