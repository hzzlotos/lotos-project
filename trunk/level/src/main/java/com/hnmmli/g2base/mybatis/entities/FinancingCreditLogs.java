package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FinancingCreditLogs implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long financingCreditId;

    private BigDecimal availableCredit;

    private BigDecimal availableExposure;

    private BigDecimal lowestDiscountValue;

    private BigDecimal regulatoryAccountBalance;

    private Date createDate;

    private BigDecimal margin;

    private FinancingCredits financingCreditsFinancingCreditId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinancingCreditId() {
        return financingCreditId;
    }

    public void setFinancingCreditId(Long financingCreditId) {
        this.financingCreditId = financingCreditId;
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

    public void setFinancingCreditsFinancingCreditId(FinancingCredits financingCreditsFinancingCreditId) {
        this.financingCreditsFinancingCreditId=financingCreditsFinancingCreditId;
    }

    public FinancingCredits getFinancingCreditsFinancingCreditId() {
        return financingCreditsFinancingCreditId;
    }
}