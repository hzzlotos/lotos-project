package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class AccountDifferentDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long accountStaticId;

    private Long differentAnalyzeId;

    private AccountValuationsStatics accountValuationsStaticsAccountStaticId;

    private DifferentAnalyzes differentAnalyzesDifferentAnalyzeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountStaticId() {
        return accountStaticId;
    }

    public void setAccountStaticId(Long accountStaticId) {
        this.accountStaticId = accountStaticId;
    }

    public Long getDifferentAnalyzeId() {
        return differentAnalyzeId;
    }

    public void setDifferentAnalyzeId(Long differentAnalyzeId) {
        this.differentAnalyzeId = differentAnalyzeId;
    }

    public void setAccountValuationsStaticsAccountStaticId(AccountValuationsStatics accountValuationsStaticsAccountStaticId) {
        this.accountValuationsStaticsAccountStaticId=accountValuationsStaticsAccountStaticId;
    }

    public AccountValuationsStatics getAccountValuationsStaticsAccountStaticId() {
        return accountValuationsStaticsAccountStaticId;
    }

    public void setDifferentAnalyzesDifferentAnalyzeId(DifferentAnalyzes differentAnalyzesDifferentAnalyzeId) {
        this.differentAnalyzesDifferentAnalyzeId=differentAnalyzesDifferentAnalyzeId;
    }

    public DifferentAnalyzes getDifferentAnalyzesDifferentAnalyzeId() {
        return differentAnalyzesDifferentAnalyzeId;
    }
}