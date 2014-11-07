package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class DocumentationType implements Serializable {
	private static final long serialVersionUID = 1L;
    private String id;

    private String typeName;

    private Long parentId;

    private Long createUserId;

    private Users usersCreateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public void setUsersCreateUserId(Users usersCreateUserId) {
        this.usersCreateUserId=usersCreateUserId;
    }

    public Users getUsersCreateUserId() {
        return usersCreateUserId;
    }
}