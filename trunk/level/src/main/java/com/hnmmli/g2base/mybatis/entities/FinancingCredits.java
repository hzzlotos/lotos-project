package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class FinancingCredits implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String code;

    private BigDecimal totalCredit;

    private BigDecimal totalExposure;

    private BigDecimal availableCredit;

    private BigDecimal availableExposure;

    private String bankBranchCode;

    private String bankBranchName;

    private String bankCustomerCode;

    private String supplyChainCode;

    private String supplyChainName;

    private String creditAgreementText;

    private BigDecimal lowestDiscountValue;

    private BigDecimal regulatoryAccountBalance;

    private Date contractBeginDate;

    private Date contractEndDate;

    private BigDecimal floatingMaximumRatio;

    private String currencyDict;

    private Date createDate;

    private BigDecimal margin;

    private String auditStatus;

    private Date auditDate;

    private Date source;

    private Long bankId;

    private Long companyId;

    private Long applyUserId;

    private Long auditUserId;

    private List<CollateralItems> collateralItemssFinancingCreditId = null;

    private List<FinancingApplys> financingApplyssFinancingCreditId = null;

    private List<FinancingCreditDetails> financingCreditDetailssFinancingCreditId = null;

    private List<FinancingCreditLogs> financingCreditLogssFinancingCreditId = null;

    private List<FinancingCreditStoresKey> financingCreditStoressFinancingCreditId = null;

    private Banks banksBankId;

    private Companys companysCompanyId;

    private Users usersApplyUserId;

    private Users usersAuditUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(BigDecimal totalCredit) {
        this.totalCredit = totalCredit;
    }

    public BigDecimal getTotalExposure() {
        return totalExposure;
    }

    public void setTotalExposure(BigDecimal totalExposure) {
        this.totalExposure = totalExposure;
    }

    public BigDecimal getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(BigDecimal availableCredit) {
        this.availableCredit = availableCredit;
    }

    public BigDecimal getAvailableExposure() {
        return availableExposure;
    }

    public void setAvailableExposure(BigDecimal availableExposure) {
        this.availableExposure = availableExposure;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankCustomerCode() {
        return bankCustomerCode;
    }

    public void setBankCustomerCode(String bankCustomerCode) {
        this.bankCustomerCode = bankCustomerCode;
    }

    public String getSupplyChainCode() {
        return supplyChainCode;
    }

    public void setSupplyChainCode(String supplyChainCode) {
        this.supplyChainCode = supplyChainCode;
    }

    public String getSupplyChainName() {
        return supplyChainName;
    }

    public void setSupplyChainName(String supplyChainName) {
        this.supplyChainName = supplyChainName;
    }

    public String getCreditAgreementText() {
        return creditAgreementText;
    }

    public void setCreditAgreementText(String creditAgreementText) {
        this.creditAgreementText = creditAgreementText;
    }

    public BigDecimal getLowestDiscountValue() {
        return lowestDiscountValue;
    }

    public void setLowestDiscountValue(BigDecimal lowestDiscountValue) {
        this.lowestDiscountValue = lowestDiscountValue;
    }

    public BigDecimal getRegulatoryAccountBalance() {
        return regulatoryAccountBalance;
    }

    public void setRegulatoryAccountBalance(BigDecimal regulatoryAccountBalance) {
        this.regulatoryAccountBalance = regulatoryAccountBalance;
    }

    public Date getContractBeginDate() {
        return contractBeginDate;
    }

    public void setContractBeginDate(Date contractBeginDate) {
        this.contractBeginDate = contractBeginDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getFloatingMaximumRatio() {
        return floatingMaximumRatio;
    }

    public void setFloatingMaximumRatio(BigDecimal floatingMaximumRatio) {
        this.floatingMaximumRatio = floatingMaximumRatio;
    }

    public String getCurrencyDict() {
        return currencyDict;
    }

    public void setCurrencyDict(String currencyDict) {
        this.currencyDict = currencyDict;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getSource() {
        return source;
    }

    public void setSource(Date source) {
        this.source = source;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public void setCollateralItemssFinancingCreditId(List collateralItemssFinancingCreditId) {
        this.collateralItemssFinancingCreditId=collateralItemssFinancingCreditId;
    }

    public List<CollateralItems> getCollateralItemssFinancingCreditId() {
        return collateralItemssFinancingCreditId;
    }

    public void setFinancingApplyssFinancingCreditId(List financingApplyssFinancingCreditId) {
        this.financingApplyssFinancingCreditId=financingApplyssFinancingCreditId;
    }

    public List<FinancingApplys> getFinancingApplyssFinancingCreditId() {
        return financingApplyssFinancingCreditId;
    }

    public void setFinancingCreditDetailssFinancingCreditId(List financingCreditDetailssFinancingCreditId) {
        this.financingCreditDetailssFinancingCreditId=financingCreditDetailssFinancingCreditId;
    }

    public List<FinancingCreditDetails> getFinancingCreditDetailssFinancingCreditId() {
        return financingCreditDetailssFinancingCreditId;
    }

    public void setFinancingCreditLogssFinancingCreditId(List financingCreditLogssFinancingCreditId) {
        this.financingCreditLogssFinancingCreditId=financingCreditLogssFinancingCreditId;
    }

    public List<FinancingCreditLogs> getFinancingCreditLogssFinancingCreditId() {
        return financingCreditLogssFinancingCreditId;
    }

    public void setFinancingCreditStoressFinancingCreditId(List financingCreditStoressFinancingCreditId) {
        this.financingCreditStoressFinancingCreditId=financingCreditStoressFinancingCreditId;
    }

    public List<FinancingCreditStoresKey> getFinancingCreditStoressFinancingCreditId() {
        return financingCreditStoressFinancingCreditId;
    }

    public void setBanksBankId(Banks banksBankId) {
        this.banksBankId=banksBankId;
    }

    public Banks getBanksBankId() {
        return banksBankId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setUsersApplyUserId(Users usersApplyUserId) {
        this.usersApplyUserId=usersApplyUserId;
    }

    public Users getUsersApplyUserId() {
        return usersApplyUserId;
    }

    public void setUsersAuditUserId(Users usersAuditUserId) {
        this.usersAuditUserId=usersAuditUserId;
    }

    public Users getUsersAuditUserId() {
        return usersAuditUserId;
    }
}