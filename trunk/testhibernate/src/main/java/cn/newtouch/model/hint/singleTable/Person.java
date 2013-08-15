package cn.newtouch.model.hint.singleTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// 设定用什么样的映射方式
// SINGLE_TABLE:多个对象存储在一张表
// JOINED:
// TABLE_PER_CLASS:
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 在数据库中用什么方式区分对象 INTEGER->数字 CHAR->字母 STRING->字符串
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
// 区分所用字段
@DiscriminatorValue("person")
public class Person
{
    private int    id;

    private String name;

    @Id
    @GeneratedValue
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

}
