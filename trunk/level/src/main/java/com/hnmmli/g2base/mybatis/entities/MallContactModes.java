package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class MallContactModes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long malcmMallid;

    private Long malcmLognid;

    private String contactMode;

    private String contactCode;

    private LogisticsAddress logisticsAddressMalcmLognid;

    private Malls mallsMalcmMallid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMalcmMallid() {
        return malcmMallid;
    }

    public void setMalcmMallid(Long malcmMallid) {
        this.malcmMallid = malcmMallid;
    }

    public Long getMalcmLognid() {
        return malcmLognid;
    }

    public void setMalcmLognid(Long malcmLognid) {
        this.malcmLognid = malcmLognid;
    }

    public String getContactMode() {
        return contactMode;
    }

    public void setContactMode(String contactMode) {
        this.contactMode = contactMode;
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public void setLogisticsAddressMalcmLognid(LogisticsAddress logisticsAddressMalcmLognid) {
        this.logisticsAddressMalcmLognid=logisticsAddressMalcmLognid;
    }

    public LogisticsAddress getLogisticsAddressMalcmLognid() {
        return logisticsAddressMalcmLognid;
    }

    public void setMallsMalcmMallid(Malls mallsMalcmMallid) {
        this.mallsMalcmMallid=mallsMalcmMallid;
    }

    public Malls getMallsMalcmMallid() {
        return mallsMalcmMallid;
    }
}