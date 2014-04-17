package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExcelInResDetails extends ExcelInResDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal showPrice;

    private BigDecimal settlePrice;

    private String isPassCheck;

    private Date importDate;

    private Long goodsMeasureId;

    private ExcelInRes excelInResExcimresId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private Resources resourcesResDefId;

    public BigDecimal getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public String getIsPassCheck() {
        return isPassCheck;
    }

    public void setIsPassCheck(String isPassCheck) {
        this.isPassCheck = isPassCheck;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setExcelInResExcimresId(ExcelInRes excelInResExcimresId) {
        this.excelInResExcimresId=excelInResExcimresId;
    }

    public ExcelInRes getExcelInResExcimresId() {
        return excelInResExcimresId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }
}