package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;

public class DeliveryPersonDetails implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long collecterId;

    private Long laddId;

    private Long goodMeasureId;

    private DeliveryPersons deliveryPersonsCollecterId;

    private GoodsMeasures goodsMeasuresGoodMeasureId;

    private LadingDetails ladingDetailsLaddId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollecterId() {
        return collecterId;
    }

    public void setCollecterId(Long collecterId) {
        this.collecterId = collecterId;
    }

    public Long getLaddId() {
        return laddId;
    }

    public void setLaddId(Long laddId) {
        this.laddId = laddId;
    }

    public Long getGoodMeasureId() {
        return goodMeasureId;
    }

    public void setGoodMeasureId(Long goodMeasureId) {
        this.goodMeasureId = goodMeasureId;
    }

    public void setDeliveryPersonsCollecterId(DeliveryPersons deliveryPersonsCollecterId) {
        this.deliveryPersonsCollecterId=deliveryPersonsCollecterId;
    }

    public DeliveryPersons getDeliveryPersonsCollecterId() {
        return deliveryPersonsCollecterId;
    }

    public void setGoodsMeasuresGoodMeasureId(GoodsMeasures goodsMeasuresGoodMeasureId) {
        this.goodsMeasuresGoodMeasureId=goodsMeasuresGoodMeasureId;
    }

    public GoodsMeasures getGoodsMeasuresGoodMeasureId() {
        return goodsMeasuresGoodMeasureId;
    }

    public void setLadingDetailsLaddId(LadingDetails ladingDetailsLaddId) {
        this.ladingDetailsLaddId=ladingDetailsLaddId;
    }

    public LadingDetails getLadingDetailsLaddId() {
        return ladingDetailsLaddId;
    }
}