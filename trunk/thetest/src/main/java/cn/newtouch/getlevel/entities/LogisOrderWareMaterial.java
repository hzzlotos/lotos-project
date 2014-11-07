package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class LogisOrderWareMaterial implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsOrderId;

    private String sourceName;

    private Long resourceId;

    private Long goodsMeasureId;

    private List<RouteWarehMaterials> routeWarehMaterialssLogisOrderWareResId = null;

    private List<WarehouseMaterialDetailsKey> warehouseMaterialDetailssLogisOrderWareId = null;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private LogisticsOrders logisticsOrdersLogisticsOrderId;

    private Resources resourcesResourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsOrderId() {
        return logisticsOrderId;
    }

    public void setLogisticsOrderId(Long logisticsOrderId) {
        this.logisticsOrderId = logisticsOrderId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setRouteWarehMaterialssLogisOrderWareResId(List routeWarehMaterialssLogisOrderWareResId) {
        this.routeWarehMaterialssLogisOrderWareResId=routeWarehMaterialssLogisOrderWareResId;
    }

    public List<RouteWarehMaterials> getRouteWarehMaterialssLogisOrderWareResId() {
        return routeWarehMaterialssLogisOrderWareResId;
    }

    public void setWarehouseMaterialDetailssLogisOrderWareId(List warehouseMaterialDetailssLogisOrderWareId) {
        this.warehouseMaterialDetailssLogisOrderWareId=warehouseMaterialDetailssLogisOrderWareId;
    }

    public List<WarehouseMaterialDetailsKey> getWarehouseMaterialDetailssLogisOrderWareId() {
        return warehouseMaterialDetailssLogisOrderWareId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setLogisticsOrdersLogisticsOrderId(LogisticsOrders logisticsOrdersLogisticsOrderId) {
        this.logisticsOrdersLogisticsOrderId=logisticsOrdersLogisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsOrderId() {
        return logisticsOrdersLogisticsOrderId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }
}