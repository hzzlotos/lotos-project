package org.springside.examples.quickstart.web.attach;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.service.attach.AttachService;
import org.springside.examples.quickstart.vo.TreeNode;
import org.springside.examples.quickstart.web.BaseController;

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
@RequestMapping(value = "/material")
public class MaterialController extends BaseController<Attach, Long>
{
    @Autowired
    private AttachService attachService;

    @RequestMapping(value = "")
    public String list(Model model, ServletRequest request)
    {
        TreeNode tn = new TreeNode();
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
