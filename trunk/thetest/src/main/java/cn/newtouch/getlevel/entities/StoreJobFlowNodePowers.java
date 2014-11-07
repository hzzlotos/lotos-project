package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class StoreJobFlowNodePowers implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long jobFlowNodeId;

    private Date createDate;

    private Long userRoleId;

    private Long userId;

    private StoreJobFlowNodes storeJobFlowNodesJobFlowNodeId;

    private UserRoles userRolesUserRoleId;

    private UserRoles userRolesUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobFlowNodeId() {
        return jobFlowNodeId;
    }

    public void setJobFlowNodeId(Long jobFlowNodeId) {
        this.jobFlowNodeId = jobFlowNodeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStoreJobFlowNodesJobFlowNodeId(StoreJobFlowNodes storeJobFlowNodesJobFlowNodeId) {
        this.storeJobFlowNodesJobFlowNodeId=storeJobFlowNodesJobFlowNodeId;
    }

    public StoreJobFlowNodes getStoreJobFlowNodesJobFlowNodeId() {
        return storeJobFlowNodesJobFlowNodeId;
    }

    public void setUserRolesUserRoleId(UserRoles userRolesUserRoleId) {
        this.userRolesUserRoleId=userRolesUserRoleId;
    }

    public UserRoles getUserRolesUserRoleId() {
        return userRolesUserRoleId;
    }

    public void setUserRolesUserId(UserRoles userRolesUserId) {
        this.userRolesUserId=userRolesUserId;
    }

    public UserRoles getUserRolesUserId() {
        return userRolesUserId;
    }
}