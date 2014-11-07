package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductiveFulfill implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long productiveId;

    private Date honorDate;

    private BigDecimal quantity;

    private Long userId;

    private Productivitys productivitysProductiveId;

    private Resources resourcesProductiveId;

    private Users usersUserId;

    public Long getProductiveId() {
        return productiveId;
    }

    public void setProductiveId(Long productiveId) {
        this.productiveId = productiveId;
    }

    public Date getHonorDate() {
        return honorDate;
    }

    public void setHonorDate(Date honorDate) {
        this.honorDate = honorDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductivitysProductiveId(Productivitys productivitysProductiveId) {
        this.productivitysProductiveId=productivitysProductiveId;
    }

    public Productivitys getProductivitysProductiveId() {
        return productivitysProductiveId;
    }

    public void setResourcesProductiveId(Resources resourcesProductiveId) {
        this.resourcesProductiveId=resourcesProductiveId;
    }

    public Resources getResourcesProductiveId() {
        return resourcesProductiveId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}