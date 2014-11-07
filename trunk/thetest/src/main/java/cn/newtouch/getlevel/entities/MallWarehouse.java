package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MallWarehouse implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long mallId;

    private Long storeId;

    private BigDecimal moneyUperLimit;

    private String saleEnableStatus;

    private Date salesLimSetTime;

    private Long setLimUserid;

    private Long userId;

    private Date setDate;

    private Long status;

    private BigDecimal curAmountSell;

    private String deliveryType;

    private Malls mallsMallId;

    private Stores storesStoreId;

    private Users usersSetLimUserid;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getMoneyUperLimit() {
        return moneyUperLimit;
    }

    public void setMoneyUperLimit(BigDecimal moneyUperLimit) {
        this.moneyUperLimit = moneyUperLimit;
    }

    public String getSaleEnableStatus() {
        return saleEnableStatus;
    }

    public void setSaleEnableStatus(String saleEnableStatus) {
        this.saleEnableStatus = saleEnableStatus;
    }

    public Date getSalesLimSetTime() {
        return salesLimSetTime;
    }

    public void setSalesLimSetTime(Date salesLimSetTime) {
        this.salesLimSetTime = salesLimSetTime;
    }

    public Long getSetLimUserid() {
        return setLimUserid;
    }

    public void setSetLimUserid(Long setLimUserid) {
        this.setLimUserid = setLimUserid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public BigDecimal getCurAmountSell() {
        return curAmountSell;
    }

    public void setCurAmountSell(BigDecimal curAmountSell) {
        this.curAmountSell = curAmountSell;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersSetLimUserid(Users usersSetLimUserid) {
        this.usersSetLimUserid=usersSetLimUserid;
    }

    public Users getUsersSetLimUserid() {
        return usersSetLimUserid;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}