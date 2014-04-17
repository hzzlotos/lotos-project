package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class LogisticsBranch implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long addressId;

    private Long companyId;

    private String branchName;

    private String telphone;

    private String departure;

    private String receiving;

    private String delivery;

    private String arayacak;

    private String fax;

    private List<LogisticsOrders> logisticsOrderssShipNetId = null;

    private List<LogisticsOrders> logisticsOrderssPickupNetId = null;

    private List<TransportDemandResponses> transportDemandResponsessShipNetId = null;

    private List<TransportDemandResponses> transportDemandResponsessPickupNetId = null;

    private Companys companysCompanyId;

    private LogisticsAddress logisticsAddressAddressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getReceiving() {
        return receiving;
    }

    public void setReceiving(String receiving) {
        this.receiving = receiving;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getArayacak() {
        return arayacak;
    }

    public void setArayacak(String arayacak) {
        this.arayacak = arayacak;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setLogisticsOrderssShipNetId(List logisticsOrderssShipNetId) {
        this.logisticsOrderssShipNetId=logisticsOrderssShipNetId;
    }

    public List<LogisticsOrders> getLogisticsOrderssShipNetId() {
        return logisticsOrderssShipNetId;
    }

    public void setLogisticsOrderssPickupNetId(List logisticsOrderssPickupNetId) {
        this.logisticsOrderssPickupNetId=logisticsOrderssPickupNetId;
    }

    public List<LogisticsOrders> getLogisticsOrderssPickupNetId() {
        return logisticsOrderssPickupNetId;
    }

    public void setTransportDemandResponsessShipNetId(List transportDemandResponsessShipNetId) {
        this.transportDemandResponsessShipNetId=transportDemandResponsessShipNetId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessShipNetId() {
        return transportDemandResponsessShipNetId;
    }

    public void setTransportDemandResponsessPickupNetId(List transportDemandResponsessPickupNetId) {
        this.transportDemandResponsessPickupNetId=transportDemandResponsessPickupNetId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessPickupNetId() {
        return transportDemandResponsessPickupNetId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setLogisticsAddressAddressId(LogisticsAddress logisticsAddressAddressId) {
        this.logisticsAddressAddressId=logisticsAddressAddressId;
    }

    public LogisticsAddress getLogisticsAddressAddressId() {
        return logisticsAddressAddressId;
    }
}