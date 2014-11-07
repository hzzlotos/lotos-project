package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class TransportDemands implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long endLognId;

    private Long beginLognId;

    private BigDecimal distance;

    private Date effectiveBeginTime;

    private Date effectiveEndTime;

    private Date lastUpdateTime;

    private String status;

    private Long logisticsSolutionId;

    private Long userId;

    private String goodsName;

    private Long subContractCaroId;

    private Date planStartTiem;

    private Date planArriveTime;

    private Long payCompanyId;

    private Long shipPickupId;

    private Long lineTacticId;

    private Long transDemandId;

    private Long goodsMeasureId;

    private List<TransportDemandResponses> transportDemandResponsessTransDemandId = null;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private LineTactics lineTacticsLineTacticId;

    private LogisticsAddress logisticsAddressEndLognId;

    private LogisticsAddress logisticsAddressBeginLognId;

    private LogisticsOrders logisticsOrdersLogisticsSolutionId;

    private LogisticsOrders logisticsOrdersSubContractCaroId;

    private ReturnNoteQuire returnNoteQuireTransDemandId;

    private ShipPickupType shipPickupTypeShipPickupId;

    private TransSettleCompany transSettleCompanyPayCompanyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEndLognId() {
        return endLognId;
    }

    public void setEndLognId(Long endLognId) {
        this.endLognId = endLognId;
    }

    public Long getBeginLognId() {
        return beginLognId;
    }

    public void setBeginLognId(Long beginLognId) {
        this.beginLognId = beginLognId;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Date getEffectiveBeginTime() {
        return effectiveBeginTime;
    }

    public void setEffectiveBeginTime(Date effectiveBeginTime) {
        this.effectiveBeginTime = effectiveBeginTime;
    }

    public Date getEffectiveEndTime() {
        return effectiveEndTime;
    }

    public void setEffectiveEndTime(Date effectiveEndTime) {
        this.effectiveEndTime = effectiveEndTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLogisticsSolutionId() {
        return logisticsSolutionId;
    }

    public void setLogisticsSolutionId(Long logisticsSolutionId) {
        this.logisticsSolutionId = logisticsSolutionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getSubContractCaroId() {
        return subContractCaroId;
    }

    public void setSubContractCaroId(Long subContractCaroId) {
        this.subContractCaroId = subContractCaroId;
    }

    public Date getPlanStartTiem() {
        return planStartTiem;
    }

    public void setPlanStartTiem(Date planStartTiem) {
        this.planStartTiem = planStartTiem;
    }

    public Date getPlanArriveTime() {
        return planArriveTime;
    }

    public void setPlanArriveTime(Date planArriveTime) {
        this.planArriveTime = planArriveTime;
    }

    public Long getPayCompanyId() {
        return payCompanyId;
    }

    public void setPayCompanyId(Long payCompanyId) {
        this.payCompanyId = payCompanyId;
    }

    public Long getShipPickupId() {
        return shipPickupId;
    }

    public void setShipPickupId(Long shipPickupId) {
        this.shipPickupId = shipPickupId;
    }

    public Long getLineTacticId() {
        return lineTacticId;
    }

    public void setLineTacticId(Long lineTacticId) {
        this.lineTacticId = lineTacticId;
    }

    public Long getTransDemandId() {
        return transDemandId;
    }

    public void setTransDemandId(Long transDemandId) {
        this.transDemandId = transDemandId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setTransportDemandResponsessTransDemandId(List transportDemandResponsessTransDemandId) {
        this.transportDemandResponsessTransDemandId=transportDemandResponsessTransDemandId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessTransDemandId() {
        return transportDemandResponsessTransDemandId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setLineTacticsLineTacticId(LineTactics lineTacticsLineTacticId) {
        this.lineTacticsLineTacticId=lineTacticsLineTacticId;
    }

    public LineTactics getLineTacticsLineTacticId() {
        return lineTacticsLineTacticId;
    }

    public void setLogisticsAddressEndLognId(LogisticsAddress logisticsAddressEndLognId) {
        this.logisticsAddressEndLognId=logisticsAddressEndLognId;
    }

    public LogisticsAddress getLogisticsAddressEndLognId() {
        return logisticsAddressEndLognId;
    }

    public void setLogisticsAddressBeginLognId(LogisticsAddress logisticsAddressBeginLognId) {
        this.logisticsAddressBeginLognId=logisticsAddressBeginLognId;
    }

    public LogisticsAddress getLogisticsAddressBeginLognId() {
        return logisticsAddressBeginLognId;
    }

    public void setLogisticsOrdersLogisticsSolutionId(LogisticsOrders logisticsOrdersLogisticsSolutionId) {
        this.logisticsOrdersLogisticsSolutionId=logisticsOrdersLogisticsSolutionId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsSolutionId() {
        return logisticsOrdersLogisticsSolutionId;
    }

    public void setLogisticsOrdersSubContractCaroId(LogisticsOrders logisticsOrdersSubContractCaroId) {
        this.logisticsOrdersSubContractCaroId=logisticsOrdersSubContractCaroId;
    }

    public LogisticsOrders getLogisticsOrdersSubContractCaroId() {
        return logisticsOrdersSubContractCaroId;
    }

    public void setReturnNoteQuireTransDemandId(ReturnNoteQuire returnNoteQuireTransDemandId) {
        this.returnNoteQuireTransDemandId=returnNoteQuireTransDemandId;
    }

    public ReturnNoteQuire getReturnNoteQuireTransDemandId() {
        return returnNoteQuireTransDemandId;
    }

    public void setShipPickupTypeShipPickupId(ShipPickupType shipPickupTypeShipPickupId) {
        this.shipPickupTypeShipPickupId=shipPickupTypeShipPickupId;
    }

    public ShipPickupType getShipPickupTypeShipPickupId() {
        return shipPickupTypeShipPickupId;
    }

    public void setTransSettleCompanyPayCompanyId(TransSettleCompany transSettleCompanyPayCompanyId) {
        this.transSettleCompanyPayCompanyId=transSettleCompanyPayCompanyId;
    }

    public TransSettleCompany getTransSettleCompanyPayCompanyId() {
        return transSettleCompanyPayCompanyId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}