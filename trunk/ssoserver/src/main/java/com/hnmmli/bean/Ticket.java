package com.hnmmli.bean;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String            username;

    private Date              createTime;

    private Date              recoverTime;

    public Ticket()
    {
        super();
    }

    public Ticket(String username, Date createTime, Date recoverTime)
    {
        super();
        this.username = username;
        this.createTime = createTime;
        this.recoverTime = recoverTime;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getRecoverTime()
    {
        return this.recoverTime;
    }

    public void setRecoverTime(Date recoverTime)
    {
        this.recoverTime = recoverTime;
    }

}
