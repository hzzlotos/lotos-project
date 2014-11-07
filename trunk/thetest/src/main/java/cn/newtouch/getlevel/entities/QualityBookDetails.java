package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class QualityBookDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long qualityBookId;

    private String productBatch;

    private String ereinorceMark;

    private String certNo;

    private String bak;

    private String reinforcedMark;

    private Long implStanderdId;

    private Long batchId;

    private Long storeJobDetailId;

    private Batchs batchsBatchId;

    private QualityBooks qualityBooksQualityBookId;

    private Standards standardsImplStanderdId;

    private StoreJobDetails storeJobDetailsStoreJobDetailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQualityBookId() {
        return qualityBookId;
    }

    public void setQualityBookId(Long qualityBookId) {
        this.qualityBookId = qualityBookId;
    }

    public String getProductBatch() {
        return productBatch;
    }

    public void setProductBatch(String productBatch) {
        this.productBatch = productBatch;
    }

    public String getEreinorceMark() {
        return ereinorceMark;
    }

    public void setEreinorceMark(String ereinorceMark) {
        this.ereinorceMark = ereinorceMark;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public String getReinforcedMark() {
        return reinforcedMark;
    }

    public void setReinforcedMark(String reinforcedMark) {
        this.reinforcedMark = reinforcedMark;
    }

    public Long getImplStanderdId() {
        return implStanderdId;
    }

    public void setImplStanderdId(Long implStanderdId) {
        this.implStanderdId = implStanderdId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getStoreJobDetailId() {
        return storeJobDetailId;
    }

    public void setStoreJobDetailId(Long storeJobDetailId) {
        this.storeJobDetailId = storeJobDetailId;
    }

    public void setBatchsBatchId(Batchs batchsBatchId) {
        this.batchsBatchId=batchsBatchId;
    }

    public Batchs getBatchsBatchId() {
        return batchsBatchId;
    }

    public void setQualityBooksQualityBookId(QualityBooks qualityBooksQualityBookId) {
        this.qualityBooksQualityBookId=qualityBooksQualityBookId;
    }

    public QualityBooks getQualityBooksQualityBookId() {
        return qualityBooksQualityBookId;
    }

    public void setStandardsImplStanderdId(Standards standardsImplStanderdId) {
        this.standardsImplStanderdId=standardsImplStanderdId;
    }

    public Standards getStandardsImplStanderdId() {
        return standardsImplStanderdId;
    }

    public void setStoreJobDetailsStoreJobDetailId(StoreJobDetails storeJobDetailsStoreJobDetailId) {
        this.storeJobDetailsStoreJobDetailId=storeJobDetailsStoreJobDetailId;
    }

    public StoreJobDetails getStoreJobDetailsStoreJobDetailId() {
        return storeJobDetailsStoreJobDetailId;
    }
}