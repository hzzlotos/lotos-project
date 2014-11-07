package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderQuotas extends OrderQuotasKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal quotaMoney;

    private Long userId;

    private Date quotaDate;

    private FundsFlowDetails fundsFlowDetailsFundsId;

    private Orders ordersOrderId;

    private Users usersUserId;

    public BigDecimal getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(BigDecimal quotaMoney) {
        this.quotaMoney = quotaMoney;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getQuotaDate() {
        return quotaDate;
    }

    public void setQuotaDate(Date quotaDate) {
        this.quotaDate = quotaDate;
    }

    public void setFundsFlowDetailsFundsId(FundsFlowDetails fundsFlowDetailsFundsId) {
        this.fundsFlowDetailsFundsId=fundsFlowDetailsFundsId;
    }

    public FundsFlowDetails getFundsFlowDetailsFundsId() {
        return fundsFlowDetailsFundsId;
    }

    public void setOrdersOrderId(Orders ordersOrderId) {
        this.ordersOrderId=ordersOrderId;
    }

    public Orders getOrdersOrderId() {
        return ordersOrderId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}