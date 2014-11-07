package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class Allocations implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long fatherAllocationId;

    private String name;

    private Long storeId;

    private Long uomId;

    private BigDecimal nowQty;

    private BigDecimal maxQty;

    private List<AccountValuationsStatics> accountValuationsStaticssAllocationId = null;

    private List<Allocations> allocationssFatherAllocationId = null;

    private List<CollateralItemDetails> collateralItemDetailssAllocationId = null;

    private List<InventoryResourceDetails> inventoryResourceDetailssAllocationId = null;

    private List<InvenvaliScopes> invenvaliScopessAllocationsId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssAllocationId = null;

    private List<ProcessMaterial> processMaterialsAllocationId = null;

    private List<ResourceDetails> resourceDetailssAllocationId = null;

    private List<ResourceSummaries> resourceSummariessAllocationsId = null;

    private List<ResoAlloUpLogs> resoAlloUpLogssNewAllocationId = null;

    private List<ResoAlloUpLogs> resoAlloUpLogssOldAllocationId = null;

    private List<StoreJobs> storeJobssTargetAllocationId = null;

    private List<StoreJobDetails> storeJobDetailssAllocationId = null;

    private Allocations allocationsFatherAllocationId;

    private Stores storesStoreId;

    private Uoms uomsUomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherAllocationId() {
        return fatherAllocationId;
    }

    public void setFatherAllocationId(Long fatherAllocationId) {
        this.fatherAllocationId = fatherAllocationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public BigDecimal getNowQty() {
        return nowQty;
    }

    public void setNowQty(BigDecimal nowQty) {
        this.nowQty = nowQty;
    }

    public BigDecimal getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(BigDecimal maxQty) {
        this.maxQty = maxQty;
    }

    public void setAccountValuationsStaticssAllocationId(List accountValuationsStaticssAllocationId) {
        this.accountValuationsStaticssAllocationId=accountValuationsStaticssAllocationId;
    }

    public List<AccountValuationsStatics> getAccountValuationsStaticssAllocationId() {
        return accountValuationsStaticssAllocationId;
    }

    public void setAllocationssFatherAllocationId(List allocationssFatherAllocationId) {
        this.allocationssFatherAllocationId=allocationssFatherAllocationId;
    }

    public List<Allocations> getAllocationssFatherAllocationId() {
        return allocationssFatherAllocationId;
    }

    public void setCollateralItemDetailssAllocationId(List collateralItemDetailssAllocationId) {
        this.collateralItemDetailssAllocationId=collateralItemDetailssAllocationId;
    }

    public List<CollateralItemDetails> getCollateralItemDetailssAllocationId() {
        return collateralItemDetailssAllocationId;
    }

    public void setInventoryResourceDetailssAllocationId(List inventoryResourceDetailssAllocationId) {
        this.inventoryResourceDetailssAllocationId=inventoryResourceDetailssAllocationId;
    }

    public List<InventoryResourceDetails> getInventoryResourceDetailssAllocationId() {
        return inventoryResourceDetailssAllocationId;
    }

    public void setInvenvaliScopessAllocationsId(List invenvaliScopessAllocationsId) {
        this.invenvaliScopessAllocationsId=invenvaliScopessAllocationsId;
    }

    public List<InvenvaliScopes> getInvenvaliScopessAllocationsId() {
        return invenvaliScopessAllocationsId;
    }

    public void setPhysicalValuationsStaticssAllocationId(List physicalValuationsStaticssAllocationId) {
        this.physicalValuationsStaticssAllocationId=physicalValuationsStaticssAllocationId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssAllocationId() {
        return physicalValuationsStaticssAllocationId;
    }

    public void setProcessMaterialsAllocationId(List processMaterialsAllocationId) {
        this.processMaterialsAllocationId=processMaterialsAllocationId;
    }

    public List<ProcessMaterial> getProcessMaterialsAllocationId() {
        return processMaterialsAllocationId;
    }

    public void setResourceDetailssAllocationId(List resourceDetailssAllocationId) {
        this.resourceDetailssAllocationId=resourceDetailssAllocationId;
    }

    public List<ResourceDetails> getResourceDetailssAllocationId() {
        return resourceDetailssAllocationId;
    }

    public void setResourceSummariessAllocationsId(List resourceSummariessAllocationsId) {
        this.resourceSummariessAllocationsId=resourceSummariessAllocationsId;
    }

    public List<ResourceSummaries> getResourceSummariessAllocationsId() {
        return resourceSummariessAllocationsId;
    }

    public void setResoAlloUpLogssNewAllocationId(List resoAlloUpLogssNewAllocationId) {
        this.resoAlloUpLogssNewAllocationId=resoAlloUpLogssNewAllocationId;
    }

    public List<ResoAlloUpLogs> getResoAlloUpLogssNewAllocationId() {
        return resoAlloUpLogssNewAllocationId;
    }

    public void setResoAlloUpLogssOldAllocationId(List resoAlloUpLogssOldAllocationId) {
        this.resoAlloUpLogssOldAllocationId=resoAlloUpLogssOldAllocationId;
    }

    public List<ResoAlloUpLogs> getResoAlloUpLogssOldAllocationId() {
        return resoAlloUpLogssOldAllocationId;
    }

    public void setStoreJobssTargetAllocationId(List storeJobssTargetAllocationId) {
        this.storeJobssTargetAllocationId=storeJobssTargetAllocationId;
    }

    public List<StoreJobs> getStoreJobssTargetAllocationId() {
        return storeJobssTargetAllocationId;
    }

    public void setStoreJobDetailssAllocationId(List storeJobDetailssAllocationId) {
        this.storeJobDetailssAllocationId=storeJobDetailssAllocationId;
    }

    public List<StoreJobDetails> getStoreJobDetailssAllocationId() {
        return storeJobDetailssAllocationId;
    }

    public void setAllocationsFatherAllocationId(Allocations allocationsFatherAllocationId) {
        this.allocationsFatherAllocationId=allocationsFatherAllocationId;
    }

    public Allocations getAllocationsFatherAllocationId() {
        return allocationsFatherAllocationId;
    }

    public void setStoresStoreId(Stores storesStoreId) {
        this.storesStoreId=storesStoreId;
    }

    public Stores getStoresStoreId() {
        return storesStoreId;
    }

    public void setUomsUomId(Uoms uomsUomId) {
        this.uomsUomId=uomsUomId;
    }

    public Uoms getUomsUomId() {
        return uomsUomId;
    }
}