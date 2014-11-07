package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class ResodOwnUpHistorys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resourceDetailId;

    private Date updateDate;

    private Long originalOwnerId;

    private Long ownerId;

    private String type;

    private Long storeJobId;

    private Date createDate;

    private Companys companysOriginalOwnerId;

    private Companys companysOwnerId;

    private ResourceDetails resourceDetailsResourceDetailId;

    private StoreJobs storeJobsStoreJobId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResourceDetailId() {
        return resourceDetailId;
    }

    public void setResourceDetailId(Long resourceDetailId) {
        this.resourceDetailId = resourceDetailId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getOriginalOwnerId() {
        return originalOwnerId;
    }

    public void setOriginalOwnerId(Long originalOwnerId) {
        this.originalOwnerId = originalOwnerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStoreJobId() {
        return storeJobId;
    }

    public void setStoreJobId(Long storeJobId) {
        this.storeJobId = storeJobId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCompanysOriginalOwnerId(Companys companysOriginalOwnerId) {
        this.companysOriginalOwnerId=companysOriginalOwnerId;
    }

    public Companys getCompanysOriginalOwnerId() {
        return companysOriginalOwnerId;
    }

    public void setCompanysOwnerId(Companys companysOwnerId) {
        this.companysOwnerId=companysOwnerId;
    }

    public Companys getCompanysOwnerId() {
        return companysOwnerId;
    }

    public void setResourceDetailsResourceDetailId(ResourceDetails resourceDetailsResourceDetailId) {
        this.resourceDetailsResourceDetailId=resourceDetailsResourceDetailId;
    }

    public ResourceDetails getResourceDetailsResourceDetailId() {
        return resourceDetailsResourceDetailId;
    }

    public void setStoreJobsStoreJobId(StoreJobs storeJobsStoreJobId) {
        this.storeJobsStoreJobId=storeJobsStoreJobId;
    }

    public StoreJobs getStoreJobsStoreJobId() {
        return storeJobsStoreJobId;
    }
}