package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class FreightPricing implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<TransportBilling> transportBillingsFreightPricingId = null;

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

    public void setTransportBillingsFreightPricingId(List transportBillingsFreightPricingId) {
        this.transportBillingsFreightPricingId=transportBillingsFreightPricingId;
    }

    public List<TransportBilling> getTransportBillingsFreightPricingId() {
        return transportBillingsFreightPricingId;
    }
}