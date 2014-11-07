package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Batchs implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long resDefId;

    private String no;

    private Date importDate;

    private List<BatchChemis> batchChemissBatchId = null;

    private List<BatchPhysics> batchPhysicssBatchId = null;

    private List<QualityBookDetails> qualityBookDetailssBatchId = null;

    private Resources resourcesResDefId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public void setBatchChemissBatchId(List batchChemissBatchId) {
        this.batchChemissBatchId=batchChemissBatchId;
    }

    public List<BatchChemis> getBatchChemissBatchId() {
        return batchChemissBatchId;
    }

    public void setBatchPhysicssBatchId(List batchPhysicssBatchId) {
        this.batchPhysicssBatchId=batchPhysicssBatchId;
    }

    public List<BatchPhysics> getBatchPhysicssBatchId() {
        return batchPhysicssBatchId;
    }

    public void setQualityBookDetailssBatchId(List qualityBookDetailssBatchId) {
        this.qualityBookDetailssBatchId=qualityBookDetailssBatchId;
    }

    public List<QualityBookDetails> getQualityBookDetailssBatchId() {
        return qualityBookDetailssBatchId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }
}