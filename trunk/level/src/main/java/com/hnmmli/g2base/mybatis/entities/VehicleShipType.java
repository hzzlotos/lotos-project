package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class VehicleShipType extends VehicleShipTypeKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private ShipType shipTypeShipTypeId;

    private Vehicles vehiclesVehicleId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setShipTypeShipTypeId(ShipType shipTypeShipTypeId) {
        this.shipTypeShipTypeId=shipTypeShipTypeId;
    }

    public ShipType getShipTypeShipTypeId() {
        return shipTypeShipTypeId;
    }

    public void setVehiclesVehicleId(Vehicles vehiclesVehicleId) {
        this.vehiclesVehicleId=vehiclesVehicleId;
    }

    public Vehicles getVehiclesVehicleId() {
        return vehiclesVehicleId;
    }
}