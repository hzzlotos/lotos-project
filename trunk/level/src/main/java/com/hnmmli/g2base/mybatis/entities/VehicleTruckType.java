package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class VehicleTruckType extends VehicleTruckTypeKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private TruckType truckTypeTruckTypeId;

    private Vehicles vehiclesVehicleId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTruckTypeTruckTypeId(TruckType truckTypeTruckTypeId) {
        this.truckTypeTruckTypeId=truckTypeTruckTypeId;
    }

    public TruckType getTruckTypeTruckTypeId() {
        return truckTypeTruckTypeId;
    }

    public void setVehiclesVehicleId(Vehicles vehiclesVehicleId) {
        this.vehiclesVehicleId=vehiclesVehicleId;
    }

    public Vehicles getVehiclesVehicleId() {
        return vehiclesVehicleId;
    }
}