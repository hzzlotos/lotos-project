package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class PhysicalDifferentDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long physicalStaticId;

    private String isExist;

    private PhysicalValuationsStatics physicalValuationsStaticsPhysicalStaticId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhysicalStaticId() {
        return physicalStaticId;
    }

    public void setPhysicalStaticId(Long physicalStaticId) {
        this.physicalStaticId = physicalStaticId;
    }

    public String getIsExist() {
        return isExist;
    }

    public void setIsExist(String isExist) {
        this.isExist = isExist;
    }

    public void setPhysicalValuationsStaticsPhysicalStaticId(PhysicalValuationsStatics physicalValuationsStaticsPhysicalStaticId) {
        this.physicalValuationsStaticsPhysicalStaticId=physicalValuationsStaticsPhysicalStaticId;
    }

    public PhysicalValuationsStatics getPhysicalValuationsStaticsPhysicalStaticId() {
        return physicalValuationsStaticsPhysicalStaticId;
    }
}