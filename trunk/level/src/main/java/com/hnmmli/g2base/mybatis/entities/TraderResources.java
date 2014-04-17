package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class TraderResources implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resDefId;

    private Long storeId;

    private String isRegulatory;

    private BigDecimal showUnitPrice;

    private BigDecimal unitPrice;

    private String isDirectionRes;

    private BigDecimal direUnitPrice;

    private String status;

    private Long traderUserid;

    private String source;

    private Date tradeDate;

    private Long settleComId;

    private String settleTactics;

    private String includeTaxe;

    private Long memberPriceId;

    private BigDecimal minimumPrice;

    private Date traderBeginTime;

    private Date distraderTime;

    private Long bankId;

    private Long companyId;

    private String traderabeType;

    private String isProductSale;

    private Long prudutityId;

    private Long saledGoodsMeasureId;

    private String ischeck;

    private String remark;

    private Long mallId;

    private Long goodsMeasureId;

    private BigDecimal isRegionPrice;

    private List<ConsulTacticsLogs> consulTacticsLogssResourceId = null;

    private List<GivenPricesKey> givenPricessResourceId = null;

    private List<OrderDetailsKey> orderDetailssTradeId = null;

    private List<RegionPrice> regionPricesId = null;

    private List<TraderResSnaps> traderResSnapssResourceId = null;

    private Companys companysCompanyId;

    private Companys companysSettleComId;

    private CompanyBankAccounts companyBankAccountsBankId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private GoodsMeasures goodsMeasuresSaledGoodsMeasureId;

    private Malls mallsMallId;

    private MemberPrices memberPricesMemberPriceId;

    private Productivitys productivitysPrudutityId;

    private Resources resourcesResDefId;

    private Stores storesStoreId;

    private Users usersTraderUserid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getIsRegulatory() {
        return isRegulatory;
    }

    public void setIsRegulatory(String isRegulatory) {
        this.isRegulatory = isRegulatory;
    }

    public BigDecimal getShowUnitPrice() {
        return showUnitPrice;
    }

    public void setShowUnitPrice(BigDecimal showUnitPrice) {
        this.showUnitPrice = showUnitPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getIsDirectionRes() {
        return isDirectionRes;
    }

    public void setIsDirectionRes(String isDirectionRes) {
        this.isDirectionRes = isDirectionRes;
    }

    public BigDecimal getDireUnitPrice() {
        return direUnitPrice;
    }

    public void setDireUnitPrice(BigDecimal direUnitPrice) {
        this.direUnitPrice = direUnitPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTraderUserid() {
        return traderUserid;
    }

    public void setTraderUserid(Long traderUserid) {
        this.traderUserid = traderUserid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Long getSettleComId() {
        return settleComId;
    }

    public void setSettleComId(Long settleComId) {
        this.settleComId = settleComId;
    }

    public String getSettleTactics() {
        return settleTactics;
    }

    public void setSettleTactics(String settleTactics) {
        this.settleTactics = settleTactics;
    }

    public String getIncludeTaxe() {
        return includeTaxe;
    }

    public void setIncludeTaxe(String includeTaxe) {
        this.includeTaxe = includeTaxe;
    }

    public Long getMemberPriceId() {
        return memberPriceId;
    }

    public void setMemberPriceId(Long memberPriceId) {
        this.memberPriceId = memberPriceId;
    }

    public BigDecimal getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Date getTraderBeginTime() {
        return traderBeginTime;
    }

    public void setTraderBeginTime(Date traderBeginTime) {
        this.traderBeginTime = traderBeginTime;
    }

    public Date getDistraderTime() {
        return distraderTime;
    }

    public void setDistraderTime(Date distraderTime) {
        this.distraderTime = distraderTime;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTraderabeType() {
        return traderabeType;
    }

    public void setTraderabeType(String traderabeType) {
        this.traderabeType = traderabeType;
    }

    public String getIsProductSale() {
        return isProductSale;
    }

    public void setIsProductSale(String isProductSale) {
        this.isProductSale = isProductSale;
    }

    public Long getPrudutityId() {
        return prudutityId;
    }

    public void setPrudutityId(Long prudutityId) {
        this.prudutityId = prudutityId;
    }

    public Long getSaledGoodsMeasureId() {
        return saledGoodsMeasureId;
    }

    public void setSaledGoodsMeasureId(Long saledGoodsMeasureId) {
        this.saledGoodsMeasureId = saledGoodsMeasureId;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public BigDecimal getIsRegionPrice() {
        return isRegionPrice;
    }

    public void setIsRegionPrice(BigDecimal isRegionPrice) {
        this.isRegionPrice = isRegionPrice;
    }

    public void setConsulTacticsLogssResourceId(List consulTacticsLogssResourceId) {
        this.consulTacticsLogssResourceId=consulTacticsLogssResourceId;
    }

    public List<ConsulTacticsLogs> getConsulTacticsLogssResourceId() {
        return consulTacticsLogssResourceId;
    }

    public void setGivenPricessResourceId(List givenPricessResourceId) {
        this.givenPricessResourceId=givenPricessResourceId;
    }

    public List<GivenPricesKey> getGivenPricessResourceId() {
        return givenPricessResourceId;
    }

    public void setOrderDetailssTradeId(List orderDetailssTradeId) {
        this.orderDetailssTradeId=orderDetailssTradeId;
    }

    public List<OrderDetailsKey> getOrderDetailssTradeId() {
        return orderDetailssTradeId;
    }

    public void setRegionPricesId(List regionPricesId) {
        this.regionPricesId=regionPricesId;
    }

    public List<RegionPrice> getRegionPricesId() {
        return regionPricesId;
    }

    public void setTraderResSnapssResourceId(List traderResSnapssResourceId) {
        this.traderResSnapssResourceId=traderResSnapssResourceId;
    }

    public List<TraderResSnaps> getTraderResSnapssResourceId() {
        return traderResSnapssResourceId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setCompanysSettleComId(Companys companysSettleComId) {
        this.companysSettleComId=companysSettleComId;
    }

    public Companys getCompanysSettleComId() {
        return companysSettleComId;
    }

    public void setCompanyBankAccountsBankId(CompanyBankAccounts companyBankAccountsBankId) {
        this.companyBankAccountsBankId=companyBankAccountsBankId;
    }

    public CompanyBankAccounts getCompanyBankAccountsBankId() {
        return companyBankAccountsBankId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setGoodsMeasuresSaledGoodsMeasureId(GoodsMeasures goodsMeasuresSaledGoodsMeasureId) {
        this.goodsMeasuresSaledGoodsMeasureId=goodsMeasuresSaledGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresSaledGoodsMeasureId() {
        return goodsMeasuresSaledGoodsMeasureId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setMemberPricesMemberPriceId(MemberPrices memberPricesMemberPriceId) {
        this.memberPricesMemberPriceId=memberPricesMemberPriceId;
    }

    public MemberPrices getMemberPricesMemberPriceId() {
        return memberPricesMemberPriceId;
    }

    public void setProductivitysPrudutityId(Productivitys productivitysPrudutityId) {
        this.productivitysPrudutityId=productivitysPrudutityId;
    }

    public Productivitys getProductivitysPrudutityId() {
        return productivitysPrudutityId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersTraderUserid(Users usersTraderUserid) {
        this.usersTraderUserid=usersTraderUserid;
    }

    public Users getUsersTraderUserid() {
        return usersTraderUserid;
    }
}