package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Productivitys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date deliveryDate;

    private String settleStatus;

    private Long companyId;

    private Long resourceId;

    private String measureType;

    private Long userId;

    private Long takenGmId;

    private Long storeId;

    private List<OrderDetailsKey> orderDetailssProduId = null;

    private List<ProductiveFulfill> productiveFulfillsProductiveId = null;

    private List<TraderResources> traderResourcessPrudutityId = null;

    private Companys companysCompanyId;

    private Resources resourcesResourceId;

    private Resources resourcesTakenGmId;

    private Stores storesStoreId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTakenGmId() {
        return takenGmId;
    }

    public void setTakenGmId(Long takenGmId) {
        this.takenGmId = takenGmId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setOrderDetailssProduId(List orderDetailssProduId) {
        this.orderDetailssProduId=orderDetailssProduId;
    }

    public List<OrderDetailsKey> getOrderDetailssProduId() {
        return orderDetailssProduId;
    }

    public void setProductiveFulfillsProductiveId(List productiveFulfillsProductiveId) {
        this.productiveFulfillsProductiveId=productiveFulfillsProductiveId;
    }

    public List<ProductiveFulfill> getProductiveFulfillsProductiveId() {
        return productiveFulfillsProductiveId;
    }

    public void setTraderResourcessPrudutityId(List traderResourcessPrudutityId) {
        this.traderResourcessPrudutityId=traderResourcessPrudutityId;
    }

    public List<TraderResources> getTraderResourcessPrudutityId() {
        return traderResourcessPrudutityId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }

    public void setResourcesTakenGmId(Resources resourcesTakenGmId) {
        this.resourcesTakenGmId=resourcesTakenGmId;
    }

    public Resources getResourcesTakenGmId() {
        return resourcesTakenGmId;
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