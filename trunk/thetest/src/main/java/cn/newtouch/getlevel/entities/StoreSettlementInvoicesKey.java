package cn.newtouch.getlevel.entities;

public class StoreSettlementInvoicesKey {
    private Long billingSettlementId;

    private Long invoiceId;

    public Long getBillingSettlementId() {
        return billingSettlementId;
    }

    public void setBillingSettlementId(Long billingSettlementId) {
        this.billingSettlementId = billingSettlementId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}