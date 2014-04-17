package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class IntegralActivities implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long mallId;

    private Long userId;

    private Date begintime;

    private Date edntime;

    private String status;

    private Long uperLimit;

    private Long currentGiven;

    private BigDecimal exchangeRate;

    private Date intaDate;

    private Date interchangeDate;

    private Date effetiveDate;

    private Date disableDate;

    private List<ScoreStrategys> scoreStrategyssMallId = null;

    private Malls mallsMallId;

    private Users usersUserId;

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEdntime() {
        return edntime;
    }

    public void setEdntime(Date edntime) {
        this.edntime = edntime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUperLimit() {
        return uperLimit;
    }

    public void setUperLimit(Long uperLimit) {
        this.uperLimit = uperLimit;
    }

    public Long getCurrentGiven() {
        return currentGiven;
    }

    public void setCurrentGiven(Long currentGiven) {
        this.currentGiven = currentGiven;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getIntaDate() {
        return intaDate;
    }

    public void setIntaDate(Date intaDate) {
        this.intaDate = intaDate;
    }

    public Date getInterchangeDate() {
        return interchangeDate;
    }

    public void setInterchangeDate(Date interchangeDate) {
        this.interchangeDate = interchangeDate;
    }

    public Date getEffetiveDate() {
        return effetiveDate;
    }

    public void setEffetiveDate(Date effetiveDate) {
        this.effetiveDate = effetiveDate;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
    }

    public void setScoreStrategyssMallId(List scoreStrategyssMallId) {
        this.scoreStrategyssMallId=scoreStrategyssMallId;
    }

    public List<ScoreStrategys> getScoreStrategyssMallId() {
        return scoreStrategyssMallId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}