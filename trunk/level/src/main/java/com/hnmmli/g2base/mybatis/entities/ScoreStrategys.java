package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScoreStrategys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal earnedScore;

    private BigDecimal areaUpperLimit;

    private BigDecimal areaLowerLimit;

    private Long mallId;

    private Long uomId;

    private Long resourcetypeId;

    private IntegralActivities integralActivitiesMallId;

    private ResourceTypes resourceTypesResourcetypeId;

    private Uoms uomsUomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEarnedScore() {
        return earnedScore;
    }

    public void setEarnedScore(BigDecimal earnedScore) {
        this.earnedScore = earnedScore;
    }

    public BigDecimal getAreaUpperLimit() {
        return areaUpperLimit;
    }

    public void setAreaUpperLimit(BigDecimal areaUpperLimit) {
        this.areaUpperLimit = areaUpperLimit;
    }

    public BigDecimal getAreaLowerLimit() {
        return areaLowerLimit;
    }

    public void setAreaLowerLimit(BigDecimal areaLowerLimit) {
        this.areaLowerLimit = areaLowerLimit;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Long getResourcetypeId() {
        return resourcetypeId;
    }

    public void setResourcetypeId(Long resourcetypeId) {
        this.resourcetypeId = resourcetypeId;
    }

    public void setIntegralActivitiesMallId(IntegralActivities integralActivitiesMallId) {
        this.integralActivitiesMallId=integralActivitiesMallId;
    }

    public IntegralActivities getIntegralActivitiesMallId() {
        return integralActivitiesMallId;
    }

    public void setResourceTypesResourcetypeId(ResourceTypes resourceTypesResourcetypeId) {
        this.resourceTypesResourcetypeId=resourceTypesResourcetypeId;
    }

    public ResourceTypes getResourceTypesResourcetypeId() {
        return resourceTypesResourcetypeId;
    }

    public void setUomsUomId(Uoms uomsUomId) {
        this.uomsUomId=uomsUomId;
    }

    public Uoms getUomsUomId() {
        return uomsUomId;
    }
}