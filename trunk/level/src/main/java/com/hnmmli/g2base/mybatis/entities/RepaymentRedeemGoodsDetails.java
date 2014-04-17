package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class RepaymentRedeemGoodsDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long redeemGoodId;

    private Long financingApplyDetailId;

    private BigDecimal redeemQty;

    private FinancingApplyDetails financingApplyDetailsFinancingApplyDetailId;

    private RepaymentRedeemGoods repaymentRedeemGoodsRedeemGoodId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedeemGoodId() {
        return redeemGoodId;
    }

    public void setRedeemGoodId(Long redeemGoodId) {
        this.redeemGoodId = redeemGoodId;
    }

    public Long getFinancingApplyDetailId() {
        return financingApplyDetailId;
    }

    public void setFinancingApplyDetailId(Long financingApplyDetailId) {
        this.financingApplyDetailId = financingApplyDetailId;
    }

    public BigDecimal getRedeemQty() {
        return redeemQty;
    }

    public void setRedeemQty(BigDecimal redeemQty) {
        this.redeemQty = redeemQty;
    }

    public void setFinancingApplyDetailsFinancingApplyDetailId(FinancingApplyDetails financingApplyDetailsFinancingApplyDetailId) {
        this.financingApplyDetailsFinancingApplyDetailId=financingApplyDetailsFinancingApplyDetailId;
    }

    public FinancingApplyDetails getFinancingApplyDetailsFinancingApplyDetailId() {
        return financingApplyDetailsFinancingApplyDetailId;
    }

    public void setRepaymentRedeemGoodsRedeemGoodId(RepaymentRedeemGoods repaymentRedeemGoodsRedeemGoodId) {
        this.repaymentRedeemGoodsRedeemGoodId=repaymentRedeemGoodsRedeemGoodId;
    }

    public RepaymentRedeemGoods getRepaymentRedeemGoodsRedeemGoodId() {
        return repaymentRedeemGoodsRedeemGoodId;
    }
}