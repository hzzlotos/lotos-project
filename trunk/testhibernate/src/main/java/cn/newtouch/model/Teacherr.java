package cn.newtouch.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "teacherSEQ", sequenceName = "teacherSEQ_DB")
// @IdClass(TeacherPK.class)
public class Teacherr
{
    private TeacherPK pk;

    // private int id;
    //
    // private String name;

    private String    title;

    private String    yourWifeName;

    private Date      birthDate;

    private boolean   good;

    private Gender    gender;

    @Enumerated(EnumType.STRING)
    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public boolean isGood()
    {
        return good;
    }

    public void setGood(boolean good)
    {
        this.good = good;
    }

    @Transient
    public String getYourWifeName()
    {
        return yourWifeName;
    }

    public void setYourWifeName(String yourWifeName)
    {
        this.yourWifeName = yourWifeName;
    }

    // @Id
    // public int getId()
    // {
    // return id;
    // }
    //
    // public void setId(int id)
    // {
    // this.id = id;
    // }
    //
    // @Id
    // public String getName()
    // {
    // return name;
    // }
    //
    // public void setName(String name)
    // {
    // this.name = name;
    // }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    @EmbeddedId
    public TeacherPK getPk()
    {
        return pk;
    }

    public void setPk(TeacherPK pk)
    {
        this.pk = pk;
    }

}
