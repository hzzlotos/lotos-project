package cn.newtouch.getlevel.entities;

import java.io.Serializable;

public class SystemRoles implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long roleId;

    private String systemType;

    private String systemRoleDesc;

    private Roles rolesRoleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemRoleDesc() {
        return systemRoleDesc;
    }

    public void setSystemRoleDesc(String systemRoleDesc) {
        this.systemRoleDesc = systemRoleDesc;
    }

    public void setRolesRoleId(Roles rolesRoleId) {
        this.rolesRoleId=rolesRoleId;
    }

    public Roles getRolesRoleId() {
        return rolesRoleId;
    }
}