package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class LocateDevice implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String deviceNo;

    private String deviceName;

    private String deviceType;

    private String status;

    private List<LocateRecord> locateRecordsLocalteDeviceId = null;

    private List<Vehicles> vehiclessVehicleId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocateRecordsLocalteDeviceId(List locateRecordsLocalteDeviceId) {
        this.locateRecordsLocalteDeviceId=locateRecordsLocalteDeviceId;
    }

    public List<LocateRecord> getLocateRecordsLocalteDeviceId() {
        return locateRecordsLocalteDeviceId;
    }

    public void setVehiclessVehicleId(List vehiclessVehicleId) {
        this.vehiclessVehicleId=vehiclessVehicleId;
    }

    public List<Vehicles> getVehiclessVehicleId() {
        return vehiclessVehicleId;
    }
}