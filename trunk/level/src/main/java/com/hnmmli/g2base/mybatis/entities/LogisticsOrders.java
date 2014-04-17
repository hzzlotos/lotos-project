package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class LogisticsOrders implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long sourceCaroId;

    private Long carrierCompanyId;

    private Long entrustCompanyId;

    private Long destinationId;

    private Long originId;

    private Date plannedBeginTime;

    private Date plannedEndTime;

    private BigDecimal plannedTime;

    private String receivingCompanyName;

    private String receivingContactName;

    private String contactPhone;

    private Long userId;

    private Date createDate;

    private String auditStatus;

    private String remark;

    private Long shipNetId;

    private Long pickupNetId;

    private String shipCompanyName;

    private String shipPerson;

    private String shipperTelphone;

    private String logisticsOrderNo;

    private Long resDefId;

    private String orderSource;

    private String outerId;

    private String signStatus;

    private String excuStatus;

    private Long returnNoteId;

    private Long lineTacticsId;

    private Long transBillId;

    private Date signDate;

    private List<CarrierOrderSocialMaterials> carrierOrderSocialMaterialssLogisticsOrderId = null;

    private List<InsurancePolicys> insurancePolicyssLogisticsOrderId = null;

    private List<Ladings> ladingssTransportId = null;

    private List<LogisticsJobFlows> logisticsJobFlowssLogisticsOrderId = null;

    private List<LogisticsOrders> logisticsOrderssSourceCaroId = null;

    private List<LogisticsOrderRoutesKey> logisticsOrderRoutessLogisticsOrderId = null;

    private List<LogisOrderWareMaterial> logisOrderWareMaterialsLogisticsOrderId = null;

    private List<TransportDemands> transportDemandssSubContractCaroId = null;

    private List<TransportDemands> transportDemandssLogisticsSolutionId = null;

    private List<WarehouseTransportsKey> warehouseTransportssLofisticsOrderId = null;

    private Companys companysCarrierCompanyId;

    private Companys companysEntrustCompanyId;

    private ConsignType consignTypeResDefId;

    private LineTactics lineTacticsLineTacticsId;

    private LogisticsAddress logisticsAddressOriginId;

    private LogisticsAddress logisticsAddressDestinationId;

    private LogisticsBranch logisticsBranchShipNetId;

    private LogisticsBranch logisticsBranchPickupNetId;

    private LogisticsOrders logisticsOrdersSourceCaroId;

    private Resources resourcesResDefId;

    private ReturnNoteQuire returnNoteQuireReturnNoteId;

    private ShipPickupType shipPickupTypeResDefId;

    private TransportBilling transportBillingTransBillId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceCaroId() {
        return sourceCaroId;
    }

    public void setSourceCaroId(Long sourceCaroId) {
        this.sourceCaroId = sourceCaroId;
    }

    public Long getCarrierCompanyId() {
        return carrierCompanyId;
    }

    public void setCarrierCompanyId(Long carrierCompanyId) {
        this.carrierCompanyId = carrierCompanyId;
    }

    public Long getEntrustCompanyId() {
        return entrustCompanyId;
    }

    public void setEntrustCompanyId(Long entrustCompanyId) {
        this.entrustCompanyId = entrustCompanyId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Date getPlannedBeginTime() {
        return plannedBeginTime;
    }

    public void setPlannedBeginTime(Date plannedBeginTime) {
        this.plannedBeginTime = plannedBeginTime;
    }

    public Date getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(Date plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public BigDecimal getPlannedTime() {
        return plannedTime;
    }

    public void setPlannedTime(BigDecimal plannedTime) {
        this.plannedTime = plannedTime;
    }

    public String getReceivingCompanyName() {
        return receivingCompanyName;
    }

    public void setReceivingCompanyName(String receivingCompanyName) {
        this.receivingCompanyName = receivingCompanyName;
    }

    public String getReceivingContactName() {
        return receivingContactName;
    }

    public void setReceivingContactName(String receivingContactName) {
        this.receivingContactName = receivingContactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getShipNetId() {
        return shipNetId;
    }

    public void setShipNetId(Long shipNetId) {
        this.shipNetId = shipNetId;
    }

    public Long getPickupNetId() {
        return pickupNetId;
    }

    public void setPickupNetId(Long pickupNetId) {
        this.pickupNetId = pickupNetId;
    }

    public String getShipCompanyName() {
        return shipCompanyName;
    }

    public void setShipCompanyName(String shipCompanyName) {
        this.shipCompanyName = shipCompanyName;
    }

    public String getShipPerson() {
        return shipPerson;
    }

    public void setShipPerson(String shipPerson) {
        this.shipPerson = shipPerson;
    }

    public String getShipperTelphone() {
        return shipperTelphone;
    }

    public void setShipperTelphone(String shipperTelphone) {
        this.shipperTelphone = shipperTelphone;
    }

    public String getLogisticsOrderNo() {
        return logisticsOrderNo;
    }

    public void setLogisticsOrderNo(String logisticsOrderNo) {
        this.logisticsOrderNo = logisticsOrderNo;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getExcuStatus() {
        return excuStatus;
    }

    public void setExcuStatus(String excuStatus) {
        this.excuStatus = excuStatus;
    }

    public Long getReturnNoteId() {
        return returnNoteId;
    }

    public void setReturnNoteId(Long returnNoteId) {
        this.returnNoteId = returnNoteId;
    }

    public Long getLineTacticsId() {
        return lineTacticsId;
    }

    public void setLineTacticsId(Long lineTacticsId) {
        this.lineTacticsId = lineTacticsId;
    }

    public Long getTransBillId() {
        return transBillId;
    }

    public void setTransBillId(Long transBillId) {
        this.transBillId = transBillId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setCarrierOrderSocialMaterialssLogisticsOrderId(List carrierOrderSocialMaterialssLogisticsOrderId) {
        this.carrierOrderSocialMaterialssLogisticsOrderId=carrierOrderSocialMaterialssLogisticsOrderId;
    }

    public List<CarrierOrderSocialMaterials> getCarrierOrderSocialMaterialssLogisticsOrderId() {
        return carrierOrderSocialMaterialssLogisticsOrderId;
    }

    public void setInsurancePolicyssLogisticsOrderId(List insurancePolicyssLogisticsOrderId) {
        this.insurancePolicyssLogisticsOrderId=insurancePolicyssLogisticsOrderId;
    }

    public List<InsurancePolicys> getInsurancePolicyssLogisticsOrderId() {
        return insurancePolicyssLogisticsOrderId;
    }

    public void setLadingssTransportId(List ladingssTransportId) {
        this.ladingssTransportId=ladingssTransportId;
    }

    public List<Ladings> getLadingssTransportId() {
        return ladingssTransportId;
    }

    public void setLogisticsJobFlowssLogisticsOrderId(List logisticsJobFlowssLogisticsOrderId) {
        this.logisticsJobFlowssLogisticsOrderId=logisticsJobFlowssLogisticsOrderId;
    }

    public List<LogisticsJobFlows> getLogisticsJobFlowssLogisticsOrderId() {
        return logisticsJobFlowssLogisticsOrderId;
    }

    public void setLogisticsOrderssSourceCaroId(List logisticsOrderssSourceCaroId) {
        this.logisticsOrderssSourceCaroId=logisticsOrderssSourceCaroId;
    }

    public List<LogisticsOrders> getLogisticsOrderssSourceCaroId() {
        return logisticsOrderssSourceCaroId;
    }

    public void setLogisticsOrderRoutessLogisticsOrderId(List logisticsOrderRoutessLogisticsOrderId) {
        this.logisticsOrderRoutessLogisticsOrderId=logisticsOrderRoutessLogisticsOrderId;
    }

    public List<LogisticsOrderRoutesKey> getLogisticsOrderRoutessLogisticsOrderId() {
        return logisticsOrderRoutessLogisticsOrderId;
    }

    public void setLogisOrderWareMaterialsLogisticsOrderId(List logisOrderWareMaterialsLogisticsOrderId) {
        this.logisOrderWareMaterialsLogisticsOrderId=logisOrderWareMaterialsLogisticsOrderId;
    }

    public List<LogisOrderWareMaterial> getLogisOrderWareMaterialsLogisticsOrderId() {
        return logisOrderWareMaterialsLogisticsOrderId;
    }

    public void setTransportDemandssSubContractCaroId(List transportDemandssSubContractCaroId) {
        this.transportDemandssSubContractCaroId=transportDemandssSubContractCaroId;
    }

    public List<TransportDemands> getTransportDemandssSubContractCaroId() {
        return transportDemandssSubContractCaroId;
    }

    public void setTransportDemandssLogisticsSolutionId(List transportDemandssLogisticsSolutionId) {
        this.transportDemandssLogisticsSolutionId=transportDemandssLogisticsSolutionId;
    }

    public List<TransportDemands> getTransportDemandssLogisticsSolutionId() {
        return transportDemandssLogisticsSolutionId;
    }

    public void setWarehouseTransportssLofisticsOrderId(List warehouseTransportssLofisticsOrderId) {
        this.warehouseTransportssLofisticsOrderId=warehouseTransportssLofisticsOrderId;
    }

    public List<WarehouseTransportsKey> getWarehouseTransportssLofisticsOrderId() {
        return warehouseTransportssLofisticsOrderId;
    }

    public void setCompanysCarrierCompanyId(Companys companysCarrierCompanyId) {
        this.companysCarrierCompanyId=companysCarrierCompanyId;
    }

    public Companys getCompanysCarrierCompanyId() {
        return companysCarrierCompanyId;
    }

    public void setCompanysEntrustCompanyId(Companys companysEntrustCompanyId) {
        this.companysEntrustCompanyId=companysEntrustCompanyId;
    }

    public Companys getCompanysEntrustCompanyId() {
        return companysEntrustCompanyId;
    }

    public void setConsignTypeResDefId(ConsignType consignTypeResDefId) {
        this.consignTypeResDefId=consignTypeResDefId;
    }

    public ConsignType getConsignTypeResDefId() {
        return consignTypeResDefId;
    }

    public void setLineTacticsLineTacticsId(LineTactics lineTacticsLineTacticsId) {
        this.lineTacticsLineTacticsId=lineTacticsLineTacticsId;
    }

    public LineTactics getLineTacticsLineTacticsId() {
        return lineTacticsLineTacticsId;
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

    public void setLogisticsBranchShipNetId(LogisticsBranch logisticsBranchShipNetId) {
        this.logisticsBranchShipNetId=logisticsBranchShipNetId;
    }

    public LogisticsBranch getLogisticsBranchShipNetId() {
        return logisticsBranchShipNetId;
    }

    public void setLogisticsBranchPickupNetId(LogisticsBranch logisticsBranchPickupNetId) {
        this.logisticsBranchPickupNetId=logisticsBranchPickupNetId;
    }

    public LogisticsBranch getLogisticsBranchPickupNetId() {
        return logisticsBranchPickupNetId;
    }

    public void setLogisticsOrdersSourceCaroId(LogisticsOrders logisticsOrdersSourceCaroId) {
        this.logisticsOrdersSourceCaroId=logisticsOrdersSourceCaroId;
    }

    public LogisticsOrders getLogisticsOrdersSourceCaroId() {
        return logisticsOrdersSourceCaroId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setReturnNoteQuireReturnNoteId(ReturnNoteQuire returnNoteQuireReturnNoteId) {
        this.returnNoteQuireReturnNoteId=returnNoteQuireReturnNoteId;
    }

    public ReturnNoteQuire getReturnNoteQuireReturnNoteId() {
        return returnNoteQuireReturnNoteId;
    }

    public void setShipPickupTypeResDefId(ShipPickupType shipPickupTypeResDefId) {
        this.shipPickupTypeResDefId=shipPickupTypeResDefId;
    }

    public ShipPickupType getShipPickupTypeResDefId() {
        return shipPickupTypeResDefId;
    }

    public void setTransportBillingTransBillId(TransportBilling transportBillingTransBillId) {
        this.transportBillingTransBillId=transportBillingTransBillId;
    }

    public TransportBilling getTransportBillingTransBillId() {
        return transportBillingTransBillId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}