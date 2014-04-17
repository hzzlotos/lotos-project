package com.hnmmli.g2base.mybatis.entities;

public class OrderQuotasKey {
    private Long fundsId;

    private Long orderId;

    public Long getFundsId() {
        return fundsId;
    }

    public void setFundsId(Long fundsId) {
        this.fundsId = fundsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}