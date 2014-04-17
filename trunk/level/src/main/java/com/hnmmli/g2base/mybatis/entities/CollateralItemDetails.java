package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class CollateralItemDetails extends CollateralItemDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private String collateralStoreBillCode;

    private Long storeId;

    private Long goodsMeasureId;

    private Allocations allocationsAllocationId;

    private CollateralItems collateralItemsCollateralItemId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    public String getCollateralStoreBillCode() {
        return collateralStoreBillCode;
    }

    public void setCollateralStoreBillCode(String collateralStoreBillCode) {
        this.collateralStoreBillCode = collateralStoreBillCode;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setAllocationsAllocationId(Allocations allocationsAllocationId) {
        this.allocationsAllocationId=allocationsAllocationId;
    }

    public Allocations getAllocationsAllocationId() {
        return allocationsAllocationId;
    }

    public void setCollateralItemsCollateralItemId(CollateralItems collateralItemsCollateralItemId) {
        this.collateralItemsCollateralItemId=collateralItemsCollateralItemId;
    }

    public CollateralItems getCollateralItemsCollateralItemId() {
        return collateralItemsCollateralItemId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
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