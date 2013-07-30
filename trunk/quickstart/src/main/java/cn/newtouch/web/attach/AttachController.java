package cn.newtouch.web.attach;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.newtouch.entity.Attach;
import cn.newtouch.service.attach.AttachService;
import cn.newtouch.util.SearchFilter;
import cn.newtouch.util.web.Servlets;
import cn.newtouch.web.BaseController;

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
public class AttachController extends BaseController<Attach, Long>
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
            parent = attachService.get(parentId);
            String parentName = attachService.get(parentId).getName();
            model.addAttribute("theParentId", null == parent.getParent() ? null
                    : parent.getParent().getId());
            model.addAttribute("parentName", parentName);
        }
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(
                request, "search_");
        if (null == parentId)
        {
            searchParams.put("EQL_parent.id", SearchFilter.IS_NULL);
        }
        else
        {
            searchParams.put("EQL_parent.id", parentId);
        }

        Page<Attach> attachs = attachService.search(pageNumber, PAGE_SIZE,
                searchParams);
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
            String parentName = attachService.get(parentId).getName();
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
            parent = attachService.get(parentId);
            newAttach.setType(Attach.TYPE_BRANCH);
        }
        else
        {
            newAttach.setType(Attach.TYPE_AREA);
        }
        newAttach.setParent(parent);
        attachService.save(newAttach);
        redirectAttributes.addFlashAttribute("message", "创建地区成功");
        return "redirect:/attach?parentId="
                + (null == parentId ? "" : parentId);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        Attach attach = attachService.get(id);
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
    public String update(@Valid @ModelAttribute("preload") Attach attach,
            @RequestParam(required = false) Long parentId,
            RedirectAttributes redirectAttributes)
    {
        attachService.save(attach);
        redirectAttributes.addFlashAttribute("message", "更新地区成功");
        return "redirect:/attach?parentId="
                + (null == parentId ? "" : parentId);
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        Attach attach = attachService.get(id);
        attachService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除地区成功");
        return "redirect:/attach/?parentId="
                + (null == attach.getParent() ? "" : attach.getParent().getId());
    }

    /**
     * Ajax请求校验name是否唯一。
     * 
     * @throws Exception
     */
    @RequestMapping(value = "checkName")
    @ResponseBody
    public String checkName(@RequestParam("name") String name,
            @RequestParam("name") String oldName) throws Exception
    {
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        if (name.equals(oldName))
        {
            return "true";
        }
        if (attachService.findByName(name) == null)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }

    @Override
    protected Class getEntityClass()
    {
        return Attach.class;
    }

    @Override
    protected AttachService getEntityService()
    {
        return attachService;
    }
}
