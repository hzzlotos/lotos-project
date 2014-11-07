package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class LineTactics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<LogisticsOrders> logisticsOrderssLineTacticsId = null;

    private List<LogisticsSolutions> logisticsSolutionssLineTaticsId = null;

    private List<RouteReceipts> routeReceiptssLineTacticsId = null;

    private List<TransportDemands> transportDemandssLineTacticId = null;

    private List<TransportDemandResponses> transportDemandResponsessLineTactiscId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogisticsOrderssLineTacticsId(List logisticsOrderssLineTacticsId) {
        this.logisticsOrderssLineTacticsId=logisticsOrderssLineTacticsId;
    }

    public List<LogisticsOrders> getLogisticsOrderssLineTacticsId() {
        return logisticsOrderssLineTacticsId;
    }

    public void setLogisticsSolutionssLineTaticsId(List logisticsSolutionssLineTaticsId) {
        this.logisticsSolutionssLineTaticsId=logisticsSolutionssLineTaticsId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssLineTaticsId() {
        return logisticsSolutionssLineTaticsId;
    }

    public void setRouteReceiptssLineTacticsId(List routeReceiptssLineTacticsId) {
        this.routeReceiptssLineTacticsId=routeReceiptssLineTacticsId;
    }

    public List<RouteReceipts> getRouteReceiptssLineTacticsId() {
        return routeReceiptssLineTacticsId;
    }

    public void setTransportDemandssLineTacticId(List transportDemandssLineTacticId) {
        this.transportDemandssLineTacticId=transportDemandssLineTacticId;
    }

    public List<TransportDemands> getTransportDemandssLineTacticId() {
        return transportDemandssLineTacticId;
    }

    public void setTransportDemandResponsessLineTactiscId(List transportDemandResponsessLineTactiscId) {
        this.transportDemandResponsessLineTactiscId=transportDemandResponsessLineTactiscId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessLineTactiscId() {
        return transportDemandResponsessLineTactiscId;
    }
}