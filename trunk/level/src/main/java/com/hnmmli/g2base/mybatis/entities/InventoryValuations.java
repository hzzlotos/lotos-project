package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class InventoryValuations implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long storeId;

    private String type;

    private String valuationMode;

    private Date planBeginDate;

    private Date planEndDate;

    private Long planUserId;

    private Date actualBeginDate;

    private Date actualEndDate;

    private Long startUserId;

    private Date jobStartDate;

    private Long jobStartUserId;

    private String status;

    private String result;

    private String range;

    private Long resourceCompanyId;

    private List<AccountValuationsStatics> accountValuationsStaticssValuationId = null;

    private List<DifferentAnalyzes> differentAnalyzessValuationsId = null;

    private List<InvenvaliScopes> invenvaliScopessValuationsId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssInventoryValuationId = null;

    private List<ValuationsResources> valuationsResourcessValuationId = null;

    private Companys companysResourceCompanyId;

    private Stores storesStoreId;

    private Users usersJobStartUserId;

    private Users usersStartUserId;

    private Users usersPlanUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValuationMode() {
        return valuationMode;
    }

    public void setValuationMode(String valuationMode) {
        this.valuationMode = valuationMode;
    }

    public Date getPlanBeginDate() {
        return planBeginDate;
    }

    public void setPlanBeginDate(Date planBeginDate) {
        this.planBeginDate = planBeginDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Long getPlanUserId() {
        return planUserId;
    }

    public void setPlanUserId(Long planUserId) {
        this.planUserId = planUserId;
    }

    public Date getActualBeginDate() {
        return actualBeginDate;
    }

    public void setActualBeginDate(Date actualBeginDate) {
        this.actualBeginDate = actualBeginDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Long getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(Long startUserId) {
        this.startUserId = startUserId;
    }

    public Date getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(Date jobStartDate) {
        this.jobStartDate = jobStartDate;
    }

    public Long getJobStartUserId() {
        return jobStartUserId;
    }

    public void setJobStartUserId(Long jobStartUserId) {
        this.jobStartUserId = jobStartUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Long getResourceCompanyId() {
        return resourceCompanyId;
    }

    public void setResourceCompanyId(Long resourceCompanyId) {
        this.resourceCompanyId = resourceCompanyId;
    }

    public void setAccountValuationsStaticssValuationId(List accountValuationsStaticssValuationId) {
        this.accountValuationsStaticssValuationId=accountValuationsStaticssValuationId;
    }

    public List<AccountValuationsStatics> getAccountValuationsStaticssValuationId() {
        return accountValuationsStaticssValuationId;
    }

    public void setDifferentAnalyzessValuationsId(List differentAnalyzessValuationsId) {
        this.differentAnalyzessValuationsId=differentAnalyzessValuationsId;
    }

    public List<DifferentAnalyzes> getDifferentAnalyzessValuationsId() {
        return differentAnalyzessValuationsId;
    }

    public void setInvenvaliScopessValuationsId(List invenvaliScopessValuationsId) {
        this.invenvaliScopessValuationsId=invenvaliScopessValuationsId;
    }

    public List<InvenvaliScopes> getInvenvaliScopessValuationsId() {
        return invenvaliScopessValuationsId;
    }

    public void setPhysicalValuationsStaticssInventoryValuationId(List physicalValuationsStaticssInventoryValuationId) {
        this.physicalValuationsStaticssInventoryValuationId=physicalValuationsStaticssInventoryValuationId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssInventoryValuationId() {
        return physicalValuationsStaticssInventoryValuationId;
    }

    public void setValuationsResourcessValuationId(List valuationsResourcessValuationId) {
        this.valuationsResourcessValuationId=valuationsResourcessValuationId;
    }

    public List<ValuationsResources> getValuationsResourcessValuationId() {
        return valuationsResourcessValuationId;
    }

    public void setCompanysResourceCompanyId(Companys companysResourceCompanyId) {
        this.companysResourceCompanyId=companysResourceCompanyId;
    }

    public Companys getCompanysResourceCompanyId() {
        return companysResourceCompanyId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUsersJobStartUserId(Users usersJobStartUserId) {
        this.usersJobStartUserId=usersJobStartUserId;
    }

    public Users getUsersJobStartUserId() {
        return usersJobStartUserId;
    }

    public void setUsersStartUserId(Users usersStartUserId) {
        this.usersStartUserId=usersStartUserId;
    }

    public Users getUsersStartUserId() {
        return usersStartUserId;
    }

    public void setUsersPlanUserId(Users usersPlanUserId) {
        this.usersPlanUserId=usersPlanUserId;
    }

    public Users getUsersPlanUserId() {
        return usersPlanUserId;
    }
}