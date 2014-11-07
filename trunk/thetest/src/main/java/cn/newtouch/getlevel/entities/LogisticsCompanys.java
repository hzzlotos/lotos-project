package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class LogisticsCompanys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsBranchNum;

    private Long lineNum;

    private Long trasationNum;

    private Long appraiseNum;

    private String forbitDesc;

    private String brandCarrier;

    private List<Appraise> appraisesLogisticsCompanyId = null;

    private List<LogisticsMemberKey> logisticsMembersLogisticsCompanyId = null;

    private List<MallCertCarrierKey> mallCertCarriersLogisticsCompanyId = null;

    private List<StoreCertCarrierKey> storeCertCarriersLogisticsCompanyId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsBranchNum() {
        return logisticsBranchNum;
    }

    public void setLogisticsBranchNum(Long logisticsBranchNum) {
        this.logisticsBranchNum = logisticsBranchNum;
    }

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public Long getTrasationNum() {
        return trasationNum;
    }

    public void setTrasationNum(Long trasationNum) {
        this.trasationNum = trasationNum;
    }

    public Long getAppraiseNum() {
        return appraiseNum;
    }

    public void setAppraiseNum(Long appraiseNum) {
        this.appraiseNum = appraiseNum;
    }

    public String getForbitDesc() {
        return forbitDesc;
    }

    public void setForbitDesc(String forbitDesc) {
        this.forbitDesc = forbitDesc;
    }

    public String getBrandCarrier() {
        return brandCarrier;
    }

    public void setBrandCarrier(String brandCarrier) {
        this.brandCarrier = brandCarrier;
    }

    public void setAppraisesLogisticsCompanyId(List appraisesLogisticsCompanyId) {
        this.appraisesLogisticsCompanyId=appraisesLogisticsCompanyId;
    }

    public List<Appraise> getAppraisesLogisticsCompanyId() {
        return appraisesLogisticsCompanyId;
    }

    public void setLogisticsMembersLogisticsCompanyId(List logisticsMembersLogisticsCompanyId) {
        this.logisticsMembersLogisticsCompanyId=logisticsMembersLogisticsCompanyId;
    }

    public List<LogisticsMemberKey> getLogisticsMembersLogisticsCompanyId() {
        return logisticsMembersLogisticsCompanyId;
    }

    public void setMallCertCarriersLogisticsCompanyId(List mallCertCarriersLogisticsCompanyId) {
        this.mallCertCarriersLogisticsCompanyId=mallCertCarriersLogisticsCompanyId;
    }

    public List<MallCertCarrierKey> getMallCertCarriersLogisticsCompanyId() {
        return mallCertCarriersLogisticsCompanyId;
    }

    public void setStoreCertCarriersLogisticsCompanyId(List storeCertCarriersLogisticsCompanyId) {
        this.storeCertCarriersLogisticsCompanyId=storeCertCarriersLogisticsCompanyId;
    }

    public List<StoreCertCarrierKey> getStoreCertCarriersLogisticsCompanyId() {
        return storeCertCarriersLogisticsCompanyId;
    }
}