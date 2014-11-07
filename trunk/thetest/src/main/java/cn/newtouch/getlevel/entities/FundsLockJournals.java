package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FundsLockJournals extends FundsLockJournalsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal fundsLock;

    private String lockReason;

    private Date lockDate;

    private Long userId;

    private Companys companysPayComId;

    private Companys companysRecComId;

    private Users usersUserId;

    public BigDecimal getFundsLock() {
        return fundsLock;
    }

    public void setFundsLock(BigDecimal fundsLock) {
        this.fundsLock = fundsLock;
    }

    public String getLockReason() {
        return lockReason;
    }

    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanysPayComId(Companys companysPayComId) {
        this.companysPayComId=companysPayComId;
    }

    public Companys getCompanysPayComId() {
        return companysPayComId;
    }

    public void setCompanysRecComId(Companys companysRecComId) {
        this.companysRecComId=companysRecComId;
    }

    public Companys getCompanysRecComId() {
        return companysRecComId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}