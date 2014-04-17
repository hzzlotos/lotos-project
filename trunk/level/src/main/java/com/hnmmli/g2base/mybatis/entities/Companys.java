package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Companys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String type;

    private String status;

    private String industry;

    private String organizationCode;

    private String legalPerson;

    private String taxCode;

    private String companyFullname;

    private String companyAbbrename;

    private String checkStatus;

    private Date checkDate;

    private Date registerDate;

    private Long mailingAddressId;

    private Long registerAddressId;

    private Long businessLicenseFileId;

    private Long taxCertificateFileId;

    private Long organizationCodeFileId;

    private String officePhone;

    private String officeFax;

    private String contact;

    private String contactPhone;

    private List<AccountValuationsStatics> accountValuationsStaticssBusinessCompanyId = null;

    private List<AddressBookKey> addressBooksCompanyId = null;

    private List<Biddings> biddingssEnterpriseId = null;

    private List<BiddingInvitations> biddingInvitationssEnterpriseId = null;

    private List<BidBails> bidBailssComId = null;

    private List<BidBailReturnApp> bidBailReturnAppsConComId = null;

    private List<BidBailReturnApp> bidBailReturnAppsSponsorComId = null;

    private List<BidDeposits> bidDepositssComId = null;

    private List<BidResponses> bidResponsessEnterpriseId = null;

    private List<BillingPolicies> billingPoliciessCompanyId = null;

    private List<BillingSettlements> billingSettlementssCompanyId = null;

    private List<BrokersKey> brokerssAgentComId = null;

    private List<BrokersKey> brokerssComId = null;

    private List<BusinPaths> businPathssUpComId = null;

    private List<BusinPaths> businPathssDownComId = null;

    private List<CollateralSummaries> collateralSummariessCompanyId = null;

    private List<CompanyBankAccounts> companyBankAccountssCompanyId = null;

    private List<CompanyBrandsKey> companyBrandssCompanyId = null;

    private List<CompanyFundAccounts> companyFundAccountssCompanyId = null;

    private List<CompanyIngredientsKey> companyIngredientssCompanyId = null;

    private List<CompanyModelsKey> companyModelssCompanyId = null;

    private List<CompanyResourcesKey> companyResourcessCompanyId = null;

    private List<CompanySpecificationsKey> companySpecificationssCompanyId = null;

    private List<ConsultTatics> consultTaticssCompanyId = null;

    private List<ConsultUsersKey> consultUserssEnterpriseId = null;

    private List<Departments> departmentssCompanyId = null;

    private List<DigitalSignatureRecords> digitalSignatureRecordssCompanyId = null;

    private List<EntrPurchPlanCount> entrPurchPlanCountsCompanyId = null;

    private List<ExcelInRes> excelInRessCompanyId = null;

    private List<FinancingCredits> financingCreditssCompanyId = null;

    private List<FundsFlowDetails> fundsFlowDetailssReceivecomId = null;

    private List<FundsFlowDetails> fundsFlowDetailssPaycomId = null;

    private List<FundsLockJournalsKey> fundsLockJournalssPayComId = null;

    private List<FundsLockJournalsKey> fundsLockJournalssRecComId = null;

    private List<GivenPricesKey> givenPricessCompanyId = null;

    private List<InventoryResourceDetails> inventoryResourceDetailssTradingCompanyId = null;

    private List<InventoryResourceDetails> inventoryResourceDetailssCargoCompanyId = null;

    private List<InventoryValuations> inventoryValuationssResourceCompanyId = null;

    private List<Invoices> invoicessWriteCompanyId = null;

    private List<LogisticsBranch> logisticsBranchsCompanyId = null;

    private List<LogisticsJobTemplate> logisticsJobTemplatesCompanyId = null;

    private List<LogisticsMemberKey> logisticsMembersMemberCompanyId = null;

    private List<LogisticsOrders> logisticsOrderssEntrustCompanyId = null;

    private List<LogisticsOrders> logisticsOrderssCarrierCompanyId = null;

    private List<LogisticsSolutions> logisticsSolutionssCarsCompanyId = null;

    private List<MallMembersKey> mallMemberssSettleComId = null;

    private List<MallMembersKey> mallMemberssMallMemberId = null;

    private List<MemberlvSettle> memberlvSettlesCompanyId = null;

    private List<MemberPrices> memberPricessCompanyId = null;

    private List<Orders> orderssBuyComId = null;

    private List<Orders> orderssSettleComId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssCargoCompanyId = null;

    private List<PhysicalValuationsStatics> physicalValuationsStaticssTradingCompanyId = null;

    private List<Positions> positionssCompanyId = null;

    private List<ProcessMaterial> processMaterialsCompanyId = null;

    private List<Productivitys> productivityssCompanyId = null;

    private List<QualityBooks> qualityBookssCompanyId = null;

    private List<ResodOwnUpHistorys> resodOwnUpHistoryssOriginalOwnerId = null;

    private List<ResodOwnUpHistorys> resodOwnUpHistoryssOwnerId = null;

    private List<ResourceDetails> resourceDetailssTradingCompanyId = null;

    private List<ResourceDetails> resourceDetailssCargoCompanyId = null;

    private List<ResourceSummaries> resourceSummariessCompanyId = null;

    private List<ScoreJournals> scoreJournalssComId = null;

    private List<Sellers> sellerssSettlementmain = null;

    private List<Sellers> sellerssCompanyId = null;

    private List<Stores> storessOwnerId = null;

    private List<Stores> storessOperatorId = null;

    private List<Stores> storessRegulatoryId = null;

    private List<StoreCompanysKey> storeCompanyssCompanyId = null;

    private List<StoreJobs> storeJobssStoreCompanyId = null;

    private List<StoreJobs> storeJobssExtractCompanyId = null;

    private List<StoreJobDetails> storeJobDetailssCargoCompanyId = null;

    private List<StoreJobDetails> storeJobDetailssTradingCompanyId = null;

    private List<TraderResources> traderResourcessSettleComId = null;

    private List<TraderResources> traderResourcessCompanyId = null;

    private List<TrustPurchase> trustPurchasesUpComId = null;

    private List<TrustPurchase> trustPurchasesPrincipalComId = null;

    private List<TrustPurchase> trustPurchasesTrusteeComId = null;

    private List<Users> userssCompanyId = null;

    private List<Vehicles> vehiclessVehicleOwnerId = null;

    private List<Vehicles> vehiclessManageCompanyId = null;

    private List<Vehicles> vehiclessCarrierId = null;

    private FileInfos fileInfosOrganizationCodeFileId;

    private FileInfos fileInfosTaxCertificateFileId;

    private FileInfos fileInfosBusinessLicenseFileId;

    private LogisticsAddress logisticsAddressRegisterAddressId;

    private LogisticsAddress logisticsAddressMailingAddressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getCompanyFullname() {
        return companyFullname;
    }

    public void setCompanyFullname(String companyFullname) {
        this.companyFullname = companyFullname;
    }

    public String getCompanyAbbrename() {
        return companyAbbrename;
    }

    public void setCompanyAbbrename(String companyAbbrename) {
        this.companyAbbrename = companyAbbrename;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Long getMailingAddressId() {
        return mailingAddressId;
    }

    public void setMailingAddressId(Long mailingAddressId) {
        this.mailingAddressId = mailingAddressId;
    }

    public Long getRegisterAddressId() {
        return registerAddressId;
    }

    public void setRegisterAddressId(Long registerAddressId) {
        this.registerAddressId = registerAddressId;
    }

    public Long getBusinessLicenseFileId() {
        return businessLicenseFileId;
    }

    public void setBusinessLicenseFileId(Long businessLicenseFileId) {
        this.businessLicenseFileId = businessLicenseFileId;
    }

    public Long getTaxCertificateFileId() {
        return taxCertificateFileId;
    }

    public void setTaxCertificateFileId(Long taxCertificateFileId) {
        this.taxCertificateFileId = taxCertificateFileId;
    }

    public Long getOrganizationCodeFileId() {
        return organizationCodeFileId;
    }

    public void setOrganizationCodeFileId(Long organizationCodeFileId) {
        this.organizationCodeFileId = organizationCodeFileId;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficeFax() {
        return officeFax;
    }

    public void setOfficeFax(String officeFax) {
        this.officeFax = officeFax;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setAccountValuationsStaticssBusinessCompanyId(List accountValuationsStaticssBusinessCompanyId) {
        this.accountValuationsStaticssBusinessCompanyId=accountValuationsStaticssBusinessCompanyId;
    }

    public List<AccountValuationsStatics> getAccountValuationsStaticssBusinessCompanyId() {
        return accountValuationsStaticssBusinessCompanyId;
    }

    public void setAddressBooksCompanyId(List addressBooksCompanyId) {
        this.addressBooksCompanyId=addressBooksCompanyId;
    }

    public List<AddressBookKey> getAddressBooksCompanyId() {
        return addressBooksCompanyId;
    }

    public void setBiddingssEnterpriseId(List biddingssEnterpriseId) {
        this.biddingssEnterpriseId=biddingssEnterpriseId;
    }

    public List<Biddings> getBiddingssEnterpriseId() {
        return biddingssEnterpriseId;
    }

    public void setBiddingInvitationssEnterpriseId(List biddingInvitationssEnterpriseId) {
        this.biddingInvitationssEnterpriseId=biddingInvitationssEnterpriseId;
    }

    public List<BiddingInvitations> getBiddingInvitationssEnterpriseId() {
        return biddingInvitationssEnterpriseId;
    }

    public void setBidBailssComId(List bidBailssComId) {
        this.bidBailssComId=bidBailssComId;
    }

    public List<BidBails> getBidBailssComId() {
        return bidBailssComId;
    }

    public void setBidBailReturnAppsConComId(List bidBailReturnAppsConComId) {
        this.bidBailReturnAppsConComId=bidBailReturnAppsConComId;
    }

    public List<BidBailReturnApp> getBidBailReturnAppsConComId() {
        return bidBailReturnAppsConComId;
    }

    public void setBidBailReturnAppsSponsorComId(List bidBailReturnAppsSponsorComId) {
        this.bidBailReturnAppsSponsorComId=bidBailReturnAppsSponsorComId;
    }

    public List<BidBailReturnApp> getBidBailReturnAppsSponsorComId() {
        return bidBailReturnAppsSponsorComId;
    }

    public void setBidDepositssComId(List bidDepositssComId) {
        this.bidDepositssComId=bidDepositssComId;
    }

    public List<BidDeposits> getBidDepositssComId() {
        return bidDepositssComId;
    }

    public void setBidResponsessEnterpriseId(List bidResponsessEnterpriseId) {
        this.bidResponsessEnterpriseId=bidResponsessEnterpriseId;
    }

    public List<BidResponses> getBidResponsessEnterpriseId() {
        return bidResponsessEnterpriseId;
    }

    public void setBillingPoliciessCompanyId(List billingPoliciessCompanyId) {
        this.billingPoliciessCompanyId=billingPoliciessCompanyId;
    }

    public List<BillingPolicies> getBillingPoliciessCompanyId() {
        return billingPoliciessCompanyId;
    }

    public void setBillingSettlementssCompanyId(List billingSettlementssCompanyId) {
        this.billingSettlementssCompanyId=billingSettlementssCompanyId;
    }

    public List<BillingSettlements> getBillingSettlementssCompanyId() {
        return billingSettlementssCompanyId;
    }

    public void setBrokerssAgentComId(List brokerssAgentComId) {
        this.brokerssAgentComId=brokerssAgentComId;
    }

    public List<BrokersKey> getBrokerssAgentComId() {
        return brokerssAgentComId;
    }

    public void setBrokerssComId(List brokerssComId) {
        this.brokerssComId=brokerssComId;
    }

    public List<BrokersKey> getBrokerssComId() {
        return brokerssComId;
    }

    public void setBusinPathssUpComId(List businPathssUpComId) {
        this.businPathssUpComId=businPathssUpComId;
    }

    public List<BusinPaths> getBusinPathssUpComId() {
        return businPathssUpComId;
    }

    public void setBusinPathssDownComId(List businPathssDownComId) {
        this.businPathssDownComId=businPathssDownComId;
    }

    public List<BusinPaths> getBusinPathssDownComId() {
        return businPathssDownComId;
    }

    public void setCollateralSummariessCompanyId(List collateralSummariessCompanyId) {
        this.collateralSummariessCompanyId=collateralSummariessCompanyId;
    }

    public List<CollateralSummaries> getCollateralSummariessCompanyId() {
        return collateralSummariessCompanyId;
    }

    public void setCompanyBankAccountssCompanyId(List companyBankAccountssCompanyId) {
        this.companyBankAccountssCompanyId=companyBankAccountssCompanyId;
    }

    public List<CompanyBankAccounts> getCompanyBankAccountssCompanyId() {
        return companyBankAccountssCompanyId;
    }

    public void setCompanyBrandssCompanyId(List companyBrandssCompanyId) {
        this.companyBrandssCompanyId=companyBrandssCompanyId;
    }

    public List<CompanyBrandsKey> getCompanyBrandssCompanyId() {
        return companyBrandssCompanyId;
    }

    public void setCompanyFundAccountssCompanyId(List companyFundAccountssCompanyId) {
        this.companyFundAccountssCompanyId=companyFundAccountssCompanyId;
    }

    public List<CompanyFundAccounts> getCompanyFundAccountssCompanyId() {
        return companyFundAccountssCompanyId;
    }

    public void setCompanyIngredientssCompanyId(List companyIngredientssCompanyId) {
        this.companyIngredientssCompanyId=companyIngredientssCompanyId;
    }

    public List<CompanyIngredientsKey> getCompanyIngredientssCompanyId() {
        return companyIngredientssCompanyId;
    }

    public void setCompanyModelssCompanyId(List companyModelssCompanyId) {
        this.companyModelssCompanyId=companyModelssCompanyId;
    }

    public List<CompanyModelsKey> getCompanyModelssCompanyId() {
        return companyModelssCompanyId;
    }

    public void setCompanyResourcessCompanyId(List companyResourcessCompanyId) {
        this.companyResourcessCompanyId=companyResourcessCompanyId;
    }

    public List<CompanyResourcesKey> getCompanyResourcessCompanyId() {
        return companyResourcessCompanyId;
    }

    public void setCompanySpecificationssCompanyId(List companySpecificationssCompanyId) {
        this.companySpecificationssCompanyId=companySpecificationssCompanyId;
    }

    public List<CompanySpecificationsKey> getCompanySpecificationssCompanyId() {
        return companySpecificationssCompanyId;
    }

    public void setConsultTaticssCompanyId(List consultTaticssCompanyId) {
        this.consultTaticssCompanyId=consultTaticssCompanyId;
    }

    public List<ConsultTatics> getConsultTaticssCompanyId() {
        return consultTaticssCompanyId;
    }

    public void setConsultUserssEnterpriseId(List consultUserssEnterpriseId) {
        this.consultUserssEnterpriseId=consultUserssEnterpriseId;
    }

    public List<ConsultUsersKey> getConsultUserssEnterpriseId() {
        return consultUserssEnterpriseId;
    }

    public void setDepartmentssCompanyId(List departmentssCompanyId) {
        this.departmentssCompanyId=departmentssCompanyId;
    }

    public List<Departments> getDepartmentssCompanyId() {
        return departmentssCompanyId;
    }

    public void setDigitalSignatureRecordssCompanyId(List digitalSignatureRecordssCompanyId) {
        this.digitalSignatureRecordssCompanyId=digitalSignatureRecordssCompanyId;
    }

    public List<DigitalSignatureRecords> getDigitalSignatureRecordssCompanyId() {
        return digitalSignatureRecordssCompanyId;
    }

    public void setEntrPurchPlanCountsCompanyId(List entrPurchPlanCountsCompanyId) {
        this.entrPurchPlanCountsCompanyId=entrPurchPlanCountsCompanyId;
    }

    public List<EntrPurchPlanCount> getEntrPurchPlanCountsCompanyId() {
        return entrPurchPlanCountsCompanyId;
    }

    public void setExcelInRessCompanyId(List excelInRessCompanyId) {
        this.excelInRessCompanyId=excelInRessCompanyId;
    }

    public List<ExcelInRes> getExcelInRessCompanyId() {
        return excelInRessCompanyId;
    }

    public void setFinancingCreditssCompanyId(List financingCreditssCompanyId) {
        this.financingCreditssCompanyId=financingCreditssCompanyId;
    }

    public List<FinancingCredits> getFinancingCreditssCompanyId() {
        return financingCreditssCompanyId;
    }

    public void setFundsFlowDetailssReceivecomId(List fundsFlowDetailssReceivecomId) {
        this.fundsFlowDetailssReceivecomId=fundsFlowDetailssReceivecomId;
    }

    public List<FundsFlowDetails> getFundsFlowDetailssReceivecomId() {
        return fundsFlowDetailssReceivecomId;
    }

    public void setFundsFlowDetailssPaycomId(List fundsFlowDetailssPaycomId) {
        this.fundsFlowDetailssPaycomId=fundsFlowDetailssPaycomId;
    }

    public List<FundsFlowDetails> getFundsFlowDetailssPaycomId() {
        return fundsFlowDetailssPaycomId;
    }

    public void setFundsLockJournalssPayComId(List fundsLockJournalssPayComId) {
        this.fundsLockJournalssPayComId=fundsLockJournalssPayComId;
    }

    public List<FundsLockJournalsKey> getFundsLockJournalssPayComId() {
        return fundsLockJournalssPayComId;
    }

    public void setFundsLockJournalssRecComId(List fundsLockJournalssRecComId) {
        this.fundsLockJournalssRecComId=fundsLockJournalssRecComId;
    }

    public List<FundsLockJournalsKey> getFundsLockJournalssRecComId() {
        return fundsLockJournalssRecComId;
    }

    public void setGivenPricessCompanyId(List givenPricessCompanyId) {
        this.givenPricessCompanyId=givenPricessCompanyId;
    }

    public List<GivenPricesKey> getGivenPricessCompanyId() {
        return givenPricessCompanyId;
    }

    public void setInventoryResourceDetailssTradingCompanyId(List inventoryResourceDetailssTradingCompanyId) {
        this.inventoryResourceDetailssTradingCompanyId=inventoryResourceDetailssTradingCompanyId;
    }

    public List<InventoryResourceDetails> getInventoryResourceDetailssTradingCompanyId() {
        return inventoryResourceDetailssTradingCompanyId;
    }

    public void setInventoryResourceDetailssCargoCompanyId(List inventoryResourceDetailssCargoCompanyId) {
        this.inventoryResourceDetailssCargoCompanyId=inventoryResourceDetailssCargoCompanyId;
    }

    public List<InventoryResourceDetails> getInventoryResourceDetailssCargoCompanyId() {
        return inventoryResourceDetailssCargoCompanyId;
    }

    public void setInventoryValuationssResourceCompanyId(List inventoryValuationssResourceCompanyId) {
        this.inventoryValuationssResourceCompanyId=inventoryValuationssResourceCompanyId;
    }

    public List<InventoryValuations> getInventoryValuationssResourceCompanyId() {
        return inventoryValuationssResourceCompanyId;
    }

    public void setInvoicessWriteCompanyId(List invoicessWriteCompanyId) {
        this.invoicessWriteCompanyId=invoicessWriteCompanyId;
    }

    public List<Invoices> getInvoicessWriteCompanyId() {
        return invoicessWriteCompanyId;
    }

    public void setLogisticsBranchsCompanyId(List logisticsBranchsCompanyId) {
        this.logisticsBranchsCompanyId=logisticsBranchsCompanyId;
    }

    public List<LogisticsBranch> getLogisticsBranchsCompanyId() {
        return logisticsBranchsCompanyId;
    }

    public void setLogisticsJobTemplatesCompanyId(List logisticsJobTemplatesCompanyId) {
        this.logisticsJobTemplatesCompanyId=logisticsJobTemplatesCompanyId;
    }

    public List<LogisticsJobTemplate> getLogisticsJobTemplatesCompanyId() {
        return logisticsJobTemplatesCompanyId;
    }

    public void setLogisticsMembersMemberCompanyId(List logisticsMembersMemberCompanyId) {
        this.logisticsMembersMemberCompanyId=logisticsMembersMemberCompanyId;
    }

    public List<LogisticsMemberKey> getLogisticsMembersMemberCompanyId() {
        return logisticsMembersMemberCompanyId;
    }

    public void setLogisticsOrderssEntrustCompanyId(List logisticsOrderssEntrustCompanyId) {
        this.logisticsOrderssEntrustCompanyId=logisticsOrderssEntrustCompanyId;
    }

    public List<LogisticsOrders> getLogisticsOrderssEntrustCompanyId() {
        return logisticsOrderssEntrustCompanyId;
    }

    public void setLogisticsOrderssCarrierCompanyId(List logisticsOrderssCarrierCompanyId) {
        this.logisticsOrderssCarrierCompanyId=logisticsOrderssCarrierCompanyId;
    }

    public List<LogisticsOrders> getLogisticsOrderssCarrierCompanyId() {
        return logisticsOrderssCarrierCompanyId;
    }

    public void setLogisticsSolutionssCarsCompanyId(List logisticsSolutionssCarsCompanyId) {
        this.logisticsSolutionssCarsCompanyId=logisticsSolutionssCarsCompanyId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssCarsCompanyId() {
        return logisticsSolutionssCarsCompanyId;
    }

    public void setMallMemberssSettleComId(List mallMemberssSettleComId) {
        this.mallMemberssSettleComId=mallMemberssSettleComId;
    }

    public List<MallMembersKey> getMallMemberssSettleComId() {
        return mallMemberssSettleComId;
    }

    public void setMallMemberssMallMemberId(List mallMemberssMallMemberId) {
        this.mallMemberssMallMemberId=mallMemberssMallMemberId;
    }

    public List<MallMembersKey> getMallMemberssMallMemberId() {
        return mallMemberssMallMemberId;
    }

    public void setMemberlvSettlesCompanyId(List memberlvSettlesCompanyId) {
        this.memberlvSettlesCompanyId=memberlvSettlesCompanyId;
    }

    public List<MemberlvSettle> getMemberlvSettlesCompanyId() {
        return memberlvSettlesCompanyId;
    }

    public void setMemberPricessCompanyId(List memberPricessCompanyId) {
        this.memberPricessCompanyId=memberPricessCompanyId;
    }

    public List<MemberPrices> getMemberPricessCompanyId() {
        return memberPricessCompanyId;
    }

    public void setOrderssBuyComId(List orderssBuyComId) {
        this.orderssBuyComId=orderssBuyComId;
    }

    public List<Orders> getOrderssBuyComId() {
        return orderssBuyComId;
    }

    public void setOrderssSettleComId(List orderssSettleComId) {
        this.orderssSettleComId=orderssSettleComId;
    }

    public List<Orders> getOrderssSettleComId() {
        return orderssSettleComId;
    }

    public void setPhysicalValuationsStaticssCargoCompanyId(List physicalValuationsStaticssCargoCompanyId) {
        this.physicalValuationsStaticssCargoCompanyId=physicalValuationsStaticssCargoCompanyId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssCargoCompanyId() {
        return physicalValuationsStaticssCargoCompanyId;
    }

    public void setPhysicalValuationsStaticssTradingCompanyId(List physicalValuationsStaticssTradingCompanyId) {
        this.physicalValuationsStaticssTradingCompanyId=physicalValuationsStaticssTradingCompanyId;
    }

    public List<PhysicalValuationsStatics> getPhysicalValuationsStaticssTradingCompanyId() {
        return physicalValuationsStaticssTradingCompanyId;
    }

    public void setPositionssCompanyId(List positionssCompanyId) {
        this.positionssCompanyId=positionssCompanyId;
    }

    public List<Positions> getPositionssCompanyId() {
        return positionssCompanyId;
    }

    public void setProcessMaterialsCompanyId(List processMaterialsCompanyId) {
        this.processMaterialsCompanyId=processMaterialsCompanyId;
    }

    public List<ProcessMaterial> getProcessMaterialsCompanyId() {
        return processMaterialsCompanyId;
    }

    public void setProductivityssCompanyId(List productivityssCompanyId) {
        this.productivityssCompanyId=productivityssCompanyId;
    }

    public List<Productivitys> getProductivityssCompanyId() {
        return productivityssCompanyId;
    }

    public void setQualityBookssCompanyId(List qualityBookssCompanyId) {
        this.qualityBookssCompanyId=qualityBookssCompanyId;
    }

    public List<QualityBooks> getQualityBookssCompanyId() {
        return qualityBookssCompanyId;
    }

    public void setResodOwnUpHistoryssOriginalOwnerId(List resodOwnUpHistoryssOriginalOwnerId) {
        this.resodOwnUpHistoryssOriginalOwnerId=resodOwnUpHistoryssOriginalOwnerId;
    }

    public List<ResodOwnUpHistorys> getResodOwnUpHistoryssOriginalOwnerId() {
        return resodOwnUpHistoryssOriginalOwnerId;
    }

    public void setResodOwnUpHistoryssOwnerId(List resodOwnUpHistoryssOwnerId) {
        this.resodOwnUpHistoryssOwnerId=resodOwnUpHistoryssOwnerId;
    }

    public List<ResodOwnUpHistorys> getResodOwnUpHistoryssOwnerId() {
        return resodOwnUpHistoryssOwnerId;
    }

    public void setResourceDetailssTradingCompanyId(List resourceDetailssTradingCompanyId) {
        this.resourceDetailssTradingCompanyId=resourceDetailssTradingCompanyId;
    }

    public List<ResourceDetails> getResourceDetailssTradingCompanyId() {
        return resourceDetailssTradingCompanyId;
    }

    public void setResourceDetailssCargoCompanyId(List resourceDetailssCargoCompanyId) {
        this.resourceDetailssCargoCompanyId=resourceDetailssCargoCompanyId;
    }

    public List<ResourceDetails> getResourceDetailssCargoCompanyId() {
        return resourceDetailssCargoCompanyId;
    }

    public void setResourceSummariessCompanyId(List resourceSummariessCompanyId) {
        this.resourceSummariessCompanyId=resourceSummariessCompanyId;
    }

    public List<ResourceSummaries> getResourceSummariessCompanyId() {
        return resourceSummariessCompanyId;
    }

    public void setScoreJournalssComId(List scoreJournalssComId) {
        this.scoreJournalssComId=scoreJournalssComId;
    }

    public List<ScoreJournals> getScoreJournalssComId() {
        return scoreJournalssComId;
    }

    public void setSellerssSettlementmain(List sellerssSettlementmain) {
        this.sellerssSettlementmain=sellerssSettlementmain;
    }

    public List<Sellers> getSellerssSettlementmain() {
        return sellerssSettlementmain;
    }

    public void setSellerssCompanyId(List sellerssCompanyId) {
        this.sellerssCompanyId=sellerssCompanyId;
    }

    public List<Sellers> getSellerssCompanyId() {
        return sellerssCompanyId;
    }

    public void setStoressOwnerId(List storessOwnerId) {
        this.storessOwnerId=storessOwnerId;
    }

    public List<Stores> getStoressOwnerId() {
        return storessOwnerId;
    }

    public void setStoressOperatorId(List storessOperatorId) {
        this.storessOperatorId=storessOperatorId;
    }

    public List<Stores> getStoressOperatorId() {
        return storessOperatorId;
    }

    public void setStoressRegulatoryId(List storessRegulatoryId) {
        this.storessRegulatoryId=storessRegulatoryId;
    }

    public List<Stores> getStoressRegulatoryId() {
        return storessRegulatoryId;
    }

    public void setStoreCompanyssCompanyId(List storeCompanyssCompanyId) {
        this.storeCompanyssCompanyId=storeCompanyssCompanyId;
    }

    public List<StoreCompanysKey> getStoreCompanyssCompanyId() {
        return storeCompanyssCompanyId;
    }

    public void setStoreJobssStoreCompanyId(List storeJobssStoreCompanyId) {
        this.storeJobssStoreCompanyId=storeJobssStoreCompanyId;
    }

    public List<StoreJobs> getStoreJobssStoreCompanyId() {
        return storeJobssStoreCompanyId;
    }

    public void setStoreJobssExtractCompanyId(List storeJobssExtractCompanyId) {
        this.storeJobssExtractCompanyId=storeJobssExtractCompanyId;
    }

    public List<StoreJobs> getStoreJobssExtractCompanyId() {
        return storeJobssExtractCompanyId;
    }

    public void setStoreJobDetailssCargoCompanyId(List storeJobDetailssCargoCompanyId) {
        this.storeJobDetailssCargoCompanyId=storeJobDetailssCargoCompanyId;
    }

    public List<StoreJobDetails> getStoreJobDetailssCargoCompanyId() {
        return storeJobDetailssCargoCompanyId;
    }

    public void setStoreJobDetailssTradingCompanyId(List storeJobDetailssTradingCompanyId) {
        this.storeJobDetailssTradingCompanyId=storeJobDetailssTradingCompanyId;
    }

    public List<StoreJobDetails> getStoreJobDetailssTradingCompanyId() {
        return storeJobDetailssTradingCompanyId;
    }

    public void setTraderResourcessSettleComId(List traderResourcessSettleComId) {
        this.traderResourcessSettleComId=traderResourcessSettleComId;
    }

    public List<TraderResources> getTraderResourcessSettleComId() {
        return traderResourcessSettleComId;
    }

    public void setTraderResourcessCompanyId(List traderResourcessCompanyId) {
        this.traderResourcessCompanyId=traderResourcessCompanyId;
    }

    public List<TraderResources> getTraderResourcessCompanyId() {
        return traderResourcessCompanyId;
    }

    public void setTrustPurchasesUpComId(List trustPurchasesUpComId) {
        this.trustPurchasesUpComId=trustPurchasesUpComId;
    }

    public List<TrustPurchase> getTrustPurchasesUpComId() {
        return trustPurchasesUpComId;
    }

    public void setTrustPurchasesPrincipalComId(List trustPurchasesPrincipalComId) {
        this.trustPurchasesPrincipalComId=trustPurchasesPrincipalComId;
    }

    public List<TrustPurchase> getTrustPurchasesPrincipalComId() {
        return trustPurchasesPrincipalComId;
    }

    public void setTrustPurchasesTrusteeComId(List trustPurchasesTrusteeComId) {
        this.trustPurchasesTrusteeComId=trustPurchasesTrusteeComId;
    }

    public List<TrustPurchase> getTrustPurchasesTrusteeComId() {
        return trustPurchasesTrusteeComId;
    }

    public void setUserssCompanyId(List userssCompanyId) {
        this.userssCompanyId=userssCompanyId;
    }

    public List<Users> getUserssCompanyId() {
        return userssCompanyId;
    }

    public void setVehiclessVehicleOwnerId(List vehiclessVehicleOwnerId) {
        this.vehiclessVehicleOwnerId=vehiclessVehicleOwnerId;
    }

    public List<Vehicles> getVehiclessVehicleOwnerId() {
        return vehiclessVehicleOwnerId;
    }

    public void setVehiclessManageCompanyId(List vehiclessManageCompanyId) {
        this.vehiclessManageCompanyId=vehiclessManageCompanyId;
    }

    public List<Vehicles> getVehiclessManageCompanyId() {
        return vehiclessManageCompanyId;
    }

    public void setVehiclessCarrierId(List vehiclessCarrierId) {
        this.vehiclessCarrierId=vehiclessCarrierId;
    }

    public List<Vehicles> getVehiclessCarrierId() {
        return vehiclessCarrierId;
    }

    public void setFileInfosOrganizationCodeFileId(FileInfos fileInfosOrganizationCodeFileId) {
        this.fileInfosOrganizationCodeFileId=fileInfosOrganizationCodeFileId;
    }

    public FileInfos getFileInfosOrganizationCodeFileId() {
        return fileInfosOrganizationCodeFileId;
    }

    public void setFileInfosTaxCertificateFileId(FileInfos fileInfosTaxCertificateFileId) {
        this.fileInfosTaxCertificateFileId=fileInfosTaxCertificateFileId;
    }

    public FileInfos getFileInfosTaxCertificateFileId() {
        return fileInfosTaxCertificateFileId;
    }

    public void setFileInfosBusinessLicenseFileId(FileInfos fileInfosBusinessLicenseFileId) {
        this.fileInfosBusinessLicenseFileId=fileInfosBusinessLicenseFileId;
    }

    public FileInfos getFileInfosBusinessLicenseFileId() {
        return fileInfosBusinessLicenseFileId;
    }

    public void setLogisticsAddressRegisterAddressId(LogisticsAddress logisticsAddressRegisterAddressId) {
        this.logisticsAddressRegisterAddressId=logisticsAddressRegisterAddressId;
    }

    public LogisticsAddress getLogisticsAddressRegisterAddressId() {
        return logisticsAddressRegisterAddressId;
    }

    public void setLogisticsAddressMailingAddressId(LogisticsAddress logisticsAddressMailingAddressId) {
        this.logisticsAddressMailingAddressId=logisticsAddressMailingAddressId;
    }

    public LogisticsAddress getLogisticsAddressMailingAddressId() {
        return logisticsAddressMailingAddressId;
    }
}