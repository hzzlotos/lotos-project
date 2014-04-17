package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class QualityBooks implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date createDate;

    private String code;

    private Long companyId;

    private Long inputerId;

    private Long departmentId;

    private Long storeJobId;

    private Date inputDate;

    private Long editerId;

    private String outsideCode;

    private Long resDefId;

    private Long printNum;

    private String productLince;

    private String qualityCode;

    private String status;

    private Date updateDate;

    private List<QualityBookDetails> qualityBookDetailssQualityBookId = null;

    private Companys companysCompanyId;

    private Departments departmentsDepartmentId;

    private Resources resourcesResDefId;

    private StoreJobs storeJobsStoreJobId;

    private Users usersEditerId;

    private Users usersInputerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getInputerId() {
        return inputerId;
    }

    public void setInputerId(Long inputerId) {
        this.inputerId = inputerId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Long getEditerId() {
        return editerId;
    }

    public void setEditerId(Long editerId) {
        this.editerId = editerId;
    }

    public String getOutsideCode() {
        return outsideCode;
    }

    public void setOutsideCode(String outsideCode) {
        this.outsideCode = outsideCode;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public Long getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Long printNum) {
        this.printNum = printNum;
    }

    public String getProductLince() {
        return productLince;
    }

    public void setProductLince(String productLince) {
        this.productLince = productLince;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setQualityBookDetailssQualityBookId(List qualityBookDetailssQualityBookId) {
        this.qualityBookDetailssQualityBookId=qualityBookDetailssQualityBookId;
    }

    public List<QualityBookDetails> getQualityBookDetailssQualityBookId() {
        return qualityBookDetailssQualityBookId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setDepartmentsDepartmentId(Departments departmentsDepartmentId) {
        this.departmentsDepartmentId=departmentsDepartmentId;
    }

    public Departments getDepartmentsDepartmentId() {
        return departmentsDepartmentId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }

    public void setUsersEditerId(Users usersEditerId) {
        this.usersEditerId=usersEditerId;
    }

    public Users getUsersEditerId() {
        return usersEditerId;
    }

    public void setUsersInputerId(Users usersInputerId) {
        this.usersInputerId=usersInputerId;
    }

    public Users getUsersInputerId() {
        return usersInputerId;
    }
}