package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderConsScore implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long scoreJournalId;

    private BigDecimal consumeScore;

    private Date actionDate;

    private Orders ordersScoreJournalId;

    private ScoreJournals scoreJournalsScoreJournalId;

    private Users usersScoreJournalId;

    public Long getScoreJournalId() {
        return scoreJournalId;
    }

    public void setScoreJournalId(Long scoreJournalId) {
        this.scoreJournalId = scoreJournalId;
    }

    public BigDecimal getConsumeScore() {
        return consumeScore;
    }

    public void setConsumeScore(BigDecimal consumeScore) {
        this.consumeScore = consumeScore;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public void setOrdersScoreJournalId(Orders ordersScoreJournalId) {
        this.ordersScoreJournalId=ordersScoreJournalId;
    }

    public Orders getOrdersScoreJournalId() {
        return ordersScoreJournalId;
    }

    public void setScoreJournalsScoreJournalId(ScoreJournals scoreJournalsScoreJournalId) {
        this.scoreJournalsScoreJournalId=scoreJournalsScoreJournalId;
    }

    public ScoreJournals getScoreJournalsScoreJournalId() {
        return scoreJournalsScoreJournalId;
    }

    public void setUsersScoreJournalId(Users usersScoreJournalId) {
        this.usersScoreJournalId=usersScoreJournalId;
    }

    public Users getUsersScoreJournalId() {
        return usersScoreJournalId;
    }
}