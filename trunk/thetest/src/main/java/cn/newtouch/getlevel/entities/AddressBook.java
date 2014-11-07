package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class AddressBook extends AddressBookKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Companys companysCompanyId;

    private LogisticsAddress logisticsAddressAddressId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setLogisticsAddressAddressId(LogisticsAddress logisticsAddressAddressId) {
        this.logisticsAddressAddressId=logisticsAddressAddressId;
    }

    public LogisticsAddress getLogisticsAddressAddressId() {
        return logisticsAddressAddressId;
    }
}