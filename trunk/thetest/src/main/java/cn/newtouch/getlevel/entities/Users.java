package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String userName;

    private String nickName;

    private String status;

    private Long companyId;

    private Date lastLoginTime;

    private String lastLoginIp;

    private String loginPassword;

    private String mobilePhone;

    private String email;

    private String name;

    private Long portraitImageFileId;

    private String isAdmin;

    private List<Appraise> appraisesPublishUserId = null;

    private List<AuthorizeFundsKey> authorizeFundssUserId = null;

    private List<Biddings> biddingssAuditUser = null;

    private List<Biddings> biddingssUserId = null;

    private List<BidBailReturnApp> bidBailReturnAppsVerifyUserid = null;

    private List<BidBailReturnApp> bidBailReturnAppsPlatAuditUserid = null;

    private List<BidBailReturnApp> bidBailReturnAppsSponsorUserid = null;

    private List<BidResponses> bidResponsessUserId = null;

    private List<Brands> brandssUserId = null;

    private List<BrokersKey> brokerssApprovUserId = null;

    private List<BrokersKey> brokerssAgentUserId = null;

    private List<BusinessLogs> businessLogssUserId = null;

    private List<BusinPaths> businPathssUserId = null;

    private List<CollateralItems> collateralItemssUserId = null;

    private List<ConsultTatics> consultTaticssUserId = null;

    private List<ConsultUsersKey> consultUserssUserId = null;

    private List<ConsulTacticsLogs> consulTacticsLogssUserId = null;

    private List<DeliveryPersons> deliveryPersonssUserId = null;

    private List<DifferentAnalyzes> differentAnalyzessUserId = null;

    private List<DigitalSignatureRecords> digitalSignatureRecordssUserId = null;

    private List<Documentation> documentationsPublishUserId = null;

    private List<DocumentationType> documentationTypesCreateUserId = null;

    private List<Driver> driversUserId = null;

    private List<Driver> driversDriverUserId = null;

    private List<EletricReceipt> eletricReceiptsUserId = null;

    private List<EntrPurchPlanCount> entrPurchPlanCountsUserId = null;

    private List<ExcelInRes> excelInRessUserId = null;

    private List<FinancingCredits> financingCreditssApplyUserId = null;

    private List<FinancingCredits> financingCreditssAuditUserId = null;

    private List<FundsFlowDetails> fundsFlowDetailssUserId = null;

    private List<FundsLockJournalsKey> fundsLockJournalssUserId = null;

    private List<GivenPricesKey> givenPricessUserId = null;

    private List<Ingredients> ingredientssUserId = null;

    private List<IntegralActivities> integralActivitiessUserId = null;

    private List<InventoryValuations> inventoryValuationssStartUserId = null;

    private List<InventoryValuations> inventoryValuationssPlanUserId = null;

    private List<InventoryValuations> inventoryValuationssJobStartUserId = null;

    private List<InvenvaliScopes> invenvaliScopessUserId = null;

    private List<Ladings> ladingssUserId = null;

    private List<LogisticsJobFlows> logisticsJobFlowssUserId = null;

    private List<LogisticsJobLinkPower> logisticsJobLinkPowersUserId = null;

    private List<LogisticsJobTemplate> logisticsJobTemplatesUserId = null;

    private List<LogisticsOrders> logisticsOrderssUserId = null;

    private List<LogisticsSolutions> logisticsSolutionssUserId = null;

    private List<MallCertCarrierKey> mallCertCarriersApllyUserId = null;

    private List<MallCertCarrierKey> mallCertCarriersCheckUserId = null;

    private List<MallTexts> mallTextssUserId = null;

    private List<MallWarehouse> mallWarehousesUserId = null;

    private List<MallWarehouse> mallWarehousesSetLimUserid = null;

    private List<MemberPrices> memberPricessUserId = null;

    private List<Menus> menussUserId = null;

    private List<Messages> messagessToUserId = null;

    private List<Messages> messagessFromUserId = null;

    private List<Models> modelssUserId = null;

    private List<ModelSpecifications> modelSpecificationssUpdateUserId = null;

    private List<ModelSpecifications> modelSpecificationssCreateUserId = null;

    private List<Orders> orderssBuyComId = null;

    private List<OrderConsScore> orderConsScoresScoreJournalId = null;

    private List<OrderQuotasKey> orderQuotassUserId = null;

    private List<Origins> originssUserId = null;

    private List<Pda> pdasUserId = null;

    private List<PdaApplication> pdaApplicationsUserId = null;

    private List<ProductiveFulfill> productiveFulfillsUserId = null;

    private List<Productivitys> productivityssUserId = null;

    private List<QualityBooks> qualityBookssInputerId = null;

    private List<QualityBooks> qualityBookssEditerId = null;

    private List<RepaymentRedeemGoods> repaymentRedeemGoodssUserId = null;

    private List<RouteReceipts> routeReceiptssDriverId = null;

    private List<SmsTask> smsTasksCreateUserId = null;

    private List<SmsTemplate> smsTemplatesPublishUserId = null;

    private List<Specifications> specificationssUserId = null;

    private List<StoreCertCarrierKey> storeCertCarriersApplyUserId = null;

    private List<StoreCertCarrierKey> storeCertCarriersCheckUserId = null;

    private List<StoreJobs> storeJobssUserId = null;

    private List<StoreJobFlows> storeJobFlowssUserId = null;

    private List<StoreJobFlowModes> storeJobFlowModessUserId = null;

    private List<StoreJobFlowNodes> storeJobFlowNodessUserId = null;

    private List<TraderResources> traderResourcessTraderUserid = null;

    private List<TraderResSnaps> traderResSnapssUserId = null;

    private List<TransportDemands> transportDemandssUserId = null;

    private List<TransportDemandResponses> transportDemandResponsessUserId = null;

    private List<TrustDistributerKey> trustDistributersUserId = null;

    private List<TrustPurchase> trustPurchasesUserId = null;

    private List<TrustPurchAgrees> trustPurchAgreessUserId = null;

    private List<TrustPurchPerform> trustPurchPerformsUserId = null;

    private List<TrustPurchRedeemDetails> trustPurchRedeemDetailssUserId = null;

    private List<Uoms> uomssUserId = null;

    private List<UserPasswordsKey> userPasswordssUserId = null;

    private List<UserRolesKey> userRolessUserId = null;

    private List<Vehicles> vehiclessRegisterUserId = null;

    private List<Vehicles> vehiclessContactId = null;

    private Companys companysCompanyId;

    private FileInfos fileInfosPortraitImageFileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPortraitImageFileId() {
        return portraitImageFileId;
    }

    public void setPortraitImageFileId(Long portraitImageFileId) {
        this.portraitImageFileId = portraitImageFileId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setAppraisesPublishUserId(List appraisesPublishUserId) {
        this.appraisesPublishUserId=appraisesPublishUserId;
    }

    public List<Appraise> getAppraisesPublishUserId() {
        return appraisesPublishUserId;
    }

    public void setAuthorizeFundssUserId(List authorizeFundssUserId) {
        this.authorizeFundssUserId=authorizeFundssUserId;
    }

    public List<AuthorizeFundsKey> getAuthorizeFundssUserId() {
        return authorizeFundssUserId;
    }

    public void setBiddingssAuditUser(List biddingssAuditUser) {
        this.biddingssAuditUser=biddingssAuditUser;
    }

    public List<Biddings> getBiddingssAuditUser() {
        return biddingssAuditUser;
    }

    public void setBiddingssUserId(List biddingssUserId) {
        this.biddingssUserId=biddingssUserId;
    }

    public List<Biddings> getBiddingssUserId() {
        return biddingssUserId;
    }

    public void setBidBailReturnAppsVerifyUserid(List bidBailReturnAppsVerifyUserid) {
        this.bidBailReturnAppsVerifyUserid=bidBailReturnAppsVerifyUserid;
    }

    public List<BidBailReturnApp> getBidBailReturnAppsVerifyUserid() {
        return bidBailReturnAppsVerifyUserid;
    }

    public void setBidBailReturnAppsPlatAuditUserid(List bidBailReturnAppsPlatAuditUserid) {
        this.bidBailReturnAppsPlatAuditUserid=bidBailReturnAppsPlatAuditUserid;
    }

    public List<BidBailReturnApp> getBidBailReturnAppsPlatAuditUserid() {
        return bidBailReturnAppsPlatAuditUserid;
    }

    public void setBidBailReturnAppsSponsorUserid(List bidBailReturnAppsSponsorUserid) {
        this.bidBailReturnAppsSponsorUserid=bidBailReturnAppsSponsorUserid;
    }

    public List<BidBailReturnApp> getBidBailReturnAppsSponsorUserid() {
        return bidBailReturnAppsSponsorUserid;
    }

    public void setBidResponsessUserId(List bidResponsessUserId) {
        this.bidResponsessUserId=bidResponsessUserId;
    }

    public List<BidResponses> getBidResponsessUserId() {
        return bidResponsessUserId;
    }

    public void setBrandssUserId(List brandssUserId) {
        this.brandssUserId=brandssUserId;
    }

    public List<Brands> getBrandssUserId() {
        return brandssUserId;
    }

    public void setBrokerssApprovUserId(List brokerssApprovUserId) {
        this.brokerssApprovUserId=brokerssApprovUserId;
    }

    public List<BrokersKey> getBrokerssApprovUserId() {
        return brokerssApprovUserId;
    }

    public void setBrokerssAgentUserId(List brokerssAgentUserId) {
        this.brokerssAgentUserId=brokerssAgentUserId;
    }

    public List<BrokersKey> getBrokerssAgentUserId() {
        return brokerssAgentUserId;
    }

    public void setBusinessLogssUserId(List businessLogssUserId) {
        this.businessLogssUserId=businessLogssUserId;
    }

    public List<BusinessLogs> getBusinessLogssUserId() {
        return businessLogssUserId;
    }

    public void setBusinPathssUserId(List businPathssUserId) {
        this.businPathssUserId=businPathssUserId;
    }

    public List<BusinPaths> getBusinPathssUserId() {
        return businPathssUserId;
    }

    public void setCollateralItemssUserId(List collateralItemssUserId) {
        this.collateralItemssUserId=collateralItemssUserId;
    }

    public List<CollateralItems> getCollateralItemssUserId() {
        return collateralItemssUserId;
    }

    public void setConsultTaticssUserId(List consultTaticssUserId) {
        this.consultTaticssUserId=consultTaticssUserId;
    }

    public List<ConsultTatics> getConsultTaticssUserId() {
        return consultTaticssUserId;
    }

    public void setConsultUserssUserId(List consultUserssUserId) {
        this.consultUserssUserId=consultUserssUserId;
    }

    public List<ConsultUsersKey> getConsultUserssUserId() {
        return consultUserssUserId;
    }

    public void setConsulTacticsLogssUserId(List consulTacticsLogssUserId) {
        this.consulTacticsLogssUserId=consulTacticsLogssUserId;
    }

    public List<ConsulTacticsLogs> getConsulTacticsLogssUserId() {
        return consulTacticsLogssUserId;
    }

    public void setDeliveryPersonssUserId(List deliveryPersonssUserId) {
        this.deliveryPersonssUserId=deliveryPersonssUserId;
    }

    public List<DeliveryPersons> getDeliveryPersonssUserId() {
        return deliveryPersonssUserId;
    }

    public void setDifferentAnalyzessUserId(List differentAnalyzessUserId) {
        this.differentAnalyzessUserId=differentAnalyzessUserId;
    }

    public List<DifferentAnalyzes> getDifferentAnalyzessUserId() {
        return differentAnalyzessUserId;
    }

    public void setDigitalSignatureRecordssUserId(List digitalSignatureRecordssUserId) {
        this.digitalSignatureRecordssUserId=digitalSignatureRecordssUserId;
    }

    public List<DigitalSignatureRecords> getDigitalSignatureRecordssUserId() {
        return digitalSignatureRecordssUserId;
    }

    public void setDocumentationsPublishUserId(List documentationsPublishUserId) {
        this.documentationsPublishUserId=documentationsPublishUserId;
    }

    public List<Documentation> getDocumentationsPublishUserId() {
        return documentationsPublishUserId;
    }

    public void setDocumentationTypesCreateUserId(List documentationTypesCreateUserId) {
        this.documentationTypesCreateUserId=documentationTypesCreateUserId;
    }

    public List<DocumentationType> getDocumentationTypesCreateUserId() {
        return documentationTypesCreateUserId;
    }

    public void setDriversUserId(List driversUserId) {
        this.driversUserId=driversUserId;
    }

    public List<Driver> getDriversUserId() {
        return driversUserId;
    }

    public void setDriversDriverUserId(List driversDriverUserId) {
        this.driversDriverUserId=driversDriverUserId;
    }

    public List<Driver> getDriversDriverUserId() {
        return driversDriverUserId;
    }

    public void setEletricReceiptsUserId(List eletricReceiptsUserId) {
        this.eletricReceiptsUserId=eletricReceiptsUserId;
    }

    public List<EletricReceipt> getEletricReceiptsUserId() {
        return eletricReceiptsUserId;
    }

    public void setEntrPurchPlanCountsUserId(List entrPurchPlanCountsUserId) {
        this.entrPurchPlanCountsUserId=entrPurchPlanCountsUserId;
    }

    public List<EntrPurchPlanCount> getEntrPurchPlanCountsUserId() {
        return entrPurchPlanCountsUserId;
    }

    public void setExcelInRessUserId(List excelInRessUserId) {
        this.excelInRessUserId=excelInRessUserId;
    }

    public List<ExcelInRes> getExcelInRessUserId() {
        return excelInRessUserId;
    }

    public void setFinancingCreditssApplyUserId(List financingCreditssApplyUserId) {
        this.financingCreditssApplyUserId=financingCreditssApplyUserId;
    }

    public List<FinancingCredits> getFinancingCreditssApplyUserId() {
        return financingCreditssApplyUserId;
    }

    public void setFinancingCreditssAuditUserId(List financingCreditssAuditUserId) {
        this.financingCreditssAuditUserId=financingCreditssAuditUserId;
    }

    public List<FinancingCredits> getFinancingCreditssAuditUserId() {
        return financingCreditssAuditUserId;
    }

    public void setFundsFlowDetailssUserId(List fundsFlowDetailssUserId) {
        this.fundsFlowDetailssUserId=fundsFlowDetailssUserId;
    }

    public List<FundsFlowDetails> getFundsFlowDetailssUserId() {
        return fundsFlowDetailssUserId;
    }

    public void setFundsLockJournalssUserId(List fundsLockJournalssUserId) {
        this.fundsLockJournalssUserId=fundsLockJournalssUserId;
    }

    public List<FundsLockJournalsKey> getFundsLockJournalssUserId() {
        return fundsLockJournalssUserId;
    }

    public void setGivenPricessUserId(List givenPricessUserId) {
        this.givenPricessUserId=givenPricessUserId;
    }

    public List<GivenPricesKey> getGivenPricessUserId() {
        return givenPricessUserId;
    }

    public void setIngredientssUserId(List ingredientssUserId) {
        this.ingredientssUserId=ingredientssUserId;
    }

    public List<Ingredients> getIngredientssUserId() {
        return ingredientssUserId;
    }

    public void setIntegralActivitiessUserId(List integralActivitiessUserId) {
        this.integralActivitiessUserId=integralActivitiessUserId;
    }

    public List<IntegralActivities> getIntegralActivitiessUserId() {
        return integralActivitiessUserId;
    }

    public void setInventoryValuationssStartUserId(List inventoryValuationssStartUserId) {
        this.inventoryValuationssStartUserId=inventoryValuationssStartUserId;
    }

    public List<InventoryValuations> getInventoryValuationssStartUserId() {
        return inventoryValuationssStartUserId;
    }

    public void setInventoryValuationssPlanUserId(List inventoryValuationssPlanUserId) {
        this.inventoryValuationssPlanUserId=inventoryValuationssPlanUserId;
    }

    public List<InventoryValuations> getInventoryValuationssPlanUserId() {
        return inventoryValuationssPlanUserId;
    }

    public void setInventoryValuationssJobStartUserId(List inventoryValuationssJobStartUserId) {
        this.inventoryValuationssJobStartUserId=inventoryValuationssJobStartUserId;
    }

    public List<InventoryValuations> getInventoryValuationssJobStartUserId() {
        return inventoryValuationssJobStartUserId;
    }

    public void setInvenvaliScopessUserId(List invenvaliScopessUserId) {
        this.invenvaliScopessUserId=invenvaliScopessUserId;
    }

    public List<InvenvaliScopes> getInvenvaliScopessUserId() {
        return invenvaliScopessUserId;
    }

    public void setLadingssUserId(List ladingssUserId) {
        this.ladingssUserId=ladingssUserId;
    }

    public List<Ladings> getLadingssUserId() {
        return ladingssUserId;
    }

    public void setLogisticsJobFlowssUserId(List logisticsJobFlowssUserId) {
        this.logisticsJobFlowssUserId=logisticsJobFlowssUserId;
    }

    public List<LogisticsJobFlows> getLogisticsJobFlowssUserId() {
        return logisticsJobFlowssUserId;
    }

    public void setLogisticsJobLinkPowersUserId(List logisticsJobLinkPowersUserId) {
        this.logisticsJobLinkPowersUserId=logisticsJobLinkPowersUserId;
    }

    public List<LogisticsJobLinkPower> getLogisticsJobLinkPowersUserId() {
        return logisticsJobLinkPowersUserId;
    }

    public void setLogisticsJobTemplatesUserId(List logisticsJobTemplatesUserId) {
        this.logisticsJobTemplatesUserId=logisticsJobTemplatesUserId;
    }

    public List<LogisticsJobTemplate> getLogisticsJobTemplatesUserId() {
        return logisticsJobTemplatesUserId;
    }

    public void setLogisticsOrderssUserId(List logisticsOrderssUserId) {
        this.logisticsOrderssUserId=logisticsOrderssUserId;
    }

    public List<LogisticsOrders> getLogisticsOrderssUserId() {
        return logisticsOrderssUserId;
    }

    public void setLogisticsSolutionssUserId(List logisticsSolutionssUserId) {
        this.logisticsSolutionssUserId=logisticsSolutionssUserId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssUserId() {
        return logisticsSolutionssUserId;
    }

    public void setMallCertCarriersApllyUserId(List mallCertCarriersApllyUserId) {
        this.mallCertCarriersApllyUserId=mallCertCarriersApllyUserId;
    }

    public List<MallCertCarrierKey> getMallCertCarriersApllyUserId() {
        return mallCertCarriersApllyUserId;
    }

    public void setMallCertCarriersCheckUserId(List mallCertCarriersCheckUserId) {
        this.mallCertCarriersCheckUserId=mallCertCarriersCheckUserId;
    }

    public List<MallCertCarrierKey> getMallCertCarriersCheckUserId() {
        return mallCertCarriersCheckUserId;
    }

    public void setMallTextssUserId(List mallTextssUserId) {
        this.mallTextssUserId=mallTextssUserId;
    }

    public List<MallTexts> getMallTextssUserId() {
        return mallTextssUserId;
    }

    public void setMallWarehousesUserId(List mallWarehousesUserId) {
        this.mallWarehousesUserId=mallWarehousesUserId;
    }

    public List<MallWarehouse> getMallWarehousesUserId() {
        return mallWarehousesUserId;
    }

    public void setMallWarehousesSetLimUserid(List mallWarehousesSetLimUserid) {
        this.mallWarehousesSetLimUserid=mallWarehousesSetLimUserid;
    }

    public List<MallWarehouse> getMallWarehousesSetLimUserid() {
        return mallWarehousesSetLimUserid;
    }

    public void setMemberPricessUserId(List memberPricessUserId) {
        this.memberPricessUserId=memberPricessUserId;
    }

    public List<MemberPrices> getMemberPricessUserId() {
        return memberPricessUserId;
    }

    public void setMenussUserId(List menussUserId) {
        this.menussUserId=menussUserId;
    }

    public List<Menus> getMenussUserId() {
        return menussUserId;
    }

    public void setMessagessToUserId(List messagessToUserId) {
        this.messagessToUserId=messagessToUserId;
    }

    public List<Messages> getMessagessToUserId() {
        return messagessToUserId;
    }

    public void setMessagessFromUserId(List messagessFromUserId) {
        this.messagessFromUserId=messagessFromUserId;
    }

    public List<Messages> getMessagessFromUserId() {
        return messagessFromUserId;
    }

    public void setModelssUserId(List modelssUserId) {
        this.modelssUserId=modelssUserId;
    }

    public List<Models> getModelssUserId() {
        return modelssUserId;
    }

    public void setModelSpecificationssUpdateUserId(List modelSpecificationssUpdateUserId) {
        this.modelSpecificationssUpdateUserId=modelSpecificationssUpdateUserId;
    }

    public List<ModelSpecifications> getModelSpecificationssUpdateUserId() {
        return modelSpecificationssUpdateUserId;
    }

    public void setModelSpecificationssCreateUserId(List modelSpecificationssCreateUserId) {
        this.modelSpecificationssCreateUserId=modelSpecificationssCreateUserId;
    }

    public List<ModelSpecifications> getModelSpecificationssCreateUserId() {
        return modelSpecificationssCreateUserId;
    }

    public void setOrderssBuyComId(List orderssBuyComId) {
        this.orderssBuyComId=orderssBuyComId;
    }

    public List<Orders> getOrderssBuyComId() {
        return orderssBuyComId;
    }

    public void setOrderConsScoresScoreJournalId(List orderConsScoresScoreJournalId) {
        this.orderConsScoresScoreJournalId=orderConsScoresScoreJournalId;
    }

    public List<OrderConsScore> getOrderConsScoresScoreJournalId() {
        return orderConsScoresScoreJournalId;
    }

    public void setOrderQuotassUserId(List orderQuotassUserId) {
        this.orderQuotassUserId=orderQuotassUserId;
    }

    public List<OrderQuotasKey> getOrderQuotassUserId() {
        return orderQuotassUserId;
    }

    public void setOriginssUserId(List originssUserId) {
        this.originssUserId=originssUserId;
    }

    public List<Origins> getOriginssUserId() {
        return originssUserId;
    }

    public void setPdasUserId(List pdasUserId) {
        this.pdasUserId=pdasUserId;
    }

    public List<Pda> getPdasUserId() {
        return pdasUserId;
    }

    public void setPdaApplicationsUserId(List pdaApplicationsUserId) {
        this.pdaApplicationsUserId=pdaApplicationsUserId;
    }

    public List<PdaApplication> getPdaApplicationsUserId() {
        return pdaApplicationsUserId;
    }

    public void setProductiveFulfillsUserId(List productiveFulfillsUserId) {
        this.productiveFulfillsUserId=productiveFulfillsUserId;
    }

    public List<ProductiveFulfill> getProductiveFulfillsUserId() {
        return productiveFulfillsUserId;
    }

    public void setProductivityssUserId(List productivityssUserId) {
        this.productivityssUserId=productivityssUserId;
    }

    public List<Productivitys> getProductivityssUserId() {
        return productivityssUserId;
    }

    public void setQualityBookssInputerId(List qualityBookssInputerId) {
        this.qualityBookssInputerId=qualityBookssInputerId;
    }

    public List<QualityBooks> getQualityBookssInputerId() {
        return qualityBookssInputerId;
    }

    public void setQualityBookssEditerId(List qualityBookssEditerId) {
        this.qualityBookssEditerId=qualityBookssEditerId;
    }

    public List<QualityBooks> getQualityBookssEditerId() {
        return qualityBookssEditerId;
    }

    public void setRepaymentRedeemGoodssUserId(List repaymentRedeemGoodssUserId) {
        this.repaymentRedeemGoodssUserId=repaymentRedeemGoodssUserId;
    }

    public List<RepaymentRedeemGoods> getRepaymentRedeemGoodssUserId() {
        return repaymentRedeemGoodssUserId;
    }

    public void setRouteReceiptssDriverId(List routeReceiptssDriverId) {
        this.routeReceiptssDriverId=routeReceiptssDriverId;
    }

    public List<RouteReceipts> getRouteReceiptssDriverId() {
        return routeReceiptssDriverId;
    }

    public void setSmsTasksCreateUserId(List smsTasksCreateUserId) {
        this.smsTasksCreateUserId=smsTasksCreateUserId;
    }

    public List<SmsTask> getSmsTasksCreateUserId() {
        return smsTasksCreateUserId;
    }

    public void setSmsTemplatesPublishUserId(List smsTemplatesPublishUserId) {
        this.smsTemplatesPublishUserId=smsTemplatesPublishUserId;
    }

    public List<SmsTemplate> getSmsTemplatesPublishUserId() {
        return smsTemplatesPublishUserId;
    }

    public void setSpecificationssUserId(List specificationssUserId) {
        this.specificationssUserId=specificationssUserId;
    }

    public List<Specifications> getSpecificationssUserId() {
        return specificationssUserId;
    }

    public void setStoreCertCarriersApplyUserId(List storeCertCarriersApplyUserId) {
        this.storeCertCarriersApplyUserId=storeCertCarriersApplyUserId;
    }

    public List<StoreCertCarrierKey> getStoreCertCarriersApplyUserId() {
        return storeCertCarriersApplyUserId;
    }

    public void setStoreCertCarriersCheckUserId(List storeCertCarriersCheckUserId) {
        this.storeCertCarriersCheckUserId=storeCertCarriersCheckUserId;
    }

    public List<StoreCertCarrierKey> getStoreCertCarriersCheckUserId() {
        return storeCertCarriersCheckUserId;
    }

    public void setStoreJobssUserId(List storeJobssUserId) {
        this.storeJobssUserId=storeJobssUserId;
    }

    public List<StoreJobs> getStoreJobssUserId() {
        return storeJobssUserId;
    }

    public void setStoreJobFlowssUserId(List storeJobFlowssUserId) {
        this.storeJobFlowssUserId=storeJobFlowssUserId;
    }

    public List<StoreJobFlows> getStoreJobFlowssUserId() {
        return storeJobFlowssUserId;
    }

    public void setStoreJobFlowModessUserId(List storeJobFlowModessUserId) {
        this.storeJobFlowModessUserId=storeJobFlowModessUserId;
    }

    public List<StoreJobFlowModes> getStoreJobFlowModessUserId() {
        return storeJobFlowModessUserId;
    }

    public void setStoreJobFlowNodessUserId(List storeJobFlowNodessUserId) {
        this.storeJobFlowNodessUserId=storeJobFlowNodessUserId;
    }

    public List<StoreJobFlowNodes> getStoreJobFlowNodessUserId() {
        return storeJobFlowNodessUserId;
    }

    public void setTraderResourcessTraderUserid(List traderResourcessTraderUserid) {
        this.traderResourcessTraderUserid=traderResourcessTraderUserid;
    }

    public List<TraderResources> getTraderResourcessTraderUserid() {
        return traderResourcessTraderUserid;
    }

    public void setTraderResSnapssUserId(List traderResSnapssUserId) {
        this.traderResSnapssUserId=traderResSnapssUserId;
    }

    public List<TraderResSnaps> getTraderResSnapssUserId() {
        return traderResSnapssUserId;
    }

    public void setTransportDemandssUserId(List transportDemandssUserId) {
        this.transportDemandssUserId=transportDemandssUserId;
    }

    public List<TransportDemands> getTransportDemandssUserId() {
        return transportDemandssUserId;
    }

    public void setTransportDemandResponsessUserId(List transportDemandResponsessUserId) {
        this.transportDemandResponsessUserId=transportDemandResponsessUserId;
    }

    public List<TransportDemandResponses> getTransportDemandResponsessUserId() {
        return transportDemandResponsessUserId;
    }

    public void setTrustDistributersUserId(List trustDistributersUserId) {
        this.trustDistributersUserId=trustDistributersUserId;
    }

    public List<TrustDistributerKey> getTrustDistributersUserId() {
        return trustDistributersUserId;
    }

    public void setTrustPurchasesUserId(List trustPurchasesUserId) {
        this.trustPurchasesUserId=trustPurchasesUserId;
    }

    public List<TrustPurchase> getTrustPurchasesUserId() {
        return trustPurchasesUserId;
    }

    public void setTrustPurchAgreessUserId(List trustPurchAgreessUserId) {
        this.trustPurchAgreessUserId=trustPurchAgreessUserId;
    }

    public List<TrustPurchAgrees> getTrustPurchAgreessUserId() {
        return trustPurchAgreessUserId;
    }

    public void setTrustPurchPerformsUserId(List trustPurchPerformsUserId) {
        this.trustPurchPerformsUserId=trustPurchPerformsUserId;
    }

    public List<TrustPurchPerform> getTrustPurchPerformsUserId() {
        return trustPurchPerformsUserId;
    }

    public void setTrustPurchRedeemDetailssUserId(List trustPurchRedeemDetailssUserId) {
        this.trustPurchRedeemDetailssUserId=trustPurchRedeemDetailssUserId;
    }

    public List<TrustPurchRedeemDetails> getTrustPurchRedeemDetailssUserId() {
        return trustPurchRedeemDetailssUserId;
    }

    public void setUomssUserId(List uomssUserId) {
        this.uomssUserId=uomssUserId;
    }

    public List<Uoms> getUomssUserId() {
        return uomssUserId;
    }

    public void setUserPasswordssUserId(List userPasswordssUserId) {
        this.userPasswordssUserId=userPasswordssUserId;
    }

    public List<UserPasswordsKey> getUserPasswordssUserId() {
        return userPasswordssUserId;
    }

    public void setUserRolessUserId(List userRolessUserId) {
        this.userRolessUserId=userRolessUserId;
    }

    public List<UserRolesKey> getUserRolessUserId() {
        return userRolessUserId;
    }

    public void setVehiclessRegisterUserId(List vehiclessRegisterUserId) {
        this.vehiclessRegisterUserId=vehiclessRegisterUserId;
    }

    public List<Vehicles> getVehiclessRegisterUserId() {
        return vehiclessRegisterUserId;
    }

    public void setVehiclessContactId(List vehiclessContactId) {
        this.vehiclessContactId=vehiclessContactId;
    }

    public List<Vehicles> getVehiclessContactId() {
        return vehiclessContactId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setFileInfosPortraitImageFileId(FileInfos fileInfosPortraitImageFileId) {
        this.fileInfosPortraitImageFileId=fileInfosPortraitImageFileId;
    }

    public FileInfos getFileInfosPortraitImageFileId() {
        return fileInfosPortraitImageFileId;
    }
}