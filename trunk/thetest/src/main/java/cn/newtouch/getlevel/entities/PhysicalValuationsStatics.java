package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class PhysicalValuationsStatics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date productionDate;

    private Date productBatch;

    private String recordHeavyId;

    private Date createDate;

    private Date updateDate;

    private String skuCode;

    private String qrCode;

    private String isRegulatory;

    private Long inventoryValuationId;

    private Long storeId;

    private Long allocationId;

    private Long resourceId;

    private Long tradingCompanyId;

    private Long cargoCompanyId;

    private List<PhysicalDifferentDetails> physicalDifferentDetailssPhysicalStaticId = null;

    private Allocations allocationsAllocationId;

    private Companys companysCargoCompanyId;

    private Companys companysTradingCompanyId;

    private InventoryValuations inventoryValuationsInventoryValuationId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(Date productBatch) {
        this.productBatch = productBatch;
    }

    public String getRecordHeavyId() {
        return recordHeavyId;
    }

    public void setRecordHeavyId(String recordHeavyId) {
        this.recordHeavyId = recordHeavyId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getIsRegulatory() {
        return isRegulatory;
    }

    public void setIsRegulatory(String isRegulatory) {
        this.isRegulatory = isRegulatory;
    }

    public Long getInventoryValuationId() {
        return inventoryValuationId;
    }

    public void setInventoryValuationId(Long inventoryValuationId) {
        this.inventoryValuationId = inventoryValuationId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getTradingCompanyId() {
        return tradingCompanyId;
    }

    public void setTradingCompanyId(Long tradingCompanyId) {
        this.tradingCompanyId = tradingCompanyId;
    }

    public Long getCargoCompanyId() {
        return cargoCompanyId;
    }

    public void setCargoCompanyId(Long cargoCompanyId) {
        this.cargoCompanyId = cargoCompanyId;
    }

    public void setPhysicalDifferentDetailssPhysicalStaticId(List physicalDifferentDetailssPhysicalStaticId) {
        this.physicalDifferentDetailssPhysicalStaticId=physicalDifferentDetailssPhysicalStaticId;
    }

    public List<PhysicalDifferentDetails> getPhysicalDifferentDetailssPhysicalStaticId() {
        return physicalDifferentDetailssPhysicalStaticId;
    }

    public void setAllocationsAllocationId(Allocations allocationsAllocationId) {
        this.allocationsAllocationId=allocationsAllocationId;
    }

    public Allocations getAllocationsAllocationId() {
        return allocationsAllocationId;
    }

    public void setCompanysCargoCompanyId(Companys companysCargoCompanyId) {
        this.companysCargoCompanyId=companysCargoCompanyId;
    }

    public Companys getCompanysCargoCompanyId() {
        return companysCargoCompanyId;
    }

    public void setCompanysTradingCompanyId(Companys companysTradingCompanyId) {
        this.companysTradingCompanyId=companysTradingCompanyId;
    }

    public Companys getCompanysTradingCompanyId() {
        return companysTradingCompanyId;
    }

    public void setInventoryValuationsInventoryValuationId(InventoryValuations inventoryValuationsInventoryValuationId) {
        this.inventoryValuationsInventoryValuationId=inventoryValuationsInventoryValuationId;
    }

    public InventoryValuations getInventoryValuationsInventoryValuationId() {
        return inventoryValuationsInventoryValuationId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}