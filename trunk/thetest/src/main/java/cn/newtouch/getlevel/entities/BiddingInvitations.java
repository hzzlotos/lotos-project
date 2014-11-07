package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class BiddingInvitations implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long enterpriseId;

    private String explanation;

    private Companys companysEnterpriseId;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setCompanysEnterpriseId(Companys companysEnterpriseId) {
        this.companysEnterpriseId=companysEnterpriseId;
    }

    public Companys getCompanysEnterpriseId() {
        return companysEnterpriseId;
    }
}