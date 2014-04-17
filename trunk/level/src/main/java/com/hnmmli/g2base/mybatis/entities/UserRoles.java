package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class UserRoles extends UserRolesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private List<StoreJobFlowNodePowers> storeJobFlowNodePowerssUserRoleId = null;

    private List<StoreJobFlowNodePowers> storeJobFlowNodePowerssUserId = null;

    private Roles rolesRoleId;

    private Users usersUserId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setStoreJobFlowNodePowerssUserRoleId(List storeJobFlowNodePowerssUserRoleId) {
        this.storeJobFlowNodePowerssUserRoleId=storeJobFlowNodePowerssUserRoleId;
    }

    public List<StoreJobFlowNodePowers> getStoreJobFlowNodePowerssUserRoleId() {
        return storeJobFlowNodePowerssUserRoleId;
    }

    public void setStoreJobFlowNodePowerssUserId(List storeJobFlowNodePowerssUserId) {
        this.storeJobFlowNodePowerssUserId=storeJobFlowNodePowerssUserId;
    }

    public List<StoreJobFlowNodePowers> getStoreJobFlowNodePowerssUserId() {
        return storeJobFlowNodePowerssUserId;
    }

    public void setRolesRoleId(Roles rolesRoleId) {
        this.rolesRoleId=rolesRoleId;
    }

    public Roles getRolesRoleId() {
        return rolesRoleId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}