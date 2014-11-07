package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class TransportBilling implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal lightPrice;

    private BigDecimal weightPrice;

    private BigDecimal entirePrice;

    private BigDecimal totalPrice;

    private BigDecimal settleTotalMoney;

    private BigDecimal goodsValue;

    private Long freightPricingId;

    private Long transSettleId;

    private List<LogisticsOrders> logisticsOrderssTransBillId = null;

    private List<RouteReceipts> routeReceiptssCarrierBillId = null;

    private List<TransportDemandResponses> transportDemandResponsessTransBillId = null;

    private List<TransBillSubjectKey> transBillSubjectsTransBillId = null;

    private FreightPricing freightPricingFreightPricingId;

    private TransSettleCompany transSettleCompanyTransSettleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLightPrice() {
        return lightPrice;
    }

    public void setLightPrice(BigDecimal lightPrice) {
        this.lightPrice = lightPrice;
    }

    public BigDecimal getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(BigDecimal weightPrice) {
        this.weightPrice = weightPrice;
    }

    public BigDecimal getEntirePrice() {
        return entirePrice;
    }

    public void setEntirePrice(BigDecimal entirePrice) {
        this.entirePrice = entirePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getSettleTotalMoney() {
        return settleTotalMoney;
    }

    public void setSettleTotalMoney(BigDecimal settleTotalMoney) {
        this.settleTotalMoney = settleTotalMoney;
    }

    public BigDecimal getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(BigDecimal goodsValue) {
        this.goodsValue = goodsValue;
    }

    public Long getFreightPricingId() {
        return freightPricingId;
    }

    public void setFreightPricingId(Long freightPricingId) {
        this.freightPricingId = freightPricingId;
    }

    public Long getTransSettleId() {
        return transSettleId;
    }

    public void setTransSettleId(Long transSettleId) {
        this.transSettleId = transSettleId;
    }

    public void setLogisticsOrderssTransBillId(List logisticsOrderssTransBillId) {
        this.logisticsOrderssTransBillId=logisticsOrderssTransBillId;
    }

    public List<LogisticsOrders> getLogisticsOrderssTransBillId() {
        return logisticsOrderssTransBillId;
    }

    public void setRouteReceiptssCarrierBillId(List routeReceiptssCarrierBillId) {
        this.routeReceiptssCarrierBillId=routeReceiptssCarrierBillId;
    }

    public List<RouteReceipts> getRouteReceiptssCarrierBillId() {
        return routeReceiptssCarrierBillId;
    }

    public void setTransportDemandResponsessTransBillId(List transportDemandResponsessTransBillId) {
        this.transportDemandResponsessTransBillId=transportDemandResponsessTransBillId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessTransBillId() {
        return transportDemandResponsessTransBillId;
    }

    public void setTransBillSubjectsTransBillId(List transBillSubjectsTransBillId) {
        this.transBillSubjectsTransBillId=transBillSubjectsTransBillId;
    }

    public List<TransBillSubjectKey> getTransBillSubjectsTransBillId() {
        return transBillSubjectsTransBillId;
    }

    public void setFreightPricingFreightPricingId(FreightPricing freightPricingFreightPricingId) {
        this.freightPricingFreightPricingId=freightPricingFreightPricingId;
    }

    public FreightPricing getFreightPricingFreightPricingId() {
        return freightPricingFreightPricingId;
    }

    public void setTransSettleCompanyTransSettleId(TransSettleCompany transSettleCompanyTransSettleId) {
        this.transSettleCompanyTransSettleId=transSettleCompanyTransSettleId;
    }

    public TransSettleCompany getTransSettleCompanyTransSettleId() {
        return transSettleCompanyTransSettleId;
    }
}