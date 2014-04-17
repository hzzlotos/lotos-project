package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class ModelSpecifications implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String code;

    private Long specificationId;

    private Long modelId;

    private Long resourceTypeId;

    private String status;

    private Date createDate;

    private Date updateDate;

    private Long createUserId;

    private Long updateUserId;

    private List<Brands> brandssModelSpecificationId = null;

    private Models modelsModelId;

    private ResourceTypes resourceTypesResourceTypeId;

    private Specifications specificationsSpecificationId;

    private Users usersUpdateUserId;

    private Users usersCreateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void setBrandssModelSpecificationId(List brandssModelSpecificationId) {
        this.brandssModelSpecificationId=brandssModelSpecificationId;
    }

    public List<Brands> getBrandssModelSpecificationId() {
        return brandssModelSpecificationId;
    }

    public void setModelsModelId(Models modelsModelId) {
        this.modelsModelId=modelsModelId;
    }

    public Models getModelsModelId() {
        return modelsModelId;
    }

    public void setResourceTypesResourceTypeId(ResourceTypes resourceTypesResourceTypeId) {
        this.resourceTypesResourceTypeId=resourceTypesResourceTypeId;
    }

    public ResourceTypes getResourceTypesResourceTypeId() {
        return resourceTypesResourceTypeId;
    }

    public void setSpecificationsSpecificationId(Specifications specificationsSpecificationId) {
        this.specificationsSpecificationId=specificationsSpecificationId;
    }

    public Specifications getSpecificationsSpecificationId() {
        return specificationsSpecificationId;
    }

    public void setUsersUpdateUserId(Users usersUpdateUserId) {
        this.usersUpdateUserId=usersUpdateUserId;
    }

    public Users getUsersUpdateUserId() {
        return usersUpdateUserId;
    }

    public void setUsersCreateUserId(Users usersCreateUserId) {
        this.usersCreateUserId=usersCreateUserId;
    }

    public Users getUsersCreateUserId() {
        return usersCreateUserId;
    }
}