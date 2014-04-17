package com.hnmmli.g2base.mybatis.entities;

public class CompanyBrandsKey {
    private Long brandId;

    private Long companyId;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}