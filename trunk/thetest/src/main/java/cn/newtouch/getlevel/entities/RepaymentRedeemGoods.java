package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class RepaymentRedeemGoods implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long financingApplyId;

    private Date createDate;

    private Long userId;

    private List<RepaymentRedeemGoodsDetails> repaymentRedeemGoodsDetailssRedeemGoodId = null;

    private FinancingApplys financingApplysFinancingApplyId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinancingApplyId() {
        return financingApplyId;
    }

    public void setFinancingApplyId(Long financingApplyId) {
        this.financingApplyId = financingApplyId;
    }

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

    public void setRepaymentRedeemGoodsDetailssRedeemGoodId(List repaymentRedeemGoodsDetailssRedeemGoodId) {
        this.repaymentRedeemGoodsDetailssRedeemGoodId=repaymentRedeemGoodsDetailssRedeemGoodId;
    }

    public List<RepaymentRedeemGoodsDetails> getRepaymentRedeemGoodsDetailssRedeemGoodId() {
        return repaymentRedeemGoodsDetailssRedeemGoodId;
    }

    public void setFinancingApplysFinancingApplyId(FinancingApplys financingApplysFinancingApplyId) {
        this.financingApplysFinancingApplyId=financingApplysFinancingApplyId;
    }

    public FinancingApplys getFinancingApplysFinancingApplyId() {
        return financingApplysFinancingApplyId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}