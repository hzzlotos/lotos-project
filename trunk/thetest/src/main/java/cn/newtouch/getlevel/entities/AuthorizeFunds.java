package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AuthorizeFunds extends AuthorizeFundsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal priceDiff;

    private Date actionDate;

    private String status;

    private Long userId;

    private FundsFlowDetails fundsFlowDetailsFundsId;

    private Resources resourcesResDefId;

    private Users usersUserId;

    public BigDecimal getPriceDiff() {
        return priceDiff;
    }

    public void setPriceDiff(BigDecimal priceDiff) {
        this.priceDiff = priceDiff;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFundsFlowDetailsFundsId(FundsFlowDetails fundsFlowDetailsFundsId) {
        this.fundsFlowDetailsFundsId=fundsFlowDetailsFundsId;
    }

    public FundsFlowDetails getFundsFlowDetailsFundsId() {
        return fundsFlowDetailsFundsId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}