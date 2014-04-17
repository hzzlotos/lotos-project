package com.hnmmli.g2base.mybatis.entities;

public class VehicleShipTypeKey {
    private Long shipTypeId;

    private Long vehicleId;

    public Long getShipTypeId() {
        return shipTypeId;
    }

    public void setShipTypeId(Long shipTypeId) {
        this.shipTypeId = shipTypeId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}