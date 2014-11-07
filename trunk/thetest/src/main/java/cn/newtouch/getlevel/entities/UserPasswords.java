package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class UserPasswords extends UserPasswordsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private String password;

    private Date beginDate;

    private Date endDate;

    private Users usersUserId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}