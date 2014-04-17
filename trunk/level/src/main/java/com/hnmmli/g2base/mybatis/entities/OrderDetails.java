package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetails extends OrderDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal pactUnitPrice;

    private BigDecimal pactTotalPrice;

    private BigDecimal unitPrice;

    private BigDecimal settlePrice;

    private BigDecimal settlePriceAj;

    private String settlePriceAjExp;

    private BigDecimal produFinish;

    private Long produId;

    private Long goodsMeasureId;

    private Long regionId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private LogisticsAddress logisticsAddressRegionId;

    private Orders ordersOrderId;

    private Productivitys productivitysProduId;

    private TraderResources traderResourcesTradeId;

    public BigDecimal getPactUnitPrice() {
        return pactUnitPrice;
    }

    public void setPactUnitPrice(BigDecimal pactUnitPrice) {
        this.pactUnitPrice = pactUnitPrice;
    }

    public BigDecimal getPactTotalPrice() {
        return pactTotalPrice;
    }

    public void setPactTotalPrice(BigDecimal pactTotalPrice) {
        this.pactTotalPrice = pactTotalPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public BigDecimal getSettlePriceAj() {
        return settlePriceAj;
    }

    public void setSettlePriceAj(BigDecimal settlePriceAj) {
        this.settlePriceAj = settlePriceAj;
    }

    public String getSettlePriceAjExp() {
        return settlePriceAjExp;
    }

    public void setSettlePriceAjExp(String settlePriceAjExp) {
        this.settlePriceAjExp = settlePriceAjExp;
    }

    public BigDecimal getProduFinish() {
        return produFinish;
    }

    public void setProduFinish(BigDecimal produFinish) {
        this.produFinish = produFinish;
    }

    public Long getProduId() {
        return produId;
    }

    public void setProduId(Long produId) {
        this.produId = produId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setLogisticsAddressRegionId(LogisticsAddress logisticsAddressRegionId) {
        this.logisticsAddressRegionId=logisticsAddressRegionId;
    }

    public LogisticsAddress getLogisticsAddressRegionId() {
        return logisticsAddressRegionId;
    }

    public void setOrdersOrderId(Orders ordersOrderId) {
        this.ordersOrderId=ordersOrderId;
    }

    public Orders getOrdersOrderId() {
        return ordersOrderId;
    }

    public void setProductivitysProduId(Productivitys productivitysProduId) {
        this.productivitysProduId=productivitysProduId;
    }

    public Productivitys getProductivitysProduId() {
        return productivitysProduId;
    }

    public void setTraderResourcesTradeId(TraderResources traderResourcesTradeId) {
        this.traderResourcesTradeId=traderResourcesTradeId;
    }

    public TraderResources getTraderResourcesTradeId() {
        return traderResourcesTradeId;
    }
}