package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class SmsTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String smsType;

    private String templateName;

    private String content;

    private Date publishDate;

    private Long publishUserId;

    private List<SmsTask> smsTasksSmsTemplateId = null;

    private Users usersPublishUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public void setSmsTasksSmsTemplateId(List smsTasksSmsTemplateId) {
        this.smsTasksSmsTemplateId=smsTasksSmsTemplateId;
    }

    public List<SmsTask> getSmsTasksSmsTemplateId() {
        return smsTasksSmsTemplateId;
    }

    public void setUsersPublishUserId(Users usersPublishUserId) {
        this.usersPublishUserId=usersPublishUserId;
    }

    public Users getUsersPublishUserId() {
        return usersPublishUserId;
    }
}