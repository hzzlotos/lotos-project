package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class StorePowers extends StorePowersKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Roles rolesRoleId;

    private Stores storesStoreId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setRolesRoleId(Roles rolesRoleId) {
        this.rolesRoleId=rolesRoleId;
    }

    public Roles getRolesRoleId() {
        return rolesRoleId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}