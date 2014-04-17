package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class LogisticsMember extends LogisticsMemberKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private String memberLevel;

    private String status;

    private Date affiliateDate;

    private Companys companysMemberCompanyId;

    private LogisticsCompanys logisticsCompanysLogisticsCompanyId;

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAffiliateDate() {
        return affiliateDate;
    }

    public void setAffiliateDate(Date affiliateDate) {
        this.affiliateDate = affiliateDate;
    }

    public void setCompanysMemberCompanyId(Companys companysMemberCompanyId) {
        this.companysMemberCompanyId=companysMemberCompanyId;
    }

    public Companys getCompanysMemberCompanyId() {
        return companysMemberCompanyId;
    }

    public void setLogisticsCompanysLogisticsCompanyId(LogisticsCompanys logisticsCompanysLogisticsCompanyId) {
        this.logisticsCompanysLogisticsCompanyId=logisticsCompanysLogisticsCompanyId;
    }

    public LogisticsCompanys getLogisticsCompanysLogisticsCompanyId() {
        return logisticsCompanysLogisticsCompanyId;
    }
}