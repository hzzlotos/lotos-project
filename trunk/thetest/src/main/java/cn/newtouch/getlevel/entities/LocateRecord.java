package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LocateRecord implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Date localteDate;

    private Long localteDeviceId;

    private Long vehiclesId;

    private LocateDevice locateDeviceLocalteDeviceId;

    private Vehicles vehiclesVehiclesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Date getLocalteDate() {
        return localteDate;
    }

    public void setLocalteDate(Date localteDate) {
        this.localteDate = localteDate;
    }

    public Long getLocalteDeviceId() {
        return localteDeviceId;
    }

    public void setLocalteDeviceId(Long localteDeviceId) {
        this.localteDeviceId = localteDeviceId;
    }

    public Long getVehiclesId() {
        return vehiclesId;
    }

    public void setVehiclesId(Long vehiclesId) {
        this.vehiclesId = vehiclesId;
    }

    public void setLocateDeviceLocalteDeviceId(LocateDevice locateDeviceLocalteDeviceId) {
        this.locateDeviceLocalteDeviceId=locateDeviceLocalteDeviceId;
    }

    public LocateDevice getLocateDeviceLocalteDeviceId() {
        return locateDeviceLocalteDeviceId;
    }

    public void setVehiclesVehiclesId(Vehicles vehiclesVehiclesId) {
        this.vehiclesVehiclesId=vehiclesVehiclesId;
    }

    public Vehicles getVehiclesVehiclesId() {
        return vehiclesVehiclesId;
    }
}