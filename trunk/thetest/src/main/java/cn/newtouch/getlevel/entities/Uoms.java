package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class Uoms implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String type;

    private String status;

    private Date createDate;

    private Long userId;

    private List<Allocations> allocationssUomId = null;

    private List<ChargeItems> chargeItemssUomId = null;

    private List<GoodsMeasures> goodsMeasuressAreaUomId = null;

    private List<GoodsMeasures> goodsMeasuressQuantityUomId = null;

    private List<GoodsMeasures> goodsMeasuressWeightUomId = null;

    private List<GoodsMeasures> goodsMeasuressVolumeUomId = null;

    private List<Resources> resourcessUomId = null;

    private List<ScoreStrategys> scoreStrategyssUomId = null;

    private List<UomChangesKey> uomChangessBigUomId = null;

    private List<UomChangesKey> uomChangessSmallUomId = null;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAllocationssUomId(List allocationssUomId) {
        this.allocationssUomId=allocationssUomId;
    }

    public List<Allocations> getAllocationssUomId() {
        return allocationssUomId;
    }

    public void setChargeItemssUomId(List chargeItemssUomId) {
        this.chargeItemssUomId=chargeItemssUomId;
    }

    public List<ChargeItems> getChargeItemssUomId() {
        return chargeItemssUomId;
    }

    public void setGoodsMeasuressAreaUomId(List goodsMeasuressAreaUomId) {
        this.goodsMeasuressAreaUomId=goodsMeasuressAreaUomId;
    }

    public List<GoodsMeasures> getGoodsMeasuressAreaUomId() {
        return goodsMeasuressAreaUomId;
    }

    public void setGoodsMeasuressQuantityUomId(List goodsMeasuressQuantityUomId) {
        this.goodsMeasuressQuantityUomId=goodsMeasuressQuantityUomId;
    }

    public List<GoodsMeasures> getGoodsMeasuressQuantityUomId() {
        return goodsMeasuressQuantityUomId;
    }

    public void setGoodsMeasuressWeightUomId(List goodsMeasuressWeightUomId) {
        this.goodsMeasuressWeightUomId=goodsMeasuressWeightUomId;
    }

    public List<GoodsMeasures> getGoodsMeasuressWeightUomId() {
        return goodsMeasuressWeightUomId;
    }

    public void setGoodsMeasuressVolumeUomId(List goodsMeasuressVolumeUomId) {
        this.goodsMeasuressVolumeUomId=goodsMeasuressVolumeUomId;
    }

    public List<GoodsMeasures> getGoodsMeasuressVolumeUomId() {
        return goodsMeasuressVolumeUomId;
    }

    public void setResourcessUomId(List resourcessUomId) {
        this.resourcessUomId=resourcessUomId;
    }

    public List<Resources> getResourcessUomId() {
        return resourcessUomId;
    }

    public void setScoreStrategyssUomId(List scoreStrategyssUomId) {
        this.scoreStrategyssUomId=scoreStrategyssUomId;
    }

    public List<ScoreStrategys> getScoreStrategyssUomId() {
        return scoreStrategyssUomId;
    }

    public void setUomChangessBigUomId(List uomChangessBigUomId) {
        this.uomChangessBigUomId=uomChangessBigUomId;
    }

    public List<UomChangesKey> getUomChangessBigUomId() {
        return uomChangessBigUomId;
    }

    public void setUomChangessSmallUomId(List uomChangessSmallUomId) {
        this.uomChangessSmallUomId=uomChangessSmallUomId;
    }

    public List<UomChangesKey> getUomChangessSmallUomId() {
        return uomChangessSmallUomId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}