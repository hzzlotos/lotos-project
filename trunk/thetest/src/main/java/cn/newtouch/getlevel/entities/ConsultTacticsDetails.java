package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class ConsultTacticsDetails extends ConsultTacticsDetailsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private BigDecimal premiun;

    private ConsultTatics consultTaticsConsultUserId;

    private Resources resourcesResDefId;

    public BigDecimal getPremiun() {
        return premiun;
    }

    public void setPremiun(BigDecimal premiun) {
        this.premiun = premiun;
    }

    public void setConsultTaticsConsultUserId(ConsultTatics consultTaticsConsultUserId) {
        this.consultTaticsConsultUserId=consultTaticsConsultUserId;
    }

    public ConsultTatics getConsultTaticsConsultUserId() {
        return consultTaticsConsultUserId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }
}