package com.hnmmli.g2base.mybatis.entities;

public class CollateralItemDetailsKey {
    private Long allocationId;

    private Long collateralItemId;

    private Long resourceId;

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public Long getCollateralItemId() {
        return collateralItemId;
    }

    public void setCollateralItemId(Long collateralItemId) {
        this.collateralItemId = collateralItemId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}