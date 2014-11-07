package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class WorktimeLadder implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal lowerLimit;

    private BigDecimal upperLimit;

    private BigDecimal fluctuation;

    private Long billPolicyId;

    private Long chargeItemId;

    private BillingPolicies billingPoliciesBillPolicyId;

    private ChargeItems chargeItemsChargeItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    public BigDecimal getFluctuation() {
        return fluctuation;
    }

    public void setFluctuation(BigDecimal fluctuation) {
        this.fluctuation = fluctuation;
    }

    public Long getBillPolicyId() {
        return billPolicyId;
    }

    public void setBillPolicyId(Long billPolicyId) {
        this.billPolicyId = billPolicyId;
    }

    public Long getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Long chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public void setBillingPoliciesBillPolicyId(BillingPolicies billingPoliciesBillPolicyId) {
        this.billingPoliciesBillPolicyId=billingPoliciesBillPolicyId;
    }

    public BillingPolicies getBillingPoliciesBillPolicyId() {
        return billingPoliciesBillPolicyId;
    }

    public void setChargeItemsChargeItemId(ChargeItems chargeItemsChargeItemId) {
        this.chargeItemsChargeItemId=chargeItemsChargeItemId;
    }

    public ChargeItems getChargeItemsChargeItemId() {
        return chargeItemsChargeItemId;
    }
}