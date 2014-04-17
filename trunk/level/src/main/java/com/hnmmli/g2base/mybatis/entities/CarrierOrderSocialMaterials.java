package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class CarrierOrderSocialMaterials implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String resouceName;

    private Long logisticsOrderId;

    private Long goodsMeasureId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private LogisticsOrders logisticsOrdersLogisticsOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResouceName() {
        return resouceName;
    }

    public void setResouceName(String resouceName) {
        this.resouceName = resouceName;
    }

    public Long getLogisticsOrderId() {
        return logisticsOrderId;
    }

    public void setLogisticsOrderId(Long logisticsOrderId) {
        this.logisticsOrderId = logisticsOrderId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setLogisticsOrdersLogisticsOrderId(LogisticsOrders logisticsOrdersLogisticsOrderId) {
        this.logisticsOrdersLogisticsOrderId=logisticsOrdersLogisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsOrderId() {
        return logisticsOrdersLogisticsOrderId;
    }
}