package cn.newtouch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import cn.newtouch.constant.Gender;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true, dynamicInsert = true)
public class Teacher
{
    private int     id;

    private String  name;

    private String  title;

    private Date    birthDate;

    private boolean good;

    private Gender  gender;

    public boolean isGood()
    {
        return good;
    }

    public void setGood(boolean good)
    {
        this.good = good;
    }

    // 不被持久化,即不存进数据库
    @Transient
    public String getYourWifeName()
    {
        return "fengjie";
    }

    @Id
    // 默认就是GenerationType.AUTO
    @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // @Column(updatable = false) 极少用
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    // 只记录时间@Temporal(TemporalType.TIME)
    // 只记录日期@Temporal(TemporalType.DATE) 默认是TIMESTAMP
    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
}
