package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class CollateralSummaries extends CollateralSummariesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date updateDate;

    private Long goodsMeasureId;

    private Banks banksBankId;

    private Companys companysCompanyId;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private Resources resourcesResourceId;

    private Stores storesStoreId;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setBanksBankId(Banks banksBankId) {
        this.banksBankId=banksBankId;
    }

    public Banks getBanksBankId() {
        return banksBankId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
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