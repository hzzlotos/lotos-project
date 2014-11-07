package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class PowerSystems extends PowerSystemsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Powers powersPowerId;

    private Powers powersFatherPowerId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setPowersPowerId(Powers powersPowerId) {
        this.powersPowerId=powersPowerId;
    }

    public Powers getPowersPowerId() {
        return powersPowerId;
    }

    public void setPowersFatherPowerId(Powers powersFatherPowerId) {
        this.powersFatherPowerId=powersFatherPowerId;
    }

    public Powers getPowersFatherPowerId() {
        return powersFatherPowerId;
    }
}