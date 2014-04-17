package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class ResoAlloUpLogs implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long newAllocationId;

    private Long oldAllocationId;

    private Long resourceDetailId;

    private Long storeJobId;

    private Date createDate;

    private Date updateDate;

    private Allocations allocationsOldAllocationId;

    private Allocations allocationsNewAllocationId;

    private ResourceDetails resourceDetailsResourceDetailId;

    private StoreJobs storeJobsStoreJobId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewAllocationId() {
        return newAllocationId;
    }

    public void setNewAllocationId(Long newAllocationId) {
        this.newAllocationId = newAllocationId;
    }

    public Long getOldAllocationId() {
        return oldAllocationId;
    }

    public void setOldAllocationId(Long oldAllocationId) {
        this.oldAllocationId = oldAllocationId;
    }

    public Long getResourceDetailId() {
        return resourceDetailId;
    }

    public void setResourceDetailId(Long resourceDetailId) {
        this.resourceDetailId = resourceDetailId;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
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

    public void setAllocationsOldAllocationId(Allocations allocationsOldAllocationId) {
        this.allocationsOldAllocationId=allocationsOldAllocationId;
    }

    public Allocations getAllocationsOldAllocationId() {
        return allocationsOldAllocationId;
    }

    public void setAllocationsNewAllocationId(Allocations allocationsNewAllocationId) {
        this.allocationsNewAllocationId=allocationsNewAllocationId;
    }

    public Allocations getAllocationsNewAllocationId() {
        return allocationsNewAllocationId;
    }

    public void setResourceDetailsResourceDetailId(ResourceDetails resourceDetailsResourceDetailId) {
        this.resourceDetailsResourceDetailId=resourceDetailsResourceDetailId;
    }

    public ResourceDetails getResourceDetailsResourceDetailId() {
        return resourceDetailsResourceDetailId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }
}