package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class InstalmentTatics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long memblvSettleId;

    private BigDecimal downPay;

    private BigDecimal shipProportion;

    private MemberlvSettle memberlvSettleMemblvSettleId;

    public Long getMemblvSettleId() {
        return memblvSettleId;
    }

    public void setMemblvSettleId(Long memblvSettleId) {
        this.memblvSettleId = memblvSettleId;
    }

    public BigDecimal getDownPay() {
        return downPay;
    }

    public void setDownPay(BigDecimal downPay) {
        this.downPay = downPay;
    }

    public BigDecimal getShipProportion() {
        return shipProportion;
    }

    public void setShipProportion(BigDecimal shipProportion) {
        this.shipProportion = shipProportion;
    }

    public void setMemberlvSettleMemblvSettleId(MemberlvSettle memberlvSettleMemblvSettleId) {
        this.memberlvSettleMemblvSettleId=memberlvSettleMemblvSettleId;
    }

    public MemberlvSettle getMemberlvSettleMemblvSettleId() {
        return memberlvSettleMemblvSettleId;
    }
}