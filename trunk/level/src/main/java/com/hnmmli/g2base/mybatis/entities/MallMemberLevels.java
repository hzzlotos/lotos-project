package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class MallMemberLevels implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long mallId;

    private BigDecimal traderMoneyLimit;

    private BigDecimal traderAmountCurday;

    private String effetiveStatus;

    private List<MallMembersKey> mallMemberssMemberLevelId = null;

    private List<MemberlvSettle> memberlvSettlesMenberLevelId = null;

    private List<MemberPrices> memberPricessMallId = null;

    private Malls mallsMallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public BigDecimal getTraderMoneyLimit() {
        return traderMoneyLimit;
    }

    public void setTraderMoneyLimit(BigDecimal traderMoneyLimit) {
        this.traderMoneyLimit = traderMoneyLimit;
    }

    public BigDecimal getTraderAmountCurday() {
        return traderAmountCurday;
    }

    public void setTraderAmountCurday(BigDecimal traderAmountCurday) {
        this.traderAmountCurday = traderAmountCurday;
    }

    public String getEffetiveStatus() {
        return effetiveStatus;
    }

    public void setEffetiveStatus(String effetiveStatus) {
        this.effetiveStatus = effetiveStatus;
    }

    public void setMallMemberssMemberLevelId(List mallMemberssMemberLevelId) {
        this.mallMemberssMemberLevelId=mallMemberssMemberLevelId;
    }

    public List<MallMembersKey> getMallMemberssMemberLevelId() {
        return mallMemberssMemberLevelId;
    }

    public void setMemberlvSettlesMenberLevelId(List memberlvSettlesMenberLevelId) {
        this.memberlvSettlesMenberLevelId=memberlvSettlesMenberLevelId;
    }

    public List<MemberlvSettle> getMemberlvSettlesMenberLevelId() {
        return memberlvSettlesMenberLevelId;
    }

    public void setMemberPricessMallId(List memberPricessMallId) {
        this.memberPricessMallId=memberPricessMallId;
    }

    public List<MemberPrices> getMemberPricessMallId() {
        return memberPricessMallId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}