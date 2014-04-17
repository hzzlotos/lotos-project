package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsulTacticsLogs extends ConsulTacticsLogsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal primitiveUnitPrice;

    private BigDecimal premium;

    private BigDecimal revivionUnitPrice;

    private Date effetiveDate;

    private Orders ordersOrderId;

    private TraderResources traderResourcesResourceId;

    private Users usersUserId;

    public BigDecimal getPrimitiveUnitPrice() {
        return primitiveUnitPrice;
    }

    public void setPrimitiveUnitPrice(BigDecimal primitiveUnitPrice) {
        this.primitiveUnitPrice = primitiveUnitPrice;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getRevivionUnitPrice() {
        return revivionUnitPrice;
    }

    public void setRevivionUnitPrice(BigDecimal revivionUnitPrice) {
        this.revivionUnitPrice = revivionUnitPrice;
    }

    public Date getEffetiveDate() {
        return effetiveDate;
    }

    public void setEffetiveDate(Date effetiveDate) {
        this.effetiveDate = effetiveDate;
    }

    public void setOrdersOrderId(Orders ordersOrderId) {
        this.ordersOrderId=ordersOrderId;
    }

    public Orders getOrdersOrderId() {
        return ordersOrderId;
    }

    public void setTraderResourcesResourceId(TraderResources traderResourcesResourceId) {
        this.traderResourcesResourceId=traderResourcesResourceId;
    }

    public TraderResources getTraderResourcesResourceId() {
        return traderResourcesResourceId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}