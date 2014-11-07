package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class DataDictionarys extends DataDictionarysKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private String value;

    private String dataDesc;

    private Long sort;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }
}