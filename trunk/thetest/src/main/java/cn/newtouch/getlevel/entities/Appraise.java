package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class Appraise implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String type;

    private String content;

    private Date appraiseDate;

    private Long logisticsCompanyId;

    private Long publishUserId;

    private LogisticsCompanys logisticsCompanysLogisticsCompanyId;

    private Users usersPublishUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAppraiseDate() {
        return appraiseDate;
    }

    public void setAppraiseDate(Date appraiseDate) {
        this.appraiseDate = appraiseDate;
    }

    public Long getLogisticsCompanyId() {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(Long logisticsCompanyId) {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public void setLogisticsCompanysLogisticsCompanyId(LogisticsCompanys logisticsCompanysLogisticsCompanyId) {
        this.logisticsCompanysLogisticsCompanyId=logisticsCompanysLogisticsCompanyId;
    }

    public LogisticsCompanys getLogisticsCompanysLogisticsCompanyId() {
        return logisticsCompanysLogisticsCompanyId;
    }

    public void setUsersPublishUserId(Users usersPublishUserId) {
        this.usersPublishUserId=usersPublishUserId;
    }

    public Users getUsersPublishUserId() {
        return usersPublishUserId;
    }
}