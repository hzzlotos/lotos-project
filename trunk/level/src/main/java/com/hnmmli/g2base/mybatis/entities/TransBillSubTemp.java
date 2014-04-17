package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class TransBillSubTemp implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String subjectName;

    private Long subjectSort;

    private BigDecimal downTotalPrice;

    private BigDecimal upperTotalPrice;

    private String variable;

    private String calculation;

    private Date updateDate;

    private List<BillPolicySubjectKey> billPolicySubjectsBillSubjectId = null;

    private List<TransBillSubjectKey> transBillSubjectsSubjectId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getSubjectSort() {
        return subjectSort;
    }

    public void setSubjectSort(Long subjectSort) {
        this.subjectSort = subjectSort;
    }

    public BigDecimal getDownTotalPrice() {
        return downTotalPrice;
    }

    public void setDownTotalPrice(BigDecimal downTotalPrice) {
        this.downTotalPrice = downTotalPrice;
    }

    public BigDecimal getUpperTotalPrice() {
        return upperTotalPrice;
    }

    public void setUpperTotalPrice(BigDecimal upperTotalPrice) {
        this.upperTotalPrice = upperTotalPrice;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setBillPolicySubjectsBillSubjectId(List billPolicySubjectsBillSubjectId) {
        this.billPolicySubjectsBillSubjectId=billPolicySubjectsBillSubjectId;
    }

    public List<BillPolicySubjectKey> getBillPolicySubjectsBillSubjectId() {
        return billPolicySubjectsBillSubjectId;
    }

    public void setTransBillSubjectsSubjectId(List transBillSubjectsSubjectId) {
        this.transBillSubjectsSubjectId=transBillSubjectsSubjectId;
    }

    public List<TransBillSubjectKey> getTransBillSubjectsSubjectId() {
        return transBillSubjectsSubjectId;
    }
}