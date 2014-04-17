package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class TrustPurchase implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long principalComId;

    private Long trusteeComId;

    private Long upComId;

    private Long resDefId;

    private BigDecimal protUnitPrice;

    private BigDecimal protocolMoney;

    private BigDecimal fulfillMoney;

    private BigDecimal redeemMoney;

    private String status;

    private BigDecimal principalQty;

    private BigDecimal finishedQty;

    private BigDecimal redeemedQty;

    private String submitStatus;

    private Long userId;

    private Long businesspathId;

    private BigDecimal bail;

    private BigDecimal bailRate;

    private String measureType;

    private List<TrustPurchPerform> trustPurchPerformsEntrustProcurId = null;

    private List<TrustPurchPlanDetailsKey> trustPurchPlanDetailssTrustPurchId = null;

    private List<TrustPurchRedeemDetails> trustPurchRedeemDetailssEntrustPurchId = null;

    private BusinPaths businPathsBusinesspathId;

    private Companys companysTrusteeComId;

    private Companys companysPrincipalComId;

    private Companys companysUpComId;

    private Resources resourcesResDefId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrincipalComId() {
        return principalComId;
    }

    public void setPrincipalComId(Long principalComId) {
        this.principalComId = principalComId;
    }

    public Long getTrusteeComId() {
        return trusteeComId;
    }

    public void setTrusteeComId(Long trusteeComId) {
        this.trusteeComId = trusteeComId;
    }

    public Long getUpComId() {
        return upComId;
    }

    public void setUpComId(Long upComId) {
        this.upComId = upComId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public BigDecimal getProtUnitPrice() {
        return protUnitPrice;
    }

    public void setProtUnitPrice(BigDecimal protUnitPrice) {
        this.protUnitPrice = protUnitPrice;
    }

    public BigDecimal getProtocolMoney() {
        return protocolMoney;
    }

    public void setProtocolMoney(BigDecimal protocolMoney) {
        this.protocolMoney = protocolMoney;
    }

    public BigDecimal getFulfillMoney() {
        return fulfillMoney;
    }

    public void setFulfillMoney(BigDecimal fulfillMoney) {
        this.fulfillMoney = fulfillMoney;
    }

    public BigDecimal getRedeemMoney() {
        return redeemMoney;
    }

    public void setRedeemMoney(BigDecimal redeemMoney) {
        this.redeemMoney = redeemMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrincipalQty() {
        return principalQty;
    }

    public void setPrincipalQty(BigDecimal principalQty) {
        this.principalQty = principalQty;
    }

    public BigDecimal getFinishedQty() {
        return finishedQty;
    }

    public void setFinishedQty(BigDecimal finishedQty) {
        this.finishedQty = finishedQty;
    }

    public BigDecimal getRedeemedQty() {
        return redeemedQty;
    }

    public void setRedeemedQty(BigDecimal redeemedQty) {
        this.redeemedQty = redeemedQty;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBusinesspathId() {
        return businesspathId;
    }

    public void setBusinesspathId(Long businesspathId) {
        this.businesspathId = businesspathId;
    }

    public BigDecimal getBail() {
        return bail;
    }

    public void setBail(BigDecimal bail) {
        this.bail = bail;
    }

    public BigDecimal getBailRate() {
        return bailRate;
    }

    public void setBailRate(BigDecimal bailRate) {
        this.bailRate = bailRate;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public void setTrustPurchPerformsEntrustProcurId(List trustPurchPerformsEntrustProcurId) {
        this.trustPurchPerformsEntrustProcurId=trustPurchPerformsEntrustProcurId;
    }

    public List<TrustPurchPerform> getTrustPurchPerformsEntrustProcurId() {
        return trustPurchPerformsEntrustProcurId;
    }

    public void setTrustPurchPlanDetailssTrustPurchId(List trustPurchPlanDetailssTrustPurchId) {
        this.trustPurchPlanDetailssTrustPurchId=trustPurchPlanDetailssTrustPurchId;
    }

    public List<TrustPurchPlanDetailsKey> getTrustPurchPlanDetailssTrustPurchId() {
        return trustPurchPlanDetailssTrustPurchId;
    }

    public void setTrustPurchRedeemDetailssEntrustPurchId(List trustPurchRedeemDetailssEntrustPurchId) {
        this.trustPurchRedeemDetailssEntrustPurchId=trustPurchRedeemDetailssEntrustPurchId;
    }

    public List<TrustPurchRedeemDetails> getTrustPurchRedeemDetailssEntrustPurchId() {
        return trustPurchRedeemDetailssEntrustPurchId;
    }

    public void setBusinPathsBusinesspathId(BusinPaths businPathsBusinesspathId) {
        this.businPathsBusinesspathId=businPathsBusinesspathId;
    }

    public BusinPaths getBusinPathsBusinesspathId() {
        return businPathsBusinesspathId;
    }

    public void setCompanysTrusteeComId(Companys companysTrusteeComId) {
        this.companysTrusteeComId=companysTrusteeComId;
    }

    public Companys getCompanysTrusteeComId() {
        return companysTrusteeComId;
    }

    public void setCompanysPrincipalComId(Companys companysPrincipalComId) {
        this.companysPrincipalComId=companysPrincipalComId;
    }

    public Companys getCompanysPrincipalComId() {
        return companysPrincipalComId;
    }

    public void setCompanysUpComId(Companys companysUpComId) {
        this.companysUpComId=companysUpComId;
    }

    public Companys getCompanysUpComId() {
        return companysUpComId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}