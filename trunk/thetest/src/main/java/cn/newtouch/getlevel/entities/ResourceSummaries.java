package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class ResourceSummaries implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long storeId;

    private Long companyId;

    private Long resourceId;

    private Date updateDate;

    private String type;

    private Long storeMeasureGoodsId;

    private Long freezeMeasureGoodsId;

    private String summaryType;

    private Long allocationsId;

    private String measureGoodsId;

    private String isRegulatory;

    private Allocations allocationsAllocationsId;

    private Companys companysCompanyId;

    private GoodsMeasures goodsMeasuresStoreMeasureGoodsId;

    private GoodsMeasures goodsMeasuresFreezeMeasureGoodsId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStoreMeasureGoodsId() {
        return storeMeasureGoodsId;
    }

    public void setStoreMeasureGoodsId(Long storeMeasureGoodsId) {
        this.storeMeasureGoodsId = storeMeasureGoodsId;
    }

    public Long getFreezeMeasureGoodsId() {
        return freezeMeasureGoodsId;
    }

    public void setFreezeMeasureGoodsId(Long freezeMeasureGoodsId) {
        this.freezeMeasureGoodsId = freezeMeasureGoodsId;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }

    public Long getAllocationsId() {
        return allocationsId;
    }

    public void setAllocationsId(Long allocationsId) {
        this.allocationsId = allocationsId;
    }

    public String getMeasureGoodsId() {
        return measureGoodsId;
    }

    public void setMeasureGoodsId(String measureGoodsId) {
        this.measureGoodsId = measureGoodsId;
    }

    public String getIsRegulatory() {
        return isRegulatory;
    }

    public void setIsRegulatory(String isRegulatory) {
        this.isRegulatory = isRegulatory;
    }

    public void setAllocationsAllocationsId(Allocations allocationsAllocationsId) {
        this.allocationsAllocationsId=allocationsAllocationsId;
    }

    public Allocations getAllocationsAllocationsId() {
        return allocationsAllocationsId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setGoodsMeasuresStoreMeasureGoodsId(GoodsMeasures goodsMeasuresStoreMeasureGoodsId) {
        this.goodsMeasuresStoreMeasureGoodsId=goodsMeasuresStoreMeasureGoodsId;
    }

    public GoodsMeasures getGoodsMeasuresStoreMeasureGoodsId() {
        return goodsMeasuresStoreMeasureGoodsId;
    }

    public void setGoodsMeasuresFreezeMeasureGoodsId(GoodsMeasures goodsMeasuresFreezeMeasureGoodsId) {
        this.goodsMeasuresFreezeMeasureGoodsId=goodsMeasuresFreezeMeasureGoodsId;
    }

    public GoodsMeasures getGoodsMeasuresFreezeMeasureGoodsId() {
        return goodsMeasuresFreezeMeasureGoodsId;
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