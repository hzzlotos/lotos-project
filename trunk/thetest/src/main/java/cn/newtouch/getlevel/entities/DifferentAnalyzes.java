package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class DifferentAnalyzes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long valuationsId;

    private Long userId;

    private Date createDate;

    private String isReplay;

    private List<AccountDifferentDetails> accountDifferentDetailssDifferentAnalyzeId = null;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsReplay() {
        return isReplay;
    }

    public void setIsReplay(String isReplay) {
        this.isReplay = isReplay;
    }

    public void setAccountDifferentDetailssDifferentAnalyzeId(List accountDifferentDetailssDifferentAnalyzeId) {
        this.accountDifferentDetailssDifferentAnalyzeId=accountDifferentDetailssDifferentAnalyzeId;
    }

    public List<AccountDifferentDetails> getAccountDifferentDetailssDifferentAnalyzeId() {
        return accountDifferentDetailssDifferentAnalyzeId;
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