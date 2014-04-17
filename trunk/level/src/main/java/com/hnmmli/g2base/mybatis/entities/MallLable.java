package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class MallLable extends MallLableKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long clicks;

    private Lable lableLableId;

    private Malls mallsMallId;

    public Long getClicks() {
        return clicks;
    }

    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public void setLableLableId(Lable lableLableId) {
        this.lableLableId=lableLableId;
    }

    public Lable getLableLableId() {
        return lableLableId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}