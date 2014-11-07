package cn.newtouch.getlevel.entities;

public class BillPolicyDetailsKey {
    private Long billingPolicieId;

    private Long chargeItemId;

    public Long getBillingPolicieId() {
        return billingPolicieId;
    }

    public void setBillingPolicieId(Long billingPolicieId) {
        this.billingPolicieId = billingPolicieId;
    }

    public Long getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Long chargeItemId) {
        this.chargeItemId = chargeItemId;
    }
}