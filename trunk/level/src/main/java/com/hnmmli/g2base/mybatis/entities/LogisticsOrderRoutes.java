package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class LogisticsOrderRoutes extends LogisticsOrderRoutesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private LogisticsOrders logisticsOrdersLogisticsOrderId;

    private RouteReceipts routeReceiptsRouteReceiptId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLogisticsOrdersLogisticsOrderId(LogisticsOrders logisticsOrdersLogisticsOrderId) {
        this.logisticsOrdersLogisticsOrderId=logisticsOrdersLogisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsOrderId() {
        return logisticsOrdersLogisticsOrderId;
    }

    public void setRouteReceiptsRouteReceiptId(RouteReceipts routeReceiptsRouteReceiptId) {
        this.routeReceiptsRouteReceiptId=routeReceiptsRouteReceiptId;
    }

    public RouteReceipts getRouteReceiptsRouteReceiptId() {
        return routeReceiptsRouteReceiptId;
    }
}