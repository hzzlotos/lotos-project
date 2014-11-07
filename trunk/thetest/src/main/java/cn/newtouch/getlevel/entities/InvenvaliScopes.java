package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class InvenvaliScopes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long valuationsId;

    private String status;

    private Long userId;

    private Long allocationsId;

    private Allocations allocationsAllocationsId;

    private InventoryValuations inventoryValuationsValuationsId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValuationsId() {
        return valuationsId;
    }

    public void setValuationsId(Long valuationsId) {
        this.valuationsId = valuationsId;
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

    public Long getAllocationsId() {
        return allocationsId;
    }

    public void setAllocationsId(Long allocationsId) {
        this.allocationsId = allocationsId;
    }

    public void setAllocationsAllocationsId(Allocations allocationsAllocationsId) {
        this.allocationsAllocationsId=allocationsAllocationsId;
    }

    public Allocations getAllocationsAllocationsId() {
        return allocationsAllocationsId;
    }

    public void setInventoryValuationsValuationsId(InventoryValuations inventoryValuationsValuationsId) {
        this.inventoryValuationsValuationsId=inventoryValuationsValuationsId;
    }

    public InventoryValuations getInventoryValuationsValuationsId() {
        return inventoryValuationsValuationsId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}