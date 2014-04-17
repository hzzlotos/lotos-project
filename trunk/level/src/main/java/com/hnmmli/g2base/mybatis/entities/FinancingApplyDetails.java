package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class FinancingApplyDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long financingApplyId;

    private BigDecimal costControl;

    private BigDecimal collateralRate;

    private String bankBackStoreCode;

    private Long storeId;

    private Long goodsMeasureId;

    private Long resourceId;

    private List<RepaymentRedeemGoodsDetails> repaymentRedeemGoodsDetailssFinancingApplyDetailId = null;

    private FinancingApplys financingApplysFinancingApplyId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinancingApplyId() {
        return financingApplyId;
    }

    public void setFinancingApplyId(Long financingApplyId) {
        this.financingApplyId = financingApplyId;
    }

    public BigDecimal getCostControl() {
        return costControl;
    }

    public void setCostControl(BigDecimal costControl) {
        this.costControl = costControl;
    }

    public BigDecimal getCollateralRate() {
        return collateralRate;
    }

    public void setCollateralRate(BigDecimal collateralRate) {
        this.collateralRate = collateralRate;
    }

    public String getBankBackStoreCode() {
        return bankBackStoreCode;
    }

    public void setBankBackStoreCode(String bankBackStoreCode) {
        this.bankBackStoreCode = bankBackStoreCode;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public void setRepaymentRedeemGoodsDetailssFinancingApplyDetailId(List repaymentRedeemGoodsDetailssFinancingApplyDetailId) {
        this.repaymentRedeemGoodsDetailssFinancingApplyDetailId=repaymentRedeemGoodsDetailssFinancingApplyDetailId;
    }

    public List<RepaymentRedeemGoodsDetails> getRepaymentRedeemGoodsDetailssFinancingApplyDetailId() {
        return repaymentRedeemGoodsDetailssFinancingApplyDetailId;
    }

    public void setFinancingApplysFinancingApplyId(FinancingApplys financingApplysFinancingApplyId) {
        this.financingApplysFinancingApplyId=financingApplysFinancingApplyId;
    }

    public FinancingApplys getFinancingApplysFinancingApplyId() {
        return financingApplysFinancingApplyId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }
}