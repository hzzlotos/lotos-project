package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class RouteWarehMaterials implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long routeId;

    private Long logisOrderWareResId;

    private String resourceName;

    private String type;

    private String remark;

    private Long goodsMeasureId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private LogisOrderWareMaterial logisOrderWareMaterialLogisOrderWareResId;

    private RouteReceipts routeReceiptsRouteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getLogisOrderWareResId() {
        return logisOrderWareResId;
    }

    public void setLogisOrderWareResId(Long logisOrderWareResId) {
        this.logisOrderWareResId = logisOrderWareResId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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

    public void setLogisOrderWareMaterialLogisOrderWareResId(LogisOrderWareMaterial logisOrderWareMaterialLogisOrderWareResId) {
        this.logisOrderWareMaterialLogisOrderWareResId=logisOrderWareMaterialLogisOrderWareResId;
    }

    public LogisOrderWareMaterial getLogisOrderWareMaterialLogisOrderWareResId() {
        return logisOrderWareMaterialLogisOrderWareResId;
    }

    public void setRouteReceiptsRouteId(RouteReceipts routeReceiptsRouteId) {
        this.routeReceiptsRouteId=routeReceiptsRouteId;
    }

    public RouteReceipts getRouteReceiptsRouteId() {
        return routeReceiptsRouteId;
    }
}