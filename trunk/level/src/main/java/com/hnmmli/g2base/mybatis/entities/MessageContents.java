package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class MessageContents implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long messageId;

    private Long fileInfoId;

    private FileInfos fileInfosFileInfoId;

    private Messages messagesMessageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(Long fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public void setFileInfosFileInfoId(FileInfos fileInfosFileInfoId) {
        this.fileInfosFileInfoId=fileInfosFileInfoId;
    }

    public FileInfos getFileInfosFileInfoId() {
        return fileInfosFileInfoId;
    }

    public void setMessagesMessageId(Messages messagesMessageId) {
        this.messagesMessageId=messagesMessageId;
    }

    public Messages getMessagesMessageId() {
        return messagesMessageId;
    }
}