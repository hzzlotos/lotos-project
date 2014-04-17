package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class BidDeposits implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long bidId;

    private Long comId;

    private Long resDefId;

    private String type;

    private String description;

    private Long bailReturnAppId;

    private Biddings biddingsBidId;

    private BidBailReturnApp bidBailReturnAppBailReturnAppId;

    private Companys companysComId;

    private Resources resourcesResDefId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBailReturnAppId() {
        return bailReturnAppId;
    }

    public void setBailReturnAppId(Long bailReturnAppId) {
        this.bailReturnAppId = bailReturnAppId;
    }

    public void setBiddingsBidId(Biddings biddingsBidId) {
        this.biddingsBidId=biddingsBidId;
    }

    public Biddings getBiddingsBidId() {
        return biddingsBidId;
    }

    public void setBidBailReturnAppBailReturnAppId(BidBailReturnApp bidBailReturnAppBailReturnAppId) {
        this.bidBailReturnAppBailReturnAppId=bidBailReturnAppBailReturnAppId;
    }

    public BidBailReturnApp getBidBailReturnAppBailReturnAppId() {
        return bidBailReturnAppBailReturnAppId;
    }

    public void setCompanysComId(Companys companysComId) {
        this.companysComId=companysComId;
    }

    public Companys getCompanysComId() {
        return companysComId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }
}