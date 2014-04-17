package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class BusinPaths implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String pathType;

    private String effetiveType;

    private Date effetBeginDate;

    private Date effetEndDate;

    private Date activiDate;

    private Long upComId;

    private Long downComId;

    private Long userId;

    private List<TrustPurchase> trustPurchasesBusinesspathId = null;

    private Companys companysUpComId;

    private Companys companysDownComId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    public String getEffetiveType() {
        return effetiveType;
    }

    public void setEffetiveType(String effetiveType) {
        this.effetiveType = effetiveType;
    }

    public Date getEffetBeginDate() {
        return effetBeginDate;
    }

    public void setEffetBeginDate(Date effetBeginDate) {
        this.effetBeginDate = effetBeginDate;
    }

    public Date getEffetEndDate() {
        return effetEndDate;
    }

    public void setEffetEndDate(Date effetEndDate) {
        this.effetEndDate = effetEndDate;
    }

    public Date getActiviDate() {
        return activiDate;
    }

    public void setActiviDate(Date activiDate) {
        this.activiDate = activiDate;
    }

    public Long getUpComId() {
        return upComId;
    }

    public void setUpComId(Long upComId) {
        this.upComId = upComId;
    }

    public Long getDownComId() {
        return downComId;
    }

    public void setDownComId(Long downComId) {
        this.downComId = downComId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTrustPurchasesBusinesspathId(List trustPurchasesBusinesspathId) {
        this.trustPurchasesBusinesspathId=trustPurchasesBusinesspathId;
    }

    public List<TrustPurchase> getTrustPurchasesBusinesspathId() {
        return trustPurchasesBusinesspathId;
    }

    public void setCompanysUpComId(Companys companysUpComId) {
        this.companysUpComId=companysUpComId;
    }

    public Companys getCompanysUpComId() {
        return companysUpComId;
    }

    public void setCompanysDownComId(Companys companysDownComId) {
        this.companysDownComId=companysDownComId;
    }

    public Companys getCompanysDownComId() {
        return companysDownComId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}