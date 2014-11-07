package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class LadingLog implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date operationTime;

    private String status;

    private String operator;

    private Long ladingId;

    private Ladings ladingsLadingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getLadingId() {
        return ladingId;
    }

    public void setLadingId(Long ladingId) {
        this.ladingId = ladingId;
    }

    public void setLadingsLadingId(Ladings ladingsLadingId) {
        this.ladingsLadingId=ladingsLadingId;
    }

    public Ladings getLadingsLadingId() {
        return ladingsLadingId;
    }
}