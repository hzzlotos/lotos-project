package cn.newtouch.model;

public class Studentt
{

    private StudentPK pk;

    private int       age;

    private String    sex;

    private boolean   good;

    public boolean isGood()
    {
        return good;
    }

    public void setGood(boolean good)
    {
        this.good = good;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public StudentPK getPk()
    {
        return pk;
    }

    public void setPk(StudentPK pk)
    {
        this.pk = pk;
    }

}
