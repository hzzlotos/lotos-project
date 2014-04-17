package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class MemberlvSettle implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long menberLevelId;

    private Long mallId;

    private String settleType;

    private String effetiveRange;

    private Date actionDate;

    private Long companyId;

    private List<InstalmentTatics> instalmentTaticssMemblvSettleId = null;

    private Companys companysCompanyId;

    private Malls mallsMallId;

    private MallMemberLevels mallMemberLevelsMenberLevelId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenberLevelId() {
        return menberLevelId;
    }

    public void setMenberLevelId(Long menberLevelId) {
        this.menberLevelId = menberLevelId;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getEffetiveRange() {
        return effetiveRange;
    }

    public void setEffetiveRange(String effetiveRange) {
        this.effetiveRange = effetiveRange;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setInstalmentTaticssMemblvSettleId(List instalmentTaticssMemblvSettleId) {
        this.instalmentTaticssMemblvSettleId=instalmentTaticssMemblvSettleId;
    }

    public List<InstalmentTatics> getInstalmentTaticssMemblvSettleId() {
        return instalmentTaticssMemblvSettleId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setMallMemberLevelsMenberLevelId(MallMemberLevels mallMemberLevelsMenberLevelId) {
        this.mallMemberLevelsMenberLevelId=mallMemberLevelsMenberLevelId;
    }

    public MallMemberLevels getMallMemberLevelsMenberLevelId() {
        return mallMemberLevelsMenberLevelId;
    }
}