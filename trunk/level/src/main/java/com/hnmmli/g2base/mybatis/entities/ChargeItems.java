package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class ChargeItems implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String isEnable;

    private String mantissaDisposal;

    private String type;

    private String isSupplieRelated;

    private String description;

    private String isDateRelated;

    private Long storeId;

    private Long uomId;

    private List<BillingDetailResourceTypesKey> billingDetailResourceTypessChargeItemId = null;

    private List<BillingSettlementDetails> billingSettlementDetailssChargeItemId = null;

    private List<BillPolicyDetailsKey> billPolicyDetailssChargeItemId = null;

    private List<QuantityLadder> quantityLaddersChargeItemId = null;

    private List<TimeLadderPrice> timeLadderPricesChargeItemId = null;

    private List<WorktimeLadder> worktimeLaddersChargeItemId = null;

    private Stores storesStoreId;

    private Uoms uomsUomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getMantissaDisposal() {
        return mantissaDisposal;
    }

    public void setMantissaDisposal(String mantissaDisposal) {
        this.mantissaDisposal = mantissaDisposal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsSupplieRelated() {
        return isSupplieRelated;
    }

    public void setIsSupplieRelated(String isSupplieRelated) {
        this.isSupplieRelated = isSupplieRelated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsDateRelated() {
        return isDateRelated;
    }

    public void setIsDateRelated(String isDateRelated) {
        this.isDateRelated = isDateRelated;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setBillingDetailResourceTypessChargeItemId(List billingDetailResourceTypessChargeItemId) {
        this.billingDetailResourceTypessChargeItemId=billingDetailResourceTypessChargeItemId;
    }

    public List<BillingDetailResourceTypesKey> getBillingDetailResourceTypessChargeItemId() {
        return billingDetailResourceTypessChargeItemId;
    }

    public void setBillingSettlementDetailssChargeItemId(List billingSettlementDetailssChargeItemId) {
        this.billingSettlementDetailssChargeItemId=billingSettlementDetailssChargeItemId;
    }

    public List<BillingSettlementDetails> getBillingSettlementDetailssChargeItemId() {
        return billingSettlementDetailssChargeItemId;
    }

    public void setBillPolicyDetailssChargeItemId(List billPolicyDetailssChargeItemId) {
        this.billPolicyDetailssChargeItemId=billPolicyDetailssChargeItemId;
    }

    public List<BillPolicyDetailsKey> getBillPolicyDetailssChargeItemId() {
        return billPolicyDetailssChargeItemId;
    }

    public void setQuantityLaddersChargeItemId(List quantityLaddersChargeItemId) {
        this.quantityLaddersChargeItemId=quantityLaddersChargeItemId;
    }

    public List<QuantityLadder> getQuantityLaddersChargeItemId() {
        return quantityLaddersChargeItemId;
    }

    public void setTimeLadderPricesChargeItemId(List timeLadderPricesChargeItemId) {
        this.timeLadderPricesChargeItemId=timeLadderPricesChargeItemId;
    }

    public List<TimeLadderPrice> getTimeLadderPricesChargeItemId() {
        return timeLadderPricesChargeItemId;
    }

    public void setWorktimeLaddersChargeItemId(List worktimeLaddersChargeItemId) {
        this.worktimeLaddersChargeItemId=worktimeLaddersChargeItemId;
    }

    public List<WorktimeLadder> getWorktimeLaddersChargeItemId() {
        return worktimeLaddersChargeItemId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUomsUomId(Uoms uomsUomId) {
        this.uomsUomId=uomsUomId;
    }

    public Uoms getUomsUomId() {
        return uomsUomId;
    }
}