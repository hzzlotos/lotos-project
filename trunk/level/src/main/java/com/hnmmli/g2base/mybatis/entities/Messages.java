package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Messages implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date sendDate;

    private Date readDate;

    private Long isRead;

    private Long isSystemSend;

    private String type;

    private Long fromUserId;

    private Long toUserId;

    private List<MessageContents> messageContentssMessageId = null;

    private Users usersToUserId;

    private Users usersFromUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Long getIsRead() {
        return isRead;
    }

    public void setIsRead(Long isRead) {
        this.isRead = isRead;
    }

    public Long getIsSystemSend() {
        return isSystemSend;
    }

    public void setIsSystemSend(Long isSystemSend) {
        this.isSystemSend = isSystemSend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public void setMessageContentssMessageId(List messageContentssMessageId) {
        this.messageContentssMessageId=messageContentssMessageId;
    }

    public List<MessageContents> getMessageContentssMessageId() {
        return messageContentssMessageId;
    }

    public void setUsersToUserId(Users usersToUserId) {
        this.usersToUserId=usersToUserId;
    }

    public Users getUsersToUserId() {
        return usersToUserId;
    }

    public void setUsersFromUserId(Users usersFromUserId) {
        this.usersFromUserId=usersFromUserId;
    }

    public Users getUsersFromUserId() {
        return usersFromUserId;
    }
}