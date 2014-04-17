package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Banks implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String code;

    private List<CollateralSummaries> collateralSummariessBankId = null;

    private List<CompanyBankAccounts> companyBankAccountssBankId = null;

    private List<FinancingCredits> financingCreditssBankId = null;

    private List<FinancingDeadlines> financingDeadlinessBankId = null;

    private List<FinancingTypes> financingTypessBankId = null;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCollateralSummariessBankId(List collateralSummariessBankId) {
        this.collateralSummariessBankId=collateralSummariessBankId;
    }

    public List<CollateralSummaries> getCollateralSummariessBankId() {
        return collateralSummariessBankId;
    }

    public void setCompanyBankAccountssBankId(List companyBankAccountssBankId) {
        this.companyBankAccountssBankId=companyBankAccountssBankId;
    }

    public List<CompanyBankAccounts> getCompanyBankAccountssBankId() {
        return companyBankAccountssBankId;
    }

    public void setFinancingCreditssBankId(List financingCreditssBankId) {
        this.financingCreditssBankId=financingCreditssBankId;
    }

    public List<FinancingCredits> getFinancingCreditssBankId() {
        return financingCreditssBankId;
    }

    public void setFinancingDeadlinessBankId(List financingDeadlinessBankId) {
        this.financingDeadlinessBankId=financingDeadlinessBankId;
    }

    public List<FinancingDeadlines> getFinancingDeadlinessBankId() {
        return financingDeadlinessBankId;
    }

    public void setFinancingTypessBankId(List financingTypessBankId) {
        this.financingTypessBankId=financingTypessBankId;
    }

    public List<FinancingTypes> getFinancingTypessBankId() {
        return financingTypessBankId;
    }
}