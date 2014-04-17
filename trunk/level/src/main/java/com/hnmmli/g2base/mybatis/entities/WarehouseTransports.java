package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class WarehouseTransports extends WarehouseTransportsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private LogisticsOrders logisticsOrdersLofisticsOrderId;

    private StoreJobs storeJobsStoreJobId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLogisticsOrdersLofisticsOrderId(LogisticsOrders logisticsOrdersLofisticsOrderId) {
        this.logisticsOrdersLofisticsOrderId=logisticsOrdersLofisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLofisticsOrderId() {
        return logisticsOrdersLofisticsOrderId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }
}