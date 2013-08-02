package cn.newtouch.web;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import cn.newtouch.service.BaseService;
import cn.newtouch.service.account.ShiroDbRealm.ShiroUser;

@Controller
public abstract class BaseController<T, PK extends Serializable>
{

    protected abstract BaseService<T, PK> getEntityService();

    protected abstract Class getEntityClass();

    protected static final int PAGE_SIZE = 5;

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
