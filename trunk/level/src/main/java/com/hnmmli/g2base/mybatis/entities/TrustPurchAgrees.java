package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class TrustPurchAgrees implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date agreemeDate;

    private Long userId;

    private Long purchPlanId;

    private List<EntrPurchDeliNote> entrPurchDeliNotesAgreementId = null;

    private List<TruPurchContrDetails> truPurchContrDetailssAgreemantId = null;

    private EntrPurchPlanCount entrPurchPlanCountPurchPlanId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAgreemeDate() {
        return agreemeDate;
    }

    public void setAgreemeDate(Date agreemeDate) {
        this.agreemeDate = agreemeDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPurchPlanId() {
        return purchPlanId;
    }

    public void setPurchPlanId(Long purchPlanId) {
        this.purchPlanId = purchPlanId;
    }

    public void setEntrPurchDeliNotesAgreementId(List entrPurchDeliNotesAgreementId) {
        this.entrPurchDeliNotesAgreementId=entrPurchDeliNotesAgreementId;
    }

    public List<EntrPurchDeliNote> getEntrPurchDeliNotesAgreementId() {
        return entrPurchDeliNotesAgreementId;
    }

    public void setTruPurchContrDetailssAgreemantId(List truPurchContrDetailssAgreemantId) {
        this.truPurchContrDetailssAgreemantId=truPurchContrDetailssAgreemantId;
    }

    public List<TruPurchContrDetails> getTruPurchContrDetailssAgreemantId() {
        return truPurchContrDetailssAgreemantId;
    }

    public void setEntrPurchPlanCountPurchPlanId(EntrPurchPlanCount entrPurchPlanCountPurchPlanId) {
        this.entrPurchPlanCountPurchPlanId=entrPurchPlanCountPurchPlanId;
    }

    public EntrPurchPlanCount getEntrPurchPlanCountPurchPlanId() {
        return entrPurchPlanCountPurchPlanId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}