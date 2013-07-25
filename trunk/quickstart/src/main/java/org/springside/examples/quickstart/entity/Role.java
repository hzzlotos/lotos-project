package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ss_role")
public class Role extends IdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private String            name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Role()
    {
    }
}