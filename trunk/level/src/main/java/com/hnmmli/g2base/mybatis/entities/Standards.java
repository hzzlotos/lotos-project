package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Standards implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String status;

    private List<QualityBookDetails> qualityBookDetailssImplStanderdId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQualityBookDetailssImplStanderdId(List qualityBookDetailssImplStanderdId) {
        this.qualityBookDetailssImplStanderdId=qualityBookDetailssImplStanderdId;
    }

    public List<QualityBookDetails> getQualityBookDetailssImplStanderdId() {
        return qualityBookDetailssImplStanderdId;
    }
}