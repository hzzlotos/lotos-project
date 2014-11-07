package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class TransBillSubject extends TransBillSubjectKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private TransportBilling transportBillingTransBillId;

    private TransBillSubTemp transBillSubTempSubjectId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setTransportBillingTransBillId(TransportBilling transportBillingTransBillId) {
        this.transportBillingTransBillId=transportBillingTransBillId;
    }

    public TransportBilling getTransportBillingTransBillId() {
        return transportBillingTransBillId;
    }

    public void setTransBillSubTempSubjectId(TransBillSubTemp transBillSubTempSubjectId) {
        this.transBillSubTempSubjectId=transBillSubTempSubjectId;
    }

    public TransBillSubTemp getTransBillSubTempSubjectId() {
        return transBillSubTempSubjectId;
    }
}