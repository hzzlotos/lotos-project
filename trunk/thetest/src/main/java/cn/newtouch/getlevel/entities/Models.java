package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Models implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long userId;

    private String status;

    private Date createDate;

    private Date updateDate;

    private List<CompanyModelsKey> companyModelssModelId = null;

    private List<ModelSpecifications> modelSpecificationssModelId = null;

    private List<Resources> resourcessModelId = null;

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

    public void setCompanyModelssModelId(List companyModelssModelId) {
        this.companyModelssModelId=companyModelssModelId;
    }

    public List<CompanyModelsKey> getCompanyModelssModelId() {
        return companyModelssModelId;
    }

    public void setModelSpecificationssModelId(List modelSpecificationssModelId) {
        this.modelSpecificationssModelId=modelSpecificationssModelId;
    }

    public List<ModelSpecifications> getModelSpecificationssModelId() {
        return modelSpecificationssModelId;
    }

    public void setResourcessModelId(List resourcessModelId) {
        this.resourcessModelId=resourcessModelId;
    }

    public List<Resources> getResourcessModelId() {
        return resourcessModelId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}