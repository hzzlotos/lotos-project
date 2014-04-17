package com.hnmmli.g2base.mybatis.entities;

public class VehicleTruckTypeKey {
    private Long truckTypeId;

    private Long vehicleId;

    public Long getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(Long truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}