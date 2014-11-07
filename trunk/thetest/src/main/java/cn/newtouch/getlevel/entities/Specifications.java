package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Specifications implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long userId;

    private String status;

    private Date createDate;

    private Date updateDate;

    private List<CompanySpecificationsKey> companySpecificationssSpecificationId = null;

    private List<ModelSpecifications> modelSpecificationssSpecificationId = null;

    private List<Resources> resourcessSpecificationId = null;

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

    public void setCompanySpecificationssSpecificationId(List companySpecificationssSpecificationId) {
        this.companySpecificationssSpecificationId=companySpecificationssSpecificationId;
    }

    public List<CompanySpecificationsKey> getCompanySpecificationssSpecificationId() {
        return companySpecificationssSpecificationId;
    }

    public void setModelSpecificationssSpecificationId(List modelSpecificationssSpecificationId) {
        this.modelSpecificationssSpecificationId=modelSpecificationssSpecificationId;
    }

    public List<ModelSpecifications> getModelSpecificationssSpecificationId() {
        return modelSpecificationssSpecificationId;
    }

    public void setResourcessSpecificationId(List resourcessSpecificationId) {
        this.resourcessSpecificationId=resourcessSpecificationId;
    }

    public List<Resources> getResourcessSpecificationId() {
        return resourcessSpecificationId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}