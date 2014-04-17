package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class WarehouseMaterialDetails extends WarehouseMaterialDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private LogisOrderWareMaterial logisOrderWareMaterialLogisOrderWareId;

    private ResourceDetails resourceDetailsResourceDetailId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLogisOrderWareMaterialLogisOrderWareId(LogisOrderWareMaterial logisOrderWareMaterialLogisOrderWareId) {
        this.logisOrderWareMaterialLogisOrderWareId=logisOrderWareMaterialLogisOrderWareId;
    }

    public LogisOrderWareMaterial getLogisOrderWareMaterialLogisOrderWareId() {
        return logisOrderWareMaterialLogisOrderWareId;
    }

    public void setResourceDetailsResourceDetailId(ResourceDetails resourceDetailsResourceDetailId) {
        this.resourceDetailsResourceDetailId=resourceDetailsResourceDetailId;
    }

    public ResourceDetails getResourceDetailsResourceDetailId() {
        return resourceDetailsResourceDetailId;
    }
}