package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class FinancingCreditStores extends FinancingCreditStoresKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private FinancingCredits financingCreditsFinancingCreditId;

    private Stores storesStoreId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setFinancingCreditsFinancingCreditId(FinancingCredits financingCreditsFinancingCreditId) {
        this.financingCreditsFinancingCreditId=financingCreditsFinancingCreditId;
    }

    public FinancingCredits getFinancingCreditsFinancingCreditId() {
        return financingCreditsFinancingCreditId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}