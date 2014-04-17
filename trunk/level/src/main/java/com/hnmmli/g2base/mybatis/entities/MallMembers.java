package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class MallMembers extends MallMembersKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long memberLevelId;

    private String effectStatus;

    private Long settleComId;

    private String checkStatus;

    private String isAcceptBroker;

    private Long bankId;

    private Date applyDate;

    private String inviteStatus;

    private List<MallMembCrectAccounts> mallMembCrectAccountssMemberId = null;

    private List<MallMembCrectAccounts> mallMembCrectAccountssMallId = null;

    private Companys companysMallMemberId;

    private Companys companysSettleComId;

    private CompanyBankAccounts companyBankAccountsBankId;

    private Malls mallsMallId;

    private MallMemberLevels mallMemberLevelsMemberLevelId;

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getEffectStatus() {
        return effectStatus;
    }

    public void setEffectStatus(String effectStatus) {
        this.effectStatus = effectStatus;
    }

    public Long getSettleComId() {
        return settleComId;
    }

    public void setSettleComId(Long settleComId) {
        this.settleComId = settleComId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getIsAcceptBroker() {
        return isAcceptBroker;
    }

    public void setIsAcceptBroker(String isAcceptBroker) {
        this.isAcceptBroker = isAcceptBroker;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public void setMallMembCrectAccountssMemberId(List mallMembCrectAccountssMemberId) {
        this.mallMembCrectAccountssMemberId=mallMembCrectAccountssMemberId;
    }

    public List<MallMembCrectAccounts> getMallMembCrectAccountssMemberId() {
        return mallMembCrectAccountssMemberId;
    }

    public void setMallMembCrectAccountssMallId(List mallMembCrectAccountssMallId) {
        this.mallMembCrectAccountssMallId=mallMembCrectAccountssMallId;
    }

    public List<MallMembCrectAccounts> getMallMembCrectAccountssMallId() {
        return mallMembCrectAccountssMallId;
    }

    public void setCompanysMallMemberId(Companys companysMallMemberId) {
        this.companysMallMemberId=companysMallMemberId;
    }

    public Companys getCompanysMallMemberId() {
        return companysMallMemberId;
    }

    public void setCompanysSettleComId(Companys companysSettleComId) {
        this.companysSettleComId=companysSettleComId;
    }

    public Companys getCompanysSettleComId() {
        return companysSettleComId;
    }

    public void setCompanyBankAccountsBankId(CompanyBankAccounts companyBankAccountsBankId) {
        this.companyBankAccountsBankId=companyBankAccountsBankId;
    }

    public CompanyBankAccounts getCompanyBankAccountsBankId() {
        return companyBankAccountsBankId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setMallMemberLevelsMemberLevelId(MallMemberLevels mallMemberLevelsMemberLevelId) {
        this.mallMemberLevelsMemberLevelId=mallMemberLevelsMemberLevelId;
    }

    public MallMemberLevels getMallMemberLevelsMemberLevelId() {
        return mallMemberLevelsMemberLevelId;
    }
}