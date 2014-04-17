package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class TrustPurchPlanDetails extends TrustPurchPlanDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal amount;

    private Long resDefId;

    private EntrPurchPlanCount entrPurchPlanCountTrpPerforId;

    private Resources resourcesResDefId;

    private TrustPurchase trustPurchaseTrustPurchId;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public void setEntrPurchPlanCountTrpPerforId(EntrPurchPlanCount entrPurchPlanCountTrpPerforId) {
        this.entrPurchPlanCountTrpPerforId=entrPurchPlanCountTrpPerforId;
    }

    public EntrPurchPlanCount getEntrPurchPlanCountTrpPerforId() {
        return entrPurchPlanCountTrpPerforId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setTrustPurchaseTrustPurchId(TrustPurchase trustPurchaseTrustPurchId) {
        this.trustPurchaseTrustPurchId=trustPurchaseTrustPurchId;
    }

    public TrustPurchase getTrustPurchaseTrustPurchId() {
        return trustPurchaseTrustPurchId;
    }
}