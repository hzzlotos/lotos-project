package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Stores implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long logisticNodeId;

    private String isAudit;

    private String status;

    private Long ownerId;

    private Long operatorId;

    private String type;

    private Long regulatoryId;

    private String phone;

    private String fax;

    private String postalcode;

    private List<Allocations> allocationssStoreId = null;

    private List<BidDeliStoresKey> bidDeliStoressStoreId = null;

    private List<BillingPolicies> billingPoliciessStoreId = null;

    private List<BillingSettlements> billingSettlementssStoreId = null;

    private List<ChargeItems> chargeItemssStoreId = null;

    private List<CollateralItemDetails> collateralItemDetailssStoreId = null;

    private List<CollateralSummaries> collateralSummariessStoreId = null;

    private List<EntrPurchDeliNote> entrPurchDeliNotesStoreId = null;

    private List<FinancingApplyDetails> financingApplyDetailssStoreId = null;

    private List<FinancingCreditStoresKey> financingCreditStoressStoreId = null;

    private List<InventoryResourceDetails> inventoryResourceDetailssStoreId = null;

    private List<InventoryValuations> inventoryValuationssStoreId = null;

    private List<Ladings> ladingssStoreId = null;

    private List<Malls> mallssVirtualStoreId = null;

    private List<MallWarehouse> mallWarehousesStoreId = null;

    private List<Pda> pdasStoreId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssStoreId = null;

    private List<ProcessMaterial> processMaterialsStoreId = null;

    private List<Productivitys> productivityssStoreId = null;

    private List<ResourceDetails> resourceDetailssStoreId = null;

    private List<ResourceSummaries> resourceSummariessStoreId = null;

    private List<StoreCertCarrierKey> storeCertCarriersStoreId = null;

    private List<StoreCompanysKey> storeCompanyssStoreId = null;

    private List<StoreJobs> storeJobssTransferStoreId = null;

    private List<StoreJobs> storeJobssJobStoreId = null;

    private List<StoreJobDetails> storeJobDetailssStoreId = null;

    private List<StoreJobFlowModes> storeJobFlowModessStoreId = null;

    private List<StorePowersKey> storePowerssStoreId = null;

    private List<TraderResources> traderResourcessStoreId = null;

    private List<TrustDistributerKey> trustDistributersStoreId = null;

    private Companys companysOwnerId;

    private Companys companysRegulatoryId;

    private Companys companysOperatorId;

    private LogisticsAddress logisticsAddressLogisticNodeId;

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

    public Long getLogisticNodeId() {
        return logisticNodeId;
    }

    public void setLogisticNodeId(Long logisticNodeId) {
        this.logisticNodeId = logisticNodeId;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRegulatoryId() {
        return regulatoryId;
    }

    public void setRegulatoryId(Long regulatoryId) {
        this.regulatoryId = regulatoryId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setAllocationssStoreId(List allocationssStoreId) {
        this.allocationssStoreId=allocationssStoreId;
    }

    public List<Allocations> getAllocationssStoreId() {
        return allocationssStoreId;
    }

    public void setBidDeliStoressStoreId(List bidDeliStoressStoreId) {
        this.bidDeliStoressStoreId=bidDeliStoressStoreId;
    }

    public List<BidDeliStoresKey> getBidDeliStoressStoreId() {
        return bidDeliStoressStoreId;
    }

    public void setBillingPoliciessStoreId(List billingPoliciessStoreId) {
        this.billingPoliciessStoreId=billingPoliciessStoreId;
    }

    public List<BillingPolicies> getBillingPoliciessStoreId() {
        return billingPoliciessStoreId;
    }

    public void setBillingSettlementssStoreId(List billingSettlementssStoreId) {
        this.billingSettlementssStoreId=billingSettlementssStoreId;
    }

    public List<BillingSettlements> getBillingSettlementssStoreId() {
        return billingSettlementssStoreId;
    }

    public void setChargeItemssStoreId(List chargeItemssStoreId) {
        this.chargeItemssStoreId=chargeItemssStoreId;
    }

    public List<ChargeItems> getChargeItemssStoreId() {
        return chargeItemssStoreId;
    }

    public void setCollateralItemDetailssStoreId(List collateralItemDetailssStoreId) {
        this.collateralItemDetailssStoreId=collateralItemDetailssStoreId;
    }

    public List<CollateralItemDetails> getCollateralItemDetailssStoreId() {
        return collateralItemDetailssStoreId;
    }

    public void setCollateralSummariessStoreId(List collateralSummariessStoreId) {
        this.collateralSummariessStoreId=collateralSummariessStoreId;
    }

    public List<CollateralSummaries> getCollateralSummariessStoreId() {
        return collateralSummariessStoreId;
    }

    public void setEntrPurchDeliNotesStoreId(List entrPurchDeliNotesStoreId) {
        this.entrPurchDeliNotesStoreId=entrPurchDeliNotesStoreId;
    }

    public List<EntrPurchDeliNote> getEntrPurchDeliNotesStoreId() {
        return entrPurchDeliNotesStoreId;
    }

    public void setFinancingApplyDetailssStoreId(List financingApplyDetailssStoreId) {
        this.financingApplyDetailssStoreId=financingApplyDetailssStoreId;
    }

    public List<FinancingApplyDetails> getFinancingApplyDetailssStoreId() {
        return financingApplyDetailssStoreId;
    }

    public void setFinancingCreditStoressStoreId(List financingCreditStoressStoreId) {
        this.financingCreditStoressStoreId=financingCreditStoressStoreId;
    }

    public List<FinancingCreditStoresKey> getFinancingCreditStoressStoreId() {
        return financingCreditStoressStoreId;
    }

    public void setInventoryResourceDetailssStoreId(List inventoryResourceDetailssStoreId) {
        this.inventoryResourceDetailssStoreId=inventoryResourceDetailssStoreId;
    }

    public List<InventoryResourceDetails> getInventoryResourceDetailssStoreId() {
        return inventoryResourceDetailssStoreId;
    }

    public void setInventoryValuationssStoreId(List inventoryValuationssStoreId) {
        this.inventoryValuationssStoreId=inventoryValuationssStoreId;
    }

    public List<InventoryValuations> getInventoryValuationssStoreId() {
        return inventoryValuationssStoreId;
    }

    public void setLadingssStoreId(List ladingssStoreId) {
        this.ladingssStoreId=ladingssStoreId;
    }

    public List<Ladings> getLadingssStoreId() {
        return ladingssStoreId;
    }

    public void setMallssVirtualStoreId(List mallssVirtualStoreId) {
        this.mallssVirtualStoreId=mallssVirtualStoreId;
    }

    public List<Malls> getMallssVirtualStoreId() {
        return mallssVirtualStoreId;
    }

    public void setMallWarehousesStoreId(List mallWarehousesStoreId) {
        this.mallWarehousesStoreId=mallWarehousesStoreId;
    }

    public List<MallWarehouse> getMallWarehousesStoreId() {
        return mallWarehousesStoreId;
    }

    public void setPdasStoreId(List pdasStoreId) {
        this.pdasStoreId=pdasStoreId;
    }

    public List<Pda> getPdasStoreId() {
        return pdasStoreId;
    }

    public void setPhysicalValuationsStaticssStoreId(List physicalValuationsStaticssStoreId) {
        this.physicalValuationsStaticssStoreId=physicalValuationsStaticssStoreId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssStoreId() {
        return physicalValuationsStaticssStoreId;
    }

    public void setProcessMaterialsStoreId(List processMaterialsStoreId) {
        this.processMaterialsStoreId=processMaterialsStoreId;
    }

    public List<ProcessMaterial> getProcessMaterialsStoreId() {
        return processMaterialsStoreId;
    }

    public void setProductivityssStoreId(List productivityssStoreId) {
        this.productivityssStoreId=productivityssStoreId;
    }

    public List<Productivitys> getProductivityssStoreId() {
        return productivityssStoreId;
    }

    public void setResourceDetailssStoreId(List resourceDetailssStoreId) {
        this.resourceDetailssStoreId=resourceDetailssStoreId;
    }

    public List<ResourceDetails> getResourceDetailssStoreId() {
        return resourceDetailssStoreId;
    }

    public void setResourceSummariessStoreId(List resourceSummariessStoreId) {
        this.resourceSummariessStoreId=resourceSummariessStoreId;
    }

    public List<ResourceSummaries> getResourceSummariessStoreId() {
        return resourceSummariessStoreId;
    }

    public void setStoreCertCarriersStoreId(List storeCertCarriersStoreId) {
        this.storeCertCarriersStoreId=storeCertCarriersStoreId;
    }

    public List<StoreCertCarrierKey> getStoreCertCarriersStoreId() {
        return storeCertCarriersStoreId;
    }

    public void setStoreCompanyssStoreId(List storeCompanyssStoreId) {
        this.storeCompanyssStoreId=storeCompanyssStoreId;
    }

    public List<StoreCompanysKey> getStoreCompanyssStoreId() {
        return storeCompanyssStoreId;
    }

    public void setStoreJobssTransferStoreId(List storeJobssTransferStoreId) {
        this.storeJobssTransferStoreId=storeJobssTransferStoreId;
    }

    public List<StoreJobs> getStoreJobssTransferStoreId() {
        return storeJobssTransferStoreId;
    }

    public void setStoreJobssJobStoreId(List storeJobssJobStoreId) {
        this.storeJobssJobStoreId=storeJobssJobStoreId;
    }

    public List<StoreJobs> getStoreJobssJobStoreId() {
        return storeJobssJobStoreId;
    }

    public void setStoreJobDetailssStoreId(List storeJobDetailssStoreId) {
        this.storeJobDetailssStoreId=storeJobDetailssStoreId;
    }

    public List<StoreJobDetails> getStoreJobDetailssStoreId() {
        return storeJobDetailssStoreId;
    }

    public void setStoreJobFlowModessStoreId(List storeJobFlowModessStoreId) {
        this.storeJobFlowModessStoreId=storeJobFlowModessStoreId;
    }

    public List<StoreJobFlowModes> getStoreJobFlowModessStoreId() {
        return storeJobFlowModessStoreId;
    }

    public void setStorePowerssStoreId(List storePowerssStoreId) {
        this.storePowerssStoreId=storePowerssStoreId;
    }

    public List<StorePowersKey> getStorePowerssStoreId() {
        return storePowerssStoreId;
    }

    public void setTraderResourcessStoreId(List traderResourcessStoreId) {
        this.traderResourcessStoreId=traderResourcessStoreId;
    }

    public List<TraderResources> getTraderResourcessStoreId() {
        return traderResourcessStoreId;
    }

    public void setTrustDistributersStoreId(List trustDistributersStoreId) {
        this.trustDistributersStoreId=trustDistributersStoreId;
    }

    public List<TrustDistributerKey> getTrustDistributersStoreId() {
        return trustDistributersStoreId;
    }

    public void setCompanysOwnerId(Companys companysOwnerId) {
        this.companysOwnerId=companysOwnerId;
    }

    public Companys getCompanysOwnerId() {
        return companysOwnerId;
    }

    public void setCompanysRegulatoryId(Companys companysRegulatoryId) {
        this.companysRegulatoryId=companysRegulatoryId;
    }

    public Companys getCompanysRegulatoryId() {
        return companysRegulatoryId;
    }

    public void setCompanysOperatorId(Companys companysOperatorId) {
        this.companysOperatorId=companysOperatorId;
    }

    public Companys getCompanysOperatorId() {
        return companysOperatorId;
    }

    public void setLogisticsAddressLogisticNodeId(LogisticsAddress logisticsAddressLogisticNodeId) {
        this.logisticsAddressLogisticNodeId=logisticsAddressLogisticNodeId;
    }

    public LogisticsAddress getLogisticsAddressLogisticNodeId() {
        return logisticsAddressLogisticNodeId;
    }
}