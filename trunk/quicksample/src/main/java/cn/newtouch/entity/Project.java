package cn.newtouch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "qs_project")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Project extends IdEntity
{
    private static final long serialVersionUID = 1L;

    private String            name;

    private Attach            attach;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id")
    public Attach getAttach()
    {
        return attach;
    }

    public String getName()
    {
        return name;
    }

    public void setAttach(Attach attach)
    {
        this.attach = attach;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Project))
        {
            return false;
        }
        Project now = (Project) obj;
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