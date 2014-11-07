package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class TransBillPolicy implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal lightPrice;

    private BigDecimal weightPrice;

    private BigDecimal entirePrice;

    private List<BillPolicySubjectKey> billPolicySubjectsBillPolicyId = null;

    private List<LogisticsSolutions> logisticsSolutionssTransBillPolicyId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLightPrice() {
        return lightPrice;
    }

    public void setLightPrice(BigDecimal lightPrice) {
        this.lightPrice = lightPrice;
    }

    public BigDecimal getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(BigDecimal weightPrice) {
        this.weightPrice = weightPrice;
    }

    public BigDecimal getEntirePrice() {
        return entirePrice;
    }

    public void setEntirePrice(BigDecimal entirePrice) {
        this.entirePrice = entirePrice;
    }

    public void setBillPolicySubjectsBillPolicyId(List billPolicySubjectsBillPolicyId) {
        this.billPolicySubjectsBillPolicyId=billPolicySubjectsBillPolicyId;
    }

    public List<BillPolicySubjectKey> getBillPolicySubjectsBillPolicyId() {
        return billPolicySubjectsBillPolicyId;
    }

    public void setLogisticsSolutionssTransBillPolicyId(List logisticsSolutionssTransBillPolicyId) {
        this.logisticsSolutionssTransBillPolicyId=logisticsSolutionssTransBillPolicyId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssTransBillPolicyId() {
        return logisticsSolutionssTransBillPolicyId;
    }
}