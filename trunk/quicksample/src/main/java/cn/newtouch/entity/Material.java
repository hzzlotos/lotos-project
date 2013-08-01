package cn.newtouch.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "qs_material")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Material extends IdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private String            fileName;

    private String            filePath;

    private String            name;

    private Attach            attach;

    public Material()
    {
    }

    public Material(String fileName, String filePath, String name, Attach attach)
    {
        this.fileName = fileName;
        this.filePath = filePath;
        this.name = name;
        this.attach = attach;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id")
    public Attach getAttach()
    {
        return attach;
    }

    @Column(name = "file_name")
    public String getFileName()
    {
        return fileName;
    }

    @Column(name = "file_path")
    public String getFilePath()
    {
        return filePath;
    }

    public String getName()
    {
        return name;
    }

    public void setAttach(Attach attach)
    {
        this.attach = attach;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Material))
        {
            return false;
        }
        Material now = (Material) obj;
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