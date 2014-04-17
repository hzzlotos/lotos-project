package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class MallSettlements implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String settleType;

    private Long mallId;

    private Date createDate;

    private Date updateDate;

    private Malls mallsMallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}