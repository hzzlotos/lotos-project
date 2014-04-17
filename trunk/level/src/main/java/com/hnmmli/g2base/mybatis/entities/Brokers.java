package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class Brokers extends BrokersKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date applyDate;

    private Date approveDate;

    private Date effetBeginDate;

    private Date effetEndDate;

    private String brokerType;

    private String effetStatus;

    private String statusComment;

    private String applyReason;

    private Long approvUserId;

    private Long agentComId;

    private Companys companysAgentComId;

    private Companys companysComId;

    private Users usersAgentUserId;

    private Users usersApprovUserId;

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getEffetBeginDate() {
        return effetBeginDate;
    }

    public void setEffetBeginDate(Date effetBeginDate) {
        this.effetBeginDate = effetBeginDate;
    }

    public Date getEffetEndDate() {
        return effetEndDate;
    }

    public void setEffetEndDate(Date effetEndDate) {
        this.effetEndDate = effetEndDate;
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    public String getEffetStatus() {
        return effetStatus;
    }

    public void setEffetStatus(String effetStatus) {
        this.effetStatus = effetStatus;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Long getApprovUserId() {
        return approvUserId;
    }

    public void setApprovUserId(Long approvUserId) {
        this.approvUserId = approvUserId;
    }

    public Long getAgentComId() {
        return agentComId;
    }

    public void setAgentComId(Long agentComId) {
        this.agentComId = agentComId;
    }

    public void setCompanysAgentComId(Companys companysAgentComId) {
        this.companysAgentComId=companysAgentComId;
    }

    public Companys getCompanysAgentComId() {
        return companysAgentComId;
    }

    public void setCompanysComId(Companys companysComId) {
        this.companysComId=companysComId;
    }

    public Companys getCompanysComId() {
        return companysComId;
    }

    public void setUsersAgentUserId(Users usersAgentUserId) {
        this.usersAgentUserId=usersAgentUserId;
    }

    public Users getUsersAgentUserId() {
        return usersAgentUserId;
    }

    public void setUsersApprovUserId(Users usersApprovUserId) {
        this.usersApprovUserId=usersApprovUserId;
    }

    public Users getUsersApprovUserId() {
        return usersApprovUserId;
    }
}