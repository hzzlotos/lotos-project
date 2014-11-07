package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long driverUserId;

    private Long userId;

    private Long fileId;

    private String driverLicenceNo;

    private Date driverLicenceGettime;

    private Date beginEffectiveDate;

    private Date endEffectiveDate;

    private Long driverLicenceTypeId;

    private List<RealtimeTransCapacityKey> realtimeTransCapacitysDriverUserId = null;

    private DriverLicenceType driverLicenceTypeDriverLicenceTypeId;

    private FileInfos fileInfosFileId;

    private Users usersDriverUserId;

    private Users usersUserId;

    public Long getDriverUserId() {
        return driverUserId;
    }

    public void setDriverUserId(Long driverUserId) {
        this.driverUserId = driverUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getDriverLicenceGettime() {
        return driverLicenceGettime;
    }

    public void setDriverLicenceGettime(Date driverLicenceGettime) {
        this.driverLicenceGettime = driverLicenceGettime;
    }

    public Date getBeginEffectiveDate() {
        return beginEffectiveDate;
    }

    public void setBeginEffectiveDate(Date beginEffectiveDate) {
        this.beginEffectiveDate = beginEffectiveDate;
    }

    public Date getEndEffectiveDate() {
        return endEffectiveDate;
    }

    public void setEndEffectiveDate(Date endEffectiveDate) {
        this.endEffectiveDate = endEffectiveDate;
    }

    public Long getDriverLicenceTypeId() {
        return driverLicenceTypeId;
    }

    public void setDriverLicenceTypeId(Long driverLicenceTypeId) {
        this.driverLicenceTypeId = driverLicenceTypeId;
    }

    public void setRealtimeTransCapacitysDriverUserId(List realtimeTransCapacitysDriverUserId) {
        this.realtimeTransCapacitysDriverUserId=realtimeTransCapacitysDriverUserId;
    }

    public List<RealtimeTransCapacityKey> getRealtimeTransCapacitysDriverUserId() {
        return realtimeTransCapacitysDriverUserId;
    }

    public void setDriverLicenceTypeDriverLicenceTypeId(DriverLicenceType driverLicenceTypeDriverLicenceTypeId) {
        this.driverLicenceTypeDriverLicenceTypeId=driverLicenceTypeDriverLicenceTypeId;
    }

    public DriverLicenceType getDriverLicenceTypeDriverLicenceTypeId() {
        return driverLicenceTypeDriverLicenceTypeId;
    }

    public void setFileInfosFileId(FileInfos fileInfosFileId) {
        this.fileInfosFileId=fileInfosFileId;
    }

    public FileInfos getFileInfosFileId() {
        return fileInfosFileId;
    }

    public void setUsersDriverUserId(Users usersDriverUserId) {
        this.usersDriverUserId=usersDriverUserId;
    }

    public Users getUsersDriverUserId() {
        return usersDriverUserId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}