package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

import java.util.List;

public class Menus implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long fatherMenuId;

    private String menuLevel;

    private String name;

    private Long powerId;

    private String isCustomMenu;

    private Long userId;

    private Long icoFileId;

    private List<Menus> menussFatherMenuId = null;

    private FileInfos fileInfosIcoFileId;

    private Menus menusFatherMenuId;

    private Powers powersPowerId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherMenuId() {
        return fatherMenuId;
    }

    public void setFatherMenuId(Long fatherMenuId) {
        this.fatherMenuId = fatherMenuId;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }

    public String getIsCustomMenu() {
        return isCustomMenu;
    }

    public void setIsCustomMenu(String isCustomMenu) {
        this.isCustomMenu = isCustomMenu;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIcoFileId() {
        return icoFileId;
    }

    public void setIcoFileId(Long icoFileId) {
        this.icoFileId = icoFileId;
    }

    public void setMenussFatherMenuId(List menussFatherMenuId) {
        this.menussFatherMenuId=menussFatherMenuId;
    }

    public List<Menus> getMenussFatherMenuId() {
        return menussFatherMenuId;
    }

    public void setFileInfosIcoFileId(FileInfos fileInfosIcoFileId) {
        this.fileInfosIcoFileId=fileInfosIcoFileId;
    }

    public FileInfos getFileInfosIcoFileId() {
        return fileInfosIcoFileId;
    }

    public void setMenusFatherMenuId(Menus menusFatherMenuId) {
        this.menusFatherMenuId=menusFatherMenuId;
    }

    public Menus getMenusFatherMenuId() {
        return menusFatherMenuId;
    }

    public void setPowersPowerId(Powers powersPowerId) {
        this.powersPowerId=powersPowerId;
    }

    public Powers getPowersPowerId() {
        return powersPowerId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}