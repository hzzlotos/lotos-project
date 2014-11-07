package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Brands implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long userId;

    private String status;

    private String code;

    private Long modelSpecificationId;

    private Date createDate;

    private Date updateDate;

    private List<CompanyBrandsKey> companyBrandssBrandId = null;

    private List<Resources> resourcessBrandId = null;

    private ModelSpecifications modelSpecificationsModelSpecificationId;

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

    public Long getModelSpecificationId() {
        return modelSpecificationId;
    }

    public void setModelSpecificationId(Long modelSpecificationId) {
        this.modelSpecificationId = modelSpecificationId;
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

    public void setCompanyBrandssBrandId(List companyBrandssBrandId) {
        this.companyBrandssBrandId=companyBrandssBrandId;
    }

    public List<CompanyBrandsKey> getCompanyBrandssBrandId() {
        return companyBrandssBrandId;
    }

    public void setResourcessBrandId(List resourcessBrandId) {
        this.resourcessBrandId=resourcessBrandId;
    }

    public List<Resources> getResourcessBrandId() {
        return resourcessBrandId;
    }

    public void setModelSpecificationsModelSpecificationId(ModelSpecifications modelSpecificationsModelSpecificationId) {
        this.modelSpecificationsModelSpecificationId=modelSpecificationsModelSpecificationId;
    }

    public ModelSpecifications getModelSpecificationsModelSpecificationId() {
        return modelSpecificationsModelSpecificationId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}