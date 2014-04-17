package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class Biddings implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String type;

    private String biddingMode;

    private Date addtime;

    private BigDecimal clichTotalMoney;

    private String isinvitation;

    private String isLimtArea;

    private String description;

    private BigDecimal ctrlGuidePrice;

    private BigDecimal payableBail;

    private String bailMode;

    private Date entrContractDate;

    private Date beginTime;

    private Date endTime;

    private Date applyDate;

    private BigDecimal initialPrice;

    private BigDecimal bidIncrement;

    private Date planDeliDate;

    private Date publishDate;

    private Long enterpriseId;

    private Long userId;

    private Long auditUser;

    private Long resDefId;

    private String isSpot;

    private String applyAuditStatus;

    private String auditDesc;

    private Long trustContractId;

    private Date trustSignedDate;

    private String isToDeal;

    private String status;

    private String biddelay;

    private Long clinchResDefId;

    private List<BidBails> bidBailssBidId = null;

    private List<BidDeliStoresKey> bidDeliStoressBidId = null;

    private List<BidDeposits> bidDepositssBidId = null;

    private List<BidLimtAreasKey> bidLimtAreassBidId = null;

    private List<BidResponses> bidResponsessBiddingId = null;

    private Companys companysEnterpriseId;

    private FileInfos fileInfosTrustContractId;

    private Resources resourcesResDefId;

    private Resources resourcesClinchResDefId;

    private Users usersAuditUser;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBiddingMode() {
        return biddingMode;
    }

    public void setBiddingMode(String biddingMode) {
        this.biddingMode = biddingMode;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public BigDecimal getClichTotalMoney() {
        return clichTotalMoney;
    }

    public void setClichTotalMoney(BigDecimal clichTotalMoney) {
        this.clichTotalMoney = clichTotalMoney;
    }

    public String getIsinvitation() {
        return isinvitation;
    }

    public void setIsinvitation(String isinvitation) {
        this.isinvitation = isinvitation;
    }

    public String getIsLimtArea() {
        return isLimtArea;
    }

    public void setIsLimtArea(String isLimtArea) {
        this.isLimtArea = isLimtArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCtrlGuidePrice() {
        return ctrlGuidePrice;
    }

    public void setCtrlGuidePrice(BigDecimal ctrlGuidePrice) {
        this.ctrlGuidePrice = ctrlGuidePrice;
    }

    public BigDecimal getPayableBail() {
        return payableBail;
    }

    public void setPayableBail(BigDecimal payableBail) {
        this.payableBail = payableBail;
    }

    public String getBailMode() {
        return bailMode;
    }

    public void setBailMode(String bailMode) {
        this.bailMode = bailMode;
    }

    public Date getEntrContractDate() {
        return entrContractDate;
    }

    public void setEntrContractDate(Date entrContractDate) {
        this.entrContractDate = entrContractDate;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public BigDecimal getBidIncrement() {
        return bidIncrement;
    }

    public void setBidIncrement(BigDecimal bidIncrement) {
        this.bidIncrement = bidIncrement;
    }

    public Date getPlanDeliDate() {
        return planDeliDate;
    }

    public void setPlanDeliDate(Date planDeliDate) {
        this.planDeliDate = planDeliDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public String getIsSpot() {
        return isSpot;
    }

    public void setIsSpot(String isSpot) {
        this.isSpot = isSpot;
    }

    public String getApplyAuditStatus() {
        return applyAuditStatus;
    }

    public void setApplyAuditStatus(String applyAuditStatus) {
        this.applyAuditStatus = applyAuditStatus;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public Long getTrustContractId() {
        return trustContractId;
    }

    public void setTrustContractId(Long trustContractId) {
        this.trustContractId = trustContractId;
    }

    public Date getTrustSignedDate() {
        return trustSignedDate;
    }

    public void setTrustSignedDate(Date trustSignedDate) {
        this.trustSignedDate = trustSignedDate;
    }

    public String getIsToDeal() {
        return isToDeal;
    }

    public void setIsToDeal(String isToDeal) {
        this.isToDeal = isToDeal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBiddelay() {
        return biddelay;
    }

    public void setBiddelay(String biddelay) {
        this.biddelay = biddelay;
    }

    public Long getClinchResDefId() {
        return clinchResDefId;
    }

    public void setClinchResDefId(Long clinchResDefId) {
        this.clinchResDefId = clinchResDefId;
    }

    public void setBidBailssBidId(List bidBailssBidId) {
        this.bidBailssBidId=bidBailssBidId;
    }

    public List<BidBails> getBidBailssBidId() {
        return bidBailssBidId;
    }

    public void setBidDeliStoressBidId(List bidDeliStoressBidId) {
        this.bidDeliStoressBidId=bidDeliStoressBidId;
    }

    public List<BidDeliStoresKey> getBidDeliStoressBidId() {
        return bidDeliStoressBidId;
    }

    public void setBidDepositssBidId(List bidDepositssBidId) {
        this.bidDepositssBidId=bidDepositssBidId;
    }

    public List<BidDeposits> getBidDepositssBidId() {
        return bidDepositssBidId;
    }

    public void setBidLimtAreassBidId(List bidLimtAreassBidId) {
        this.bidLimtAreassBidId=bidLimtAreassBidId;
    }

    public List<BidLimtAreasKey> getBidLimtAreassBidId() {
        return bidLimtAreassBidId;
    }

    public void setBidResponsessBiddingId(List bidResponsessBiddingId) {
        this.bidResponsessBiddingId=bidResponsessBiddingId;
    }

    public List<BidResponses> getBidResponsessBiddingId() {
        return bidResponsessBiddingId;
    }

    public void setCompanysEnterpriseId(Companys companysEnterpriseId) {
        this.companysEnterpriseId=companysEnterpriseId;
    }

    public Companys getCompanysEnterpriseId() {
        return companysEnterpriseId;
    }

    public void setFileInfosTrustContractId(FileInfos fileInfosTrustContractId) {
        this.fileInfosTrustContractId=fileInfosTrustContractId;
    }

    public FileInfos getFileInfosTrustContractId() {
        return fileInfosTrustContractId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setResourcesClinchResDefId(Resources resourcesClinchResDefId) {
        this.resourcesClinchResDefId=resourcesClinchResDefId;
    }

    public Resources getResourcesClinchResDefId() {
        return resourcesClinchResDefId;
    }

    public void setUsersAuditUser(Users usersAuditUser) {
        this.usersAuditUser=usersAuditUser;
    }

    public Users getUsersAuditUser() {
        return usersAuditUser;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}