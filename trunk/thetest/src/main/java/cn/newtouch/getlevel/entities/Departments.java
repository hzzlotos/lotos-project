package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class Departments implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private Long superiorId;

    private String name;

    private Long companyId;

    private List<Departments> departmentssSuperiorId = null;

    private List<QualityBooks> qualityBookssDepartmentId = null;

    private List<Roles> rolessDeptId = null;

    private Companys companysCompanyId;

    private Departments departmentsSuperiorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setDepartmentssSuperiorId(List departmentssSuperiorId) {
        this.departmentssSuperiorId=departmentssSuperiorId;
    }

    public List<Departments> getDepartmentssSuperiorId() {
        return departmentssSuperiorId;
    }

    public void setQualityBookssDepartmentId(List qualityBookssDepartmentId) {
        this.qualityBookssDepartmentId=qualityBookssDepartmentId;
    }

    public List<QualityBooks> getQualityBookssDepartmentId() {
        return qualityBookssDepartmentId;
    }

    public void setRolessDeptId(List rolessDeptId) {
        this.rolessDeptId=rolessDeptId;
    }

    public List<Roles> getRolessDeptId() {
        return rolessDeptId;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setDepartmentsSuperiorId(Departments departmentsSuperiorId) {
        this.departmentsSuperiorId=departmentsSuperiorId;
    }

    public Departments getDepartmentsSuperiorId() {
        return departmentsSuperiorId;
    }
}