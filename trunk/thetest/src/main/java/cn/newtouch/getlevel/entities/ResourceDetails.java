package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class ResourceDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resourceId;

    private Date productionDate;

    private String productBatch;

    private Long tradingCompanyId;

    private Long storeId;

    private String recordHeavyId;

    private Long allocationId;

    private Long cargoCompanyId;

    private Date createDate;

    private Date updateDate;

    private Long storeJobDetailsId;

    private String skuCode;

    private String qrCode;

    private String isRegulatory;

    private List<ResodOwnUpHistorys> resodOwnUpHistoryssResourceDetailId = null;

    private List<ResoAlloUpLogs> resoAlloUpLogssResourceDetailId = null;

    private List<WarehouseMaterialDetailsKey> warehouseMaterialDetailssResourceDetailId = null;

    private Allocations allocationsAllocationId;

    private Companys companysCargoCompanyId;

    private Companys companysTradingCompanyId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    private StoreJobDetails storeJobDetailsStoreJobDetailsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
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

    public Long getTradingCompanyId() {
        return tradingCompanyId;
    }

    public void setTradingCompanyId(Long tradingCompanyId) {
        this.tradingCompanyId = tradingCompanyId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getRecordHeavyId() {
        return recordHeavyId;
    }

    public void setRecordHeavyId(String recordHeavyId) {
        this.recordHeavyId = recordHeavyId;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getCargoCompanyId() {
        return cargoCompanyId;
    }

    public void setCargoCompanyId(Long cargoCompanyId) {
        this.cargoCompanyId = cargoCompanyId;
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

    public Long getStoreJobDetailsId() {
        return storeJobDetailsId;
    }

    public void setStoreJobDetailsId(Long storeJobDetailsId) {
        this.storeJobDetailsId = storeJobDetailsId;
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

    public void setResodOwnUpHistoryssResourceDetailId(List resodOwnUpHistoryssResourceDetailId) {
        this.resodOwnUpHistoryssResourceDetailId=resodOwnUpHistoryssResourceDetailId;
    }

    public List<ResodOwnUpHistorys> getResodOwnUpHistoryssResourceDetailId() {
        return resodOwnUpHistoryssResourceDetailId;
    }

    public void setResoAlloUpLogssResourceDetailId(List resoAlloUpLogssResourceDetailId) {
        this.resoAlloUpLogssResourceDetailId=resoAlloUpLogssResourceDetailId;
    }

    public List<ResoAlloUpLogs> getResoAlloUpLogssResourceDetailId() {
        return resoAlloUpLogssResourceDetailId;
    }

    public void setWarehouseMaterialDetailssResourceDetailId(List warehouseMaterialDetailssResourceDetailId) {
        this.warehouseMaterialDetailssResourceDetailId=warehouseMaterialDetailssResourceDetailId;
    }

    public List<WarehouseMaterialDetailsKey> getWarehouseMaterialDetailssResourceDetailId() {
        return warehouseMaterialDetailssResourceDetailId;
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

    public void setStoreJobDetailsStoreJobDetailsId(StoreJobDetails storeJobDetailsStoreJobDetailsId) {
        this.storeJobDetailsStoreJobDetailsId=storeJobDetailsStoreJobDetailsId;
    }

    public StoreJobDetails getStoreJobDetailsStoreJobDetailsId() {
        return storeJobDetailsStoreJobDetailsId;
    }
}