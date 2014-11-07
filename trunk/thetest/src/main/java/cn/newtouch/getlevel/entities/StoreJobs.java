package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class StoreJobs implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String code;

    private Long lastStoreJobId;

    private Date jobDate;

    private Long jobStoreId;

    private Long transferStoreId;

    private Long storeCompanyId;

    private Long extractCompanyId;

    private String sourceType;

    private String externalCode;

    private String remark;

    private String status;

    private String jobTypeId;

    private String actionTypeId;

    private Long ladingId;

    private String solveStatus;

    private Date updateDate;

    private Date createDate;

    private String vehicleCode;

    private Long userId;

    private String flowStatus;

    private Long targetAllocationId;

    private String allotType;

    private String allotStatus;

    private List<EntrPurchDeliNote> entrPurchDeliNotesStoreJobId = null;

    private List<QualityBooks> qualityBookssStoreJobId = null;

    private List<ResodOwnUpHistorys> resodOwnUpHistoryssStoreJobId = null;

    private List<ResoAlloUpLogs> resoAlloUpLogssStoreJobId = null;

    private List<StoreJobs> storeJobssLastStoreJobId = null;

    private List<StoreJobDetails> storeJobDetailssStoreJobId = null;

    private List<StoreJobFlows> storeJobFlowssStoreJobId = null;

    private List<TrustPurchPerform> trustPurchPerformsStoreJobId = null;

    private List<TrustPurchRedeemDetails> trustPurchRedeemDetailssOwnerJobId = null;

    private List<WarehouseTransportsKey> warehouseTransportssStoreJobId = null;

    private Allocations allocationsTargetAllocationId;

    private Companys companysExtractCompanyId;

    private Companys companysStoreCompanyId;

    private Ladings ladingsLadingId;

    private Stores storesJobStoreId;

    private Stores storesTransferStoreId;

    private StoreJobs storeJobsLastStoreJobId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getLastStoreJobId() {
        return lastStoreJobId;
    }

    public void setLastStoreJobId(Long lastStoreJobId) {
        this.lastStoreJobId = lastStoreJobId;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public Long getJobStoreId() {
        return jobStoreId;
    }

    public void setJobStoreId(Long jobStoreId) {
        this.jobStoreId = jobStoreId;
    }

    public Long getTransferStoreId() {
        return transferStoreId;
    }

    public void setTransferStoreId(Long transferStoreId) {
        this.transferStoreId = transferStoreId;
    }

    public Long getStoreCompanyId() {
        return storeCompanyId;
    }

    public void setStoreCompanyId(Long storeCompanyId) {
        this.storeCompanyId = storeCompanyId;
    }

    public Long getExtractCompanyId() {
        return extractCompanyId;
    }

    public void setExtractCompanyId(Long extractCompanyId) {
        this.extractCompanyId = extractCompanyId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public String getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(String actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public Long getLadingId() {
        return ladingId;
    }

    public void setLadingId(Long ladingId) {
        this.ladingId = ladingId;
    }

    public String getSolveStatus() {
        return solveStatus;
    }

    public void setSolveStatus(String solveStatus) {
        this.solveStatus = solveStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Long getTargetAllocationId() {
        return targetAllocationId;
    }

    public void setTargetAllocationId(Long targetAllocationId) {
        this.targetAllocationId = targetAllocationId;
    }

    public String getAllotType() {
        return allotType;
    }

    public void setAllotType(String allotType) {
        this.allotType = allotType;
    }

    public String getAllotStatus() {
        return allotStatus;
    }

    public void setAllotStatus(String allotStatus) {
        this.allotStatus = allotStatus;
    }

    public void setEntrPurchDeliNotesStoreJobId(List entrPurchDeliNotesStoreJobId) {
        this.entrPurchDeliNotesStoreJobId=entrPurchDeliNotesStoreJobId;
    }

    public List<EntrPurchDeliNote> getEntrPurchDeliNotesStoreJobId() {
        return entrPurchDeliNotesStoreJobId;
    }

    public void setQualityBookssStoreJobId(List qualityBookssStoreJobId) {
        this.qualityBookssStoreJobId=qualityBookssStoreJobId;
    }

    public List<QualityBooks> getQualityBookssStoreJobId() {
        return qualityBookssStoreJobId;
    }

    public void setResodOwnUpHistoryssStoreJobId(List resodOwnUpHistoryssStoreJobId) {
        this.resodOwnUpHistoryssStoreJobId=resodOwnUpHistoryssStoreJobId;
    }

    public List<ResodOwnUpHistorys> getResodOwnUpHistoryssStoreJobId() {
        return resodOwnUpHistoryssStoreJobId;
    }

    public void setResoAlloUpLogssStoreJobId(List resoAlloUpLogssStoreJobId) {
        this.resoAlloUpLogssStoreJobId=resoAlloUpLogssStoreJobId;
    }

    public List<ResoAlloUpLogs> getResoAlloUpLogssStoreJobId() {
        return resoAlloUpLogssStoreJobId;
    }

    public void setStoreJobssLastStoreJobId(List storeJobssLastStoreJobId) {
        this.storeJobssLastStoreJobId=storeJobssLastStoreJobId;
    }

    public List<StoreJobs> getStoreJobssLastStoreJobId() {
        return storeJobssLastStoreJobId;
    }

    public void setStoreJobDetailssStoreJobId(List storeJobDetailssStoreJobId) {
        this.storeJobDetailssStoreJobId=storeJobDetailssStoreJobId;
    }

    public List<StoreJobDetails> getStoreJobDetailssStoreJobId() {
        return storeJobDetailssStoreJobId;
    }

    public void setStoreJobFlowssStoreJobId(List storeJobFlowssStoreJobId) {
        this.storeJobFlowssStoreJobId=storeJobFlowssStoreJobId;
    }

    public List<StoreJobFlows> getStoreJobFlowssStoreJobId() {
        return storeJobFlowssStoreJobId;
    }

    public void setTrustPurchPerformsStoreJobId(List trustPurchPerformsStoreJobId) {
        this.trustPurchPerformsStoreJobId=trustPurchPerformsStoreJobId;
    }

    public List<TrustPurchPerform> getTrustPurchPerformsStoreJobId() {
        return trustPurchPerformsStoreJobId;
    }

    public void setTrustPurchRedeemDetailssOwnerJobId(List trustPurchRedeemDetailssOwnerJobId) {
        this.trustPurchRedeemDetailssOwnerJobId=trustPurchRedeemDetailssOwnerJobId;
    }

    public List<TrustPurchRedeemDetails> getTrustPurchRedeemDetailssOwnerJobId() {
        return trustPurchRedeemDetailssOwnerJobId;
    }

    public void setWarehouseTransportssStoreJobId(List warehouseTransportssStoreJobId) {
        this.warehouseTransportssStoreJobId=warehouseTransportssStoreJobId;
    }

    public List<WarehouseTransportsKey> getWarehouseTransportssStoreJobId() {
        return warehouseTransportssStoreJobId;
    }

    public void setAllocationsTargetAllocationId(Allocations allocationsTargetAllocationId) {
        this.allocationsTargetAllocationId=allocationsTargetAllocationId;
    }

    public Allocations getAllocationsTargetAllocationId() {
        return allocationsTargetAllocationId;
    }

    public void setCompanysExtractCompanyId(Companys companysExtractCompanyId) {
        this.companysExtractCompanyId=companysExtractCompanyId;
    }

    public Companys getCompanysExtractCompanyId() {
        return companysExtractCompanyId;
    }

    public void setCompanysStoreCompanyId(Companys companysStoreCompanyId) {
        this.companysStoreCompanyId=companysStoreCompanyId;
    }

    public Companys getCompanysStoreCompanyId() {
        return companysStoreCompanyId;
    }

    public void setLadingsLadingId(Ladings ladingsLadingId) {
        this.ladingsLadingId=ladingsLadingId;
    }

    public Ladings getLadingsLadingId() {
        return ladingsLadingId;
    }

    public void setStoresJobStoreId(Stores storesJobStoreId) {
        this.storesJobStoreId=storesJobStoreId;
    }

    public Stores getStoresJobStoreId() {
        return storesJobStoreId;
    }

    public void setStoresTransferStoreId(Stores storesTransferStoreId) {
        this.storesTransferStoreId=storesTransferStoreId;
    }

    public Stores getStoresTransferStoreId() {
        return storesTransferStoreId;
    }

    public void setStoreJobsLastStoreJobId(StoreJobs storeJobsLastStoreJobId) {
        this.storeJobsLastStoreJobId=storeJobsLastStoreJobId;
    }

    public StoreJobs getStoreJobsLastStoreJobId() {
        return storeJobsLastStoreJobId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}