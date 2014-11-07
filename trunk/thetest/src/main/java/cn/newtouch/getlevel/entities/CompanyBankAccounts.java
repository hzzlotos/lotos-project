package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class CompanyBankAccounts implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String accountCode;

    private Long companyId;

    private String userName;

    private String accountBank;

    private Long bankId;

    private String isOlPayment;

    private List<FundsFlowDetails> fundsFlowDetailssRecAccountId = null;

    private List<FundsFlowDetails> fundsFlowDetailssPayAccountId = null;

    private List<MallMembersKey> mallMemberssBankId = null;

    private List<Sellers> sellerssSettlementmbaid = null;

    private List<TraderResources> traderResourcessBankId = null;

    private Banks banksBankId;

    private Companys companysCompanyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getIsOlPayment() {
        return isOlPayment;
    }

    public void setIsOlPayment(String isOlPayment) {
        this.isOlPayment = isOlPayment;
    }

    public void setFundsFlowDetailssRecAccountId(List fundsFlowDetailssRecAccountId) {
        this.fundsFlowDetailssRecAccountId=fundsFlowDetailssRecAccountId;
    }

    public List<FundsFlowDetails> getFundsFlowDetailssRecAccountId() {
        return fundsFlowDetailssRecAccountId;
    }

    public void setFundsFlowDetailssPayAccountId(List fundsFlowDetailssPayAccountId) {
        this.fundsFlowDetailssPayAccountId=fundsFlowDetailssPayAccountId;
    }

    public List<FundsFlowDetails> getFundsFlowDetailssPayAccountId() {
        return fundsFlowDetailssPayAccountId;
    }

    public void setMallMemberssBankId(List mallMemberssBankId) {
        this.mallMemberssBankId=mallMemberssBankId;
    }

    public List<MallMembersKey> getMallMemberssBankId() {
        return mallMemberssBankId;
    }

    public void setSellerssSettlementmbaid(List sellerssSettlementmbaid) {
        this.sellerssSettlementmbaid=sellerssSettlementmbaid;
    }

    public List<Sellers> getSellerssSettlementmbaid() {
        return sellerssSettlementmbaid;
    }

    public void setTraderResourcessBankId(List traderResourcessBankId) {
        this.traderResourcessBankId=traderResourcessBankId;
    }

    public List<TraderResources> getTraderResourcessBankId() {
        return traderResourcessBankId;
    }

    public void setBanksBankId(Banks banksBankId) {
        this.banksBankId=banksBankId;
    }

    public Banks getBanksBankId() {
        return banksBankId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }
}