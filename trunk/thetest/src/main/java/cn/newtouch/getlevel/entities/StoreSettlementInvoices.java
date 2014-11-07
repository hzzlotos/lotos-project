package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class StoreSettlementInvoices extends StoreSettlementInvoicesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private BillingSettlements billingSettlementsBillingSettlementId;

    private Invoices invoicesInvoiceId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBillingSettlementsBillingSettlementId(BillingSettlements billingSettlementsBillingSettlementId) {
        this.billingSettlementsBillingSettlementId=billingSettlementsBillingSettlementId;
    }

    public BillingSettlements getBillingSettlementsBillingSettlementId() {
        return billingSettlementsBillingSettlementId;
    }

    public void setInvoicesInvoiceId(Invoices invoicesInvoiceId) {
        this.invoicesInvoiceId=invoicesInvoiceId;
    }

    public Invoices getInvoicesInvoiceId() {
        return invoicesInvoiceId;
    }
}