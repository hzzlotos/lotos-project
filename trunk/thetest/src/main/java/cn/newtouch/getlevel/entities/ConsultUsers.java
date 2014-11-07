package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class ConsultUsers extends ConsultUsersKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Long userId;

    private Companys companysEnterpriseId;

    private Sellers sellersSellerId;

    private Users usersUserId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanysEnterpriseId(Companys companysEnterpriseId) {
        this.companysEnterpriseId=companysEnterpriseId;
    }

    public Companys getCompanysEnterpriseId() {
        return companysEnterpriseId;
    }

    public void setSellersSellerId(Sellers sellersSellerId) {
        this.sellersSellerId=sellersSellerId;
    }

    public Sellers getSellersSellerId() {
        return sellersSellerId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}