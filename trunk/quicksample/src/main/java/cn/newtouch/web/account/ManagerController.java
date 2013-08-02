package cn.newtouch.web.account;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.newtouch.contants.AttachType;
import cn.newtouch.contants.AuthType;
import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Attach;
import cn.newtouch.entity.User;
import cn.newtouch.service.AttachService;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.vo.KeyValue;
import cn.newtouch.web.BaseController;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController extends BaseController<User, Long>
{

    @Autowired
    private AccountService accountService;

    @Autowired
    private AttachService  attachService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model)
    {
        List<User> users = accountService.getAll();
        model.addAttribute("users", users);
        return "account/managerList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String registerForm(Model model)
    {
        model.addAttribute("roleList", RoleType.ROLE_TYPE_LIST);
        model.addAttribute("authList", AuthType.AUTH_TYPE_LIST);
        model.addAttribute("attahAreaList", attachService.getAreaList());
        try
        {
            model.addAttribute(
                    "attahBranchList",
                    attachService.getBranchList(attachService.getAreaList()
                            .get(0).getId()));
        }
        catch (Exception e)
        {
            System.out.println("=====attahBranch=====没有被选择");
        }
        model.addAttribute("action", "create");
        return "account/managerForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("preload") User user,
            @RequestParam(required = false) Long attahArea,
            @RequestParam(required = false) Long attahBranch,
            RedirectAttributes redirectAttributes)
    {
        Attach attach = null;
        if (null == attahBranch)
        {
            if (null != attahArea)
            {
                attach = attachService.get(attahArea);
            }
        }
        else
        {
            attach = attachService.get(attahBranch);
        }
        user.setAttach(attach);
        accountService.registerUser(user);
        redirectAttributes.addFlashAttribute("message",
                "添加用户" + user.getLoginName() + "成功");
        return "redirect:/manager";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        User user = accountService.get(id);
        model.addAttribute("user", user);
        model.addAttribute("roleList", RoleType.ROLE_TYPE_LIST);
        model.addAttribute("authList", AuthType.AUTH_TYPE_LIST);
        model.addAttribute("attahAreaList", attachService.getAreaList());
        try
        {
            if (user.getAttach().getType() == AttachType.TYPE_AREA)
            {
                model.addAttribute("attahBranch", null);
                model.addAttribute("attahArea", user.getAttach().getId());
                model.addAttribute(
                        "attahBranchList",
                        attachService.getBranchList(attachService.getAreaList()
                                .get(0).getId()));
            }

            model.addAttribute("attahBranch", user.getAttach().getId());
            model.addAttribute("attahArea", user.getAttach().getParent()
                    .getId());
            model.addAttribute(
                    "attahBranchList",
                    attachService.getBranchList(user.getAttach().getParent()
                            .getId()));
        }
        catch (Exception e)
        {
            System.out.println("=====attahBranch=====没有被选择");
        }
        model.addAttribute("user", accountService.get(id));
        model.addAttribute("action", "update");
        return "account/managerForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preload") User user,
            @RequestParam Long attahArea, @RequestParam Long attahBranch,
            RedirectAttributes redirectAttributes)
    {
        Attach attach;
        if (null == attahBranch)
        {
            attach = attachService.get(attahArea);
        }
        else
        {
            attach = attachService.get(attahBranch);
        }
        user.setAttach(attach);
        accountService.updateUser(user);
        redirectAttributes.addFlashAttribute("message",
                "更新用户" + user.getLoginName() + "成功");
        return "redirect:/manager";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        User user = accountService.get(id);
        accountService.delete(id);
        redirectAttributes.addFlashAttribute("message",
                "删除用户" + user.getLoginName() + "成功");
        return "redirect:/manager";
    }

    @RequestMapping(value = "checkLoginName")
    @ResponseBody
    public String checkLoginName(@RequestParam("loginName") String loginName,
            @RequestParam("oldName") String oldName) throws Exception
    {
        loginName = new String(loginName.getBytes("ISO-8859-1"), "UTF-8");
        oldName = new String(oldName.getBytes("ISO-8859-1"), "UTF-8");
        if (loginName.equals(oldName))
        {
            return "true";
        }
        if (accountService.findUserByLoginName(loginName) == null)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }

    @RequestMapping(value = "attahList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getAttahList(
            @RequestParam("parentId") Long parentId)
    {
        List<Attach> attachs = attachService.getBranchList(parentId);
        List<KeyValue> result = Lists.newArrayList();
        for (Attach attach : attachs)
        {
            result.add(new KeyValue(String.valueOf(attach.getId()), attach
                    .getName()));
        }
        return new ResponseEntity(result, HttpStatus.OK);
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
