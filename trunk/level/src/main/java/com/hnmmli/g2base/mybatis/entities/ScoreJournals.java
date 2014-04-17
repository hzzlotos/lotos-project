package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class ScoreJournals implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal effetScore;

    private BigDecimal uselessScore;

    private Date createTime;

    private Date effetiveDate;

    private Date disableDate;

    private Long mallId;

    private Long comId;

    private List<OrderConsScore> orderConsScoresScoreJournalId = null;

    private Companys companysComId;

    private Malls mallsMallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEffetScore() {
        return effetScore;
    }

    public void setEffetScore(BigDecimal effetScore) {
        this.effetScore = effetScore;
    }

    public BigDecimal getUselessScore() {
        return uselessScore;
    }

    public void setUselessScore(BigDecimal uselessScore) {
        this.uselessScore = uselessScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public void setOrderConsScoresScoreJournalId(List orderConsScoresScoreJournalId) {
        this.orderConsScoresScoreJournalId=orderConsScoresScoreJournalId;
    }

    public List<OrderConsScore> getOrderConsScoresScoreJournalId() {
        return orderConsScoresScoreJournalId;
    }

    public void setCompanysComId(Companys companysComId) {
        this.companysComId=companysComId;
    }

    public Companys getCompanysComId() {
        return companysComId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}