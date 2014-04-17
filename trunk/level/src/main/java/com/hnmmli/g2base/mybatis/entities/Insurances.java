package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Insurances implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String insuranceCompany;

    private String insuranceName;

    private List<InsurancePolicys> insurancePolicyssInsuranceId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public void setInsurancePolicyssInsuranceId(List insurancePolicyssInsuranceId) {
        this.insurancePolicyssInsuranceId=insurancePolicyssInsuranceId;
    }

    public List<InsurancePolicys> getInsurancePolicyssInsuranceId() {
        return insurancePolicyssInsuranceId;
    }
}