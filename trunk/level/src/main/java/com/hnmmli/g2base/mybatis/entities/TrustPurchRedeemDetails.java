package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TrustPurchRedeemDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long entrustPurchId;

    private BigDecimal redeemQty;

    private BigDecimal redeemAmount;

    private Date perforDate;

    private Long userId;

    private Long ownerJobId;

    private Long fundsId;

    private Long resDefId;

    private FundsFlowDetails fundsFlowDetailsFundsId;

    private Resources resourcesResDefId;

    private StoreJobs storeJobsOwnerJobId;

    private TrustPurchase trustPurchaseEntrustPurchId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntrustPurchId() {
        return entrustPurchId;
    }

    public void setEntrustPurchId(Long entrustPurchId) {
        this.entrustPurchId = entrustPurchId;
    }

    public BigDecimal getRedeemQty() {
        return redeemQty;
    }

    public void setRedeemQty(BigDecimal redeemQty) {
        this.redeemQty = redeemQty;
    }

    public BigDecimal getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(BigDecimal redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public Date getPerforDate() {
        return perforDate;
    }

    public void setPerforDate(Date perforDate) {
        this.perforDate = perforDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOwnerJobId() {
        return ownerJobId;
    }

    public void setOwnerJobId(Long ownerJobId) {
        this.ownerJobId = ownerJobId;
    }

    public Long getFundsId() {
        return fundsId;
    }

    public void setFundsId(Long fundsId) {
        this.fundsId = fundsId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public void setFundsFlowDetailsFundsId(FundsFlowDetails fundsFlowDetailsFundsId) {
        this.fundsFlowDetailsFundsId=fundsFlowDetailsFundsId;
    }

    public FundsFlowDetails getFundsFlowDetailsFundsId() {
        return fundsFlowDetailsFundsId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setStoreJobsOwnerJobId(StoreJobs storeJobsOwnerJobId) {
        this.storeJobsOwnerJobId=storeJobsOwnerJobId;
    }

    public StoreJobs getStoreJobsOwnerJobId() {
        return storeJobsOwnerJobId;
    }

    public void setTrustPurchaseEntrustPurchId(TrustPurchase trustPurchaseEntrustPurchId) {
        this.trustPurchaseEntrustPurchId=trustPurchaseEntrustPurchId;
    }

    public TrustPurchase getTrustPurchaseEntrustPurchId() {
        return trustPurchaseEntrustPurchId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}