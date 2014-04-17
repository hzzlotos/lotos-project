package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class EntrPurchPlanCount implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date purchaseDate;

    private BigDecimal totalPrice;

    private Long userId;

    private Long companyId;

    private List<TrustPurchAgrees> trustPurchAgreessPurchPlanId = null;

    private List<TrustPurchPlanDetailsKey> trustPurchPlanDetailssTrpPerforId = null;

    private Companys companysCompanyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setTrustPurchAgreessPurchPlanId(List trustPurchAgreessPurchPlanId) {
        this.trustPurchAgreessPurchPlanId=trustPurchAgreessPurchPlanId;
    }

    public List<TrustPurchAgrees> getTrustPurchAgreessPurchPlanId() {
        return trustPurchAgreessPurchPlanId;
    }

    public void setTrustPurchPlanDetailssTrpPerforId(List trustPurchPlanDetailssTrpPerforId) {
        this.trustPurchPlanDetailssTrpPerforId=trustPurchPlanDetailssTrpPerforId;
    }

    public List<TrustPurchPlanDetailsKey> getTrustPurchPlanDetailssTrpPerforId() {
        return trustPurchPlanDetailssTrpPerforId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}