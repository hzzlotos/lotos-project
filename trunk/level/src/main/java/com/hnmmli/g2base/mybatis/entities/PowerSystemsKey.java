package com.hnmmli.g2base.mybatis.entities;

public class PowerSystemsKey {
    private Long fatherPowerId;

    private Long powerId;

    public Long getFatherPowerId() {
        return fatherPowerId;
    }

    public void setFatherPowerId(Long fatherPowerId) {
        this.fatherPowerId = fatherPowerId;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }
}