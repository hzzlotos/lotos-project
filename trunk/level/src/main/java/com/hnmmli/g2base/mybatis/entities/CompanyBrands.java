package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class CompanyBrands extends CompanyBrandsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Brands brandsBrandId;

    private Companys companysCompanyId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBrandsBrandId(Brands brandsBrandId) {
        this.brandsBrandId=brandsBrandId;
    }

    public Brands getBrandsBrandId() {
        return brandsBrandId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }
}