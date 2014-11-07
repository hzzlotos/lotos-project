package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillingSettlementDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long billingSettlementId;

    private BigDecimal price;

    private BigDecimal qty;

    private BigDecimal receivableSubtotal;

    private BigDecimal paidinSubtotal;

    private Long chargeItemId;

    private BillingSettlements billingSettlementsBillingSettlementId;

    private ChargeItems chargeItemsChargeItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillingSettlementId() {
        return billingSettlementId;
    }

    public void setBillingSettlementId(Long billingSettlementId) {
        this.billingSettlementId = billingSettlementId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getReceivableSubtotal() {
        return receivableSubtotal;
    }

    public void setReceivableSubtotal(BigDecimal receivableSubtotal) {
        this.receivableSubtotal = receivableSubtotal;
    }

    public BigDecimal getPaidinSubtotal() {
        return paidinSubtotal;
    }

    public void setPaidinSubtotal(BigDecimal paidinSubtotal) {
        this.paidinSubtotal = paidinSubtotal;
    }

    public Long getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(Long chargeItemId) {
        this.chargeItemId = chargeItemId;
    }

    public void setBillingSettlementsBillingSettlementId(BillingSettlements billingSettlementsBillingSettlementId) {
        this.billingSettlementsBillingSettlementId=billingSettlementsBillingSettlementId;
    }

    public BillingSettlements getBillingSettlementsBillingSettlementId() {
        return billingSettlementsBillingSettlementId;
    }

    public void setChargeItemsChargeItemId(ChargeItems chargeItemsChargeItemId) {
        this.chargeItemsChargeItemId=chargeItemsChargeItemId;
    }

    public ChargeItems getChargeItemsChargeItemId() {
        return chargeItemsChargeItemId;
    }
}