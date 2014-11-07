package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class RegionPrice implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal price;

    private LogisticsAddress logisticsAddressId;

    private TraderResources traderResourcesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setLogisticsAddressId(LogisticsAddress logisticsAddressId) {
        this.logisticsAddressId=logisticsAddressId;
    }

    public LogisticsAddress getLogisticsAddressId() {
        return logisticsAddressId;
    }

    public void setTraderResourcesId(TraderResources traderResourcesId) {
        this.traderResourcesId=traderResourcesId;
    }

    public TraderResources getTraderResourcesId() {
        return traderResourcesId;
    }
}