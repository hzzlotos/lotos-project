package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class BillingSettlements implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long companyId;

    private BigDecimal shouldCharge;

    private BigDecimal actualCharge;

    private Date settlementsDate;

    private String status;

    private Long storeId;

    private List<BillingSettlementDetails> billingSettlementDetailssBillingSettlementId = null;

    private List<StoreSettlementInvoicesKey> storeSettlementInvoicessBillingSettlementId = null;

    private Companys companysCompanyId;

    private Stores storesStoreId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getShouldCharge() {
        return shouldCharge;
    }

    public void setShouldCharge(BigDecimal shouldCharge) {
        this.shouldCharge = shouldCharge;
    }

    public BigDecimal getActualCharge() {
        return actualCharge;
    }

    public void setActualCharge(BigDecimal actualCharge) {
        this.actualCharge = actualCharge;
    }

    public Date getSettlementsDate() {
        return settlementsDate;
    }

    public void setSettlementsDate(Date settlementsDate) {
        this.settlementsDate = settlementsDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setBillingSettlementDetailssBillingSettlementId(List billingSettlementDetailssBillingSettlementId) {
        this.billingSettlementDetailssBillingSettlementId=billingSettlementDetailssBillingSettlementId;
    }

    public List<BillingSettlementDetails> getBillingSettlementDetailssBillingSettlementId() {
        return billingSettlementDetailssBillingSettlementId;
    }

    public void setStoreSettlementInvoicessBillingSettlementId(List storeSettlementInvoicessBillingSettlementId) {
        this.storeSettlementInvoicessBillingSettlementId=storeSettlementInvoicessBillingSettlementId;
    }

    public List<StoreSettlementInvoicesKey> getStoreSettlementInvoicessBillingSettlementId() {
        return storeSettlementInvoicessBillingSettlementId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}