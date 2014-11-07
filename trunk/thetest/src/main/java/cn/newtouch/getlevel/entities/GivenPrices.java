package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GivenPrices extends GivenPricesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal unitPrice;

    private Date activeDate;

    private Long userId;

    private Companys companysCompanyId;

    private TraderResources traderResourcesResourceId;

    private Users usersUserId;

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setTraderResourcesResourceId(TraderResources traderResourcesResourceId) {
        this.traderResourcesResourceId=traderResourcesResourceId;
    }

    public TraderResources getTraderResourcesResourceId() {
        return traderResourcesResourceId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}