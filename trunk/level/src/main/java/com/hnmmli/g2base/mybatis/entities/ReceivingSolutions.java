package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class ReceivingSolutions extends ReceivingSolutionsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private LogisticsSolutions logisticsSolutionsLogisticsSolutionsId;

    private ShipPickupType shipPickupTypeReceivingId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLogisticsSolutionsLogisticsSolutionsId(LogisticsSolutions logisticsSolutionsLogisticsSolutionsId) {
        this.logisticsSolutionsLogisticsSolutionsId=logisticsSolutionsLogisticsSolutionsId;
    }

    public LogisticsSolutions getLogisticsSolutionsLogisticsSolutionsId() {
        return logisticsSolutionsLogisticsSolutionsId;
    }

    public void setShipPickupTypeReceivingId(ShipPickupType shipPickupTypeReceivingId) {
        this.shipPickupTypeReceivingId=shipPickupTypeReceivingId;
    }

    public ShipPickupType getShipPickupTypeReceivingId() {
        return shipPickupTypeReceivingId;
    }
}