package org.springside.examples.quickstart.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.AccountService;
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
@RequestMapping(value = "/manager")
public class ManagerController
{
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "")
    public String list(Model model)
    {
        User user = accountService.getUser(getCurrentUserId());
        return "attach/attachList";
    }

    /**
     * 取出Shiro中的当前用户Id.
     */
    private Long getCurrentUserId()
    {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }
}
