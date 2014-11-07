package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Malls implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String address;

    private String postalcode;

    private Date orderLimitedDate;

    private Long confirmGoods;

    private Long orderClear;

    private Long transactionStatus;

    private Long pageTemplate;

    private Long resourceDisplay;

    private Long openingCycle;

    private Date openingTime;

    private Date closingTime;

    private Long isOrderFinancing;

    private String code;

    private Long autoQuoteMember;

    private Long type;

    private Date payOnlineDeadline;

    private Date payOfflineDeadline;

    private String configSettleAccount;

    private String isuportProduSale;

    private String traderResCheckNode;

    private String isMergeQuota;

    private String isAcceptOrder;

    private String traderResSetshow;

    private Long virtualStoreId;

    private String status;

    private List<IntegralActivities> integralActivitiessMallId = null;

    private List<MallCertCarrierKey> mallCertCarriersMallId = null;

    private List<MallChannels> mallChannelssMallId = null;

    private List<MallContactModes> mallContactModessMalcmMallid = null;

    private List<MallDeliverys> mallDeliveryssMallId = null;

    private List<MallLableKey> mallLablesMallId = null;

    private List<MallMembersKey> mallMemberssMallId = null;

    private List<MallMemberLevels> mallMemberLevelssMallId = null;

    private List<MallPayments> mallPaymentssMallId = null;

    private List<MallSettlements> mallSettlementssMallId = null;

    private List<MallWarehouse> mallWarehousesMallId = null;

    private List<MemberlvSettle> memberlvSettlesMallId = null;

    private List<Orders> orderssMallId = null;

    private List<RegionSellLimitsKey> regionSellLimitssMallId = null;

    private List<ScoreJournals> scoreJournalssMallId = null;

    private List<Sellers> sellerssMallid = null;

    private List<TraderResources> traderResourcessMallId = null;

    private List<TrustDistributerKey> trustDistributersMallId = null;

    private Stores storesVirtualStoreId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public Date getOrderLimitedDate() {
        return orderLimitedDate;
    }

    public void setOrderLimitedDate(Date orderLimitedDate) {
        this.orderLimitedDate = orderLimitedDate;
    }

    public Long getConfirmGoods() {
        return confirmGoods;
    }

    public void setConfirmGoods(Long confirmGoods) {
        this.confirmGoods = confirmGoods;
    }

    public Long getOrderClear() {
        return orderClear;
    }

    public void setOrderClear(Long orderClear) {
        this.orderClear = orderClear;
    }

    public Long getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Long transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Long getPageTemplate() {
        return pageTemplate;
    }

    public void setPageTemplate(Long pageTemplate) {
        this.pageTemplate = pageTemplate;
    }

    public Long getResourceDisplay() {
        return resourceDisplay;
    }

    public void setResourceDisplay(Long resourceDisplay) {
        this.resourceDisplay = resourceDisplay;
    }

    public Long getOpeningCycle() {
        return openingCycle;
    }

    public void setOpeningCycle(Long openingCycle) {
        this.openingCycle = openingCycle;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public Long getIsOrderFinancing() {
        return isOrderFinancing;
    }

    public void setIsOrderFinancing(Long isOrderFinancing) {
        this.isOrderFinancing = isOrderFinancing;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAutoQuoteMember() {
        return autoQuoteMember;
    }

    public void setAutoQuoteMember(Long autoQuoteMember) {
        this.autoQuoteMember = autoQuoteMember;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Date getPayOnlineDeadline() {
        return payOnlineDeadline;
    }

    public void setPayOnlineDeadline(Date payOnlineDeadline) {
        this.payOnlineDeadline = payOnlineDeadline;
    }

    public Date getPayOfflineDeadline() {
        return payOfflineDeadline;
    }

    public void setPayOfflineDeadline(Date payOfflineDeadline) {
        this.payOfflineDeadline = payOfflineDeadline;
    }

    public String getConfigSettleAccount() {
        return configSettleAccount;
    }

    public void setConfigSettleAccount(String configSettleAccount) {
        this.configSettleAccount = configSettleAccount;
    }

    public String getIsuportProduSale() {
        return isuportProduSale;
    }

    public void setIsuportProduSale(String isuportProduSale) {
        this.isuportProduSale = isuportProduSale;
    }

    public String getTraderResCheckNode() {
        return traderResCheckNode;
    }

    public void setTraderResCheckNode(String traderResCheckNode) {
        this.traderResCheckNode = traderResCheckNode;
    }

    public String getIsMergeQuota() {
        return isMergeQuota;
    }

    public void setIsMergeQuota(String isMergeQuota) {
        this.isMergeQuota = isMergeQuota;
    }

    public String getIsAcceptOrder() {
        return isAcceptOrder;
    }

    public void setIsAcceptOrder(String isAcceptOrder) {
        this.isAcceptOrder = isAcceptOrder;
    }

    public String getTraderResSetshow() {
        return traderResSetshow;
    }

    public void setTraderResSetshow(String traderResSetshow) {
        this.traderResSetshow = traderResSetshow;
    }

    public Long getVirtualStoreId() {
        return virtualStoreId;
    }

    public void setVirtualStoreId(Long virtualStoreId) {
        this.virtualStoreId = virtualStoreId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIntegralActivitiessMallId(List integralActivitiessMallId) {
        this.integralActivitiessMallId=integralActivitiessMallId;
    }

    public List<IntegralActivities> getIntegralActivitiessMallId() {
        return integralActivitiessMallId;
    }

    public void setMallCertCarriersMallId(List mallCertCarriersMallId) {
        this.mallCertCarriersMallId=mallCertCarriersMallId;
    }

    public List<MallCertCarrierKey> getMallCertCarriersMallId() {
        return mallCertCarriersMallId;
    }

    public void setMallChannelssMallId(List mallChannelssMallId) {
        this.mallChannelssMallId=mallChannelssMallId;
    }

    public List<MallChannels> getMallChannelssMallId() {
        return mallChannelssMallId;
    }

    public void setMallContactModessMalcmMallid(List mallContactModessMalcmMallid) {
        this.mallContactModessMalcmMallid=mallContactModessMalcmMallid;
    }

    public List<MallContactModes> getMallContactModessMalcmMallid() {
        return mallContactModessMalcmMallid;
    }

    public void setMallDeliveryssMallId(List mallDeliveryssMallId) {
        this.mallDeliveryssMallId=mallDeliveryssMallId;
    }

    public List<MallDeliverys> getMallDeliveryssMallId() {
        return mallDeliveryssMallId;
    }

    public void setMallLablesMallId(List mallLablesMallId) {
        this.mallLablesMallId=mallLablesMallId;
    }

    public List<MallLableKey> getMallLablesMallId() {
        return mallLablesMallId;
    }

    public void setMallMemberssMallId(List mallMemberssMallId) {
        this.mallMemberssMallId=mallMemberssMallId;
    }

    public List<MallMembersKey> getMallMemberssMallId() {
        return mallMemberssMallId;
    }

    public void setMallMemberLevelssMallId(List mallMemberLevelssMallId) {
        this.mallMemberLevelssMallId=mallMemberLevelssMallId;
    }

    public List<MallMemberLevels> getMallMemberLevelssMallId() {
        return mallMemberLevelssMallId;
    }

    public void setMallPaymentssMallId(List mallPaymentssMallId) {
        this.mallPaymentssMallId=mallPaymentssMallId;
    }

    public List<MallPayments> getMallPaymentssMallId() {
        return mallPaymentssMallId;
    }

    public void setMallSettlementssMallId(List mallSettlementssMallId) {
        this.mallSettlementssMallId=mallSettlementssMallId;
    }

    public List<MallSettlements> getMallSettlementssMallId() {
        return mallSettlementssMallId;
    }

    public void setMallWarehousesMallId(List mallWarehousesMallId) {
        this.mallWarehousesMallId=mallWarehousesMallId;
    }

    public List<MallWarehouse> getMallWarehousesMallId() {
        return mallWarehousesMallId;
    }

    public void setMemberlvSettlesMallId(List memberlvSettlesMallId) {
        this.memberlvSettlesMallId=memberlvSettlesMallId;
    }

    public List<MemberlvSettle> getMemberlvSettlesMallId() {
        return memberlvSettlesMallId;
    }

    public void setOrderssMallId(List orderssMallId) {
        this.orderssMallId=orderssMallId;
    }

    public List<Orders> getOrderssMallId() {
        return orderssMallId;
    }

    public void setRegionSellLimitssMallId(List regionSellLimitssMallId) {
        this.regionSellLimitssMallId=regionSellLimitssMallId;
    }

    public List<RegionSellLimitsKey> getRegionSellLimitssMallId() {
        return regionSellLimitssMallId;
    }

    public void setScoreJournalssMallId(List scoreJournalssMallId) {
        this.scoreJournalssMallId=scoreJournalssMallId;
    }

    public List<ScoreJournals> getScoreJournalssMallId() {
        return scoreJournalssMallId;
    }

    public void setSellerssMallid(List sellerssMallid) {
        this.sellerssMallid=sellerssMallid;
    }

    public List<Sellers> getSellerssMallid() {
        return sellerssMallid;
    }

    public void setTraderResourcessMallId(List traderResourcessMallId) {
        this.traderResourcessMallId=traderResourcessMallId;
    }

    public List<TraderResources> getTraderResourcessMallId() {
        return traderResourcessMallId;
    }

    public void setTrustDistributersMallId(List trustDistributersMallId) {
        this.trustDistributersMallId=trustDistributersMallId;
    }

    public List<TrustDistributerKey> getTrustDistributersMallId() {
        return trustDistributersMallId;
    }

    public void setStoresVirtualStoreId(Stores storesVirtualStoreId) {
        this.storesVirtualStoreId=storesVirtualStoreId;
    }

    public Stores getStoresVirtualStoreId() {
        return storesVirtualStoreId;
    }
}