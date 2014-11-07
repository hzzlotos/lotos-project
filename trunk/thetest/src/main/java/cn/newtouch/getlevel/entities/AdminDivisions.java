package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class AdminDivisions implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long fatherAdminDivisionId;

    private String name;

    private String divisionLevel;

    private String postalcode;

    private List<AdminDivisions> adminDivisionssFatherAdminDivisionId = null;

    private List<LogisticsAddress> logisticsAddresssCountry = null;

    private List<LogisticsAddress> logisticsAddresssCityarea = null;

    private List<LogisticsAddress> logisticsAddresssProvince = null;

    private List<LogisticsAddress> logisticsAddresssCity = null;

    private AdminDivisions adminDivisionsFatherAdminDivisionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherAdminDivisionId() {
        return fatherAdminDivisionId;
    }

    public void setFatherAdminDivisionId(Long fatherAdminDivisionId) {
        this.fatherAdminDivisionId = fatherAdminDivisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivisionLevel() {
        return divisionLevel;
    }

    public void setDivisionLevel(String divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setAdminDivisionssFatherAdminDivisionId(List adminDivisionssFatherAdminDivisionId) {
        this.adminDivisionssFatherAdminDivisionId=adminDivisionssFatherAdminDivisionId;
    }

    public List<AdminDivisions> getAdminDivisionssFatherAdminDivisionId() {
        return adminDivisionssFatherAdminDivisionId;
    }

    public void setLogisticsAddresssCountry(List logisticsAddresssCountry) {
        this.logisticsAddresssCountry=logisticsAddresssCountry;
    }

    public List<LogisticsAddress> getLogisticsAddresssCountry() {
        return logisticsAddresssCountry;
    }

    public void setLogisticsAddresssCityarea(List logisticsAddresssCityarea) {
        this.logisticsAddresssCityarea=logisticsAddresssCityarea;
    }

    public List<LogisticsAddress> getLogisticsAddresssCityarea() {
        return logisticsAddresssCityarea;
    }

    public void setLogisticsAddresssProvince(List logisticsAddresssProvince) {
        this.logisticsAddresssProvince=logisticsAddresssProvince;
    }

    public List<LogisticsAddress> getLogisticsAddresssProvince() {
        return logisticsAddresssProvince;
    }

    public void setLogisticsAddresssCity(List logisticsAddresssCity) {
        this.logisticsAddresssCity=logisticsAddresssCity;
    }

    public List<LogisticsAddress> getLogisticsAddresssCity() {
        return logisticsAddresssCity;
    }

    public void setAdminDivisionsFatherAdminDivisionId(AdminDivisions adminDivisionsFatherAdminDivisionId) {
        this.adminDivisionsFatherAdminDivisionId=adminDivisionsFatherAdminDivisionId;
    }

    public AdminDivisions getAdminDivisionsFatherAdminDivisionId() {
        return adminDivisionsFatherAdminDivisionId;
    }
}