package com.hnmlip.model;

import java.util.Date;

public class users {
    private Long id;

    private String userName;

    private String nickName;

    private String status;

    private Long companyId;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String loginPassword;

    private String mobilePhone;

    private String email;

    private String name;

    private Long portraitImageFileId;

    private String isAdmin;

    private Long logisticsAddressId;

    private String sex;

    private String qqCode;

    private String birthDate;

    private String microblogging;

    private String phone;

    private String idCardCode;

    private Long idCardFileId;

    private Date rrgistrationDate;

    private String isModifiedPassword;

    private String workbench;

    private String isOld;

    private Long dataVer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getPortraitImageFileId() {
        return portraitImageFileId;
    }

    public void setPortraitImageFileId(Long portraitImageFileId) {
        this.portraitImageFileId = portraitImageFileId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin == null ? null : isAdmin.trim();
    }

    public Long getLogisticsAddressId() {
        return logisticsAddressId;
    }

    public void setLogisticsAddressId(Long logisticsAddressId) {
        this.logisticsAddressId = logisticsAddressId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getQqCode() {
        return qqCode;
    }

    public void setQqCode(String qqCode) {
        this.qqCode = qqCode == null ? null : qqCode.trim();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate == null ? null : birthDate.trim();
    }

    public String getMicroblogging() {
        return microblogging;
    }

    public void setMicroblogging(String microblogging) {
        this.microblogging = microblogging == null ? null : microblogging.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCardCode() {
        return idCardCode;
    }

    public void setIdCardCode(String idCardCode) {
        this.idCardCode = idCardCode == null ? null : idCardCode.trim();
    }

    public Long getIdCardFileId() {
        return idCardFileId;
    }

    public void setIdCardFileId(Long idCardFileId) {
        this.idCardFileId = idCardFileId;
    }

    public Date getRrgistrationDate() {
        return rrgistrationDate;
    }

    public void setRrgistrationDate(Date rrgistrationDate) {
        this.rrgistrationDate = rrgistrationDate;
    }

    public String getIsModifiedPassword() {
        return isModifiedPassword;
    }

    public void setIsModifiedPassword(String isModifiedPassword) {
        this.isModifiedPassword = isModifiedPassword == null ? null : isModifiedPassword.trim();
    }

    public String getWorkbench() {
        return workbench;
    }

    public void setWorkbench(String workbench) {
        this.workbench = workbench == null ? null : workbench.trim();
    }

    public String getIsOld() {
        return isOld;
    }

    public void setIsOld(String isOld) {
        this.isOld = isOld == null ? null : isOld.trim();
    }

    public Long getDataVer() {
        return dataVer;
    }

    public void setDataVer(Long dataVer) {
        this.dataVer = dataVer;
    }
}