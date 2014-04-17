package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class UomChanges extends UomChangesKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal changesFactor;

    private Uoms uomsSmallUomId;

    private Uoms uomsBigUomId;

    public BigDecimal getChangesFactor() {
        return changesFactor;
    }

    public void setChangesFactor(BigDecimal changesFactor) {
        this.changesFactor = changesFactor;
    }

    public void setUomsSmallUomId(Uoms uomsSmallUomId) {
        this.uomsSmallUomId=uomsSmallUomId;
    }

    public Uoms getUomsSmallUomId() {
        return uomsSmallUomId;
    }

    public void setUomsBigUomId(Uoms uomsBigUomId) {
        this.uomsBigUomId=uomsBigUomId;
    }

    public Uoms getUomsBigUomId() {
        return uomsBigUomId;
    }
}