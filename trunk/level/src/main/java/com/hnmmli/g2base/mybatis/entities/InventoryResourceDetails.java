package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class InventoryResourceDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date productionDate;

    private String productBatch;

    private String recordHeavyId;

    private Date createDate;

    private Date updateDate;

    private String skuCode;

    private String qrCode;

    private String isRegulatory;

    private Long resourcesId;

    private Long tradingCompanyId;

    private Long cargoCompanyId;

    private Long allocationId;

    private Long storeId;

    private Allocations allocationsAllocationId;

    private Companys companysTradingCompanyId;

    private Companys companysCargoCompanyId;

    private Resources resourcesResourcesId;

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

    public String getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(String productBatch) {
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

    public Long getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Long resourcesId) {
        this.resourcesId = resourcesId;
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

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setAllocationsAllocationId(Allocations allocationsAllocationId) {
        this.allocationsAllocationId=allocationsAllocationId;
    }

    public Allocations getAllocationsAllocationId() {
        return allocationsAllocationId;
    }

    public void setCompanysTradingCompanyId(Companys companysTradingCompanyId) {
        this.companysTradingCompanyId=companysTradingCompanyId;
    }

    public Companys getCompanysTradingCompanyId() {
        return companysTradingCompanyId;
    }

    public void setCompanysCargoCompanyId(Companys companysCargoCompanyId) {
        this.companysCargoCompanyId=companysCargoCompanyId;
    }

    public Companys getCompanysCargoCompanyId() {
        return companysCargoCompanyId;
    }

    public void setResourcesResourcesId(Resources resourcesResourcesId) {
        this.resourcesResourcesId=resourcesResourcesId;
    }

    public Resources getResourcesResourcesId() {
        return resourcesResourcesId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}