package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class FinancingApplys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date applyDate;

    private BigDecimal availableCredit;

    private BigDecimal availableExposure;

    private BigDecimal applyMoney;

    private BigDecimal amountRaised;

    private BigDecimal marketWithholdingAmount;

    private BigDecimal initialMarginRatio;

    private BigDecimal initialMarginAmount;

    private String status;

    private String financingApplyCode;

    private Long financingCreditId;

    private String financingType;

    private Long financingTypeId;

    private Long financingDeadlineId;

    private Long orderId;

    private List<FinancingApplyDetails> financingApplyDetailssFinancingApplyId = null;

    private List<RepaymentRedeemGoods> repaymentRedeemGoodssFinancingApplyId = null;

    private FinancingCredits financingCreditsFinancingCreditId;

    private FinancingDeadlines financingDeadlinesFinancingDeadlineId;

    private FinancingTypes financingTypesFinancingTypeId;

    private Orders ordersOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public BigDecimal getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(BigDecimal applyMoney) {
        this.applyMoney = applyMoney;
    }

    public BigDecimal getAmountRaised() {
        return amountRaised;
    }

    public void setAmountRaised(BigDecimal amountRaised) {
        this.amountRaised = amountRaised;
    }

    public BigDecimal getMarketWithholdingAmount() {
        return marketWithholdingAmount;
    }

    public void setMarketWithholdingAmount(BigDecimal marketWithholdingAmount) {
        this.marketWithholdingAmount = marketWithholdingAmount;
    }

    public BigDecimal getInitialMarginRatio() {
        return initialMarginRatio;
    }

    public void setInitialMarginRatio(BigDecimal initialMarginRatio) {
        this.initialMarginRatio = initialMarginRatio;
    }

    public BigDecimal getInitialMarginAmount() {
        return initialMarginAmount;
    }

    public void setInitialMarginAmount(BigDecimal initialMarginAmount) {
        this.initialMarginAmount = initialMarginAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinancingApplyCode() {
        return financingApplyCode;
    }

    public void setFinancingApplyCode(String financingApplyCode) {
        this.financingApplyCode = financingApplyCode;
    }

    public Long getFinancingCreditId() {
        return financingCreditId;
    }

    public void setFinancingCreditId(Long financingCreditId) {
        this.financingCreditId = financingCreditId;
    }

    public String getFinancingType() {
        return financingType;
    }

    public void setFinancingType(String financingType) {
        this.financingType = financingType;
    }

    public Long getFinancingTypeId() {
        return financingTypeId;
    }

    public void setFinancingTypeId(Long financingTypeId) {
        this.financingTypeId = financingTypeId;
    }

    public Long getFinancingDeadlineId() {
        return financingDeadlineId;
    }

    public void setFinancingDeadlineId(Long financingDeadlineId) {
        this.financingDeadlineId = financingDeadlineId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setFinancingApplyDetailssFinancingApplyId(List financingApplyDetailssFinancingApplyId) {
        this.financingApplyDetailssFinancingApplyId=financingApplyDetailssFinancingApplyId;
    }

    public List<FinancingApplyDetails> getFinancingApplyDetailssFinancingApplyId() {
        return financingApplyDetailssFinancingApplyId;
    }

    public void setRepaymentRedeemGoodssFinancingApplyId(List repaymentRedeemGoodssFinancingApplyId) {
        this.repaymentRedeemGoodssFinancingApplyId=repaymentRedeemGoodssFinancingApplyId;
    }

    public List<RepaymentRedeemGoods> getRepaymentRedeemGoodssFinancingApplyId() {
        return repaymentRedeemGoodssFinancingApplyId;
    }

    public void setFinancingCreditsFinancingCreditId(FinancingCredits financingCreditsFinancingCreditId) {
        this.financingCreditsFinancingCreditId=financingCreditsFinancingCreditId;
    }

    public FinancingCredits getFinancingCreditsFinancingCreditId() {
        return financingCreditsFinancingCreditId;
    }

    public void setFinancingDeadlinesFinancingDeadlineId(FinancingDeadlines financingDeadlinesFinancingDeadlineId) {
        this.financingDeadlinesFinancingDeadlineId=financingDeadlinesFinancingDeadlineId;
    }

    public FinancingDeadlines getFinancingDeadlinesFinancingDeadlineId() {
        return financingDeadlinesFinancingDeadlineId;
    }

    public void setFinancingTypesFinancingTypeId(FinancingTypes financingTypesFinancingTypeId) {
        this.financingTypesFinancingTypeId=financingTypesFinancingTypeId;
    }

    public FinancingTypes getFinancingTypesFinancingTypeId() {
        return financingTypesFinancingTypeId;
    }

    public void setOrdersOrderId(Orders ordersOrderId) {
        this.ordersOrderId=ordersOrderId;
    }

    public Orders getOrdersOrderId() {
        return ordersOrderId;
    }
}