package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Lable implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private String type;

    private List<MallLableKey> mallLablesLableId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMallLablesLableId(List mallLablesLableId) {
        this.mallLablesLableId=mallLablesLableId;
    }

    public List<MallLableKey> getMallLablesLableId() {
        return mallLablesLableId;
    }
}