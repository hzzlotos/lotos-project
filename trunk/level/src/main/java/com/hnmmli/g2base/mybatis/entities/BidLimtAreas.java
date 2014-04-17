package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class BidLimtAreas extends BidLimtAreasKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Biddings biddingsBidId;

    private LogisticsAddress logisticsAddressRegionId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBiddingsBidId(Biddings biddingsBidId) {
        this.biddingsBidId=biddingsBidId;
    }

    public Biddings getBiddingsBidId() {
        return biddingsBidId;
    }

    public void setLogisticsAddressRegionId(LogisticsAddress logisticsAddressRegionId) {
        this.logisticsAddressRegionId=logisticsAddressRegionId;
    }

    public LogisticsAddress getLogisticsAddressRegionId() {
        return logisticsAddressRegionId;
    }
}