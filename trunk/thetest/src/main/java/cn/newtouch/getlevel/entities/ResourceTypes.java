package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class ResourceTypes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long fatherTypeId;

    private String code;

    private String name;

    private Long typeLevel;

    private String status;

    private List<BillingDetailResourceTypesKey> billingDetailResourceTypessResourceTypesId = null;

    private List<CollateralGuidePrices> collateralGuidePricessResourceTypeId = null;

    private List<FinancingCreditDetails> financingCreditDetailssResourceTypeId = null;

    private List<ModelSpecifications> modelSpecificationssResourceTypeId = null;

    private List<Resources> resourcessResourceTypeId = null;

    private List<ResourceTypes> resourceTypessFatherTypeId = null;

    private List<ResourceTypeAttributes> resourceTypeAttributessResourceTypeId = null;

    private List<ScoreStrategys> scoreStrategyssResourcetypeId = null;

    private ResourceTypes resourceTypesFatherTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherTypeId() {
        return fatherTypeId;
    }

    public void setFatherTypeId(Long fatherTypeId) {
        this.fatherTypeId = fatherTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Long typeLevel) {
        this.typeLevel = typeLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBillingDetailResourceTypessResourceTypesId(List billingDetailResourceTypessResourceTypesId) {
        this.billingDetailResourceTypessResourceTypesId=billingDetailResourceTypessResourceTypesId;
    }

    public List<BillingDetailResourceTypesKey> getBillingDetailResourceTypessResourceTypesId() {
        return billingDetailResourceTypessResourceTypesId;
    }

    public void setCollateralGuidePricessResourceTypeId(List collateralGuidePricessResourceTypeId) {
        this.collateralGuidePricessResourceTypeId=collateralGuidePricessResourceTypeId;
    }

    public List<CollateralGuidePrices> getCollateralGuidePricessResourceTypeId() {
        return collateralGuidePricessResourceTypeId;
    }

    public void setFinancingCreditDetailssResourceTypeId(List financingCreditDetailssResourceTypeId) {
        this.financingCreditDetailssResourceTypeId=financingCreditDetailssResourceTypeId;
    }

    public List<FinancingCreditDetails> getFinancingCreditDetailssResourceTypeId() {
        return financingCreditDetailssResourceTypeId;
    }

    public void setModelSpecificationssResourceTypeId(List modelSpecificationssResourceTypeId) {
        this.modelSpecificationssResourceTypeId=modelSpecificationssResourceTypeId;
    }

    public List<ModelSpecifications> getModelSpecificationssResourceTypeId() {
        return modelSpecificationssResourceTypeId;
    }

    public void setResourcessResourceTypeId(List resourcessResourceTypeId) {
        this.resourcessResourceTypeId=resourcessResourceTypeId;
    }

    public List<Resources> getResourcessResourceTypeId() {
        return resourcessResourceTypeId;
    }

    public void setResourceTypessFatherTypeId(List resourceTypessFatherTypeId) {
        this.resourceTypessFatherTypeId=resourceTypessFatherTypeId;
    }

    public List<ResourceTypes> getResourceTypessFatherTypeId() {
        return resourceTypessFatherTypeId;
    }

    public void setResourceTypeAttributessResourceTypeId(List resourceTypeAttributessResourceTypeId) {
        this.resourceTypeAttributessResourceTypeId=resourceTypeAttributessResourceTypeId;
    }

    public List<ResourceTypeAttributes> getResourceTypeAttributessResourceTypeId() {
        return resourceTypeAttributessResourceTypeId;
    }

    public void setScoreStrategyssResourcetypeId(List scoreStrategyssResourcetypeId) {
        this.scoreStrategyssResourcetypeId=scoreStrategyssResourcetypeId;
    }

    public List<ScoreStrategys> getScoreStrategyssResourcetypeId() {
        return scoreStrategyssResourcetypeId;
    }

    public void setResourceTypesFatherTypeId(ResourceTypes resourceTypesFatherTypeId) {
        this.resourceTypesFatherTypeId=resourceTypesFatherTypeId;
    }

    public ResourceTypes getResourceTypesFatherTypeId() {
        return resourceTypesFatherTypeId;
    }
}