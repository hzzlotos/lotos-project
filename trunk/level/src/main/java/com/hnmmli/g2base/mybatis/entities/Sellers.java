package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Sellers implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String ismainaccount;

    private Long companyId;

    private Long settlementmain;

    private Long mallid;

    private Long settlementmbaid;

    private String isAcceptOrder;

    private String status;

    private List<ConsultUsersKey> consultUserssSellerId = null;

    private Companys companysCompanyId;

    private Companys companysSettlementmain;

    private CompanyBankAccounts companyBankAccountsSettlementmbaid;

    private Malls mallsMallid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsmainaccount() {
        return ismainaccount;
    }

    public void setIsmainaccount(String ismainaccount) {
        this.ismainaccount = ismainaccount;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSettlementmain() {
        return settlementmain;
    }

    public void setSettlementmain(Long settlementmain) {
        this.settlementmain = settlementmain;
    }

    public Long getMallid() {
        return mallid;
    }

    public void setMallid(Long mallid) {
        this.mallid = mallid;
    }

    public Long getSettlementmbaid() {
        return settlementmbaid;
    }

    public void setSettlementmbaid(Long settlementmbaid) {
        this.settlementmbaid = settlementmbaid;
    }

    public String getIsAcceptOrder() {
        return isAcceptOrder;
    }

    public void setIsAcceptOrder(String isAcceptOrder) {
        this.isAcceptOrder = isAcceptOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setConsultUserssSellerId(List consultUserssSellerId) {
        this.consultUserssSellerId=consultUserssSellerId;
    }

    public List<ConsultUsersKey> getConsultUserssSellerId() {
        return consultUserssSellerId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setCompanysSettlementmain(Companys companysSettlementmain) {
        this.companysSettlementmain=companysSettlementmain;
    }

    public Companys getCompanysSettlementmain() {
        return companysSettlementmain;
    }

    public void setCompanyBankAccountsSettlementmbaid(CompanyBankAccounts companyBankAccountsSettlementmbaid) {
        this.companyBankAccountsSettlementmbaid=companyBankAccountsSettlementmbaid;
    }

    public CompanyBankAccounts getCompanyBankAccountsSettlementmbaid() {
        return companyBankAccountsSettlementmbaid;
    }

    public void setMallsMallid(Malls mallsMallid) {
        this.mallsMallid=mallsMallid;
    }

    public Malls getMallsMallid() {
        return mallsMallid;
    }
}