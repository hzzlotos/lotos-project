package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class TruckType implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<VehicleTruckTypeKey> vehicleTruckTypesTruckTypeId = null;

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

    public void setVehicleTruckTypesTruckTypeId(List vehicleTruckTypesTruckTypeId) {
        this.vehicleTruckTypesTruckTypeId=vehicleTruckTypesTruckTypeId;
    }

    public List<VehicleTruckTypeKey> getVehicleTruckTypesTruckTypeId() {
        return vehicleTruckTypesTruckTypeId;
    }
}