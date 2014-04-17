package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class BillingDetailResourceTypes extends BillingDetailResourceTypesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long resourceTypesId;

    private BillingPolicies billingPoliciesBillingPolicieId;

    private ChargeItems chargeItemsChargeItemId;

    private ResourceTypes resourceTypesResourceTypesId;

    public Long getResourceTypesId() {
        return resourceTypesId;
    }

    public void setResourceTypesId(Long resourceTypesId) {
        this.resourceTypesId = resourceTypesId;
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

    public void setResourceTypesResourceTypesId(ResourceTypes resourceTypesResourceTypesId) {
        this.resourceTypesResourceTypesId=resourceTypesResourceTypesId;
    }

    public ResourceTypes getResourceTypesResourceTypesId() {
        return resourceTypesResourceTypesId;
    }
}