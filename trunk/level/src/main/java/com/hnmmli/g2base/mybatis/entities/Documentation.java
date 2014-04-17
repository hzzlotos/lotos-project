package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class Documentation implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String title;

    private String keyword;

    private String content;

    private String status;

    private String recommend;

    private Date publishDate;

    private Long publishUserId;

    private Users usersPublishUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
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

    public void setUsersPublishUserId(Users usersPublishUserId) {
        this.usersPublishUserId=usersPublishUserId;
    }

    public Users getUsersPublishUserId() {
        return usersPublishUserId;
    }
}