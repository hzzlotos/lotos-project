package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

public class EletricReceipt implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long routeReceiptId;

    private Date receiptDate;

    private Long userId;

    private Long fileId;

    private FileInfos fileInfosFileId;

    private RouteTemplates routeTemplatesRouteReceiptId;

    private Users usersUserId;

    public Long getRouteReceiptId() {
        return routeReceiptId;
    }

    public void setRouteReceiptId(Long routeReceiptId) {
        this.routeReceiptId = routeReceiptId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public void setFileInfosFileId(FileInfos fileInfosFileId) {
        this.fileInfosFileId=fileInfosFileId;
    }

    public FileInfos getFileInfosFileId() {
        return fileInfosFileId;
    }

    public void setRouteTemplatesRouteReceiptId(RouteTemplates routeTemplatesRouteReceiptId) {
        this.routeTemplatesRouteReceiptId=routeTemplatesRouteReceiptId;
    }

    public RouteTemplates getRouteTemplatesRouteReceiptId() {
        return routeTemplatesRouteReceiptId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}