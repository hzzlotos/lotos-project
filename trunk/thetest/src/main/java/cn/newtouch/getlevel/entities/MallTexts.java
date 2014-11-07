package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class MallTexts implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String url;

    private Date publishDate;

    private Date updateDate;

    private Long userId;

    private String status;

    private Long mallChannleId;

    private Long sort;

    private MallChannels mallChannelsMallChannleId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMallChannleId() {
        return mallChannleId;
    }

    public void setMallChannleId(Long mallChannleId) {
        this.mallChannleId = mallChannleId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public void setMallChannelsMallChannleId(MallChannels mallChannelsMallChannleId) {
        this.mallChannelsMallChannleId=mallChannelsMallChannleId;
    }

    public MallChannels getMallChannelsMallChannleId() {
        return mallChannelsMallChannleId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}