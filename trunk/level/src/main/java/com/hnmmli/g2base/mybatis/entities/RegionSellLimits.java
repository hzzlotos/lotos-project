package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class RegionSellLimits extends RegionSellLimitsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal moneyUpper;

    private String effectStatus;

    private BigDecimal totalSaleDay;

    private LogisticsAddress logisticsAddressRegionId;

    private Malls mallsMallId;

    public BigDecimal getMoneyUpper() {
        return moneyUpper;
    }

    public void setMoneyUpper(BigDecimal moneyUpper) {
        this.moneyUpper = moneyUpper;
    }

    public String getEffectStatus() {
        return effectStatus;
    }

    public void setEffectStatus(String effectStatus) {
        this.effectStatus = effectStatus;
    }

    public BigDecimal getTotalSaleDay() {
        return totalSaleDay;
    }

    public void setTotalSaleDay(BigDecimal totalSaleDay) {
        this.totalSaleDay = totalSaleDay;
    }

    public void setLogisticsAddressRegionId(LogisticsAddress logisticsAddressRegionId) {
        this.logisticsAddressRegionId=logisticsAddressRegionId;
    }

    public LogisticsAddress getLogisticsAddressRegionId() {
        return logisticsAddressRegionId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}