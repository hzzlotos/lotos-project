package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class ConsultTatics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date createDate;

    private Long companyId;

    private Long userId;

    private List<ConsultTacticsDetailsKey> consultTacticsDetailssConsultUserId = null;

    private Companys companysCompanyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public void setConsultTacticsDetailssConsultUserId(List consultTacticsDetailssConsultUserId) {
        this.consultTacticsDetailssConsultUserId=consultTacticsDetailssConsultUserId;
    }

    public List<ConsultTacticsDetailsKey> getConsultTacticsDetailssConsultUserId() {
        return consultTacticsDetailssConsultUserId;
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