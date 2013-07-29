package org.springside.examples.quickstart.web.account;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.AccountService;

/**
 * 管理员管理用户的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/manager")
public class ManagerController
{

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model)
    {
        List<User> users = accountService.getAll();
        model.addAttribute("users", users);
        return "account/managerList";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("user", accountService.get(id));
        return "account/managerForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preloadUser") User user,
            RedirectAttributes redirectAttributes)
    {
        accountService.updateUser(user);
        redirectAttributes.addFlashAttribute("message", "更新用户"
                + user.getLoginName() + "成功");
        return "redirect:/manager";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        User user = accountService.get(id);
        accountService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "删除用户"
                + user.getLoginName() + "成功");
        return "redirect:/manager";
    }

    /**
     * 使用@ModelAttribute, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
     */
    @ModelAttribute("preloadUser")
    public User getUser(@RequestParam(value = "id", required = false) Long id)
    {
        if (id != null)
        {
            return accountService.get(id);
        }
        return null;
    }
}
