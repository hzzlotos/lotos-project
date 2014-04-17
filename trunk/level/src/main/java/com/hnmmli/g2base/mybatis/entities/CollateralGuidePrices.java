package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class CollateralGuidePrices implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal platformGuidePrice;

    private BigDecimal bankCostControl;

    private Long addressId;

    private Long resourceTypeId;

    private LogisticsAddress logisticsAddressAddressId;

    private ResourceTypes resourceTypesResourceTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPlatformGuidePrice() {
        return platformGuidePrice;
    }

    public void setPlatformGuidePrice(BigDecimal platformGuidePrice) {
        this.platformGuidePrice = platformGuidePrice;
    }

    public BigDecimal getBankCostControl() {
        return bankCostControl;
    }

    public void setBankCostControl(BigDecimal bankCostControl) {
        this.bankCostControl = bankCostControl;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public void setLogisticsAddressAddressId(LogisticsAddress logisticsAddressAddressId) {
        this.logisticsAddressAddressId=logisticsAddressAddressId;
    }

    public LogisticsAddress getLogisticsAddressAddressId() {
        return logisticsAddressAddressId;
    }

    public void setResourceTypesResourceTypeId(ResourceTypes resourceTypesResourceTypeId) {
        this.resourceTypesResourceTypeId=resourceTypesResourceTypeId;
    }

    public ResourceTypes getResourceTypesResourceTypeId() {
        return resourceTypesResourceTypeId;
    }
}