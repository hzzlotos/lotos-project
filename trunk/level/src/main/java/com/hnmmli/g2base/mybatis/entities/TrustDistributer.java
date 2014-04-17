package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class TrustDistributer extends TrustDistributerKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long userId;

    private Malls mallsMallId;

    private Stores storesStoreId;

    private Users usersUserId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}