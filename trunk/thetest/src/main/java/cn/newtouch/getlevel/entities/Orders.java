package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String status;

    private String code;

    private BigDecimal totalPrice;

    private Date singleDate;

    private String paymentStatus;

    private String transferStatus;

    private String deliveryStatus;

    private BigDecimal pactTotalprice;

    private Long settleComId;

    private String settlementId;

    private String paymentId;

    private Long mallId;

    private Long buyComId;

    private Date countBeginTime;

    private Date orderDeadlineEffetive;

    private String orderType;

    private List<ConsulTacticsLogs> consulTacticsLogssOrderId = null;

    private List<FinancingApplys> financingApplyssOrderId = null;

    private List<OrderConsScore> orderConsScoresScoreJournalId = null;

    private List<OrderDetailsKey> orderDetailssOrderId = null;

    private List<OrderQuotasKey> orderQuotassOrderId = null;

    private Companys companysSettleComId;

    private Companys companysBuyComId;

    private Malls mallsMallId;

    private Users usersBuyComId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSingleDate() {
        return singleDate;
    }

    public void setSingleDate(Date singleDate) {
        this.singleDate = singleDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public BigDecimal getPactTotalprice() {
        return pactTotalprice;
    }

    public void setPactTotalprice(BigDecimal pactTotalprice) {
        this.pactTotalprice = pactTotalprice;
    }

    public Long getSettleComId() {
        return settleComId;
    }

    public void setSettleComId(Long settleComId) {
        this.settleComId = settleComId;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getBuyComId() {
        return buyComId;
    }

    public void setBuyComId(Long buyComId) {
        this.buyComId = buyComId;
    }

    public Date getCountBeginTime() {
        return countBeginTime;
    }

    public void setCountBeginTime(Date countBeginTime) {
        this.countBeginTime = countBeginTime;
    }

    public Date getOrderDeadlineEffetive() {
        return orderDeadlineEffetive;
    }

    public void setOrderDeadlineEffetive(Date orderDeadlineEffetive) {
        this.orderDeadlineEffetive = orderDeadlineEffetive;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setConsulTacticsLogssOrderId(List consulTacticsLogssOrderId) {
        this.consulTacticsLogssOrderId=consulTacticsLogssOrderId;
    }

    public List<ConsulTacticsLogs> getConsulTacticsLogssOrderId() {
        return consulTacticsLogssOrderId;
    }

    public void setFinancingApplyssOrderId(List financingApplyssOrderId) {
        this.financingApplyssOrderId=financingApplyssOrderId;
    }

    public List<FinancingApplys> getFinancingApplyssOrderId() {
        return financingApplyssOrderId;
    }

    public void setOrderConsScoresScoreJournalId(List orderConsScoresScoreJournalId) {
        this.orderConsScoresScoreJournalId=orderConsScoresScoreJournalId;
    }

    public List<OrderConsScore> getOrderConsScoresScoreJournalId() {
        return orderConsScoresScoreJournalId;
    }

    public void setOrderDetailssOrderId(List orderDetailssOrderId) {
        this.orderDetailssOrderId=orderDetailssOrderId;
    }

    public List<OrderDetailsKey> getOrderDetailssOrderId() {
        return orderDetailssOrderId;
    }

    public void setOrderQuotassOrderId(List orderQuotassOrderId) {
        this.orderQuotassOrderId=orderQuotassOrderId;
    }

    public List<OrderQuotasKey> getOrderQuotassOrderId() {
        return orderQuotassOrderId;
    }

    public void setCompanysSettleComId(Companys companysSettleComId) {
        this.companysSettleComId=companysSettleComId;
    }

    public Companys getCompanysSettleComId() {
        return companysSettleComId;
    }

    public void setCompanysBuyComId(Companys companysBuyComId) {
        this.companysBuyComId=companysBuyComId;
    }

    public Companys getCompanysBuyComId() {
        return companysBuyComId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }

    public void setUsersBuyComId(Users usersBuyComId) {
        this.usersBuyComId=usersBuyComId;
    }

    public Users getUsersBuyComId() {
        return usersBuyComId;
    }
}