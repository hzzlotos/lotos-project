package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinancingCreditDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long financingCreditId;

    private BigDecimal impawnrate;

    private Long resourceTypeId;

    private FinancingCredits financingCreditsFinancingCreditId;

    private ResourceTypes resourceTypesResourceTypeId;

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

    public BigDecimal getImpawnrate() {
        return impawnrate;
    }

    public void setImpawnrate(BigDecimal impawnrate) {
        this.impawnrate = impawnrate;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public void setFinancingCreditsFinancingCreditId(FinancingCredits financingCreditsFinancingCreditId) {
        this.financingCreditsFinancingCreditId=financingCreditsFinancingCreditId;
    }

    public FinancingCredits getFinancingCreditsFinancingCreditId() {
        return financingCreditsFinancingCreditId;
    }

    public void setResourceTypesResourceTypeId(ResourceTypes resourceTypesResourceTypeId) {
        this.resourceTypesResourceTypeId=resourceTypesResourceTypeId;
    }

    public ResourceTypes getResourceTypesResourceTypeId() {
        return resourceTypesResourceTypeId;
    }
}