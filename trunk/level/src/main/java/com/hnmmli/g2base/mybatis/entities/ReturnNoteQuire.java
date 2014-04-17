package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class ReturnNoteQuire implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String descripction;

    private List<LogisticsOrders> logisticsOrderssReturnNoteId = null;

    private List<TransportDemands> transportDemandssTransDemandId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripction() {
        return descripction;
    }

    public void setDescripction(String descripction) {
        this.descripction = descripction;
    }

    public void setLogisticsOrderssReturnNoteId(List logisticsOrderssReturnNoteId) {
        this.logisticsOrderssReturnNoteId=logisticsOrderssReturnNoteId;
    }

    public List<LogisticsOrders> getLogisticsOrderssReturnNoteId() {
        return logisticsOrderssReturnNoteId;
    }

    public void setTransportDemandssTransDemandId(List transportDemandssTransDemandId) {
        this.transportDemandssTransDemandId=transportDemandssTransDemandId;
    }

    public List<TransportDemands> getTransportDemandssTransDemandId() {
        return transportDemandssTransDemandId;
    }
}