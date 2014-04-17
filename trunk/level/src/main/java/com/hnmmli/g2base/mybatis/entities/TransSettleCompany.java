package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class TransSettleCompany implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<TransportBilling> transportBillingsTransSettleId = null;

    private List<TransportDemands> transportDemandssPayCompanyId = null;

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

    public void setTransportBillingsTransSettleId(List transportBillingsTransSettleId) {
        this.transportBillingsTransSettleId=transportBillingsTransSettleId;
    }

    public List<TransportBilling> getTransportBillingsTransSettleId() {
        return transportBillingsTransSettleId;
    }

    public void setTransportDemandssPayCompanyId(List transportDemandssPayCompanyId) {
        this.transportDemandssPayCompanyId=transportDemandssPayCompanyId;
    }

    public List<TransportDemands> getTransportDemandssPayCompanyId() {
        return transportDemandssPayCompanyId;
    }
}