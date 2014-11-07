package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Resources implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long resourceTypeId;

    private Long specificationId;

    private Long modelId;

    private Long brandId;

    private Long ingredientId;

    private Long minPictureId;

    private String descJson;

    private Long excelTemplateId;

    private Long pictureId;

    private String code;

    private String status;

    private String auditStatus;

    private Long originId;

    private Date createDate;

    private Date updateDate;

    private Long uomId;

    private List<AccountValuationsStatics> accountValuationsStaticssResourceId = null;

    private List<AuthorizeFundsKey> authorizeFundssResDefId = null;

    private List<Batchs> batchssResDefId = null;

    private List<Biddings> biddingssResDefId = null;

    private List<Biddings> biddingssClinchResDefId = null;

    private List<BidDeposits> bidDepositssResDefId = null;

    private List<CollateralItemDetails> collateralItemDetailssResourceId = null;

    private List<CollateralSummaries> collateralSummariessResourceId = null;

    private List<CompanyResourcesKey> companyResourcessResourceId = null;

    private List<ConsultTacticsDetailsKey> consultTacticsDetailssResDefId = null;

    private List<EntrPurchDeliDetails> entrPurchDeliDetailssResDefId = null;

    private List<ExcelInResDetailsKey> excelInResDetailssResDefId = null;

    private List<FinancingApplyDetails> financingApplyDetailssResourceId = null;

    private List<InventoryResourceDetails> inventoryResourceDetailssResourcesId = null;

    private List<LadingDetails> ladingDetailssResDefId = null;

    private List<LogisticsOrders> logisticsOrderssResDefId = null;

    private List<LogisOrderWareMaterial> logisOrderWareMaterialsResourceId = null;

    private List<MemberPrices> memberPricessResourceId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssResourceId = null;

    private List<ProcessMaterial> processMaterialsResourceId = null;

    private List<ProductiveFulfill> productiveFulfillsProductiveId = null;

    private List<Productivitys> productivityssTakenGmId = null;

    private List<Productivitys> productivityssResourceId = null;

    private List<QualityBooks> qualityBookssResDefId = null;

    private List<ResourceDetails> resourceDetailssResourceId = null;

    private List<ResourceSummaries> resourceSummariessResourceId = null;

    private List<StoreJobDetails> storeJobDetailssResourceId = null;

    private List<TraderResources> traderResourcessResDefId = null;

    private List<TrustPurchase> trustPurchasesResDefId = null;

    private List<TrustPurchPerform> trustPurchPerformsResDefId = null;

    private List<TrustPurchPlanDetailsKey> trustPurchPlanDetailssResDefId = null;

    private List<TrustPurchRedeemDetails> trustPurchRedeemDetailssResDefId = null;

    private List<TruPurchContrDetails> truPurchContrDetailssResDefId = null;

    private List<ValuationsResources> valuationsResourcessResourceId = null;

    private Brands brandsBrandId;

    private FileInfos fileInfosExcelTemplateId;

    private FileInfos fileInfosPictureId;

    private FileInfos fileInfosMinPictureId;

    private Ingredients ingredientsIngredientId;

    private Models modelsModelId;

    private Origins originsOriginId;

    private ResourceTypes resourceTypesResourceTypeId;

    private Specifications specificationsSpecificationId;

    private Uoms uomsUomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getMinPictureId() {
        return minPictureId;
    }

    public void setMinPictureId(Long minPictureId) {
        this.minPictureId = minPictureId;
    }

    public String getDescJson() {
        return descJson;
    }

    public void setDescJson(String descJson) {
        this.descJson = descJson;
    }

    public Long getExcelTemplateId() {
        return excelTemplateId;
    }

    public void setExcelTemplateId(Long excelTemplateId) {
        this.excelTemplateId = excelTemplateId;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setAccountValuationsStaticssResourceId(List accountValuationsStaticssResourceId) {
        this.accountValuationsStaticssResourceId=accountValuationsStaticssResourceId;
    }

    public List<AccountValuationsStatics> getAccountValuationsStaticssResourceId() {
        return accountValuationsStaticssResourceId;
    }

    public void setAuthorizeFundssResDefId(List authorizeFundssResDefId) {
        this.authorizeFundssResDefId=authorizeFundssResDefId;
    }

    public List<AuthorizeFundsKey> getAuthorizeFundssResDefId() {
        return authorizeFundssResDefId;
    }

    public void setBatchssResDefId(List batchssResDefId) {
        this.batchssResDefId=batchssResDefId;
    }

    public List<Batchs> getBatchssResDefId() {
        return batchssResDefId;
    }

    public void setBiddingssResDefId(List biddingssResDefId) {
        this.biddingssResDefId=biddingssResDefId;
    }

    public List<Biddings> getBiddingssResDefId() {
        return biddingssResDefId;
    }

    public void setBiddingssClinchResDefId(List biddingssClinchResDefId) {
        this.biddingssClinchResDefId=biddingssClinchResDefId;
    }

    public List<Biddings> getBiddingssClinchResDefId() {
        return biddingssClinchResDefId;
    }

    public void setBidDepositssResDefId(List bidDepositssResDefId) {
        this.bidDepositssResDefId=bidDepositssResDefId;
    }

    public List<BidDeposits> getBidDepositssResDefId() {
        return bidDepositssResDefId;
    }

    public void setCollateralItemDetailssResourceId(List collateralItemDetailssResourceId) {
        this.collateralItemDetailssResourceId=collateralItemDetailssResourceId;
    }

    public List<CollateralItemDetails> getCollateralItemDetailssResourceId() {
        return collateralItemDetailssResourceId;
    }

    public void setCollateralSummariessResourceId(List collateralSummariessResourceId) {
        this.collateralSummariessResourceId=collateralSummariessResourceId;
    }

    public List<CollateralSummaries> getCollateralSummariessResourceId() {
        return collateralSummariessResourceId;
    }

    public void setCompanyResourcessResourceId(List companyResourcessResourceId) {
        this.companyResourcessResourceId=companyResourcessResourceId;
    }

    public List<CompanyResourcesKey> getCompanyResourcessResourceId() {
        return companyResourcessResourceId;
    }

    public void setConsultTacticsDetailssResDefId(List consultTacticsDetailssResDefId) {
        this.consultTacticsDetailssResDefId=consultTacticsDetailssResDefId;
    }

    public List<ConsultTacticsDetailsKey> getConsultTacticsDetailssResDefId() {
        return consultTacticsDetailssResDefId;
    }

    public void setEntrPurchDeliDetailssResDefId(List entrPurchDeliDetailssResDefId) {
        this.entrPurchDeliDetailssResDefId=entrPurchDeliDetailssResDefId;
    }

    public List<EntrPurchDeliDetails> getEntrPurchDeliDetailssResDefId() {
        return entrPurchDeliDetailssResDefId;
    }

    public void setExcelInResDetailssResDefId(List excelInResDetailssResDefId) {
        this.excelInResDetailssResDefId=excelInResDetailssResDefId;
    }

    public List<ExcelInResDetailsKey> getExcelInResDetailssResDefId() {
        return excelInResDetailssResDefId;
    }

    public void setFinancingApplyDetailssResourceId(List financingApplyDetailssResourceId) {
        this.financingApplyDetailssResourceId=financingApplyDetailssResourceId;
    }

    public List<FinancingApplyDetails> getFinancingApplyDetailssResourceId() {
        return financingApplyDetailssResourceId;
    }

    public void setInventoryResourceDetailssResourcesId(List inventoryResourceDetailssResourcesId) {
        this.inventoryResourceDetailssResourcesId=inventoryResourceDetailssResourcesId;
    }

    public List<InventoryResourceDetails> getInventoryResourceDetailssResourcesId() {
        return inventoryResourceDetailssResourcesId;
    }

    public void setLadingDetailssResDefId(List ladingDetailssResDefId) {
        this.ladingDetailssResDefId=ladingDetailssResDefId;
    }

    public List<LadingDetails> getLadingDetailssResDefId() {
        return ladingDetailssResDefId;
    }

    public void setLogisticsOrderssResDefId(List logisticsOrderssResDefId) {
        this.logisticsOrderssResDefId=logisticsOrderssResDefId;
    }

    public List<LogisticsOrders> getLogisticsOrderssResDefId() {
        return logisticsOrderssResDefId;
    }

    public void setLogisOrderWareMaterialsResourceId(List logisOrderWareMaterialsResourceId) {
        this.logisOrderWareMaterialsResourceId=logisOrderWareMaterialsResourceId;
    }

    public List<LogisOrderWareMaterial> getLogisOrderWareMaterialsResourceId() {
        return logisOrderWareMaterialsResourceId;
    }

    public void setMemberPricessResourceId(List memberPricessResourceId) {
        this.memberPricessResourceId=memberPricessResourceId;
    }

    public List<MemberPrices> getMemberPricessResourceId() {
        return memberPricessResourceId;
    }

    public void setPhysicalValuationsStaticssResourceId(List physicalValuationsStaticssResourceId) {
        this.physicalValuationsStaticssResourceId=physicalValuationsStaticssResourceId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssResourceId() {
        return physicalValuationsStaticssResourceId;
    }

    public void setProcessMaterialsResourceId(List processMaterialsResourceId) {
        this.processMaterialsResourceId=processMaterialsResourceId;
    }

    public List<ProcessMaterial> getProcessMaterialsResourceId() {
        return processMaterialsResourceId;
    }

    public void setProductiveFulfillsProductiveId(List productiveFulfillsProductiveId) {
        this.productiveFulfillsProductiveId=productiveFulfillsProductiveId;
    }

    public List<ProductiveFulfill> getProductiveFulfillsProductiveId() {
        return productiveFulfillsProductiveId;
    }

    public void setProductivityssTakenGmId(List productivityssTakenGmId) {
        this.productivityssTakenGmId=productivityssTakenGmId;
    }

    public List<Productivitys> getProductivityssTakenGmId() {
        return productivityssTakenGmId;
    }

    public void setProductivityssResourceId(List productivityssResourceId) {
        this.productivityssResourceId=productivityssResourceId;
    }

    public List<Productivitys> getProductivityssResourceId() {
        return productivityssResourceId;
    }

    public void setQualityBookssResDefId(List qualityBookssResDefId) {
        this.qualityBookssResDefId=qualityBookssResDefId;
    }

    public List<QualityBooks> getQualityBookssResDefId() {
        return qualityBookssResDefId;
    }

    public void setResourceDetailssResourceId(List resourceDetailssResourceId) {
        this.resourceDetailssResourceId=resourceDetailssResourceId;
    }

    public List<ResourceDetails> getResourceDetailssResourceId() {
        return resourceDetailssResourceId;
    }

    public void setResourceSummariessResourceId(List resourceSummariessResourceId) {
        this.resourceSummariessResourceId=resourceSummariessResourceId;
    }

    public List<ResourceSummaries> getResourceSummariessResourceId() {
        return resourceSummariessResourceId;
    }

    public void setStoreJobDetailssResourceId(List storeJobDetailssResourceId) {
        this.storeJobDetailssResourceId=storeJobDetailssResourceId;
    }

    public List<StoreJobDetails> getStoreJobDetailssResourceId() {
        return storeJobDetailssResourceId;
    }

    public void setTraderResourcessResDefId(List traderResourcessResDefId) {
        this.traderResourcessResDefId=traderResourcessResDefId;
    }

    public List<TraderResources> getTraderResourcessResDefId() {
        return traderResourcessResDefId;
    }

    public void setTrustPurchasesResDefId(List trustPurchasesResDefId) {
        this.trustPurchasesResDefId=trustPurchasesResDefId;
    }

    public List<TrustPurchase> getTrustPurchasesResDefId() {
        return trustPurchasesResDefId;
    }

    public void setTrustPurchPerformsResDefId(List trustPurchPerformsResDefId) {
        this.trustPurchPerformsResDefId=trustPurchPerformsResDefId;
    }

    public List<TrustPurchPerform> getTrustPurchPerformsResDefId() {
        return trustPurchPerformsResDefId;
    }

    public void setTrustPurchPlanDetailssResDefId(List trustPurchPlanDetailssResDefId) {
        this.trustPurchPlanDetailssResDefId=trustPurchPlanDetailssResDefId;
    }

    public List<TrustPurchPlanDetailsKey> getTrustPurchPlanDetailssResDefId() {
        return trustPurchPlanDetailssResDefId;
    }

    public void setTrustPurchRedeemDetailssResDefId(List trustPurchRedeemDetailssResDefId) {
        this.trustPurchRedeemDetailssResDefId=trustPurchRedeemDetailssResDefId;
    }

    public List<TrustPurchRedeemDetails> getTrustPurchRedeemDetailssResDefId() {
        return trustPurchRedeemDetailssResDefId;
    }

    public void setTruPurchContrDetailssResDefId(List truPurchContrDetailssResDefId) {
        this.truPurchContrDetailssResDefId=truPurchContrDetailssResDefId;
    }

    public List<TruPurchContrDetails> getTruPurchContrDetailssResDefId() {
        return truPurchContrDetailssResDefId;
    }

    public void setValuationsResourcessResourceId(List valuationsResourcessResourceId) {
        this.valuationsResourcessResourceId=valuationsResourcessResourceId;
    }

    public List<ValuationsResources> getValuationsResourcessResourceId() {
        return valuationsResourcessResourceId;
    }

    public void setBrandsBrandId(Brands brandsBrandId) {
        this.brandsBrandId=brandsBrandId;
    }

    public Brands getBrandsBrandId() {
        return brandsBrandId;
    }

    public void setFileInfosExcelTemplateId(FileInfos fileInfosExcelTemplateId) {
        this.fileInfosExcelTemplateId=fileInfosExcelTemplateId;
    }

    public FileInfos getFileInfosExcelTemplateId() {
        return fileInfosExcelTemplateId;
    }

    public void setFileInfosPictureId(FileInfos fileInfosPictureId) {
        this.fileInfosPictureId=fileInfosPictureId;
    }

    public FileInfos getFileInfosPictureId() {
        return fileInfosPictureId;
    }

    public void setFileInfosMinPictureId(FileInfos fileInfosMinPictureId) {
        this.fileInfosMinPictureId=fileInfosMinPictureId;
    }

    public FileInfos getFileInfosMinPictureId() {
        return fileInfosMinPictureId;
    }

    public void setIngredientsIngredientId(Ingredients ingredientsIngredientId) {
        this.ingredientsIngredientId=ingredientsIngredientId;
    }

    public Ingredients getIngredientsIngredientId() {
        return ingredientsIngredientId;
    }

    public void setModelsModelId(Models modelsModelId) {
        this.modelsModelId=modelsModelId;
    }

    public Models getModelsModelId() {
        return modelsModelId;
    }

    public void setOriginsOriginId(Origins originsOriginId) {
        this.originsOriginId=originsOriginId;
    }

    public Origins getOriginsOriginId() {
        return originsOriginId;
    }

    public void setResourceTypesResourceTypeId(ResourceTypes resourceTypesResourceTypeId) {
        this.resourceTypesResourceTypeId=resourceTypesResourceTypeId;
    }

    public ResourceTypes getResourceTypesResourceTypeId() {
        return resourceTypesResourceTypeId;
    }

    public void setSpecificationsSpecificationId(Specifications specificationsSpecificationId) {
        this.specificationsSpecificationId=specificationsSpecificationId;
    }

    public Specifications getSpecificationsSpecificationId() {
        return specificationsSpecificationId;
    }

    public void setUomsUomId(Uoms uomsUomId) {
        this.uomsUomId=uomsUomId;
    }

    public Uoms getUomsUomId() {
        return uomsUomId;
    }
}