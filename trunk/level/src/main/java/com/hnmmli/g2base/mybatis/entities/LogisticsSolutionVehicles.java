package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class LogisticsSolutionVehicles extends LogisticsSolutionVehiclesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private LogisticsSolutions logisticsSolutionsLogisticsSolutionId;

    private Vehicles vehiclesVehicleId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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