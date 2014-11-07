package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class Vehicles implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long vehicleOwnerId;

    private BigDecimal checkRatifyWeight;

    private BigDecimal checkRatifySpace;

    private Long manageCompanyId;

    private String vehicleCode;

    private String vehicleType;

    private String ratedSeat;

    private String ratedTeu;

    private String arkingSpace;

    private String shiplengThid;

    private String shipTypeWide;

    private String shipTypeDeep;

    private String shipDraft;

    private Long truckLengthId;

    private Long navigationAreaId;

    private Long vehicleId;

    private Long carrierId;

    private Long fileId;

    private String driverLicenceNo;

    private Date driverLicenceRegDate;

    private Date drvLiceBeginEffDate;

    private Date drvLiceEndEffDate;

    private Long registerUserId;

    private Long contactId;

    private List<LocateRecord> locateRecordsVehiclesId = null;

    private List<LogisticsSolutionVehiclesKey> logisticsSolutionVehiclessVehicleId = null;

    private List<RealtimeTransCapacityKey> realtimeTransCapacitysVehicleId = null;

    private List<RouteReceipts> routeReceiptssVehicleId = null;

    private List<VehicleShipTypeKey> vehicleShipTypesVehicleId = null;

    private List<VehicleTruckTypeKey> vehicleTruckTypesVehicleId = null;

    private Companys companysVehicleOwnerId;

    private Companys companysManageCompanyId;

    private Companys companysCarrierId;

    private FileInfos fileInfosFileId;

    private LocateDevice locateDeviceVehicleId;

    private NavigationArea navigationAreaNavigationAreaId;

    private TruckLength truckLengthTruckLengthId;

    private Users usersRegisterUserId;

    private Users usersContactId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(Long vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public BigDecimal getCheckRatifyWeight() {
        return checkRatifyWeight;
    }

    public void setCheckRatifyWeight(BigDecimal checkRatifyWeight) {
        this.checkRatifyWeight = checkRatifyWeight;
    }

    public BigDecimal getCheckRatifySpace() {
        return checkRatifySpace;
    }

    public void setCheckRatifySpace(BigDecimal checkRatifySpace) {
        this.checkRatifySpace = checkRatifySpace;
    }

    public Long getManageCompanyId() {
        return manageCompanyId;
    }

    public void setManageCompanyId(Long manageCompanyId) {
        this.manageCompanyId = manageCompanyId;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRatedSeat() {
        return ratedSeat;
    }

    public void setRatedSeat(String ratedSeat) {
        this.ratedSeat = ratedSeat;
    }

    public String getRatedTeu() {
        return ratedTeu;
    }

    public void setRatedTeu(String ratedTeu) {
        this.ratedTeu = ratedTeu;
    }

    public String getArkingSpace() {
        return arkingSpace;
    }

    public void setArkingSpace(String arkingSpace) {
        this.arkingSpace = arkingSpace;
    }

    public String getShiplengThid() {
        return shiplengThid;
    }

    public void setShiplengThid(String shiplengThid) {
        this.shiplengThid = shiplengThid;
    }

    public String getShipTypeWide() {
        return shipTypeWide;
    }

    public void setShipTypeWide(String shipTypeWide) {
        this.shipTypeWide = shipTypeWide;
    }

    public String getShipTypeDeep() {
        return shipTypeDeep;
    }

    public void setShipTypeDeep(String shipTypeDeep) {
        this.shipTypeDeep = shipTypeDeep;
    }

    public String getShipDraft() {
        return shipDraft;
    }

    public void setShipDraft(String shipDraft) {
        this.shipDraft = shipDraft;
    }

    public Long getTruckLengthId() {
        return truckLengthId;
    }

    public void setTruckLengthId(Long truckLengthId) {
        this.truckLengthId = truckLengthId;
    }

    public Long getNavigationAreaId() {
        return navigationAreaId;
    }

    public void setNavigationAreaId(Long navigationAreaId) {
        this.navigationAreaId = navigationAreaId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getDriverLicenceNo() {
        return driverLicenceNo;
    }

    public void setDriverLicenceNo(String driverLicenceNo) {
        this.driverLicenceNo = driverLicenceNo;
    }

    public Date getDriverLicenceRegDate() {
        return driverLicenceRegDate;
    }

    public void setDriverLicenceRegDate(Date driverLicenceRegDate) {
        this.driverLicenceRegDate = driverLicenceRegDate;
    }

    public Date getDrvLiceBeginEffDate() {
        return drvLiceBeginEffDate;
    }

    public void setDrvLiceBeginEffDate(Date drvLiceBeginEffDate) {
        this.drvLiceBeginEffDate = drvLiceBeginEffDate;
    }

    public Date getDrvLiceEndEffDate() {
        return drvLiceEndEffDate;
    }

    public void setDrvLiceEndEffDate(Date drvLiceEndEffDate) {
        this.drvLiceEndEffDate = drvLiceEndEffDate;
    }

    public Long getRegisterUserId() {
        return registerUserId;
    }

    public void setRegisterUserId(Long registerUserId) {
        this.registerUserId = registerUserId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setLocateRecordsVehiclesId(List locateRecordsVehiclesId) {
        this.locateRecordsVehiclesId=locateRecordsVehiclesId;
    }

    public List<LocateRecord> getLocateRecordsVehiclesId() {
        return locateRecordsVehiclesId;
    }

    public void setLogisticsSolutionVehiclessVehicleId(List logisticsSolutionVehiclessVehicleId) {
        this.logisticsSolutionVehiclessVehicleId=logisticsSolutionVehiclessVehicleId;
    }

    public List<LogisticsSolutionVehiclesKey> getLogisticsSolutionVehiclessVehicleId() {
        return logisticsSolutionVehiclessVehicleId;
    }

    public void setRealtimeTransCapacitysVehicleId(List realtimeTransCapacitysVehicleId) {
        this.realtimeTransCapacitysVehicleId=realtimeTransCapacitysVehicleId;
    }

    public List<RealtimeTransCapacityKey> getRealtimeTransCapacitysVehicleId() {
        return realtimeTransCapacitysVehicleId;
    }

    public void setRouteReceiptssVehicleId(List routeReceiptssVehicleId) {
        this.routeReceiptssVehicleId=routeReceiptssVehicleId;
    }

    public List<RouteReceipts> getRouteReceiptssVehicleId() {
        return routeReceiptssVehicleId;
    }

    public void setVehicleShipTypesVehicleId(List vehicleShipTypesVehicleId) {
        this.vehicleShipTypesVehicleId=vehicleShipTypesVehicleId;
    }

    public List<VehicleShipTypeKey> getVehicleShipTypesVehicleId() {
        return vehicleShipTypesVehicleId;
    }

    public void setVehicleTruckTypesVehicleId(List vehicleTruckTypesVehicleId) {
        this.vehicleTruckTypesVehicleId=vehicleTruckTypesVehicleId;
    }

    public List<VehicleTruckTypeKey> getVehicleTruckTypesVehicleId() {
        return vehicleTruckTypesVehicleId;
    }

    public void setCompanysVehicleOwnerId(Companys companysVehicleOwnerId) {
        this.companysVehicleOwnerId=companysVehicleOwnerId;
    }

    public Companys getCompanysVehicleOwnerId() {
        return companysVehicleOwnerId;
    }

    public void setCompanysManageCompanyId(Companys companysManageCompanyId) {
        this.companysManageCompanyId=companysManageCompanyId;
    }

    public Companys getCompanysManageCompanyId() {
        return companysManageCompanyId;
    }

    public void setCompanysCarrierId(Companys companysCarrierId) {
        this.companysCarrierId=companysCarrierId;
    }

    public Companys getCompanysCarrierId() {
        return companysCarrierId;
    }

    public void setFileInfosFileId(FileInfos fileInfosFileId) {
        this.fileInfosFileId=fileInfosFileId;
    }

    public FileInfos getFileInfosFileId() {
        return fileInfosFileId;
    }

    public void setLocateDeviceVehicleId(LocateDevice locateDeviceVehicleId) {
        this.locateDeviceVehicleId=locateDeviceVehicleId;
    }

    public LocateDevice getLocateDeviceVehicleId() {
        return locateDeviceVehicleId;
    }

    public void setNavigationAreaNavigationAreaId(NavigationArea navigationAreaNavigationAreaId) {
        this.navigationAreaNavigationAreaId=navigationAreaNavigationAreaId;
    }

    public NavigationArea getNavigationAreaNavigationAreaId() {
        return navigationAreaNavigationAreaId;
    }

    public void setTruckLengthTruckLengthId(TruckLength truckLengthTruckLengthId) {
        this.truckLengthTruckLengthId=truckLengthTruckLengthId;
    }

    public TruckLength getTruckLengthTruckLengthId() {
        return truckLengthTruckLengthId;
    }

    public void setUsersRegisterUserId(Users usersRegisterUserId) {
        this.usersRegisterUserId=usersRegisterUserId;
    }

    public Users getUsersRegisterUserId() {
        return usersRegisterUserId;
    }

    public void setUsersContactId(Users usersContactId) {
        this.usersContactId=usersContactId;
    }

    public Users getUsersContactId() {
        return usersContactId;
    }
}