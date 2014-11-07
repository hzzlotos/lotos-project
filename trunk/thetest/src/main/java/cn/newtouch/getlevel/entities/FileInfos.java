package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class FileInfos implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String path;

    private String type;

    private Long fileSize;

    private List<Biddings> biddingssTrustContractId = null;

    private List<BidResponses> bidResponsessValidContractId = null;

    private List<Companys> companyssOrganizationCodeFileId = null;

    private List<Companys> companyssTaxCertificateFileId = null;

    private List<Companys> companyssBusinessLicenseFileId = null;

    private List<Driver> driversFileId = null;

    private List<EletricReceipt> eletricReceiptsFileId = null;

    private List<ExcelInRes> excelInRessFileId = null;

    private List<Menus> menussIcoFileId = null;

    private List<MessageContents> messageContentssFileInfoId = null;

    private List<Resources> resourcessMinPictureId = null;

    private List<Resources> resourcessPictureId = null;

    private List<Resources> resourcessExcelTemplateId = null;

    private List<Users> userssPortraitImageFileId = null;

    private List<Vehicles> vehiclessFileId = null;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public void setBiddingssTrustContractId(List biddingssTrustContractId) {
        this.biddingssTrustContractId=biddingssTrustContractId;
    }

    public List<Biddings> getBiddingssTrustContractId() {
        return biddingssTrustContractId;
    }

    public void setBidResponsessValidContractId(List bidResponsessValidContractId) {
        this.bidResponsessValidContractId=bidResponsessValidContractId;
    }

    public List<BidResponses> getBidResponsessValidContractId() {
        return bidResponsessValidContractId;
    }

    public void setCompanyssOrganizationCodeFileId(List companyssOrganizationCodeFileId) {
        this.companyssOrganizationCodeFileId=companyssOrganizationCodeFileId;
    }

    public List<Companys> getCompanyssOrganizationCodeFileId() {
        return companyssOrganizationCodeFileId;
    }

    public void setCompanyssTaxCertificateFileId(List companyssTaxCertificateFileId) {
        this.companyssTaxCertificateFileId=companyssTaxCertificateFileId;
    }

    public List<Companys> getCompanyssTaxCertificateFileId() {
        return companyssTaxCertificateFileId;
    }

    public void setCompanyssBusinessLicenseFileId(List companyssBusinessLicenseFileId) {
        this.companyssBusinessLicenseFileId=companyssBusinessLicenseFileId;
    }

    public List<Companys> getCompanyssBusinessLicenseFileId() {
        return companyssBusinessLicenseFileId;
    }

    public void setDriversFileId(List driversFileId) {
        this.driversFileId=driversFileId;
    }

    public List<Driver> getDriversFileId() {
        return driversFileId;
    }

    public void setEletricReceiptsFileId(List eletricReceiptsFileId) {
        this.eletricReceiptsFileId=eletricReceiptsFileId;
    }

    public List<EletricReceipt> getEletricReceiptsFileId() {
        return eletricReceiptsFileId;
    }

    public void setExcelInRessFileId(List excelInRessFileId) {
        this.excelInRessFileId=excelInRessFileId;
    }

    public List<ExcelInRes> getExcelInRessFileId() {
        return excelInRessFileId;
    }

    public void setMenussIcoFileId(List menussIcoFileId) {
        this.menussIcoFileId=menussIcoFileId;
    }

    public List<Menus> getMenussIcoFileId() {
        return menussIcoFileId;
    }

    public void setMessageContentssFileInfoId(List messageContentssFileInfoId) {
        this.messageContentssFileInfoId=messageContentssFileInfoId;
    }

    public List<MessageContents> getMessageContentssFileInfoId() {
        return messageContentssFileInfoId;
    }

    public void setResourcessMinPictureId(List resourcessMinPictureId) {
        this.resourcessMinPictureId=resourcessMinPictureId;
    }

    public List<Resources> getResourcessMinPictureId() {
        return resourcessMinPictureId;
    }

    public void setResourcessPictureId(List resourcessPictureId) {
        this.resourcessPictureId=resourcessPictureId;
    }

    public List<Resources> getResourcessPictureId() {
        return resourcessPictureId;
    }

    public void setResourcessExcelTemplateId(List resourcessExcelTemplateId) {
        this.resourcessExcelTemplateId=resourcessExcelTemplateId;
    }

    public List<Resources> getResourcessExcelTemplateId() {
        return resourcessExcelTemplateId;
    }

    public void setUserssPortraitImageFileId(List userssPortraitImageFileId) {
        this.userssPortraitImageFileId=userssPortraitImageFileId;
    }

    public List<Users> getUserssPortraitImageFileId() {
        return userssPortraitImageFileId;
    }

    public void setVehiclessFileId(List vehiclessFileId) {
        this.vehiclessFileId=vehiclessFileId;
    }

    public List<Vehicles> getVehiclessFileId() {
        return vehiclessFileId;
    }
}