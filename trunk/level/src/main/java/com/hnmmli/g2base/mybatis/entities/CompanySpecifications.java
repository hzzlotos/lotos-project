package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class CompanySpecifications extends CompanySpecificationsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Companys companysCompanyId;

    private Specifications specificationsSpecificationId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setSpecificationsSpecificationId(Specifications specificationsSpecificationId) {
        this.specificationsSpecificationId=specificationsSpecificationId;
    }

    public Specifications getSpecificationsSpecificationId() {
        return specificationsSpecificationId;
    }
}