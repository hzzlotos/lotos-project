package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class AccountValuationsStatics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long valuationId;

    private Long resourceId;

    private Long allocationId;

    private String isRegulatory;

    private String isRegulatoryAudit;

    private Date createDate;

    private String recordHeavyId;

    private Long businessCompanyId;

    private List<AccountDifferentDetails> accountDifferentDetailssAccountStaticId = null;

    private Allocations allocationsAllocationId;

    private Companys companysBusinessCompanyId;

    private InventoryValuations inventoryValuationsValuationId;

    private Resources resourcesResourceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValuationId() {
        return valuationId;
    }

    public void setValuationId(Long valuationId) {
        this.valuationId = valuationId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public String getIsRegulatory() {
        return isRegulatory;
    }

    public void setIsRegulatory(String isRegulatory) {
        this.isRegulatory = isRegulatory;
    }

    public String getIsRegulatoryAudit() {
        return isRegulatoryAudit;
    }

    public void setIsRegulatoryAudit(String isRegulatoryAudit) {
        this.isRegulatoryAudit = isRegulatoryAudit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRecordHeavyId() {
        return recordHeavyId;
    }

    public void setRecordHeavyId(String recordHeavyId) {
        this.recordHeavyId = recordHeavyId;
    }

    public Long getBusinessCompanyId() {
        return businessCompanyId;
    }

    public void setBusinessCompanyId(Long businessCompanyId) {
        this.businessCompanyId = businessCompanyId;
    }

    public void setAccountDifferentDetailssAccountStaticId(List accountDifferentDetailssAccountStaticId) {
        this.accountDifferentDetailssAccountStaticId=accountDifferentDetailssAccountStaticId;
    }

    public List<AccountDifferentDetails> getAccountDifferentDetailssAccountStaticId() {
        return accountDifferentDetailssAccountStaticId;
    }

    public void setAllocationsAllocationId(Allocations allocationsAllocationId) {
        this.allocationsAllocationId=allocationsAllocationId;
    }

    public Allocations getAllocationsAllocationId() {
        return allocationsAllocationId;
    }

    public void setCompanysBusinessCompanyId(Companys companysBusinessCompanyId) {
        this.companysBusinessCompanyId=companysBusinessCompanyId;
    }

    public Companys getCompanysBusinessCompanyId() {
        return companysBusinessCompanyId;
    }

    public void setInventoryValuationsValuationId(InventoryValuations inventoryValuationsValuationId) {
        this.inventoryValuationsValuationId=inventoryValuationsValuationId;
    }

    public InventoryValuations getInventoryValuationsValuationId() {
        return inventoryValuationsValuationId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }
}