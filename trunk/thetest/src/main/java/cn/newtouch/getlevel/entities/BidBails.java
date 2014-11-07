package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BidBails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long bidId;

    private Long comId;

    private BigDecimal money;

    private Date publishDate;

    private Long fundsId;

    private String description;

    private String type;

    private Long bidReturnDepositId;

    private Biddings biddingsBidId;

    private BidBailReturnApp bidBailReturnAppBidReturnDepositId;

    private Companys companysComId;

    private FundsFlowDetails fundsFlowDetailsFundsId;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getFundsId() {
        return fundsId;
    }

    public void setFundsId(Long fundsId) {
        this.fundsId = fundsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBidReturnDepositId() {
        return bidReturnDepositId;
    }

    public void setBidReturnDepositId(Long bidReturnDepositId) {
        this.bidReturnDepositId = bidReturnDepositId;
    }

    public void setBiddingsBidId(Biddings biddingsBidId) {
        this.biddingsBidId=biddingsBidId;
    }

    public Biddings getBiddingsBidId() {
        return biddingsBidId;
    }

    public void setBidBailReturnAppBidReturnDepositId(BidBailReturnApp bidBailReturnAppBidReturnDepositId) {
        this.bidBailReturnAppBidReturnDepositId=bidBailReturnAppBidReturnDepositId;
    }

    public BidBailReturnApp getBidBailReturnAppBidReturnDepositId() {
        return bidBailReturnAppBidReturnDepositId;
    }

    public void setCompanysComId(Companys companysComId) {
        this.companysComId=companysComId;
    }

    public Companys getCompanysComId() {
        return companysComId;
    }

    public void setFundsFlowDetailsFundsId(FundsFlowDetails fundsFlowDetailsFundsId) {
        this.fundsFlowDetailsFundsId=fundsFlowDetailsFundsId;
    }

    public FundsFlowDetails getFundsFlowDetailsFundsId() {
        return fundsFlowDetailsFundsId;
    }
}