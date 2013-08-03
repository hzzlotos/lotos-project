package cn.newtouch.web.documents;

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

import cn.newtouch.contants.AuthType;
import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Attach;
import cn.newtouch.entity.Project;
import cn.newtouch.entity.User;
import cn.newtouch.service.AttachService;
import cn.newtouch.service.ProjectService;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.util.web.Servlets;
import cn.newtouch.web.BaseController;

@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController<Project, Long>
{
    @Autowired
    private AttachService  attachService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "{attachId}")
    public String list(@PathVariable("attachId") Long attachId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            Model model, ServletRequest request)
    {
        String result = "";
        User manager = accountService.get(getCurrentUserId());
        if (manager.getRole() == RoleType.ROLE_ADMIN)
        {
            result = "project/project-manage";
        }
        else
        {
            if (manager.getAuth() == AuthType.AUTH_MANAGE)
            {
                result = "project/project-manage";
            }
            else
            {
                result = "project/project-show";
            }
        }
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(
                request, "search_");
        model.addAttribute("attachId", attachId);
        searchParams.put("EQL_attach.id", attachId);
        Page<Project> projects = projectService.search(pageNumber, PAGE_SIZE,
                searchParams);
        model.addAttribute("projects", projects);
        return result;
    }

    @RequestMapping(value = "create/{attachId}", method = RequestMethod.GET)
    public String createForm(@PathVariable("attachId") Long attachId,
            Model model)
    {
        model.addAttribute("attachId", attachId);
        model.addAttribute("project", new Project());
        model.addAttribute("action", "create");
        return "project/projectForm";
    }

    @RequestMapping(value = "create/{attachId}", method = RequestMethod.POST)
    public String create(@PathVariable("attachId") Long attachId,
            @Valid @ModelAttribute("preload") Project newProject,
            RedirectAttributes redirectAttributes)
    {
        Attach attach = attachService.get(attachId);
        newProject.setAttach(attach);
        projectService.save(newProject);
        redirectAttributes.addFlashAttribute("message", "创建项目成功");
        return "redirect:/project/" + attachId;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        model.addAttribute("attachId", project.getAttach().getId());
        model.addAttribute("action", "update");
        return "project/projectForm";
    }

    @RequestMapping(value = "update/{attachId}", method = RequestMethod.POST)
    public String update(@PathVariable("attachId") Long attachId,
            @Valid @ModelAttribute("preload") Project project,
            RedirectAttributes redirectAttributes)
    {
        projectService.save(project);
        redirectAttributes.addFlashAttribute("message", "更新项目成功");
        return "redirect:/project/" + project.getAttach().getId();
    }

    @RequestMapping(value = "delete/{attachId}/{id}")
    public String delete(@PathVariable("attachId") Long attachId,
            @PathVariable("id") Long id, RedirectAttributes redirectAttributes)
    {
        projectService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除项目成功");
        return "redirect:/project/" + attachId;
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
        if (projectService.findByName(name) == null)
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
        return Project.class;
    }

    @Override
    protected ProjectService getEntityService()
    {
        return projectService;
    }
}