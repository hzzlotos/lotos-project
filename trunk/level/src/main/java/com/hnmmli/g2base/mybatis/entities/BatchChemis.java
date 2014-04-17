package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class BatchChemis implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long batchId;

    private BigDecimal c;

    private BigDecimal mn;

    private BigDecimal p;

    private BigDecimal s;

    private BigDecimal si;

    private BigDecimal ni;

    private BigDecimal cr;

    private BigDecimal cu;

    private BigDecimal v;

    private BigDecimal mo;

    private BigDecimal nb;

    private BigDecimal ceq;

    private Batchs batchsBatchId;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }

    public BigDecimal getMn() {
        return mn;
    }

    public void setMn(BigDecimal mn) {
        this.mn = mn;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getS() {
        return s;
    }

    public void setS(BigDecimal s) {
        this.s = s;
    }

    public BigDecimal getSi() {
        return si;
    }

    public void setSi(BigDecimal si) {
        this.si = si;
    }

    public BigDecimal getNi() {
        return ni;
    }

    public void setNi(BigDecimal ni) {
        this.ni = ni;
    }

    public BigDecimal getCr() {
        return cr;
    }

    public void setCr(BigDecimal cr) {
        this.cr = cr;
    }

    public BigDecimal getCu() {
        return cu;
    }

    public void setCu(BigDecimal cu) {
        this.cu = cu;
    }

    public BigDecimal getV() {
        return v;
    }

    public void setV(BigDecimal v) {
        this.v = v;
    }

    public BigDecimal getMo() {
        return mo;
    }

    public void setMo(BigDecimal mo) {
        this.mo = mo;
    }

    public BigDecimal getNb() {
        return nb;
    }

    public void setNb(BigDecimal nb) {
        this.nb = nb;
    }

    public BigDecimal getCeq() {
        return ceq;
    }

    public void setCeq(BigDecimal ceq) {
        this.ceq = ceq;
    }

    public void setBatchsBatchId(Batchs batchsBatchId) {
        this.batchsBatchId=batchsBatchId;
    }

    public Batchs getBatchsBatchId() {
        return batchsBatchId;
    }
}