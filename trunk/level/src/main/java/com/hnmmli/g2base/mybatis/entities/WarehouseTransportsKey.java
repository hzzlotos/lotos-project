package com.hnmmli.g2base.mybatis.entities;

public class WarehouseTransportsKey {
    private Long lofisticsOrderId;

    private Long storeJobId;

    public Long getLofisticsOrderId() {
        return lofisticsOrderId;
    }

    public void setLofisticsOrderId(Long lofisticsOrderId) {
        this.lofisticsOrderId = lofisticsOrderId;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
    }
}