package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class TruPurchContrDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal amonut;

    private Long agreemantId;

    private Long resDefId;

    private List<EntrPurchDeliDetails> entrPurchDeliDetailssContactDetailId = null;

    private Resources resourcesResDefId;

    private TrustPurchAgrees trustPurchAgreesAgreemantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmonut() {
        return amonut;
    }

    public void setAmonut(BigDecimal amonut) {
        this.amonut = amonut;
    }

    public Long getAgreemantId() {
        return agreemantId;
    }

    public void setAgreemantId(Long agreemantId) {
        this.agreemantId = agreemantId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public void setEntrPurchDeliDetailssContactDetailId(List entrPurchDeliDetailssContactDetailId) {
        this.entrPurchDeliDetailssContactDetailId=entrPurchDeliDetailssContactDetailId;
    }

    public List<EntrPurchDeliDetails> getEntrPurchDeliDetailssContactDetailId() {
        return entrPurchDeliDetailssContactDetailId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setTrustPurchAgreesAgreemantId(TrustPurchAgrees trustPurchAgreesAgreemantId) {
        this.trustPurchAgreesAgreemantId=trustPurchAgreesAgreemantId;
    }

    public TrustPurchAgrees getTrustPurchAgreesAgreemantId() {
        return trustPurchAgreesAgreemantId;
    }
}