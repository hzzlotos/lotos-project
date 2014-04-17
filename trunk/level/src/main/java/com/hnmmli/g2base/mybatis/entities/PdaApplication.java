package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class PdaApplication implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String appProVersion;

    private String ipJson;

    private Long downloadNum;

    private Date publicDate;

    private String appName;

    private Long userId;

    private List<Pda> pdasAppId = null;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppProVersion() {
        return appProVersion;
    }

    public void setAppProVersion(String appProVersion) {
        this.appProVersion = appProVersion;
    }

    public String getIpJson() {
        return ipJson;
    }

    public void setIpJson(String ipJson) {
        this.ipJson = ipJson;
    }

    public Long getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Long downloadNum) {
        this.downloadNum = downloadNum;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPdasAppId(List pdasAppId) {
        this.pdasAppId=pdasAppId;
    }

    public List<Pda> getPdasAppId() {
        return pdasAppId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}