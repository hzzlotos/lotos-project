package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class StoreJobDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resourceId;

    private Long tradingCompanyId;

    private Long storeId;

    private Date jobDate;

    private String action;

    private Long isRegulatoryAudit;

    private Long isRegulatory;

    private Long storeJobId;

    private String recordHeavyId;

    private Long allocationId;

    private Long cargoCompanyId;

    private Date createDate;

    private Date updateDate;

    private Long measureGoodsId;

    private Long finishedMeasureGoodsId;

    private List<QualityBookDetails> qualityBookDetailssStoreJobDetailId = null;

    private List<ResourceDetails> resourceDetailssStoreJobDetailsId = null;

    private Allocations allocationsAllocationId;

    private Companys companysTradingCompanyId;

    private Companys companysCargoCompanyId;

    private GoodsMeasures goodsMeasuresMeasureGoodsId;

    private GoodsMeasures goodsMeasuresFinishedMeasureGoodsId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    private StoreJobs storeJobsStoreJobId;

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

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getIsRegulatoryAudit() {
        return isRegulatoryAudit;
    }

    public void setIsRegulatoryAudit(Long isRegulatoryAudit) {
        this.isRegulatoryAudit = isRegulatoryAudit;
    }

    public Long getIsRegulatory() {
        return isRegulatory;
    }

    public void setIsRegulatory(Long isRegulatory) {
        this.isRegulatory = isRegulatory;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
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

    public Long getMeasureGoodsId() {
        return measureGoodsId;
    }

    public void setMeasureGoodsId(Long measureGoodsId) {
        this.measureGoodsId = measureGoodsId;
    }

    public Long getFinishedMeasureGoodsId() {
        return finishedMeasureGoodsId;
    }

    public void setFinishedMeasureGoodsId(Long finishedMeasureGoodsId) {
        this.finishedMeasureGoodsId = finishedMeasureGoodsId;
    }

    public void setQualityBookDetailssStoreJobDetailId(List qualityBookDetailssStoreJobDetailId) {
        this.qualityBookDetailssStoreJobDetailId=qualityBookDetailssStoreJobDetailId;
    }

    public List<QualityBookDetails> getQualityBookDetailssStoreJobDetailId() {
        return qualityBookDetailssStoreJobDetailId;
    }

    public void setResourceDetailssStoreJobDetailsId(List resourceDetailssStoreJobDetailsId) {
        this.resourceDetailssStoreJobDetailsId=resourceDetailssStoreJobDetailsId;
    }

    public List<ResourceDetails> getResourceDetailssStoreJobDetailsId() {
        return resourceDetailssStoreJobDetailsId;
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

    public void setGoodsMeasuresMeasureGoodsId(GoodsMeasures goodsMeasuresMeasureGoodsId) {
        this.goodsMeasuresMeasureGoodsId=goodsMeasuresMeasureGoodsId;
    }

    public GoodsMeasures getGoodsMeasuresMeasureGoodsId() {
        return goodsMeasuresMeasureGoodsId;
    }

    public void setGoodsMeasuresFinishedMeasureGoodsId(GoodsMeasures goodsMeasuresFinishedMeasureGoodsId) {
        this.goodsMeasuresFinishedMeasureGoodsId=goodsMeasuresFinishedMeasureGoodsId;
    }

    public GoodsMeasures getGoodsMeasuresFinishedMeasureGoodsId() {
        return goodsMeasuresFinishedMeasureGoodsId;
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

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }
}