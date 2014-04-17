package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class StoreCertCarrier extends StoreCertCarrierKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date applyDate;

    private String auditStatus;

    private String usableStatus;

    private String certType;

    private Date auditDate;

    private Long applyUserId;

    private Long checkUserId;

    private LogisticsCompanys logisticsCompanysLogisticsCompanyId;

    private Stores storesStoreId;

    private Users usersApplyUserId;

    private Users usersCheckUserId;

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getUsableStatus() {
        return usableStatus;
    }

    public void setUsableStatus(String usableStatus) {
        this.usableStatus = usableStatus;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
    }

    public void setLogisticsCompanysLogisticsCompanyId(LogisticsCompanys logisticsCompanysLogisticsCompanyId) {
        this.logisticsCompanysLogisticsCompanyId=logisticsCompanysLogisticsCompanyId;
    }

    public LogisticsCompanys getLogisticsCompanysLogisticsCompanyId() {
        return logisticsCompanysLogisticsCompanyId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersApplyUserId(Users usersApplyUserId) {
        this.usersApplyUserId=usersApplyUserId;
    }

    public Users getUsersApplyUserId() {
        return usersApplyUserId;
    }

    public void setUsersCheckUserId(Users usersCheckUserId) {
        this.usersCheckUserId=usersCheckUserId;
    }

    public Users getUsersCheckUserId() {
        return usersCheckUserId;
    }
}