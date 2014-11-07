package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompanyResources extends CompanyResourcesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private String status;

    private BigDecimal defaultPrice;

    private String pictureJson;

    private Companys companysCompanyId;

    private Resources resourcesResourceId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getPictureJson() {
        return pictureJson;
    }

    public void setPictureJson(String pictureJson) {
        this.pictureJson = pictureJson;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }
}