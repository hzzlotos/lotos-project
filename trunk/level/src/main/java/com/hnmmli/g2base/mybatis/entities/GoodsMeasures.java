package com.hnmmli.g2base.mybatis.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.List;

public class GoodsMeasures implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long quantityUomId;

    private BigDecimal qty;

    private Long weightUomId;

    private BigDecimal pieceWeight;

    private BigDecimal weight;

    private Long volumeUomId;

    private BigDecimal pieceVolume;

    private BigDecimal volume;

    private Long areaUomId;

    private BigDecimal pieceArea;

    private BigDecimal area;

    private List<CarrierOrderSocialMaterials> carrierOrderSocialMaterialssGoodsMeasureId = null;

    private List<CollateralItemDetails> collateralItemDetailssGoodsMeasureId = null;

    private List<CollateralSummaries> collateralSummariessGoodsMeasureId = null;

    private List<DeliveryPersonDetails> deliveryPersonDetailssGoodMeasureId = null;

    private List<ExcelInResDetailsKey> excelInResDetailssGoodsMeasureId = null;

    private List<FinancingApplyDetails> financingApplyDetailssGoodsMeasureId = null;

    private List<LadingDetails> ladingDetailssGoodsMeasureId = null;

    private List<LogisOrderWareMaterial> logisOrderWareMaterialsGoodsMeasureId = null;

    private List<OrderDetailsKey> orderDetailssGoodsMeasureId = null;

    private List<ResourceSummaries> resourceSummariessFreezeMeasureGoodsId = null;

    private List<ResourceSummaries> resourceSummariessStoreMeasureGoodsId = null;

    private List<RouteSocialMaterial> routeSocialMaterialsGoodsMeasureId = null;

    private List<RouteWarehMaterials> routeWarehMaterialssGoodsMeasureId = null;

    private List<StoreJobDetails> storeJobDetailssFinishedMeasureGoodsId = null;

    private List<StoreJobDetails> storeJobDetailssMeasureGoodsId = null;

    private List<TraderResources> traderResourcessGoodsMeasureId = null;

    private List<TraderResources> traderResourcessSaledGoodsMeasureId = null;

    private List<TransportDemands> transportDemandssGoodsMeasureId = null;

    private Uoms uomsQuantityUomId;

    private Uoms uomsAreaUomId;

    private Uoms uomsVolumeUomId;

    private Uoms uomsWeightUomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantityUomId() {
        return quantityUomId;
    }

    public void setQuantityUomId(Long quantityUomId) {
        this.quantityUomId = quantityUomId;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Long getWeightUomId() {
        return weightUomId;
    }

    public void setWeightUomId(Long weightUomId) {
        this.weightUomId = weightUomId;
    }

    public BigDecimal getPieceWeight() {
        return pieceWeight;
    }

    public void setPieceWeight(BigDecimal pieceWeight) {
        this.pieceWeight = pieceWeight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Long getVolumeUomId() {
        return volumeUomId;
    }

    public void setVolumeUomId(Long volumeUomId) {
        this.volumeUomId = volumeUomId;
    }

    public BigDecimal getPieceVolume() {
        return pieceVolume;
    }

    public void setPieceVolume(BigDecimal pieceVolume) {
        this.pieceVolume = pieceVolume;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Long getAreaUomId() {
        return areaUomId;
    }

    public void setAreaUomId(Long areaUomId) {
        this.areaUomId = areaUomId;
    }

    public BigDecimal getPieceArea() {
        return pieceArea;
    }

    public void setPieceArea(BigDecimal pieceArea) {
        this.pieceArea = pieceArea;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public void setCarrierOrderSocialMaterialssGoodsMeasureId(List carrierOrderSocialMaterialssGoodsMeasureId) {
        this.carrierOrderSocialMaterialssGoodsMeasureId=carrierOrderSocialMaterialssGoodsMeasureId;
    }

    public List<CarrierOrderSocialMaterials> getCarrierOrderSocialMaterialssGoodsMeasureId() {
        return carrierOrderSocialMaterialssGoodsMeasureId;
    }

    public void setCollateralItemDetailssGoodsMeasureId(List collateralItemDetailssGoodsMeasureId) {
        this.collateralItemDetailssGoodsMeasureId=collateralItemDetailssGoodsMeasureId;
    }

    public List<CollateralItemDetails> getCollateralItemDetailssGoodsMeasureId() {
        return collateralItemDetailssGoodsMeasureId;
    }

    public void setCollateralSummariessGoodsMeasureId(List collateralSummariessGoodsMeasureId) {
        this.collateralSummariessGoodsMeasureId=collateralSummariessGoodsMeasureId;
    }

    public List<CollateralSummaries> getCollateralSummariessGoodsMeasureId() {
        return collateralSummariessGoodsMeasureId;
    }

    public void setDeliveryPersonDetailssGoodMeasureId(List deliveryPersonDetailssGoodMeasureId) {
        this.deliveryPersonDetailssGoodMeasureId=deliveryPersonDetailssGoodMeasureId;
    }

    public List<DeliveryPersonDetails> getDeliveryPersonDetailssGoodMeasureId() {
        return deliveryPersonDetailssGoodMeasureId;
    }

    public void setExcelInResDetailssGoodsMeasureId(List excelInResDetailssGoodsMeasureId) {
        this.excelInResDetailssGoodsMeasureId=excelInResDetailssGoodsMeasureId;
    }

    public List<ExcelInResDetailsKey> getExcelInResDetailssGoodsMeasureId() {
        return excelInResDetailssGoodsMeasureId;
    }

    public void setFinancingApplyDetailssGoodsMeasureId(List financingApplyDetailssGoodsMeasureId) {
        this.financingApplyDetailssGoodsMeasureId=financingApplyDetailssGoodsMeasureId;
    }

    public List<FinancingApplyDetails> getFinancingApplyDetailssGoodsMeasureId() {
        return financingApplyDetailssGoodsMeasureId;
    }

    public void setLadingDetailssGoodsMeasureId(List ladingDetailssGoodsMeasureId) {
        this.ladingDetailssGoodsMeasureId=ladingDetailssGoodsMeasureId;
    }

    public List<LadingDetails> getLadingDetailssGoodsMeasureId() {
        return ladingDetailssGoodsMeasureId;
    }

    public void setLogisOrderWareMaterialsGoodsMeasureId(List logisOrderWareMaterialsGoodsMeasureId) {
        this.logisOrderWareMaterialsGoodsMeasureId=logisOrderWareMaterialsGoodsMeasureId;
    }

    public List<LogisOrderWareMaterial> getLogisOrderWareMaterialsGoodsMeasureId() {
        return logisOrderWareMaterialsGoodsMeasureId;
    }

    public void setOrderDetailssGoodsMeasureId(List orderDetailssGoodsMeasureId) {
        this.orderDetailssGoodsMeasureId=orderDetailssGoodsMeasureId;
    }

    public List<OrderDetailsKey> getOrderDetailssGoodsMeasureId() {
        return orderDetailssGoodsMeasureId;
    }

    public void setResourceSummariessFreezeMeasureGoodsId(List resourceSummariessFreezeMeasureGoodsId) {
        this.resourceSummariessFreezeMeasureGoodsId=resourceSummariessFreezeMeasureGoodsId;
    }

    public List<ResourceSummaries> getResourceSummariessFreezeMeasureGoodsId() {
        return resourceSummariessFreezeMeasureGoodsId;
    }

    public void setResourceSummariessStoreMeasureGoodsId(List resourceSummariessStoreMeasureGoodsId) {
        this.resourceSummariessStoreMeasureGoodsId=resourceSummariessStoreMeasureGoodsId;
    }

    public List<ResourceSummaries> getResourceSummariessStoreMeasureGoodsId() {
        return resourceSummariessStoreMeasureGoodsId;
    }

    public void setRouteSocialMaterialsGoodsMeasureId(List routeSocialMaterialsGoodsMeasureId) {
        this.routeSocialMaterialsGoodsMeasureId=routeSocialMaterialsGoodsMeasureId;
    }

    public List<RouteSocialMaterial> getRouteSocialMaterialsGoodsMeasureId() {
        return routeSocialMaterialsGoodsMeasureId;
    }

    public void setRouteWarehMaterialssGoodsMeasureId(List routeWarehMaterialssGoodsMeasureId) {
        this.routeWarehMaterialssGoodsMeasureId=routeWarehMaterialssGoodsMeasureId;
    }

    public List<RouteWarehMaterials> getRouteWarehMaterialssGoodsMeasureId() {
        return routeWarehMaterialssGoodsMeasureId;
    }

    public void setStoreJobDetailssFinishedMeasureGoodsId(List storeJobDetailssFinishedMeasureGoodsId) {
        this.storeJobDetailssFinishedMeasureGoodsId=storeJobDetailssFinishedMeasureGoodsId;
    }

    public List<StoreJobDetails> getStoreJobDetailssFinishedMeasureGoodsId() {
        return storeJobDetailssFinishedMeasureGoodsId;
    }

    public void setStoreJobDetailssMeasureGoodsId(List storeJobDetailssMeasureGoodsId) {
        this.storeJobDetailssMeasureGoodsId=storeJobDetailssMeasureGoodsId;
    }

    public List<StoreJobDetails> getStoreJobDetailssMeasureGoodsId() {
        return storeJobDetailssMeasureGoodsId;
    }

    public void setTraderResourcessGoodsMeasureId(List traderResourcessGoodsMeasureId) {
        this.traderResourcessGoodsMeasureId=traderResourcessGoodsMeasureId;
    }

    public List<TraderResources> getTraderResourcessGoodsMeasureId() {
        return traderResourcessGoodsMeasureId;
    }

    public void setTraderResourcessSaledGoodsMeasureId(List traderResourcessSaledGoodsMeasureId) {
        this.traderResourcessSaledGoodsMeasureId=traderResourcessSaledGoodsMeasureId;
    }

    public List<TraderResources> getTraderResourcessSaledGoodsMeasureId() {
        return traderResourcessSaledGoodsMeasureId;
    }

    public void setTransportDemandssGoodsMeasureId(List transportDemandssGoodsMeasureId) {
        this.transportDemandssGoodsMeasureId=transportDemandssGoodsMeasureId;
    }

    public List<TransportDemands> getTransportDemandssGoodsMeasureId() {
        return transportDemandssGoodsMeasureId;
    }

    public void setUomsQuantityUomId(Uoms uomsQuantityUomId) {
        this.uomsQuantityUomId=uomsQuantityUomId;
    }

    public Uoms getUomsQuantityUomId() {
        return uomsQuantityUomId;
    }

    public void setUomsAreaUomId(Uoms uomsAreaUomId) {
        this.uomsAreaUomId=uomsAreaUomId;
    }

    public Uoms getUomsAreaUomId() {
        return uomsAreaUomId;
    }

    public void setUomsVolumeUomId(Uoms uomsVolumeUomId) {
        this.uomsVolumeUomId=uomsVolumeUomId;
    }

    public Uoms getUomsVolumeUomId() {
        return uomsVolumeUomId;
    }

    public void setUomsWeightUomId(Uoms uomsWeightUomId) {
        this.uomsWeightUomId=uomsWeightUomId;
    }

    public Uoms getUomsWeightUomId() {
        return uomsWeightUomId;
    }
}