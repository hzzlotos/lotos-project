package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

public class MemberPrices implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal priceDiffent;

    private BigDecimal scope;

    private Date dateScope;

    private Long mallId;

    private Long resourceId;

    private Long companyId;

    private Long userId;

    private List<TraderResources> traderResourcessMemberPriceId = null;

    private Companys companysCompanyId;

    private MallMemberLevels mallMemberLevelsMallId;

    private Resources resourcesResourceId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPriceDiffent() {
        return priceDiffent;
    }

    public void setPriceDiffent(BigDecimal priceDiffent) {
        this.priceDiffent = priceDiffent;
    }

    public BigDecimal getScope() {
        return scope;
    }

    public void setScope(BigDecimal scope) {
        this.scope = scope;
    }

    public Date getDateScope() {
        return dateScope;
    }

    public void setDateScope(Date dateScope) {
        this.dateScope = dateScope;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTraderResourcessMemberPriceId(List traderResourcessMemberPriceId) {
        this.traderResourcessMemberPriceId=traderResourcessMemberPriceId;
    }

    public List<TraderResources> getTraderResourcessMemberPriceId() {
        return traderResourcessMemberPriceId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setMallMemberLevelsMallId(MallMemberLevels mallMemberLevelsMallId) {
        this.mallMemberLevelsMallId=mallMemberLevelsMallId;
    }

    public MallMemberLevels getMallMemberLevelsMallId() {
        return mallMemberLevelsMallId;
    }

    public void setResourcesResourceId(Resources resourcesResourceId) {
        this.resourcesResourceId=resourcesResourceId;
    }

    public Resources getResourcesResourceId() {
        return resourcesResourceId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}