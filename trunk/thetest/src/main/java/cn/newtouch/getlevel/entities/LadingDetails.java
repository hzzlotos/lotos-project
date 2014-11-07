package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class LadingDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long ladId;

    private Long resDefId;

    private Long goodsMeasureId;

    private List<DeliveryPersonDetails> deliveryPersonDetailssLaddId = null;

    private GoodsMeasures goodsMeasuresGoodsMeasureId;

    private Ladings ladingsLadId;

    private Resources resourcesResDefId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLadId() {
        return ladId;
    }

    public void setLadId(Long ladId) {
        this.ladId = ladId;
    }

    public Long getResDefId() {
        return resDefId;
    }

    public void setResDefId(Long resDefId) {
        this.resDefId = resDefId;
    }

    public Long getGoodsMeasureId() {
        return goodsMeasureId;
    }

    public void setGoodsMeasureId(Long goodsMeasureId) {
        this.goodsMeasureId = goodsMeasureId;
    }

    public void setDeliveryPersonDetailssLaddId(List deliveryPersonDetailssLaddId) {
        this.deliveryPersonDetailssLaddId=deliveryPersonDetailssLaddId;
    }

    public List<DeliveryPersonDetails> getDeliveryPersonDetailssLaddId() {
        return deliveryPersonDetailssLaddId;
    }

    public void setGoodsMeasuresGoodsMeasureId(GoodsMeasures goodsMeasuresGoodsMeasureId) {
        this.goodsMeasuresGoodsMeasureId=goodsMeasuresGoodsMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodsMeasureId() {
        return goodsMeasuresGoodsMeasureId;
    }

    public void setLadingsLadId(Ladings ladingsLadId) {
        this.ladingsLadId=ladingsLadId;
    }

    public Ladings getLadingsLadId() {
        return ladingsLadId;
    }

    public void setResourcesResDefId(Resources resourcesResDefId) {
        this.resourcesResDefId=resourcesResDefId;
    }

    public Resources getResourcesResDefId() {
        return resourcesResDefId;
    }
}