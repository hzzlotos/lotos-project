package cn.newtouch.web.account;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.newtouch.entity.User;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.service.account.ShiroDbRealm.ShiroUser;
import cn.newtouch.web.BaseController;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController extends BaseController<User, Long>
{

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String updateForm(Model model)
    {
        Long id = getCurrentUserId();
        model.addAttribute("user", accountService.get(id));
        return "account/profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preload") User user)
    {
        accountService.updateUser(user);
        updateCurrentUserName(user.getName());
        return "redirect:/";
    }

    @ModelAttribute("preload")
    public User getUser(@RequestParam(value = "id", required = false) Long id)
    {
        if (id != null)
        {
            return accountService.get(id);
        }
        return null;
    }

    private void updateCurrentUserName(String userName)
    {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        user.name = userName;
    }

    @Override
    protected Class getEntityClass()
    {
        return User.class;
    }

    @Override
    protected AccountService getEntityService()
    {
        return accountService;
    }
}
