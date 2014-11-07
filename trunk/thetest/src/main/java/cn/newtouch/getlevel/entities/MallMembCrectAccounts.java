package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class MallMembCrectAccounts implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long integralCount;

    private Long integralAvailable;

    private Long memberId;

    private Long mallId;

    private MallMembers mallMembersMemberId;

    private MallMembers mallMembersMallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIntegralCount() {
        return integralCount;
    }

    public void setIntegralCount(Long integralCount) {
        this.integralCount = integralCount;
    }

    public Long getIntegralAvailable() {
        return integralAvailable;
    }

    public void setIntegralAvailable(Long integralAvailable) {
        this.integralAvailable = integralAvailable;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public void setMallMembersMemberId(MallMembers mallMembersMemberId) {
        this.mallMembersMemberId=mallMembersMemberId;
    }

    public MallMembers getMallMembersMemberId() {
        return mallMembersMemberId;
    }

    public void setMallMembersMallId(MallMembers mallMembersMallId) {
        this.mallMembersMallId=mallMembersMallId;
    }

    public MallMembers getMallMembersMallId() {
        return mallMembersMallId;
    }
}