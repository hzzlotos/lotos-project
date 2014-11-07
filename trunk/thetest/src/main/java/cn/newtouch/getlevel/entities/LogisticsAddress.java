package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class LogisticsAddress implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long country;

    private Long province;

    private Long city;

    private Long cityarea;

    private String street;

    private String postalCode;

    private String type;

    private List<AddressBookKey> addressBooksAddressId = null;

    private List<BidLimtAreasKey> bidLimtAreassRegionId = null;

    private List<CollateralGuidePrices> collateralGuidePricessAddressId = null;

    private List<Companys> companyssMailingAddressId = null;

    private List<Companys> companyssRegisterAddressId = null;

    private List<Invoices> invoicessAddress = null;

    private List<LogisticsBranch> logisticsBranchsAddressId = null;

    private List<LogisticsOrders> logisticsOrderssDestinationId = null;

    private List<LogisticsOrders> logisticsOrderssOriginId = null;

    private List<LogisticsSolutions> logisticsSolutionssOriginId = null;

    private List<LogisticsSolutions> logisticsSolutionssDestinationId = null;

    private List<MallContactModes> mallContactModessMalcmLognid = null;

    private List<OrderDetailsKey> orderDetailssRegionId = null;

    private List<RegionPrice> regionPricesId = null;

    private List<RegionSellLimitsKey> regionSellLimitssRegionId = null;

    private List<RouteReceipts> routeReceiptssOriginId = null;

    private List<RouteReceipts> routeReceiptssDestinationId = null;

    private List<RouteTemplates> routeTemplatessDestinationId = null;

    private List<RouteTemplates> routeTemplatessOriginId = null;

    private List<Stores> storessLogisticNodeId = null;

    private List<TransportDemands> transportDemandssBeginLognId = null;

    private List<TransportDemands> transportDemandssEndLognId = null;

    private List<TransportDemandResponses> transportDemandResponsessPickupAddressId = null;

    private List<TransportDemandResponses> transportDemandResponsessShipAddressId = null;

    private AdminDivisions adminDivisionsProvince;

    private AdminDivisions adminDivisionsCountry;

    private AdminDivisions adminDivisionsCityarea;

    private AdminDivisions adminDivisionsCity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getCityarea() {
        return cityarea;
    }

    public void setCityarea(Long cityarea) {
        this.cityarea = cityarea;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddressBooksAddressId(List addressBooksAddressId) {
        this.addressBooksAddressId=addressBooksAddressId;
    }

    public List<AddressBookKey> getAddressBooksAddressId() {
        return addressBooksAddressId;
    }

    public void setBidLimtAreassRegionId(List bidLimtAreassRegionId) {
        this.bidLimtAreassRegionId=bidLimtAreassRegionId;
    }

    public List<BidLimtAreasKey> getBidLimtAreassRegionId() {
        return bidLimtAreassRegionId;
    }

    public void setCollateralGuidePricessAddressId(List collateralGuidePricessAddressId) {
        this.collateralGuidePricessAddressId=collateralGuidePricessAddressId;
    }

    public List<CollateralGuidePrices> getCollateralGuidePricessAddressId() {
        return collateralGuidePricessAddressId;
    }

    public void setCompanyssMailingAddressId(List companyssMailingAddressId) {
        this.companyssMailingAddressId=companyssMailingAddressId;
    }

    public List<Companys> getCompanyssMailingAddressId() {
        return companyssMailingAddressId;
    }

    public void setCompanyssRegisterAddressId(List companyssRegisterAddressId) {
        this.companyssRegisterAddressId=companyssRegisterAddressId;
    }

    public List<Companys> getCompanyssRegisterAddressId() {
        return companyssRegisterAddressId;
    }

    public void setInvoicessAddress(List invoicessAddress) {
        this.invoicessAddress=invoicessAddress;
    }

    public List<Invoices> getInvoicessAddress() {
        return invoicessAddress;
    }

    public void setLogisticsBranchsAddressId(List logisticsBranchsAddressId) {
        this.logisticsBranchsAddressId=logisticsBranchsAddressId;
    }

    public List<LogisticsBranch> getLogisticsBranchsAddressId() {
        return logisticsBranchsAddressId;
    }

    public void setLogisticsOrderssDestinationId(List logisticsOrderssDestinationId) {
        this.logisticsOrderssDestinationId=logisticsOrderssDestinationId;
    }

    public List<LogisticsOrders> getLogisticsOrderssDestinationId() {
        return logisticsOrderssDestinationId;
    }

    public void setLogisticsOrderssOriginId(List logisticsOrderssOriginId) {
        this.logisticsOrderssOriginId=logisticsOrderssOriginId;
    }

    public List<LogisticsOrders> getLogisticsOrderssOriginId() {
        return logisticsOrderssOriginId;
    }

    public void setLogisticsSolutionssOriginId(List logisticsSolutionssOriginId) {
        this.logisticsSolutionssOriginId=logisticsSolutionssOriginId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssOriginId() {
        return logisticsSolutionssOriginId;
    }

    public void setLogisticsSolutionssDestinationId(List logisticsSolutionssDestinationId) {
        this.logisticsSolutionssDestinationId=logisticsSolutionssDestinationId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssDestinationId() {
        return logisticsSolutionssDestinationId;
    }

    public void setMallContactModessMalcmLognid(List mallContactModessMalcmLognid) {
        this.mallContactModessMalcmLognid=mallContactModessMalcmLognid;
    }

    public List<MallContactModes> getMallContactModessMalcmLognid() {
        return mallContactModessMalcmLognid;
    }

    public void setOrderDetailssRegionId(List orderDetailssRegionId) {
        this.orderDetailssRegionId=orderDetailssRegionId;
    }

    public List<OrderDetailsKey> getOrderDetailssRegionId() {
        return orderDetailssRegionId;
    }

    public void setRegionPricesId(List regionPricesId) {
        this.regionPricesId=regionPricesId;
    }

    public List<RegionPrice> getRegionPricesId() {
        return regionPricesId;
    }

    public void setRegionSellLimitssRegionId(List regionSellLimitssRegionId) {
        this.regionSellLimitssRegionId=regionSellLimitssRegionId;
    }

    public List<RegionSellLimitsKey> getRegionSellLimitssRegionId() {
        return regionSellLimitssRegionId;
    }

    public void setRouteReceiptssOriginId(List routeReceiptssOriginId) {
        this.routeReceiptssOriginId=routeReceiptssOriginId;
    }

    public List<RouteReceipts> getRouteReceiptssOriginId() {
        return routeReceiptssOriginId;
    }

    public void setRouteReceiptssDestinationId(List routeReceiptssDestinationId) {
        this.routeReceiptssDestinationId=routeReceiptssDestinationId;
    }

    public List<RouteReceipts> getRouteReceiptssDestinationId() {
        return routeReceiptssDestinationId;
    }

    public void setRouteTemplatessDestinationId(List routeTemplatessDestinationId) {
        this.routeTemplatessDestinationId=routeTemplatessDestinationId;
    }

    public List<RouteTemplates> getRouteTemplatessDestinationId() {
        return routeTemplatessDestinationId;
    }

    public void setRouteTemplatessOriginId(List routeTemplatessOriginId) {
        this.routeTemplatessOriginId=routeTemplatessOriginId;
    }

    public List<RouteTemplates> getRouteTemplatessOriginId() {
        return routeTemplatessOriginId;
    }

    public void setStoressLogisticNodeId(List storessLogisticNodeId) {
        this.storessLogisticNodeId=storessLogisticNodeId;
    }

    public List<Stores> getStoressLogisticNodeId() {
        return storessLogisticNodeId;
    }

    public void setTransportDemandssBeginLognId(List transportDemandssBeginLognId) {
        this.transportDemandssBeginLognId=transportDemandssBeginLognId;
    }

    public List<TransportDemands> getTransportDemandssBeginLognId() {
        return transportDemandssBeginLognId;
    }

    public void setTransportDemandssEndLognId(List transportDemandssEndLognId) {
        this.transportDemandssEndLognId=transportDemandssEndLognId;
    }

    public List<TransportDemands> getTransportDemandssEndLognId() {
        return transportDemandssEndLognId;
    }

    public void setTransportDemandResponsessPickupAddressId(List transportDemandResponsessPickupAddressId) {
        this.transportDemandResponsessPickupAddressId=transportDemandResponsessPickupAddressId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessPickupAddressId() {
        return transportDemandResponsessPickupAddressId;
    }

    public void setTransportDemandResponsessShipAddressId(List transportDemandResponsessShipAddressId) {
        this.transportDemandResponsessShipAddressId=transportDemandResponsessShipAddressId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessShipAddressId() {
        return transportDemandResponsessShipAddressId;
    }

    public void setAdminDivisionsProvince(AdminDivisions adminDivisionsProvince) {
        this.adminDivisionsProvince=adminDivisionsProvince;
    }

    public AdminDivisions getAdminDivisionsProvince() {
        return adminDivisionsProvince;
    }

    public void setAdminDivisionsCountry(AdminDivisions adminDivisionsCountry) {
        this.adminDivisionsCountry=adminDivisionsCountry;
    }

    public AdminDivisions getAdminDivisionsCountry() {
        return adminDivisionsCountry;
    }

    public void setAdminDivisionsCityarea(AdminDivisions adminDivisionsCityarea) {
        this.adminDivisionsCityarea=adminDivisionsCityarea;
    }

    public AdminDivisions getAdminDivisionsCityarea() {
        return adminDivisionsCityarea;
    }

    public void setAdminDivisionsCity(AdminDivisions adminDivisionsCity) {
        this.adminDivisionsCity=adminDivisionsCity;
    }

    public AdminDivisions getAdminDivisionsCity() {
        return adminDivisionsCity;
    }
}