package cn.newtouch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.newtouch.util.hibernate.AutoIdEntity;

@Entity
@Table(name = "subject_pool")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SubjectPool extends AutoIdEntity
{
    private static final long serialVersionUID = 1L;

    private String            serialNo;             // 编号

    private String            name;                 // 名称

    @Column(name = "serial_no")
    public String getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
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