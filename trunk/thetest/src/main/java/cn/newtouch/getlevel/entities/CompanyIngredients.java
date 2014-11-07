package cn.newtouch.getlevel.entities;

import java.io.Serializable;
import java.util.Date;

public class CompanyIngredients extends CompanyIngredientsKey implements Serializable {
	private static final long serialVersionUID = 1L;
    private Date createDate;

    private Companys companysCompanyId;

    private Ingredients ingredientsIngredientId;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCompanysCompanyId(Companys companysCompanyId) {
        this.companysCompanyId=companysCompanyId;
    }

    public Companys getCompanysCompanyId() {
        return companysCompanyId;
    }

    public void setIngredientsIngredientId(Ingredients ingredientsIngredientId) {
        this.ingredientsIngredientId=ingredientsIngredientId;
    }

    public Ingredients getIngredientsIngredientId() {
        return ingredientsIngredientId;
    }
}