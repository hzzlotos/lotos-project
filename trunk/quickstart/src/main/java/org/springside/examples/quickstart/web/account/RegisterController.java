package org.springside.examples.quickstart.web.account;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.contants.AuthType;
import org.springside.examples.quickstart.contants.KeyValue;
import org.springside.examples.quickstart.contants.RoleType;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.AttachService;
import org.springside.examples.quickstart.service.account.AccountService;

import com.google.common.collect.Lists;

/**
 * 用户注册的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController
{

    @Autowired
    private AccountService accountService;

    @Autowired
    private AttachService  attachService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerForm(Model model)
    {
        model.addAttribute("roleList", RoleType.ROLE_TYPE_LIST);
        model.addAttribute("authList", AuthType.AUTH_TYPE_LIST);
        model.addAttribute("attahAreaList", attachService.getAreaList());
        try
        {
            model.addAttribute("attahBranchList", attachService
                    .getBranchList(attachService.getAreaList().get(0).getId()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "account/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid User user,
            RedirectAttributes redirectAttributes)
    {
        accountService.registerUser(user);
        redirectAttributes.addFlashAttribute("username", user.getLoginName());
        return "redirect:/login";
    }

    /**
     * Ajax请求校验loginName是否唯一。
     */
    @RequestMapping(value = "checkLoginName")
    @ResponseBody
    public String checkLoginName(@RequestParam("loginName") String loginName)
    {
        if (accountService.findUserByLoginName(loginName) == null)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }

    /**
     * Ajax请求校验loginName是否唯一。
     */
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
}
