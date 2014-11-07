package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class RealtimeTransCapacity extends RealtimeTransCapacityKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long driverUserId;

    private Driver driverDriverUserId;

    private LogisticsSolutions logisticsSolutionsLogisticsSolutionId;

    private Vehicles vehiclesVehicleId;

    public Long getDriverUserId() {
        return driverUserId;
    }

    public void setDriverUserId(Long driverUserId) {
        this.driverUserId = driverUserId;
    }

    public void setDriverDriverUserId(Driver driverDriverUserId) {
        this.driverDriverUserId=driverDriverUserId;
    }

    public Driver getDriverDriverUserId() {
        return driverDriverUserId;
    }

    public void setLogisticsSolutionsLogisticsSolutionId(LogisticsSolutions logisticsSolutionsLogisticsSolutionId) {
        this.logisticsSolutionsLogisticsSolutionId=logisticsSolutionsLogisticsSolutionId;
    }

    public LogisticsSolutions getLogisticsSolutionsLogisticsSolutionId() {
        return logisticsSolutionsLogisticsSolutionId;
    }

    public void setVehiclesVehicleId(Vehicles vehiclesVehicleId) {
        this.vehiclesVehicleId=vehiclesVehicleId;
    }

    public Vehicles getVehiclesVehicleId() {
        return vehiclesVehicleId;
    }
}