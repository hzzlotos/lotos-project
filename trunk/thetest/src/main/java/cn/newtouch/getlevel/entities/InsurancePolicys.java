package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InsurancePolicys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsOrderId;

    private Long insuranceId;

    private BigDecimal amountInsured;

    private BigDecimal premium;

    private String beneficiaryCompany;

    private String beneficiaryName;

    private String beneficiaryIdentityCard;

    private String organizAtionCode;

    private Date beginValidDate;

    private Date endValidDate;

    private String insuranceNo;

    private Insurances insurancesInsuranceId;

    private LogisticsOrders logisticsOrdersLogisticsOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsOrderId() {
        return logisticsOrderId;
    }

    public void setLogisticsOrderId(Long logisticsOrderId) {
        this.logisticsOrderId = logisticsOrderId;
    }

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public BigDecimal getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(BigDecimal amountInsured) {
        this.amountInsured = amountInsured;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public String getBeneficiaryCompany() {
        return beneficiaryCompany;
    }

    public void setBeneficiaryCompany(String beneficiaryCompany) {
        this.beneficiaryCompany = beneficiaryCompany;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryIdentityCard() {
        return beneficiaryIdentityCard;
    }

    public void setBeneficiaryIdentityCard(String beneficiaryIdentityCard) {
        this.beneficiaryIdentityCard = beneficiaryIdentityCard;
    }

    public String getOrganizAtionCode() {
        return organizAtionCode;
    }

    public void setOrganizAtionCode(String organizAtionCode) {
        this.organizAtionCode = organizAtionCode;
    }

    public Date getBeginValidDate() {
        return beginValidDate;
    }

    public void setBeginValidDate(Date beginValidDate) {
        this.beginValidDate = beginValidDate;
    }

    public Date getEndValidDate() {
        return endValidDate;
    }

    public void setEndValidDate(Date endValidDate) {
        this.endValidDate = endValidDate;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public void setInsurancesInsuranceId(Insurances insurancesInsuranceId) {
        this.insurancesInsuranceId=insurancesInsuranceId;
    }

    public Insurances getInsurancesInsuranceId() {
        return insurancesInsuranceId;
    }

    public void setLogisticsOrdersLogisticsOrderId(LogisticsOrders logisticsOrdersLogisticsOrderId) {
        this.logisticsOrdersLogisticsOrderId=logisticsOrdersLogisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsOrderId() {
        return logisticsOrdersLogisticsOrderId;
    }
}