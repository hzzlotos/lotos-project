package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class MallCertCarrier extends MallCertCarrierKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date applyDate;

    private String auditStatus;

    private String enableStatus;

    private String certType;

    private Date auditDate;

    private Long apllyUserId;

    private Long checkUserId;

    private LogisticsCompanys logisticsCompanysLogisticsCompanyId;

    private Malls mallsMallId;

    private Users usersCheckUserId;

    private Users usersApllyUserId;

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

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus;
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

    public Long getApllyUserId() {
        return apllyUserId;
    }

    public void setApllyUserId(Long apllyUserId) {
        this.apllyUserId = apllyUserId;
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

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setUsersCheckUserId(Users usersCheckUserId) {
        this.usersCheckUserId=usersCheckUserId;
    }

    public Users getUsersCheckUserId() {
        return usersCheckUserId;
    }

    public void setUsersApllyUserId(Users usersApllyUserId) {
        this.usersApllyUserId=usersApllyUserId;
    }

    public Users getUsersApllyUserId() {
        return usersApllyUserId;
    }
}