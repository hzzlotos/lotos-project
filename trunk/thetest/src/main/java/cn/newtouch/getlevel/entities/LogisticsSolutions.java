package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class LogisticsSolutions implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long originId;

    private Long destinationId;

    private BigDecimal distance;

    private Long carsCompanyId;

    private Date effectiveBegintime;

    private Date effectiveEndtime;

    private Date lastUpdateTime;

    private BigDecimal plannedTime;

    private String solutionCode;

    private String timeSolution;

    private String intervalDate;

    private Long userId;

    private Date estimaPickupDate;

    private String lineType;

    private Date receiptDealine;

    private Date startTime;

    private String assocType;

    private Long checkingId;

    private Long transBillPolicyId;

    private Long lineTaticsId;

    private List<LogisticsSolutionVehiclesKey> logisticsSolutionVehiclessLogisticsSolutionId = null;

    private List<RealtimeTransCapacityKey> realtimeTransCapacitysLogisticsSolutionId = null;

    private List<ReceivingSolutionsKey> receivingSolutionssLogisticsSolutionsId = null;

    private List<RouteTemplates> routeTemplatessLogisticsSolutionId = null;

    private List<WeekSolutions> weekSolutionssLogisticsSolutionId = null;

    private Companys companysCarsCompanyId;

    private ConsignType consignTypeCheckingId;

    private LineTactics lineTacticsLineTaticsId;

    private LogisticsAddress logisticsAddressOriginId;

    private LogisticsAddress logisticsAddressDestinationId;

    private TransBillPolicy transBillPolicyTransBillPolicyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Long getCarsCompanyId() {
        return carsCompanyId;
    }

    public void setCarsCompanyId(Long carsCompanyId) {
        this.carsCompanyId = carsCompanyId;
    }

    public Date getEffectiveBegintime() {
        return effectiveBegintime;
    }

    public void setEffectiveBegintime(Date effectiveBegintime) {
        this.effectiveBegintime = effectiveBegintime;
    }

    public Date getEffectiveEndtime() {
        return effectiveEndtime;
    }

    public void setEffectiveEndtime(Date effectiveEndtime) {
        this.effectiveEndtime = effectiveEndtime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigDecimal getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(BigDecimal plannedTime) {
        this.plannedTime = plannedTime;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(String solutionCode) {
        this.solutionCode = solutionCode;
    }

    public String getTimeSolution() {
        return timeSolution;
    }

    public void setTimeSolution(String timeSolution) {
        this.timeSolution = timeSolution;
    }

    public String getIntervalDate() {
        return intervalDate;
    }

    public void setIntervalDate(String intervalDate) {
        this.intervalDate = intervalDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getEstimaPickupDate() {
        return estimaPickupDate;
    }

    public void setEstimaPickupDate(Date estimaPickupDate) {
        this.estimaPickupDate = estimaPickupDate;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public Date getReceiptDealine() {
        return receiptDealine;
    }

    public void setReceiptDealine(Date receiptDealine) {
        this.receiptDealine = receiptDealine;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAssocType() {
        return assocType;
    }

    public void setAssocType(String assocType) {
        this.assocType = assocType;
    }

    public Long getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(Long checkingId) {
        this.checkingId = checkingId;
    }

    public Long getTransBillPolicyId() {
        return transBillPolicyId;
    }

    public void setTransBillPolicyId(Long transBillPolicyId) {
        this.transBillPolicyId = transBillPolicyId;
    }

    public Long getLineTaticsId() {
        return lineTaticsId;
    }

    public void setLineTaticsId(Long lineTaticsId) {
        this.lineTaticsId = lineTaticsId;
    }

    public void setLogisticsSolutionVehiclessLogisticsSolutionId(List logisticsSolutionVehiclessLogisticsSolutionId) {
        this.logisticsSolutionVehiclessLogisticsSolutionId=logisticsSolutionVehiclessLogisticsSolutionId;
    }

    public List<LogisticsSolutionVehiclesKey> getLogisticsSolutionVehiclessLogisticsSolutionId() {
        return logisticsSolutionVehiclessLogisticsSolutionId;
    }

    public void setRealtimeTransCapacitysLogisticsSolutionId(List realtimeTransCapacitysLogisticsSolutionId) {
        this.realtimeTransCapacitysLogisticsSolutionId=realtimeTransCapacitysLogisticsSolutionId;
    }

    public List<RealtimeTransCapacityKey> getRealtimeTransCapacitysLogisticsSolutionId() {
        return realtimeTransCapacitysLogisticsSolutionId;
    }

    public void setReceivingSolutionssLogisticsSolutionsId(List receivingSolutionssLogisticsSolutionsId) {
        this.receivingSolutionssLogisticsSolutionsId=receivingSolutionssLogisticsSolutionsId;
    }

    public List<ReceivingSolutionsKey> getReceivingSolutionssLogisticsSolutionsId() {
        return receivingSolutionssLogisticsSolutionsId;
    }

    public void setRouteTemplatessLogisticsSolutionId(List routeTemplatessLogisticsSolutionId) {
        this.routeTemplatessLogisticsSolutionId=routeTemplatessLogisticsSolutionId;
    }

    public List<RouteTemplates> getRouteTemplatessLogisticsSolutionId() {
        return routeTemplatessLogisticsSolutionId;
    }

    public void setWeekSolutionssLogisticsSolutionId(List weekSolutionssLogisticsSolutionId) {
        this.weekSolutionssLogisticsSolutionId=weekSolutionssLogisticsSolutionId;
    }

    public List<WeekSolutions> getWeekSolutionssLogisticsSolutionId() {
        return weekSolutionssLogisticsSolutionId;
    }

    public void setCompanysCarsCompanyId(Companys companysCarsCompanyId) {
        this.companysCarsCompanyId=companysCarsCompanyId;
    }

    public Companys getCompanysCarsCompanyId() {
        return companysCarsCompanyId;
    }

    public void setConsignTypeCheckingId(ConsignType consignTypeCheckingId) {
        this.consignTypeCheckingId=consignTypeCheckingId;
    }

    public ConsignType getConsignTypeCheckingId() {
        return consignTypeCheckingId;
    }

    public void setLineTacticsLineTaticsId(LineTactics lineTacticsLineTaticsId) {
        this.lineTacticsLineTaticsId=lineTacticsLineTaticsId;
    }

    public LineTactics getLineTacticsLineTaticsId() {
        return lineTacticsLineTaticsId;
    }

    public void setLogisticsAddressOriginId(LogisticsAddress logisticsAddressOriginId) {
        this.logisticsAddressOriginId=logisticsAddressOriginId;
    }

    public LogisticsAddress getLogisticsAddressOriginId() {
        return logisticsAddressOriginId;
    }

    public void setLogisticsAddressDestinationId(LogisticsAddress logisticsAddressDestinationId) {
        this.logisticsAddressDestinationId=logisticsAddressDestinationId;
    }

    public LogisticsAddress getLogisticsAddressDestinationId() {
        return logisticsAddressDestinationId;
    }

    public void setTransBillPolicyTransBillPolicyId(TransBillPolicy transBillPolicyTransBillPolicyId) {
        this.transBillPolicyTransBillPolicyId=transBillPolicyTransBillPolicyId;
    }

    public TransBillPolicy getTransBillPolicyTransBillPolicyId() {
        return transBillPolicyTransBillPolicyId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}