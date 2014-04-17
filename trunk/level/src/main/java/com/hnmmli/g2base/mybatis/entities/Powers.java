package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Powers implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String url;

    private String status;

    private String powerDesc;

    private String code;

    private List<Menus> menussPowerId = null;

    private List<PowerSystemsKey> powerSystemssFatherPowerId = null;

    private List<PowerSystemsKey> powerSystemssPowerId = null;

    private List<RolePowersKey> rolePowerssPowerId = null;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPowerDesc() {
        return powerDesc;
    }

    public void setPowerDesc(String powerDesc) {
        this.powerDesc = powerDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMenussPowerId(List menussPowerId) {
        this.menussPowerId=menussPowerId;
    }

    public List<Menus> getMenussPowerId() {
        return menussPowerId;
    }

    public void setPowerSystemssFatherPowerId(List powerSystemssFatherPowerId) {
        this.powerSystemssFatherPowerId=powerSystemssFatherPowerId;
    }

    public List<PowerSystemsKey> getPowerSystemssFatherPowerId() {
        return powerSystemssFatherPowerId;
    }

    public void setPowerSystemssPowerId(List powerSystemssPowerId) {
        this.powerSystemssPowerId=powerSystemssPowerId;
    }

    public List<PowerSystemsKey> getPowerSystemssPowerId() {
        return powerSystemssPowerId;
    }

    public void setRolePowerssPowerId(List rolePowerssPowerId) {
        this.rolePowerssPowerId=rolePowerssPowerId;
    }

    public List<RolePowersKey> getRolePowerssPowerId() {
        return rolePowerssPowerId;
    }
}