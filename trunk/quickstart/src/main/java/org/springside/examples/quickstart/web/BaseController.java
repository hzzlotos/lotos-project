package org.springside.examples.quickstart.web;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springside.examples.quickstart.service.BaseService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;

/**
 * Attach管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /Attach/ Create page : GET /Attach/create Create action :
 * POST /Attach/create Update page : GET /Attach/update/{id} Update action :
 * POST /Attach/update Delete action : GET /Attach/delete/{id}
 * 
 * @author calvin
 */
@Controller
public abstract class BaseController<T, PK extends Serializable>
{

    protected abstract BaseService<T, PK> getEntityService();

    protected abstract Class getEntityClass();

    @ModelAttribute("preload")
    public T getEntity(@RequestParam(value = "id", required = false) PK id)
            throws Exception
    {
        if (id != null)
        {
            return getEntityService().get(id);
        }
        else
        {
            return (T) getEntityClass().newInstance();
        }
    }

    /**
     * 取出Shiro中的当前用户Id.
     */
    public Long getCurrentUserId()
    {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}
