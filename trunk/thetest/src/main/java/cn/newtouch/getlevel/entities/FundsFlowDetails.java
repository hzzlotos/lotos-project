package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class FundsFlowDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long recAccountId;

    private Long payAccountId;

    private BigDecimal money;

    private Date billlngDate;

    private Date arriveDate;

    private Long userId;

    private Long type;

    private String isConfReceive;

    private String honorCycle;

    private String remark;

    private String isInstantSettle;

    private String currencyId;

    private Long receivecomId;

    private Long paycomId;

    private Date actionDate;

    private List<AuthorizeFundsKey> authorizeFundssFundsId = null;

    private List<BidBails> bidBailssFundsId = null;

    private List<OrderQuotasKey> orderQuotassFundsId = null;

    private List<TrustPurchRedeemDetails> trustPurchRedeemDetailssFundsId = null;

    private Companys companysPaycomId;

    private Companys companysReceivecomId;

    private CompanyBankAccounts companyBankAccountsPayAccountId;

    private CompanyBankAccounts companyBankAccountsRecAccountId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecAccountId() {
        return recAccountId;
    }

    public void setRecAccountId(Long recAccountId) {
        this.recAccountId = recAccountId;
    }

    public Long getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getBilllngDate() {
        return billlngDate;
    }

    public void setBilllngDate(Date billlngDate) {
        this.billlngDate = billlngDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getIsConfReceive() {
        return isConfReceive;
    }

    public void setIsConfReceive(String isConfReceive) {
        this.isConfReceive = isConfReceive;
    }

    public String getHonorCycle() {
        return honorCycle;
    }

    public void setHonorCycle(String honorCycle) {
        this.honorCycle = honorCycle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsInstantSettle() {
        return isInstantSettle;
    }

    public void setIsInstantSettle(String isInstantSettle) {
        this.isInstantSettle = isInstantSettle;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Long getReceivecomId() {
        return receivecomId;
    }

    public void setReceivecomId(Long receivecomId) {
        this.receivecomId = receivecomId;
    }

    public Long getPaycomId() {
        return paycomId;
    }

    public void setPaycomId(Long paycomId) {
        this.paycomId = paycomId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public void setAuthorizeFundssFundsId(List authorizeFundssFundsId) {
        this.authorizeFundssFundsId=authorizeFundssFundsId;
    }

    public List<AuthorizeFundsKey> getAuthorizeFundssFundsId() {
        return authorizeFundssFundsId;
    }

    public void setBidBailssFundsId(List bidBailssFundsId) {
        this.bidBailssFundsId=bidBailssFundsId;
    }

    public List<BidBails> getBidBailssFundsId() {
        return bidBailssFundsId;
    }

    public void setOrderQuotassFundsId(List orderQuotassFundsId) {
        this.orderQuotassFundsId=orderQuotassFundsId;
    }

    public List<OrderQuotasKey> getOrderQuotassFundsId() {
        return orderQuotassFundsId;
    }

    public void setTrustPurchRedeemDetailssFundsId(List trustPurchRedeemDetailssFundsId) {
        this.trustPurchRedeemDetailssFundsId=trustPurchRedeemDetailssFundsId;
    }

    public List<TrustPurchRedeemDetails> getTrustPurchRedeemDetailssFundsId() {
        return trustPurchRedeemDetailssFundsId;
    }

    public void setCompanysPaycomId(Companys companysPaycomId) {
        this.companysPaycomId=companysPaycomId;
    }

    public Companys getCompanysPaycomId() {
        return companysPaycomId;
    }

    public void setCompanysReceivecomId(Companys companysReceivecomId) {
        this.companysReceivecomId=companysReceivecomId;
    }

    public Companys getCompanysReceivecomId() {
        return companysReceivecomId;
    }

    public void setCompanyBankAccountsPayAccountId(CompanyBankAccounts companyBankAccountsPayAccountId) {
        this.companyBankAccountsPayAccountId=companyBankAccountsPayAccountId;
    }

    public CompanyBankAccounts getCompanyBankAccountsPayAccountId() {
        return companyBankAccountsPayAccountId;
    }

    public void setCompanyBankAccountsRecAccountId(CompanyBankAccounts companyBankAccountsRecAccountId) {
        this.companyBankAccountsRecAccountId=companyBankAccountsRecAccountId;
    }

    public CompanyBankAccounts getCompanyBankAccountsRecAccountId() {
        return companyBankAccountsRecAccountId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}