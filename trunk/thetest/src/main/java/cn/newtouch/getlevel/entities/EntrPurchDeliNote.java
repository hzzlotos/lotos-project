package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class EntrPurchDeliNote implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String deliveryNote;

    private String submitStatus;

    private Long storeJobId;

    private Long storeId;

    private Long agreementId;

    private List<EntrPurchDeliDetails> entrPurchDeliDetailssDeliverynoteId = null;

    private Stores storesStoreId;

    private StoreJobs storeJobsStoreJobId;

    private TrustPurchAgrees trustPurchAgreesAgreementId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public void setEntrPurchDeliDetailssDeliverynoteId(List entrPurchDeliDetailssDeliverynoteId) {
        this.entrPurchDeliDetailssDeliverynoteId=entrPurchDeliDetailssDeliverynoteId;
    }

    public List<EntrPurchDeliDetails> getEntrPurchDeliDetailssDeliverynoteId() {
        return entrPurchDeliDetailssDeliverynoteId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }

    public void setTrustPurchAgreesAgreementId(TrustPurchAgrees trustPurchAgreesAgreementId) {
        this.trustPurchAgreesAgreementId=trustPurchAgreesAgreementId;
    }

    public TrustPurchAgrees getTrustPurchAgreesAgreementId() {
        return trustPurchAgreesAgreementId;
    }
}