package cn.newtouch.model.HQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topic
{
    private int       id;

    private String    title;

    private Category  category;

    // private Category category2;
    private List<Msg> msgs = new ArrayList<Msg>();

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    public List<Msg> getMsgs()
    {

        return msgs;
    }

    public void setMsgs(List<Msg> msgs)
    {
        this.msgs = msgs;
    }

    private Date createDate;

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

}
