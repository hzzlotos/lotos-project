package com.hnmmli.g2base.mybatis.entities;

public class UserPasswordsKey {
    private String type;

    private Long userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}