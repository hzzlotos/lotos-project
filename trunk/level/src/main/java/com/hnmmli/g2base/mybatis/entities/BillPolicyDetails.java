package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillPolicyDetails extends BillPolicyDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal price;

    private BillingPolicies billingPoliciesBillingPolicieId;

    private ChargeItems chargeItemsChargeItemId;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBillingPoliciesBillingPolicieId(BillingPolicies billingPoliciesBillingPolicieId) {
        this.billingPoliciesBillingPolicieId=billingPoliciesBillingPolicieId;
    }

    public BillingPolicies getBillingPoliciesBillingPolicieId() {
        return billingPoliciesBillingPolicieId;
    }

    public void setChargeItemsChargeItemId(ChargeItems chargeItemsChargeItemId) {
        this.chargeItemsChargeItemId=chargeItemsChargeItemId;
    }

    public ChargeItems getChargeItemsChargeItemId() {
        return chargeItemsChargeItemId;
    }
}