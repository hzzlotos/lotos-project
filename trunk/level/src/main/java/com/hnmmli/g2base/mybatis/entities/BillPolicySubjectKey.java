package com.hnmmli.g2base.mybatis.entities;

public class BillPolicySubjectKey {
    private Long billPolicyId;

    private Long billSubjectId;

    public Long getBillPolicyId() {
        return billPolicyId;
    }

    public void setBillPolicyId(Long billPolicyId) {
        this.billPolicyId = billPolicyId;
    }

    public Long getBillSubjectId() {
        return billSubjectId;
    }

    public void setBillSubjectId(Long billSubjectId) {
        this.billSubjectId = billSubjectId;
    }
}