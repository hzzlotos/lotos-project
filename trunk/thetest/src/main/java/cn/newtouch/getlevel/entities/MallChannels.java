package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class MallChannels implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long textsortmodes;

    private Long status;

    private Long mallId;

    private List<MallTexts> mallTextssMallChannleId = null;

    private Malls mallsMallId;

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

    public Long getTextsortmodes() {
        return textsortmodes;
    }

    public void setTextsortmodes(Long textsortmodes) {
        this.textsortmodes = textsortmodes;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public void setMallTextssMallChannleId(List mallTextssMallChannleId) {
        this.mallTextssMallChannleId=mallTextssMallChannleId;
    }

    public List<MallTexts> getMallTextssMallChannleId() {
        return mallTextssMallChannleId;
    }

    public void setMallsMallId(Malls mallsMallId) {
        this.mallsMallId=mallsMallId;
    }

    public Malls getMallsMallId() {
        return mallsMallId;
    }
}