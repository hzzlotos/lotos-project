package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Ladings implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String ladCode;

    private String status;

    private Date activeDate;

    private String dispachType;

    private Long storeId;

    private Long userId;

    private Long transportId;

    private List<DeliveryPersons> deliveryPersonssLadingId = null;

    private List<LadingDetails> ladingDetailssLadId = null;

    private List<LadingLog> ladingLogsLadingId = null;

    private List<StoreJobs> storeJobssLadingId = null;

    private LogisticsOrders logisticsOrdersTransportId;

    private Stores storesStoreId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLadCode() {
        return ladCode;
    }

    public void setLadCode(String ladCode) {
        this.ladCode = ladCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getDispachType() {
        return dispachType;
    }

    public void setDispachType(String dispachType) {
        this.dispachType = dispachType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public void setDeliveryPersonssLadingId(List deliveryPersonssLadingId) {
        this.deliveryPersonssLadingId=deliveryPersonssLadingId;
    }

    public List<DeliveryPersons> getDeliveryPersonssLadingId() {
        return deliveryPersonssLadingId;
    }

    public void setLadingDetailssLadId(List ladingDetailssLadId) {
        this.ladingDetailssLadId=ladingDetailssLadId;
    }

    public List<LadingDetails> getLadingDetailssLadId() {
        return ladingDetailssLadId;
    }

    public void setLadingLogsLadingId(List ladingLogsLadingId) {
        this.ladingLogsLadingId=ladingLogsLadingId;
    }

    public List<LadingLog> getLadingLogsLadingId() {
        return ladingLogsLadingId;
    }

    public void setStoreJobssLadingId(List storeJobssLadingId) {
        this.storeJobssLadingId=storeJobssLadingId;
    }

    public List<StoreJobs> getStoreJobssLadingId() {
        return storeJobssLadingId;
    }

    public void setLogisticsOrdersTransportId(LogisticsOrders logisticsOrdersTransportId) {
        this.logisticsOrdersTransportId=logisticsOrdersTransportId;
    }

    public LogisticsOrders getLogisticsOrdersTransportId() {
        return logisticsOrdersTransportId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}