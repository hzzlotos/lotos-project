package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class BidDeliStores extends BidDeliStoresKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Biddings biddingsBidId;

    private Stores storesStoreId;

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

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}