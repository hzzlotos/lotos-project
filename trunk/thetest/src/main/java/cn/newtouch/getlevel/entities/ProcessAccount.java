package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProcessAccount implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal passRate;

    private BigDecimal realityYield;

    private String status;

    private Date processDate;

    private String processAccountCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPassRate() {
        return passRate;
    }

    public void setPassRate(BigDecimal passRate) {
        this.passRate = passRate;
    }

    public BigDecimal getRealityYield() {
        return realityYield;
    }

    public void setRealityYield(BigDecimal realityYield) {
        this.realityYield = realityYield;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessAccountCode() {
        return processAccountCode;
    }

    public void setProcessAccountCode(String processAccountCode) {
        this.processAccountCode = processAccountCode;
    }
}