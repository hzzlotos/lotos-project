package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

public class StoreJobFlowNodes implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long lastNodeId;

    private Long jobFlowModeId;

    private String name;

    private String appendFunction;

    private String actionTypeId;

    private Date createDate;

    private Long userId;

    private String isTop;

    private List<StoreJobFlows> storeJobFlowssJobFlowNodeId = null;

    private List<StoreJobFlowNodes> storeJobFlowNodessLastNodeId = null;

    private List<StoreJobFlowNodePowers> storeJobFlowNodePowerssJobFlowNodeId = null;

    private StoreJobFlowModes storeJobFlowModesJobFlowModeId;

    private StoreJobFlowNodes storeJobFlowNodesLastNodeId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastNodeId() {
        return lastNodeId;
    }

    public void setLastNodeId(Long lastNodeId) {
        this.lastNodeId = lastNodeId;
    }

    public Long getJobFlowModeId() {
        return jobFlowModeId;
    }

    public void setJobFlowModeId(Long jobFlowModeId) {
        this.jobFlowModeId = jobFlowModeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppendFunction() {
        return appendFunction;
    }

    public void setAppendFunction(String appendFunction) {
        this.appendFunction = appendFunction;
    }

    public String getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(String actionTypeId) {
        this.actionTypeId = actionTypeId;
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

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public void setStoreJobFlowssJobFlowNodeId(List storeJobFlowssJobFlowNodeId) {
        this.storeJobFlowssJobFlowNodeId=storeJobFlowssJobFlowNodeId;
    }

    public List<StoreJobFlows> getStoreJobFlowssJobFlowNodeId() {
        return storeJobFlowssJobFlowNodeId;
    }

    public void setStoreJobFlowNodessLastNodeId(List storeJobFlowNodessLastNodeId) {
        this.storeJobFlowNodessLastNodeId=storeJobFlowNodessLastNodeId;
    }

    public List<StoreJobFlowNodes> getStoreJobFlowNodessLastNodeId() {
        return storeJobFlowNodessLastNodeId;
    }

    public void setStoreJobFlowNodePowerssJobFlowNodeId(List storeJobFlowNodePowerssJobFlowNodeId) {
        this.storeJobFlowNodePowerssJobFlowNodeId=storeJobFlowNodePowerssJobFlowNodeId;
    }

    public List<StoreJobFlowNodePowers> getStoreJobFlowNodePowerssJobFlowNodeId() {
        return storeJobFlowNodePowerssJobFlowNodeId;
    }

    public void setStoreJobFlowModesJobFlowModeId(StoreJobFlowModes storeJobFlowModesJobFlowModeId) {
        this.storeJobFlowModesJobFlowModeId=storeJobFlowModesJobFlowModeId;
    }

    public StoreJobFlowModes getStoreJobFlowModesJobFlowModeId() {
        return storeJobFlowModesJobFlowModeId;
    }

    public void setStoreJobFlowNodesLastNodeId(StoreJobFlowNodes storeJobFlowNodesLastNodeId) {
        this.storeJobFlowNodesLastNodeId=storeJobFlowNodesLastNodeId;
    }

    public StoreJobFlowNodes getStoreJobFlowNodesLastNodeId() {
        return storeJobFlowNodesLastNodeId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}