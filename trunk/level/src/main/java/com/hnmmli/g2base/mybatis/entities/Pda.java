package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class Pda implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String instrumentNo;

    private Date appupdateDate;

    private String useStatus;

    private Long updateNum;

    private Date registerDate;

    private Long storeId;

    private Long appId;

    private Long userId;

    private PdaApplication pdaApplicationAppId;

    private Stores storesStoreId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrumentNo() {
        return instrumentNo;
    }

    public void setInstrumentNo(String instrumentNo) {
        this.instrumentNo = instrumentNo;
    }

    public Date getAppupdateDate() {
        return appupdateDate;
    }

    public void setAppupdateDate(Date appupdateDate) {
        this.appupdateDate = appupdateDate;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public Long getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(Long updateNum) {
        this.updateNum = updateNum;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPdaApplicationAppId(PdaApplication pdaApplicationAppId) {
        this.pdaApplicationAppId=pdaApplicationAppId;
    }

    public PdaApplication getPdaApplicationAppId() {
        return pdaApplicationAppId;
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