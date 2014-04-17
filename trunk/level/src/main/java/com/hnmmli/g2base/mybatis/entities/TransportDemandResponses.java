package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransportDemandResponses implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    private Long transDemandId;

    private Date plannedBeginTime;

    private Date plannedEndTime;

    private BigDecimal plannedTime;

    private String isWinBidding;

    private Long transBillId;

    private Long shipNetId;

    private Long pickupNetId;

    private Long lineTactiscId;

    private Long shipPickupId;

    private Long shipAddressId;

    private Long pickupAddressId;

    private String vehicleType;

    private LineTactics lineTacticsLineTactiscId;

    private LogisticsAddress logisticsAddressPickupAddressId;

    private LogisticsAddress logisticsAddressShipAddressId;

    private LogisticsBranch logisticsBranchShipNetId;

    private LogisticsBranch logisticsBranchPickupNetId;

    private ShipPickupType shipPickupTypeShipPickupId;

    private TransportBilling transportBillingTransBillId;

    private TransportDemands transportDemandsTransDemandId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTransDemandId() {
        return transDemandId;
    }

    public void setTransDemandId(Long transDemandId) {
        this.transDemandId = transDemandId;
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

    public String getIsWinBidding() {
        return isWinBidding;
    }

    public void setIsWinBidding(String isWinBidding) {
        this.isWinBidding = isWinBidding;
    }

    public Long getTransBillId() {
        return transBillId;
    }

    public void setTransBillId(Long transBillId) {
        this.transBillId = transBillId;
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

    public Long getLineTactiscId() {
        return lineTactiscId;
    }

    public void setLineTactiscId(Long lineTactiscId) {
        this.lineTactiscId = lineTactiscId;
    }

    public Long getShipPickupId() {
        return shipPickupId;
    }

    public void setShipPickupId(Long shipPickupId) {
        this.shipPickupId = shipPickupId;
    }

    public Long getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Long shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public Long getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(Long pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLineTacticsLineTactiscId(LineTactics lineTacticsLineTactiscId) {
        this.lineTacticsLineTactiscId=lineTacticsLineTactiscId;
    }

    public LineTactics getLineTacticsLineTactiscId() {
        return lineTacticsLineTactiscId;
    }

    public void setLogisticsAddressPickupAddressId(LogisticsAddress logisticsAddressPickupAddressId) {
        this.logisticsAddressPickupAddressId=logisticsAddressPickupAddressId;
    }

    public LogisticsAddress getLogisticsAddressPickupAddressId() {
        return logisticsAddressPickupAddressId;
    }

    public void setLogisticsAddressShipAddressId(LogisticsAddress logisticsAddressShipAddressId) {
        this.logisticsAddressShipAddressId=logisticsAddressShipAddressId;
    }

    public LogisticsAddress getLogisticsAddressShipAddressId() {
        return logisticsAddressShipAddressId;
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

    public void setShipPickupTypeShipPickupId(ShipPickupType shipPickupTypeShipPickupId) {
        this.shipPickupTypeShipPickupId=shipPickupTypeShipPickupId;
    }

    public ShipPickupType getShipPickupTypeShipPickupId() {
        return shipPickupTypeShipPickupId;
    }

    public void setTransportBillingTransBillId(TransportBilling transportBillingTransBillId) {
        this.transportBillingTransBillId=transportBillingTransBillId;
    }

    public TransportBilling getTransportBillingTransBillId() {
        return transportBillingTransBillId;
    }

    public void setTransportDemandsTransDemandId(TransportDemands transportDemandsTransDemandId) {
        this.transportDemandsTransDemandId=transportDemandsTransDemandId;
    }

    public TransportDemands getTransportDemandsTransDemandId() {
        return transportDemandsTransDemandId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}