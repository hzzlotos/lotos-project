package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class RouteTemplates implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsSolutionId;

    private Long destinationId;

    private Long originId;

    private BigDecimal plannedTime;

    private BigDecimal distance;

    private List<EletricReceipt> eletricReceiptsRouteReceiptId = null;

    private LogisticsAddress logisticsAddressOriginId;

    private LogisticsAddress logisticsAddressDestinationId;

    private LogisticsSolutions logisticsSolutionsLogisticsSolutionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsSolutionId() {
        return logisticsSolutionId;
    }

    public void setLogisticsSolutionId(Long logisticsSolutionId) {
        this.logisticsSolutionId = logisticsSolutionId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public BigDecimal getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(BigDecimal plannedTime) {
        this.plannedTime = plannedTime;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public void setEletricReceiptsRouteReceiptId(List eletricReceiptsRouteReceiptId) {
        this.eletricReceiptsRouteReceiptId=eletricReceiptsRouteReceiptId;
    }

    public List<EletricReceipt> getEletricReceiptsRouteReceiptId() {
        return eletricReceiptsRouteReceiptId;
    }

    public void setLogisticsAddressOriginId(LogisticsAddress logisticsAddressOriginId) {
        this.logisticsAddressOriginId=logisticsAddressOriginId;
    }

    public LogisticsAddress getLogisticsAddressOriginId() {
        return logisticsAddressOriginId;
    }

    public void setLogisticsAddressDestinationId(LogisticsAddress logisticsAddressDestinationId) {
        this.logisticsAddressDestinationId=logisticsAddressDestinationId;
    }

    public LogisticsAddress getLogisticsAddressDestinationId() {
        return logisticsAddressDestinationId;
    }

    public void setLogisticsSolutionsLogisticsSolutionId(LogisticsSolutions logisticsSolutionsLogisticsSolutionId) {
        this.logisticsSolutionsLogisticsSolutionId=logisticsSolutionsLogisticsSolutionId;
    }

    public LogisticsSolutions getLogisticsSolutionsLogisticsSolutionId() {
        return logisticsSolutionsLogisticsSolutionId;
    }
}