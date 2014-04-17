package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class ValuationsResources implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resourceId;

    private Long valuationId;

    private InventoryValuations inventoryValuationsValuationId;

    private Resources resourcesResourceId;

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

    public Long getValuationId() {
        return valuationId;
    }

    public void setValuationId(Long valuationId) {
        this.valuationId = valuationId;
    }

    public void setInventoryValuationsValuationId(InventoryValuations inventoryValuationsValuationId) {
        this.inventoryValuationsValuationId=inventoryValuationsValuationId;
    }

    public InventoryValuations getInventoryValuationsValuationId() {
        return inventoryValuationsValuationId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }
}