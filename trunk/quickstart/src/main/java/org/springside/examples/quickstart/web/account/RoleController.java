package org.springside.examples.quickstart.web.account;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.Role;
import org.springside.examples.quickstart.service.account.RoleService;
import org.springside.modules.web.Servlets;

@Controller
@RequestMapping(value = "/role")
public class RoleController
{

    private static final int PAGE_SIZE = 5;

    @Autowired
    private RoleService      roleService;

    @RequestMapping(value = "")
    public String list(
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            Model model, ServletRequest request)
    {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(
                request, "search_");

        Page<Role> roles = roleService.getRolePage(searchParams, pageNumber,
                PAGE_SIZE);

        model.addAttribute("roles", roles);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets
                .encodeParameterStringWithPrefix(searchParams, "search_"));

        return "role/roleList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model)
    {
        model.addAttribute("role", new Role());
        model.addAttribute("action", "create");
        return "role/roleForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Role newRole,
            RedirectAttributes redirectAttributes)
    {

        roleService.saveRole(newRole);
        redirectAttributes.addFlashAttribute("message", "创建角色成功");
        return "redirect:/role/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("role", roleService.getRole(id));
        model.addAttribute("action", "update");
        return "role/roleForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preloadRole") Role role,
            RedirectAttributes redirectAttributes)
    {
        roleService.saveRole(role);
        redirectAttributes.addFlashAttribute("message", "更新角色成功");
        return "redirect:/role/";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        roleService.deleteRole(id);
        redirectAttributes.addFlashAttribute("message", "删除角色成功");
        return "redirect:/role/";
    }

    /**
     * 使用@ModelAttribute, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
     */
    @ModelAttribute("preloadRole")
    public Role getRole(@RequestParam(value = "id", required = false) Long id)
    {
        if (id != null)
        {
            return roleService.getRole(id);
        }
        return null;
    }
}
