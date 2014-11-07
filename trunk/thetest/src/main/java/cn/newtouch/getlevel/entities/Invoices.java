package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class Invoices implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long writeCompanyId;

    private String type;

    private BigDecimal money;

    private Date writeDate;

    private String title;

    private String taxCode;

    private Long address;

    private String deliveryWayId;

    private String contacter;

    private String contactPhone;

    private String status;

    private String code;

    private List<StoreSettlementInvoicesKey> storeSettlementInvoicessInvoiceId = null;

    private Companys companysWriteCompanyId;

    private LogisticsAddress logisticsAddressAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWriteCompanyId() {
        return writeCompanyId;
    }

    public void setWriteCompanyId(Long writeCompanyId) {
        this.writeCompanyId = writeCompanyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getDeliveryWayId() {
        return deliveryWayId;
    }

    public void setDeliveryWayId(String deliveryWayId) {
        this.deliveryWayId = deliveryWayId;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

    public void setStoreSettlementInvoicessInvoiceId(List storeSettlementInvoicessInvoiceId) {
        this.storeSettlementInvoicessInvoiceId=storeSettlementInvoicessInvoiceId;
    }

    public List<StoreSettlementInvoicesKey> getStoreSettlementInvoicessInvoiceId() {
        return storeSettlementInvoicessInvoiceId;
    }

    public void setCompanysWriteCompanyId(Companys companysWriteCompanyId) {
        this.companysWriteCompanyId=companysWriteCompanyId;
    }

    public Companys getCompanysWriteCompanyId() {
        return companysWriteCompanyId;
    }

    public void setLogisticsAddressAddress(LogisticsAddress logisticsAddressAddress) {
        this.logisticsAddressAddress=logisticsAddressAddress;
    }

    public LogisticsAddress getLogisticsAddressAddress() {
        return logisticsAddressAddress;
    }
}