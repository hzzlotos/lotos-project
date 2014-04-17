package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TrustPurchPerform implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal quantity;

    private Date performDate;

    private Long entrustProcurId;

    private Long resDefId;

    private Long storeJobId;

    private Long userId;

    private Resources resourcesResDefId;

    private StoreJobs storeJobsStoreJobId;

    private TrustPurchase trustPurchaseEntrustProcurId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getPerformDate() {
        return performDate;
    }

    public void setPerformDate(Date performDate) {
        this.performDate = performDate;
    }

    public Long getEntrustProcurId() {
        return entrustProcurId;
    }

    public void setEntrustProcurId(Long entrustProcurId) {
        this.entrustProcurId = entrustProcurId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
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

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }

    public void setTrustPurchaseEntrustProcurId(TrustPurchase trustPurchaseEntrustProcurId) {
        this.trustPurchaseEntrustProcurId=trustPurchaseEntrustProcurId;
    }

    public TrustPurchase getTrustPurchaseEntrustProcurId() {
        return trustPurchaseEntrustProcurId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}