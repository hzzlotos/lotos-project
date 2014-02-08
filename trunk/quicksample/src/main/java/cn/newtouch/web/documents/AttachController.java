package cn.newtouch.web.documents;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Attach;
import cn.newtouch.entity.User;
import cn.newtouch.service.AttachService;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.util.SearchFilter;
import cn.newtouch.util.web.Servlets;
import cn.newtouch.vo.TreeNode;
import cn.newtouch.web.BaseController;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/attach")
public class AttachController extends BaseController<Attach, Long>
{

    @Autowired
    private AttachService  attachService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "")
    public String list(@RequestParam(required = false) Long parentId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            Model model, ServletRequest request)
    {
        Attach parent;
        if (null != parentId)
        {
            parent = this.attachService.get(parentId);
            String parentName = this.attachService.get(parentId).getName();
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

        Page<Attach> attachs = this.attachService.search(pageNumber, PAGE_SIZE,
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
            String parentName = this.attachService.get(parentId).getName();
            model.addAttribute("parentName", parentName);
        }
        return "attach/attachForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("preload") Attach newAttach,
            @RequestParam(required = false) Long parentId,
            RedirectAttributes redirectAttributes)
    {
        Attach parent = null;
        if (null != parentId)
        {
            parent = this.attachService.get(parentId);
            newAttach.setType(AttachType.TYPE_BRANCH);
        }
        else
        {
            newAttach.setType(AttachType.TYPE_AREA);
        }
        newAttach.setParent(parent);
        this.attachService.save(newAttach);
        redirectAttributes.addFlashAttribute("message", "创建地区成功");
        return "redirect:/attach?parentId="
                + (null == parentId ? "" : parentId);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        Attach attach = this.attachService.get(id);
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
        this.attachService.save(attach);
        redirectAttributes.addFlashAttribute("message", "更新地区成功");
        return "redirect:/attach?parentId="
                + (null == parentId ? "" : parentId);
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        Attach attach = this.attachService.get(id);
        this.attachService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除地区成功");
        return "redirect:/attach/?parentId="
                + (null == attach.getParent() ? "" : attach.getParent().getId());
    }

    @RequestMapping(value = "checkName")
    @ResponseBody
    public String checkName(@RequestParam("name") String name,
            @RequestParam("oldName") String oldName) throws Exception
    {
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        oldName = new String(oldName.getBytes("ISO-8859-1"), "UTF-8");
        if (name.equals(oldName))
        {
            return "true";
        }
        if (this.attachService.findByName(name) == null)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }

    @RequestMapping(value = "show")
    public String list()
    {
        return "attach/attachShowList";
    }

    @RequestMapping(value = "attahTree")
    @ResponseBody
    public ResponseEntity<?> getAttahList()
    {
        List<TreeNode> tree = Lists.newArrayList();
        User user = this.accountService.get(this.getCurrentUserId());
        TreeNode tn = null;
        Attach attach = null;
        if (RoleType.ROLE_ADMIN == user.getRole())
        {
            tn = new TreeNode();
            tn.setId("0");
            tn.setName("总公司");
            tree.add(tn);
            List<Attach> attachs = this.attachService.getAll();
            for (Attach temp : attachs)
            {
                tn = new TreeNode();
                tn.setId(String.valueOf(temp.getId()));
                tn.setName(temp.getName());
                if (null == temp.getParent())
                {
                    tn.setpId("0");
                }
                else
                {
                    tn.setpId(String.valueOf(temp.getParent().getId()));
                }
                tree.add(tn);
            }
        }
        else
        {
            tn = new TreeNode();
            attach = user.getAttach();
            tn.setId(String.valueOf(attach.getId()));
            tn.setName(attach.getName());
            tree.add(tn);
            if (null != attach.getChildren() && !attach.getChildren().isEmpty())
            {
                for (Attach temp : attach.getChildren())
                {
                    tn = new TreeNode();
                    tn.setId(String.valueOf(temp.getId()));
                    tn.setName(temp.getName());
                    tn.setpId(String.valueOf(temp.getParent().getId()));
                    tree.add(tn);
                }
            }
        }
        return new ResponseEntity(tree, HttpStatus.OK);
    }

    @Override
    protected Class getEntityClass()
    {
        return Attach.class;
    }

    @Override
    protected AttachService getEntityService()
    {
        return this.attachService;
    }
}
