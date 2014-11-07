package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class MallDeliverys implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long mallId;

    private String delyveryType;

    private Date creactDate;

    private Date updateDate;

    private Malls mallsMallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public String getDelyveryType() {
        return delyveryType;
    }

    public void setDelyveryType(String delyveryType) {
        this.delyveryType = delyveryType;
    }

    public Date getCreactDate() {
        return creactDate;
    }

    public void setCreactDate(Date creactDate) {
        this.creactDate = creactDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}