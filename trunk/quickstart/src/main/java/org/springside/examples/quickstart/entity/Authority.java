package org.springside.examples.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ss_authority")
public class Authority extends IdEntity
{
    private static final long serialVersionUID = 1L;

    private String            name;                 // 名称

    public Authority()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
