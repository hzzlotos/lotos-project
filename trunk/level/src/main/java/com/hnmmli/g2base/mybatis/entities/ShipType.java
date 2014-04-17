package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class ShipType implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<VehicleShipTypeKey> vehicleShipTypesShipTypeId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVehicleShipTypesShipTypeId(List vehicleShipTypesShipTypeId) {
        this.vehicleShipTypesShipTypeId=vehicleShipTypesShipTypeId;
    }

    public List<VehicleShipTypeKey> getVehicleShipTypesShipTypeId() {
        return vehicleShipTypesShipTypeId;
    }
}