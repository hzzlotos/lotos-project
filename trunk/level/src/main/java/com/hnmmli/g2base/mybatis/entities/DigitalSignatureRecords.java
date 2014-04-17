package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class DigitalSignatureRecords implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date signatureDate;

    private String businessName;

    private String businessNameCode;

    private String originalText;

    private String certificate;

    private String digitalSignatureValue;

    private Long companyId;

    private Long userId;

    private Companys companysCompanyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessNameCode() {
        return businessNameCode;
    }

    public void setBusinessNameCode(String businessNameCode) {
        this.businessNameCode = businessNameCode;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getDigitalSignatureValue() {
        return digitalSignatureValue;
    }

    public void setDigitalSignatureValue(String digitalSignatureValue) {
        this.digitalSignatureValue = digitalSignatureValue;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}