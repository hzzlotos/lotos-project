package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class AppendFunctions implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String appendFunctionsName;

    private String appendFunctionsValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppendFunctionsName() {
        return appendFunctionsName;
    }

    public void setAppendFunctionsName(String appendFunctionsName) {
        this.appendFunctionsName = appendFunctionsName;
    }

    public String getAppendFunctionsValue() {
        return appendFunctionsValue;
    }

    public void setAppendFunctionsValue(String appendFunctionsValue) {
        this.appendFunctionsValue = appendFunctionsValue;
    }
}