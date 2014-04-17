package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String type;

    private String roleDesc;

    private Long positionId;

    private Long deptId;

    private List<LogisticsJobLinkPower> logisticsJobLinkPowersRoleId = null;

    private List<RolePowersKey> rolePowerssRoleId = null;

    private List<StorePowersKey> storePowerssRoleId = null;

    private List<SystemRoles> systemRolessRoleId = null;

    private List<UserRolesKey> userRolessRoleId = null;

    private Departments departmentsDeptId;

    private Positions positionsPositionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setLogisticsJobLinkPowersRoleId(List logisticsJobLinkPowersRoleId) {
        this.logisticsJobLinkPowersRoleId=logisticsJobLinkPowersRoleId;
    }

    public List<LogisticsJobLinkPower> getLogisticsJobLinkPowersRoleId() {
        return logisticsJobLinkPowersRoleId;
    }

    public void setRolePowerssRoleId(List rolePowerssRoleId) {
        this.rolePowerssRoleId=rolePowerssRoleId;
    }

    public List<RolePowersKey> getRolePowerssRoleId() {
        return rolePowerssRoleId;
    }

    public void setStorePowerssRoleId(List storePowerssRoleId) {
        this.storePowerssRoleId=storePowerssRoleId;
    }

    public List<StorePowersKey> getStorePowerssRoleId() {
        return storePowerssRoleId;
    }

    public void setSystemRolessRoleId(List systemRolessRoleId) {
        this.systemRolessRoleId=systemRolessRoleId;
    }

    public List<SystemRoles> getSystemRolessRoleId() {
        return systemRolessRoleId;
    }

    public void setUserRolessRoleId(List userRolessRoleId) {
        this.userRolessRoleId=userRolessRoleId;
    }

    public List<UserRolesKey> getUserRolessRoleId() {
        return userRolessRoleId;
    }

    public void setDepartmentsDeptId(Departments departmentsDeptId) {
        this.departmentsDeptId=departmentsDeptId;
    }

    public Departments getDepartmentsDeptId() {
        return departmentsDeptId;
    }

    public void setPositionsPositionId(Positions positionsPositionId) {
        this.positionsPositionId=positionsPositionId;
    }

    public Positions getPositionsPositionId() {
        return positionsPositionId;
    }
}