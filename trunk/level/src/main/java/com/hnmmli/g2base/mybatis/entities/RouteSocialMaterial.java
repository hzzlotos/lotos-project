package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class RouteSocialMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String resourceName;

    private Long routeReceiptId;

    private String type;

    private String remark;

    private Long goodsMeasureId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private RouteReceipts routeReceiptsRouteReceiptId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Long getRouteReceiptId() {
        return routeReceiptId;
    }

    public void setRouteReceiptId(Long routeReceiptId) {
        this.routeReceiptId = routeReceiptId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setRouteReceiptsRouteReceiptId(RouteReceipts routeReceiptsRouteReceiptId) {
        this.routeReceiptsRouteReceiptId=routeReceiptsRouteReceiptId;
    }

    public RouteReceipts getRouteReceiptsRouteReceiptId() {
        return routeReceiptsRouteReceiptId;
    }
}