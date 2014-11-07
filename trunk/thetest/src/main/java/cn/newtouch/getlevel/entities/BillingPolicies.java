package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class BillingPolicies implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String type;

    private Long storeId;

    private Long companyId;

    private String beginDate;

    private String endDate;

    private String status;

    private String settlementId;

    private String name;

    private String actionType;

    private String isAutoCreate;

    private List<BillingDetailResourceTypesKey> billingDetailResourceTypessBillingPolicieId = null;

    private List<BillPolicyDetailsKey> billPolicyDetailssBillingPolicieId = null;

    private List<QuantityLadder> quantityLaddersBillPolicyId = null;

    private List<TimeLadderPrice> timeLadderPricesBillPolicyId = null;

    private List<WorktimeLadder> worktimeLaddersBillPolicyId = null;

    private Companys companysCompanyId;

    private Stores storesStoreId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getIsAutoCreate() {
        return isAutoCreate;
    }

    public void setIsAutoCreate(String isAutoCreate) {
        this.isAutoCreate = isAutoCreate;
    }

    public void setBillingDetailResourceTypessBillingPolicieId(List billingDetailResourceTypessBillingPolicieId) {
        this.billingDetailResourceTypessBillingPolicieId=billingDetailResourceTypessBillingPolicieId;
    }

    public List<BillingDetailResourceTypesKey> getBillingDetailResourceTypessBillingPolicieId() {
        return billingDetailResourceTypessBillingPolicieId;
    }

    public void setBillPolicyDetailssBillingPolicieId(List billPolicyDetailssBillingPolicieId) {
        this.billPolicyDetailssBillingPolicieId=billPolicyDetailssBillingPolicieId;
    }

    public List<BillPolicyDetailsKey> getBillPolicyDetailssBillingPolicieId() {
        return billPolicyDetailssBillingPolicieId;
    }

    public void setQuantityLaddersBillPolicyId(List quantityLaddersBillPolicyId) {
        this.quantityLaddersBillPolicyId=quantityLaddersBillPolicyId;
    }

    public List<QuantityLadder> getQuantityLaddersBillPolicyId() {
        return quantityLaddersBillPolicyId;
    }

    public void setTimeLadderPricesBillPolicyId(List timeLadderPricesBillPolicyId) {
        this.timeLadderPricesBillPolicyId=timeLadderPricesBillPolicyId;
    }

    public List<TimeLadderPrice> getTimeLadderPricesBillPolicyId() {
        return timeLadderPricesBillPolicyId;
    }

    public void setWorktimeLaddersBillPolicyId(List worktimeLaddersBillPolicyId) {
        this.worktimeLaddersBillPolicyId=worktimeLaddersBillPolicyId;
    }

    public List<WorktimeLadder> getWorktimeLaddersBillPolicyId() {
        return worktimeLaddersBillPolicyId;
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