package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class StoreJobFlowModes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String jobTypeId;

    private String name;

    private Date createDate;

    private Long version;

    private String status;

    private Long storeId;

    private Long userId;

    private List<StoreJobFlows> storeJobFlowssJobFlowModeId = null;

    private List<StoreJobFlowNodes> storeJobFlowNodessJobFlowModeId = null;

    private Stores storesStoreId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStoreJobFlowssJobFlowModeId(List storeJobFlowssJobFlowModeId) {
        this.storeJobFlowssJobFlowModeId=storeJobFlowssJobFlowModeId;
    }

    public List<StoreJobFlows> getStoreJobFlowssJobFlowModeId() {
        return storeJobFlowssJobFlowModeId;
    }

    public void setStoreJobFlowNodessJobFlowModeId(List storeJobFlowNodessJobFlowModeId) {
        this.storeJobFlowNodessJobFlowModeId=storeJobFlowNodessJobFlowModeId;
    }

    public List<StoreJobFlowNodes> getStoreJobFlowNodessJobFlowModeId() {
        return storeJobFlowNodessJobFlowModeId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}