package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class RouteReceipts implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long destinationId;

    private Long originId;

    private Long vehicleId;

    private Date plannedBeginTime;

    private Date plannedEndTime;

    private BigDecimal plannedTime;

    private Date actualBeginTime;

    private Date actualEndTime;

    private BigDecimal actualTime;

    private Long driverId;

    private BigDecimal distance;

    private String remark;

    private String status;

    private String routeNo;

    private String signPassword;

    private Long carrierBillId;

    private Long lineTacticsId;

    private List<LogisticsOrderRoutesKey> logisticsOrderRoutessRouteReceiptId = null;

    private List<RouteSocialMaterial> routeSocialMaterialsRouteReceiptId = null;

    private List<RouteWarehMaterials> routeWarehMaterialssRouteId = null;

    private LineTactics lineTacticsLineTacticsId;

    private LogisticsAddress logisticsAddressOriginId;

    private LogisticsAddress logisticsAddressDestinationId;

    private TransportBilling transportBillingCarrierBillId;

    private Users usersDriverId;

    private Vehicles vehiclesVehicleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

    public Date getActualBeginTime() {
        return actualBeginTime;
    }

    public void setActualBeginTime(Date actualBeginTime) {
        this.actualBeginTime = actualBeginTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public BigDecimal getActualTime() {
        return actualTime;
    }

    public void setActualTime(BigDecimal actualTime) {
        this.actualTime = actualTime;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public String getSignPassword() {
        return signPassword;
    }

    public void setSignPassword(String signPassword) {
        this.signPassword = signPassword;
    }

    public Long getCarrierBillId() {
        return carrierBillId;
    }

    public void setCarrierBillId(Long carrierBillId) {
        this.carrierBillId = carrierBillId;
    }

    public Long getLineTacticsId() {
        return lineTacticsId;
    }

    public void setLineTacticsId(Long lineTacticsId) {
        this.lineTacticsId = lineTacticsId;
    }

    public void setLogisticsOrderRoutessRouteReceiptId(List logisticsOrderRoutessRouteReceiptId) {
        this.logisticsOrderRoutessRouteReceiptId=logisticsOrderRoutessRouteReceiptId;
    }

    public List<LogisticsOrderRoutesKey> getLogisticsOrderRoutessRouteReceiptId() {
        return logisticsOrderRoutessRouteReceiptId;
    }

    public void setRouteSocialMaterialsRouteReceiptId(List routeSocialMaterialsRouteReceiptId) {
        this.routeSocialMaterialsRouteReceiptId=routeSocialMaterialsRouteReceiptId;
    }

    public List<RouteSocialMaterial> getRouteSocialMaterialsRouteReceiptId() {
        return routeSocialMaterialsRouteReceiptId;
    }

    public void setRouteWarehMaterialssRouteId(List routeWarehMaterialssRouteId) {
        this.routeWarehMaterialssRouteId=routeWarehMaterialssRouteId;
    }

    public List<RouteWarehMaterials> getRouteWarehMaterialssRouteId() {
        return routeWarehMaterialssRouteId;
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

    public void setTransportBillingCarrierBillId(TransportBilling transportBillingCarrierBillId) {
        this.transportBillingCarrierBillId=transportBillingCarrierBillId;
    }

    public TransportBilling getTransportBillingCarrierBillId() {
        return transportBillingCarrierBillId;
    }

    public void setUsersDriverId(Users usersDriverId) {
        this.usersDriverId=usersDriverId;
    }

    public Users getUsersDriverId() {
        return usersDriverId;
    }

    public void setVehiclesVehicleId(Vehicles vehiclesVehicleId) {
        this.vehiclesVehicleId=vehiclesVehicleId;
    }

    public Vehicles getVehiclesVehicleId() {
        return vehiclesVehicleId;
    }
}