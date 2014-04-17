package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class BidBailReturnApp implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long sponsorUserid;

    private Long sponsorComId;

    private Date publishDate;

    private Long verifyUserid;

    private Long conComId;

    private Date verifyDate;

    private Long platAuditUserid;

    private Date platAuditDate;

    private List<BidBails> bidBailssBidReturnDepositId = null;

    private List<BidDeposits> bidDepositssBailReturnAppId = null;

    private Companys companysSponsorComId;

    private Companys companysConComId;

    private Users usersPlatAuditUserid;

    private Users usersSponsorUserid;

    private Users usersVerifyUserid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSponsorUserid() {
        return sponsorUserid;
    }

    public void setSponsorUserid(Long sponsorUserid) {
        this.sponsorUserid = sponsorUserid;
    }

    public Long getSponsorComId() {
        return sponsorComId;
    }

    public void setSponsorComId(Long sponsorComId) {
        this.sponsorComId = sponsorComId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getVerifyUserid() {
        return verifyUserid;
    }

    public void setVerifyUserid(Long verifyUserid) {
        this.verifyUserid = verifyUserid;
    }

    public Long getConComId() {
        return conComId;
    }

    public void setConComId(Long conComId) {
        this.conComId = conComId;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public Long getPlatAuditUserid() {
        return platAuditUserid;
    }

    public void setPlatAuditUserid(Long platAuditUserid) {
        this.platAuditUserid = platAuditUserid;
    }

    public Date getPlatAuditDate() {
        return platAuditDate;
    }

    public void setPlatAuditDate(Date platAuditDate) {
        this.platAuditDate = platAuditDate;
    }

    public void setBidBailssBidReturnDepositId(List bidBailssBidReturnDepositId) {
        this.bidBailssBidReturnDepositId=bidBailssBidReturnDepositId;
    }

    public List<BidBails> getBidBailssBidReturnDepositId() {
        return bidBailssBidReturnDepositId;
    }

    public void setBidDepositssBailReturnAppId(List bidDepositssBailReturnAppId) {
        this.bidDepositssBailReturnAppId=bidDepositssBailReturnAppId;
    }

    public List<BidDeposits> getBidDepositssBailReturnAppId() {
        return bidDepositssBailReturnAppId;
    }

    public void setCompanysSponsorComId(Companys companysSponsorComId) {
        this.companysSponsorComId=companysSponsorComId;
    }

    public Companys getCompanysSponsorComId() {
        return companysSponsorComId;
    }

    public void setCompanysConComId(Companys companysConComId) {
        this.companysConComId=companysConComId;
    }

    public Companys getCompanysConComId() {
        return companysConComId;
    }

    public void setUsersPlatAuditUserid(Users usersPlatAuditUserid) {
        this.usersPlatAuditUserid=usersPlatAuditUserid;
    }

    public Users getUsersPlatAuditUserid() {
        return usersPlatAuditUserid;
    }

    public void setUsersSponsorUserid(Users usersSponsorUserid) {
        this.usersSponsorUserid=usersSponsorUserid;
    }

    public Users getUsersSponsorUserid() {
        return usersSponsorUserid;
    }

    public void setUsersVerifyUserid(Users usersVerifyUserid) {
        this.usersVerifyUserid=usersVerifyUserid;
    }

    public Users getUsersVerifyUserid() {
        return usersVerifyUserid;
    }
}