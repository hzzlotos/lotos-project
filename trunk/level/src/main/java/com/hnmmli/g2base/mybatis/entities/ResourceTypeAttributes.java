package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class ResourceTypeAttributes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resourceTypeId;

    private String attributeName;

    private String status;

    private Long sort;

    private String isNotNull;

    private Date createDate;

    private ResourceTypes resourceTypesResourceTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getIsNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(String isNotNull) {
        this.isNotNull = isNotNull;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setResourceTypesResourceTypeId(ResourceTypes resourceTypesResourceTypeId) {
        this.resourceTypesResourceTypeId=resourceTypesResourceTypeId;
    }

    public ResourceTypes getResourceTypesResourceTypeId() {
        return resourceTypesResourceTypeId;
    }
}