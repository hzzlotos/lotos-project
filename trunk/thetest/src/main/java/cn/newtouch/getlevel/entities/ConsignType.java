package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class ConsignType implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String typeName;

    private List<LogisticsOrders> logisticsOrderssResDefId = null;

    private List<LogisticsSolutions> logisticsSolutionssCheckingId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setLogisticsOrderssResDefId(List logisticsOrderssResDefId) {
        this.logisticsOrderssResDefId=logisticsOrderssResDefId;
    }

    public List<LogisticsOrders> getLogisticsOrderssResDefId() {
        return logisticsOrderssResDefId;
    }

    public void setLogisticsSolutionssCheckingId(List logisticsSolutionssCheckingId) {
        this.logisticsSolutionssCheckingId=logisticsSolutionssCheckingId;
    }

    public List<LogisticsSolutions> getLogisticsSolutionssCheckingId() {
        return logisticsSolutionssCheckingId;
    }
}