package com.hnmmli.g2base.mybatis.entities;

public class LogisticsMemberKey {
    private Long logisticsCompanyId;

    private Long memberCompanyId;

    public Long getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(Long logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public Long getMemberCompanyId() {
        return memberCompanyId;
    }

    public void setMemberCompanyId(Long memberCompanyId) {
        this.memberCompanyId = memberCompanyId;
    }
}