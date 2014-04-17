package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class RolePowers extends RolePowersKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Powers powersPowerId;

    private Roles rolesRoleId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setPowersPowerId(Powers powersPowerId) {
        this.powersPowerId=powersPowerId;
    }

    public Powers getPowersPowerId() {
        return powersPowerId;
    }

    public void setRolesRoleId(Roles rolesRoleId) {
        this.rolesRoleId=rolesRoleId;
    }

    public Roles getRolesRoleId() {
        return rolesRoleId;
    }
}