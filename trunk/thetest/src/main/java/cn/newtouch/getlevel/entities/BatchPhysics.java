package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class BatchPhysics implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long batchId;

    private BigDecimal diameter;

    private BigDecimal length;

    private BigDecimal bend;

    private BigDecimal rebend;

    private BigDecimal rebending;

    private BigDecimal coldBend;

    private BigDecimal rebendstr;

    private BigDecimal yieldtensile1;

    private BigDecimal yieldtensile2;

    private BigDecimal yieldtensile3;

    private BigDecimal yieldtensile4;

    private BigDecimal yield;

    private BigDecimal yield2;

    private BigDecimal yield3;

    private BigDecimal yield4;

    private BigDecimal elongation1;

    private BigDecimal elongation2;

    private BigDecimal elongation3;

    private BigDecimal elongation4;

    private BigDecimal totalelongation1;

    private BigDecimal totalelongation2;

    private BigDecimal totalelongation3;

    private BigDecimal totalelongation4;

    private BigDecimal yieldratio1;

    private BigDecimal yieldratio2;

    private BigDecimal yieldratio3;

    private BigDecimal yieldratio4;

    private BigDecimal tensile1;

    private BigDecimal tensile2;

    private BigDecimal tensile3;

    private BigDecimal tensile4;

    private Batchs batchsBatchId;

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public void setDiameter(BigDecimal diameter) {
        this.diameter = diameter;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getBend() {
        return bend;
    }

    public void setBend(BigDecimal bend) {
        this.bend = bend;
    }

    public BigDecimal getRebend() {
        return rebend;
    }

    public void setRebend(BigDecimal rebend) {
        this.rebend = rebend;
    }

    public BigDecimal getRebending() {
        return rebending;
    }

    public void setRebending(BigDecimal rebending) {
        this.rebending = rebending;
    }

    public BigDecimal getColdBend() {
        return coldBend;
    }

    public void setColdBend(BigDecimal coldBend) {
        this.coldBend = coldBend;
    }

    public BigDecimal getRebendstr() {
        return rebendstr;
    }

    public void setRebendstr(BigDecimal rebendstr) {
        this.rebendstr = rebendstr;
    }

    public BigDecimal getYieldtensile1() {
        return yieldtensile1;
    }

    public void setYieldtensile1(BigDecimal yieldtensile1) {
        this.yieldtensile1 = yieldtensile1;
    }

    public BigDecimal getYieldtensile2() {
        return yieldtensile2;
    }

    public void setYieldtensile2(BigDecimal yieldtensile2) {
        this.yieldtensile2 = yieldtensile2;
    }

    public BigDecimal getYieldtensile3() {
        return yieldtensile3;
    }

    public void setYieldtensile3(BigDecimal yieldtensile3) {
        this.yieldtensile3 = yieldtensile3;
    }

    public BigDecimal getYieldtensile4() {
        return yieldtensile4;
    }

    public void setYieldtensile4(BigDecimal yieldtensile4) {
        this.yieldtensile4 = yieldtensile4;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public BigDecimal getYield2() {
        return yield2;
    }

    public void setYield2(BigDecimal yield2) {
        this.yield2 = yield2;
    }

    public BigDecimal getYield3() {
        return yield3;
    }

    public void setYield3(BigDecimal yield3) {
        this.yield3 = yield3;
    }

    public BigDecimal getYield4() {
        return yield4;
    }

    public void setYield4(BigDecimal yield4) {
        this.yield4 = yield4;
    }

    public BigDecimal getElongation1() {
        return elongation1;
    }

    public void setElongation1(BigDecimal elongation1) {
        this.elongation1 = elongation1;
    }

    public BigDecimal getElongation2() {
        return elongation2;
    }

    public void setElongation2(BigDecimal elongation2) {
        this.elongation2 = elongation2;
    }

    public BigDecimal getElongation3() {
        return elongation3;
    }

    public void setElongation3(BigDecimal elongation3) {
        this.elongation3 = elongation3;
    }

    public BigDecimal getElongation4() {
        return elongation4;
    }

    public void setElongation4(BigDecimal elongation4) {
        this.elongation4 = elongation4;
    }

    public BigDecimal getTotalelongation1() {
        return totalelongation1;
    }

    public void setTotalelongation1(BigDecimal totalelongation1) {
        this.totalelongation1 = totalelongation1;
    }

    public BigDecimal getTotalelongation2() {
        return totalelongation2;
    }

    public void setTotalelongation2(BigDecimal totalelongation2) {
        this.totalelongation2 = totalelongation2;
    }

    public BigDecimal getTotalelongation3() {
        return totalelongation3;
    }

    public void setTotalelongation3(BigDecimal totalelongation3) {
        this.totalelongation3 = totalelongation3;
    }

    public BigDecimal getTotalelongation4() {
        return totalelongation4;
    }

    public void setTotalelongation4(BigDecimal totalelongation4) {
        this.totalelongation4 = totalelongation4;
    }

    public BigDecimal getYieldratio1() {
        return yieldratio1;
    }

    public void setYieldratio1(BigDecimal yieldratio1) {
        this.yieldratio1 = yieldratio1;
    }

    public BigDecimal getYieldratio2() {
        return yieldratio2;
    }

    public void setYieldratio2(BigDecimal yieldratio2) {
        this.yieldratio2 = yieldratio2;
    }

    public BigDecimal getYieldratio3() {
        return yieldratio3;
    }

    public void setYieldratio3(BigDecimal yieldratio3) {
        this.yieldratio3 = yieldratio3;
    }

    public BigDecimal getYieldratio4() {
        return yieldratio4;
    }

    public void setYieldratio4(BigDecimal yieldratio4) {
        this.yieldratio4 = yieldratio4;
    }

    public BigDecimal getTensile1() {
        return tensile1;
    }

    public void setTensile1(BigDecimal tensile1) {
        this.tensile1 = tensile1;
    }

    public BigDecimal getTensile2() {
        return tensile2;
    }

    public void setTensile2(BigDecimal tensile2) {
        this.tensile2 = tensile2;
    }

    public BigDecimal getTensile3() {
        return tensile3;
    }

    public void setTensile3(BigDecimal tensile3) {
        this.tensile3 = tensile3;
    }

    public BigDecimal getTensile4() {
        return tensile4;
    }

    public void setTensile4(BigDecimal tensile4) {
        this.tensile4 = tensile4;
    }

    public void setBatchsBatchId(Batchs batchsBatchId) {
        this.batchsBatchId=batchsBatchId;
    }

    public Batchs getBatchsBatchId() {
        return batchsBatchId;
    }
}