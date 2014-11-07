package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class EntrPurchDeliDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal quantity;

    private Long deliverynoteId;

    private Long contactDetailId;

    private Long resDefId;

    private EntrPurchDeliNote entrPurchDeliNoteDeliverynoteId;

    private Resources resourcesResDefId;

    private TruPurchContrDetails truPurchContrDetailsContactDetailId;

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

    public Long getDeliverynoteId() {
        return deliverynoteId;
    }

    public void setDeliverynoteId(Long deliverynoteId) {
        this.deliverynoteId = deliverynoteId;
    }

    public Long getContactDetailId() {
        return contactDetailId;
    }

    public void setContactDetailId(Long contactDetailId) {
        this.contactDetailId = contactDetailId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public void setEntrPurchDeliNoteDeliverynoteId(EntrPurchDeliNote entrPurchDeliNoteDeliverynoteId) {
        this.entrPurchDeliNoteDeliverynoteId=entrPurchDeliNoteDeliverynoteId;
    }

    public EntrPurchDeliNote getEntrPurchDeliNoteDeliverynoteId() {
        return entrPurchDeliNoteDeliverynoteId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setTruPurchContrDetailsContactDetailId(TruPurchContrDetails truPurchContrDetailsContactDetailId) {
        this.truPurchContrDetailsContactDetailId=truPurchContrDetailsContactDetailId;
    }

    public TruPurchContrDetails getTruPurchContrDetailsContactDetailId() {
        return truPurchContrDetailsContactDetailId;
    }
}