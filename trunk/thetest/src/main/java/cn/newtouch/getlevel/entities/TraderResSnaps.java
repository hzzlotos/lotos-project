package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class TraderResSnaps implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long resourceId;

    private String snapName;

    private Date effectiveDate;

    private Long userId;

    private TraderResources traderResourcesResourceId;

    private Users usersUserId;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getSnapName() {
        return snapName;
    }

    public void setSnapName(String snapName) {
        this.snapName = snapName;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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