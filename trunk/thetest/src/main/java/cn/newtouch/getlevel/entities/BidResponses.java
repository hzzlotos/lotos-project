package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BidResponses implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long biddingId;

    private Long userId;

    private BigDecimal unitPrice;

    private BigDecimal quantity;

    private BigDecimal totalPrice;

    private Date bidTime;

    private BigDecimal payableDeposit;

    private Long enterpriseId;

    private String isWin;

    private Long validContractId;

    private Date validContractDate;

    private Biddings biddingsBiddingId;

    private Companys companysEnterpriseId;

    private FileInfos fileInfosValidContractId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiddingId() {
        return biddingId;
    }

    public void setBiddingId(Long biddingId) {
        this.biddingId = biddingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public BigDecimal getPayableDeposit() {
        return payableDeposit;
    }

    public void setPayableDeposit(BigDecimal payableDeposit) {
        this.payableDeposit = payableDeposit;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getIsWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = isWin;
    }

    public Long getValidContractId() {
        return validContractId;
    }

    public void setValidContractId(Long validContractId) {
        this.validContractId = validContractId;
    }

    public Date getValidContractDate() {
        return validContractDate;
    }

    public void setValidContractDate(Date validContractDate) {
        this.validContractDate = validContractDate;
    }

    public void setBiddingsBiddingId(Biddings biddingsBiddingId) {
        this.biddingsBiddingId=biddingsBiddingId;
    }

    public Biddings getBiddingsBiddingId() {
        return biddingsBiddingId;
    }

    public void setCompanysEnterpriseId(Companys companysEnterpriseId) {
        this.companysEnterpriseId=companysEnterpriseId;
    }

    public Companys getCompanysEnterpriseId() {
        return companysEnterpriseId;
    }

    public void setFileInfosValidContractId(FileInfos fileInfosValidContractId) {
        this.fileInfosValidContractId=fileInfosValidContractId;
    }

    public FileInfos getFileInfosValidContractId() {
        return fileInfosValidContractId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}