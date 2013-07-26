package org.springside.examples.quickstart.web;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
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
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.service.AttachService;
import org.springside.examples.quickstart.service.account.ShiroDbRealm.ShiroUser;
import org.springside.modules.web.Servlets;

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
@RequestMapping(value = "/attach")
public class AttachController
{

    private static final int PAGE_SIZE = 5;

    @Autowired
    private AttachService    attachService;

    @RequestMapping(value = "")
    public String list(@RequestParam(required = false) Long parentId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            Model model, ServletRequest request)
    {
        Attach parent;
        if (null != parentId)
        {
            parent = attachService.getAttach(parentId);
            String parentName = attachService.getAttach(parentId).getName();
            model.addAttribute("theParentId", null == parent.getParent() ? null
                    : parent.getParent().getId());
            model.addAttribute("parentName", parentName);
        }
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(
                request, "search_");
        Page<Attach> attachs = attachService.getAttachPage(parentId,
                searchParams, pageNumber, PAGE_SIZE);
        model.addAttribute("parentId", parentId);
        model.addAttribute("attachs", attachs);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets
                .encodeParameterStringWithPrefix(searchParams, "search_"));

        return "attach/attachList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(@RequestParam(required = false) Long parentId,
            Model model)
    {
        model.addAttribute("attach", new Attach());
        model.addAttribute("action", "create");
        model.addAttribute("parentId", parentId);
        if (null != parentId)
        {
            String parentName = attachService.getAttach(parentId).getName();
            model.addAttribute("parentName", parentName);
        }
        return "attach/attachForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Attach newAttach,
            @RequestParam(required = false) Long parentId,
            RedirectAttributes redirectAttributes)
    {
        Attach parent = null;
        if (null != parentId)
        {
            parent = attachService.getAttach(parentId);
            newAttach.setType(Attach.TYPE_BRANCH);
        }
        else
        {
            newAttach.setType(Attach.TYPE_AREA);
        }
        newAttach.setParent(parent);
        attachService.saveAttach(newAttach);
        redirectAttributes.addFlashAttribute("message", "创建归属地成功");
        return "redirect:/attach?parentId=" + parentId;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        Attach attach = attachService.getAttach(id);
        if (null != attach.getParent())
        {
            model.addAttribute("parentName", attach.getParent().getName());
        }
        model.addAttribute("attach", attach);
        model.addAttribute("action", "update");
        model.addAttribute("parentId", null == attach.getParent() ? null
                : attach.getParent().getId());
        return "attach/attachForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("preloadAttach") Attach attach,
            @RequestParam(required = false) Long parentId,
            RedirectAttributes redirectAttributes)
    {
        attachService.saveAttach(attach);
        redirectAttributes.addFlashAttribute("message", "更新归属地成功");
        return "redirect:/attach?parentId=" + parentId;
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        attachService.deleteAttach(id);
        redirectAttributes.addFlashAttribute("message", "删除任务成功");
        return "redirect:/attach/";
    }

    /**
     * 使用@ModelAttribute, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出Attach对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
     */
    @ModelAttribute("preloadAttach")
    public Attach getAttach(
            @RequestParam(value = "id", required = false) Long id)
    {
        if (id != null)
        {
            return attachService.getAttach(id);
        }
        return null;
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