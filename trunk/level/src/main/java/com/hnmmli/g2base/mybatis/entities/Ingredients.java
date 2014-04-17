package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Ingredients implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long userId;

    private String status;

    private String code;

    private Date createDate;

    private Date updateDate;

    private List<CompanyIngredientsKey> companyIngredientssIngredientId = null;

    private List<Resources> resourcessIngredientId = null;

    private Users usersUserId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setCompanyIngredientssIngredientId(List companyIngredientssIngredientId) {
        this.companyIngredientssIngredientId=companyIngredientssIngredientId;
    }

    public List<CompanyIngredientsKey> getCompanyIngredientssIngredientId() {
        return companyIngredientssIngredientId;
    }

    public void setResourcessIngredientId(List resourcessIngredientId) {
        this.resourcessIngredientId=resourcessIngredientId;
    }

    public List<Resources> getResourcessIngredientId() {
        return resourcessIngredientId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}