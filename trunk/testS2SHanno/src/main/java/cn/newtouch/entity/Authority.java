package cn.newtouch.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.newtouch.constant.Constants;
import cn.newtouch.util.hibernate.AutoIdEntity;

@Entity
@Table(name = "authority")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Authority extends AutoIdEntity
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

    @Transient
    public String getPrefixedName()
    {
        return Constants.AUTHORITY_PREFIX + name;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}
