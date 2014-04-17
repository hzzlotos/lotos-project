package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class ExcelInRes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date importDate;

    private Long userId;

    private Long companyId;

    private Long entryqty;

    private Long fulfilentryqty;

    private BigDecimal fileSize;

    private Long fileId;

    private List<ExcelInResDetailsKey> excelInResDetailssExcimresId = null;

    private Companys companysCompanyId;

    private FileInfos fileInfosFileId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEntryqty() {
        return entryqty;
    }

    public void setEntryqty(Long entryqty) {
        this.entryqty = entryqty;
    }

    public Long getFulfilentryqty() {
        return fulfilentryqty;
    }

    public void setFulfilentryqty(Long fulfilentryqty) {
        this.fulfilentryqty = fulfilentryqty;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public void setExcelInResDetailssExcimresId(List excelInResDetailssExcimresId) {
        this.excelInResDetailssExcimresId=excelInResDetailssExcimresId;
    }

    public List<ExcelInResDetailsKey> getExcelInResDetailssExcimresId() {
        return excelInResDetailssExcimresId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setFileInfosFileId(FileInfos fileInfosFileId) {
        this.fileInfosFileId=fileInfosFileId;
    }

    public FileInfos getFileInfosFileId() {
        return fileInfosFileId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}