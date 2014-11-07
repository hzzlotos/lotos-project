package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class ShipPickupType implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<LogisticsOrders> logisticsOrderssResDefId = null;

    private List<ReceivingSolutionsKey> receivingSolutionssReceivingId = null;

    private List<TransportDemands> transportDemandssShipPickupId = null;

    private List<TransportDemandResponses> transportDemandResponsessShipPickupId = null;

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

    public void setLogisticsOrderssResDefId(List logisticsOrderssResDefId) {
        this.logisticsOrderssResDefId=logisticsOrderssResDefId;
    }

    public List<LogisticsOrders> getLogisticsOrderssResDefId() {
        return logisticsOrderssResDefId;
    }

    public void setReceivingSolutionssReceivingId(List receivingSolutionssReceivingId) {
        this.receivingSolutionssReceivingId=receivingSolutionssReceivingId;
    }

    public List<ReceivingSolutionsKey> getReceivingSolutionssReceivingId() {
        return receivingSolutionssReceivingId;
    }

    public void setTransportDemandssShipPickupId(List transportDemandssShipPickupId) {
        this.transportDemandssShipPickupId=transportDemandssShipPickupId;
    }

    public List<TransportDemands> getTransportDemandssShipPickupId() {
        return transportDemandssShipPickupId;
    }

    public void setTransportDemandResponsessShipPickupId(List transportDemandResponsessShipPickupId) {
        this.transportDemandResponsessShipPickupId=transportDemandResponsessShipPickupId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessShipPickupId() {
        return transportDemandResponsessShipPickupId;
    }
}