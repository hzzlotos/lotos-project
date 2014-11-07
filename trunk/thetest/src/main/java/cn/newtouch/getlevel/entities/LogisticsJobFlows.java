package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class LogisticsJobFlows implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long logisticsOrderId;

    private Long logisticsJobTempId;

    private String isPass;

    private String remark;

    private Long userId;

    private LogisticsJobTemplate logisticsJobTemplateLogisticsJobTempId;

    private LogisticsOrders logisticsOrdersLogisticsOrderId;

    private Users usersUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsOrderId() {
        return logisticsOrderId;
    }

    public void setLogisticsOrderId(Long logisticsOrderId) {
        this.logisticsOrderId = logisticsOrderId;
    }

    public Long getLogisticsJobTempId() {
        return logisticsJobTempId;
    }

    public void setLogisticsJobTempId(Long logisticsJobTempId) {
        this.logisticsJobTempId = logisticsJobTempId;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setLogisticsJobTemplateLogisticsJobTempId(LogisticsJobTemplate logisticsJobTemplateLogisticsJobTempId) {
        this.logisticsJobTemplateLogisticsJobTempId=logisticsJobTemplateLogisticsJobTempId;
    }

    public LogisticsJobTemplate getLogisticsJobTemplateLogisticsJobTempId() {
        return logisticsJobTemplateLogisticsJobTempId;
    }

    public void setLogisticsOrdersLogisticsOrderId(LogisticsOrders logisticsOrdersLogisticsOrderId) {
        this.logisticsOrdersLogisticsOrderId=logisticsOrdersLogisticsOrderId;
    }

    public LogisticsOrders getLogisticsOrdersLogisticsOrderId() {
        return logisticsOrdersLogisticsOrderId;
    }

    public void setUsersUserId(Users usersUserId) {
        this.usersUserId=usersUserId;
    }

    public Users getUsersUserId() {
        return usersUserId;
    }
}