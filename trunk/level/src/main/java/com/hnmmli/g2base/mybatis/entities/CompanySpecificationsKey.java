package com.hnmmli.g2base.mybatis.entities;

public class CompanySpecificationsKey {
    private Long companyId;

    private Long specificationId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }
}