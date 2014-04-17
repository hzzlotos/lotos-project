package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class LogisticsJobLinkPower implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsJobTempId;

    private Long userId;

    private Long roleId;

    private LogisticsJobTemplate logisticsJobTemplateLogisticsJobTempId;

    private Roles rolesRoleId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsJobTempId() {
        return logisticsJobTempId;
    }

    public void setLogisticsJobTempId(Long logisticsJobTempId) {
        this.logisticsJobTempId = logisticsJobTempId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setLogisticsJobTemplateLogisticsJobTempId(LogisticsJobTemplate logisticsJobTemplateLogisticsJobTempId) {
        this.logisticsJobTemplateLogisticsJobTempId=logisticsJobTemplateLogisticsJobTempId;
    }

    public LogisticsJobTemplate getLogisticsJobTemplateLogisticsJobTempId() {
        return logisticsJobTemplateLogisticsJobTempId;
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