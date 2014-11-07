package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class BillPolicySubject extends BillPolicySubjectKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private TransBillPolicy transBillPolicyBillPolicyId;

    private TransBillSubTemp transBillSubTempBillSubjectId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTransBillPolicyBillPolicyId(TransBillPolicy transBillPolicyBillPolicyId) {
        this.transBillPolicyBillPolicyId=transBillPolicyBillPolicyId;
    }

    public TransBillPolicy getTransBillPolicyBillPolicyId() {
        return transBillPolicyBillPolicyId;
    }

    public void setTransBillSubTempBillSubjectId(TransBillSubTemp transBillSubTempBillSubjectId) {
        this.transBillSubTempBillSubjectId=transBillSubTempBillSubjectId;
    }

    public TransBillSubTemp getTransBillSubTempBillSubjectId() {
        return transBillSubTempBillSubjectId;
    }
}