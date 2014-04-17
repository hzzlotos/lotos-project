package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class CollateralItems implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date pledgeDate;

    private Long financingCreditId;

    private String pledgeRequestCode;

    private String type;

    private Date createDate;

    private Long userId;

    private List<CollateralItemDetails> collateralItemDetailssCollateralItemId = null;

    private FinancingCredits financingCreditsFinancingCreditId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPledgeDate() {
        return pledgeDate;
    }

    public void setPledgeDate(Date pledgeDate) {
        this.pledgeDate = pledgeDate;
    }

    public Long getFinancingCreditId() {
        return financingCreditId;
    }

    public void setFinancingCreditId(Long financingCreditId) {
        this.financingCreditId = financingCreditId;
    }

    public String getPledgeRequestCode() {
        return pledgeRequestCode;
    }

    public void setPledgeRequestCode(String pledgeRequestCode) {
        this.pledgeRequestCode = pledgeRequestCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCollateralItemDetailssCollateralItemId(List collateralItemDetailssCollateralItemId) {
        this.collateralItemDetailssCollateralItemId=collateralItemDetailssCollateralItemId;
    }

    public List<CollateralItemDetails> getCollateralItemDetailssCollateralItemId() {
        return collateralItemDetailssCollateralItemId;
    }

    public void setFinancingCreditsFinancingCreditId(FinancingCredits financingCreditsFinancingCreditId) {
        this.financingCreditsFinancingCreditId=financingCreditsFinancingCreditId;
    }

    public FinancingCredits getFinancingCreditsFinancingCreditId() {
        return financingCreditsFinancingCreditId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}