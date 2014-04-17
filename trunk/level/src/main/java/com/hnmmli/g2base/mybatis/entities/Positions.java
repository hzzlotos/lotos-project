package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Positions implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long companyId;

    private List<Roles> rolessPositionId = null;

    private Companys companysCompanyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setRolessPositionId(List rolessPositionId) {
        this.rolessPositionId=rolessPositionId;
    }

    public List<Roles> getRolessPositionId() {
        return rolessPositionId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }
}