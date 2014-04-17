package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class LogisticsJobTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long linkUpId;

    private Long companyId;

    private String jobType;

    private String links;

    private Long userId;

    private String appendFunction;

    private List<LogisticsJobFlows> logisticsJobFlowssLogisticsJobTempId = null;

    private List<LogisticsJobLinkPower> logisticsJobLinkPowersLogisticsJobTempId = null;

    private List<LogisticsJobTemplate> logisticsJobTemplatesLinkUpId = null;

    private Companys companysCompanyId;

    private LogisticsJobTemplate logisticsJobTemplateLinkUpId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLinkUpId() {
        return linkUpId;
    }

    public void setLinkUpId(Long linkUpId) {
        this.linkUpId = linkUpId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAppendFunction() {
        return appendFunction;
    }

    public void setAppendFunction(String appendFunction) {
        this.appendFunction = appendFunction;
    }

    public void setLogisticsJobFlowssLogisticsJobTempId(List logisticsJobFlowssLogisticsJobTempId) {
        this.logisticsJobFlowssLogisticsJobTempId=logisticsJobFlowssLogisticsJobTempId;
    }

    public List<LogisticsJobFlows> getLogisticsJobFlowssLogisticsJobTempId() {
        return logisticsJobFlowssLogisticsJobTempId;
    }

    public void setLogisticsJobLinkPowersLogisticsJobTempId(List logisticsJobLinkPowersLogisticsJobTempId) {
        this.logisticsJobLinkPowersLogisticsJobTempId=logisticsJobLinkPowersLogisticsJobTempId;
    }

    public List<LogisticsJobLinkPower> getLogisticsJobLinkPowersLogisticsJobTempId() {
        return logisticsJobLinkPowersLogisticsJobTempId;
    }

    public void setLogisticsJobTemplatesLinkUpId(List logisticsJobTemplatesLinkUpId) {
        this.logisticsJobTemplatesLinkUpId=logisticsJobTemplatesLinkUpId;
    }

    public List<LogisticsJobTemplate> getLogisticsJobTemplatesLinkUpId() {
        return logisticsJobTemplatesLinkUpId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setLogisticsJobTemplateLinkUpId(LogisticsJobTemplate logisticsJobTemplateLinkUpId) {
        this.logisticsJobTemplateLinkUpId=logisticsJobTemplateLinkUpId;
    }

    public LogisticsJobTemplate getLogisticsJobTemplateLinkUpId() {
        return logisticsJobTemplateLinkUpId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}