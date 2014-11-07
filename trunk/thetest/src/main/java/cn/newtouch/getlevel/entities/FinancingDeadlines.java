package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class FinancingDeadlines implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long bankId;

    private List<FinancingApplys> financingApplyssFinancingDeadlineId = null;

    private Banks banksBankId;

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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public void setFinancingApplyssFinancingDeadlineId(List financingApplyssFinancingDeadlineId) {
        this.financingApplyssFinancingDeadlineId=financingApplyssFinancingDeadlineId;
    }

    public List<FinancingApplys> getFinancingApplyssFinancingDeadlineId() {
        return financingApplyssFinancingDeadlineId;
    }

    public void setBanksBankId(Banks banksBankId) {
        this.banksBankId=banksBankId;
    }

    public Banks getBanksBankId() {
        return banksBankId;
    }
}