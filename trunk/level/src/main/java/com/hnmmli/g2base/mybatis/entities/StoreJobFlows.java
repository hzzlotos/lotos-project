package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class StoreJobFlows implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long lastJobFlowId;

    private Long jobFlowModeId;

    private Long jobFlowNodeId;

    private Date createDate;

    private String status;

    private String remark;

    private Long storeJobId;

    private Long userId;

    private Date updateDate;

    private List<StoreJobFlows> storeJobFlowssLastJobFlowId = null;

    private StoreJobs storeJobsStoreJobId;

    private StoreJobFlows storeJobFlowsLastJobFlowId;

    private StoreJobFlowModes storeJobFlowModesJobFlowModeId;

    private StoreJobFlowNodes storeJobFlowNodesJobFlowNodeId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastJobFlowId() {
        return lastJobFlowId;
    }

    public void setLastJobFlowId(Long lastJobFlowId) {
        this.lastJobFlowId = lastJobFlowId;
    }

    public Long getJobFlowModeId() {
        return jobFlowModeId;
    }

    public void setJobFlowModeId(Long jobFlowModeId) {
        this.jobFlowModeId = jobFlowModeId;
    }

    public Long getJobFlowNodeId() {
        return jobFlowNodeId;
    }

    public void setJobFlowNodeId(Long jobFlowNodeId) {
        this.jobFlowNodeId = jobFlowNodeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setStoreJobFlowssLastJobFlowId(List storeJobFlowssLastJobFlowId) {
        this.storeJobFlowssLastJobFlowId=storeJobFlowssLastJobFlowId;
    }

    public List<StoreJobFlows> getStoreJobFlowssLastJobFlowId() {
        return storeJobFlowssLastJobFlowId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }

    public void setStoreJobFlowsLastJobFlowId(StoreJobFlows storeJobFlowsLastJobFlowId) {
        this.storeJobFlowsLastJobFlowId=storeJobFlowsLastJobFlowId;
    }

    public StoreJobFlows getStoreJobFlowsLastJobFlowId() {
        return storeJobFlowsLastJobFlowId;
    }

    public void setStoreJobFlowModesJobFlowModeId(StoreJobFlowModes storeJobFlowModesJobFlowModeId) {
        this.storeJobFlowModesJobFlowModeId=storeJobFlowModesJobFlowModeId;
    }

    public StoreJobFlowModes getStoreJobFlowModesJobFlowModeId() {
        return storeJobFlowModesJobFlowModeId;
    }

    public void setStoreJobFlowNodesJobFlowNodeId(StoreJobFlowNodes storeJobFlowNodesJobFlowNodeId) {
        this.storeJobFlowNodesJobFlowNodeId=storeJobFlowNodesJobFlowNodeId;
    }

    public StoreJobFlowNodes getStoreJobFlowNodesJobFlowNodeId() {
        return storeJobFlowNodesJobFlowNodeId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}