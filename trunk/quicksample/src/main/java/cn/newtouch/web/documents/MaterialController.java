package cn.newtouch.web.documents;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
import cn.newtouch.contants.Contants;
import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Material;
import cn.newtouch.entity.Project;
import cn.newtouch.entity.User;
import cn.newtouch.service.MaterialService;
import cn.newtouch.service.ProjectService;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.util.RequestUtils;
import cn.newtouch.util.web.Servlets;
import cn.newtouch.web.BaseController;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/material")
public class MaterialController extends BaseController<Material, Long>
{
    @Autowired
    private ProjectService  projectService;

    @Autowired
    private AccountService  accountService;

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "show/{projectId}")
    public String registerForm(@PathVariable("projectId") Long projectId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            Model model, ServletRequest request)
    {
        String result = "";
        User manager = accountService.get(getCurrentUserId());
        if (manager.getRole() == RoleType.ROLE_ADMIN)
        {
            result = "material/material-manage";
        }
        else
        {
            if (manager.getAuth() == AuthType.AUTH_MANAGE)
            {
                result = "material/material-manage";
            }
            else
            {
                result = "material/material-show";
            }
        }
        model.addAttribute("attachId", projectService.get(projectId)
                .getAttach().getId());
        model.addAttribute("projectId", projectId);
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(
                request, "search_");
        searchParams.put("EQL_project.id", projectId);
        Page<Material> materials = materialService.search(pageNumber,
                PAGE_SIZE, searchParams);
        model.addAttribute("materials", materials);
        return result;
    }

    @RequestMapping(value = "create/{projectId}", method = RequestMethod.GET)
    public String createForm(@PathVariable("projectId") Long projectId,
            Model model)
    {
        model.addAttribute("projectId", projectId);
        model.addAttribute("material", new Material());
        model.addAttribute("action", "create");
        return "material/materialForm";
    }

    @RequestMapping(value = "create/{projectId}", method = RequestMethod.POST)
    public String create(@PathVariable("projectId") Long projectId,
            @RequestParam("theFileName") String theFileName,
            @RequestParam("theFilePath") String theFilePath,
            @Valid @ModelAttribute("preload") Material newMaterial,
            RedirectAttributes redirectAttributes, HttpServletRequest request)
            throws Exception
    {
        Project project = projectService.get(projectId);
        newMaterial.setProject(project);
        File temp = new File(theFilePath);
        String path = RequestUtils.getRealPath(request.getSession()
                .getServletContext(), Contants.IMAGE_PATH + File.separator
                + Contants.MATERIAL_PATH);
        File file = new File(path + File.separator + temp.getName());
        FileUtils.copyFile(temp, file);
        newMaterial.setFileName(theFileName);
        newMaterial.setFilePath(file.getName());
        materialService.save(newMaterial);
        redirectAttributes.addFlashAttribute("message", "创建资料成功");
        return "redirect:/material/show/" + projectId;
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model)
    {
        Material material = materialService.get(id);
        model.addAttribute("material", material);
        model.addAttribute("projectId", material.getProject().getId());
        model.addAttribute("action", "update");
        return "material/materialForm";
    }

    @RequestMapping(value = "update/{projectId}", method = RequestMethod.POST)
    public String update(@PathVariable("projectId") Long projectId,
            @RequestParam("theFileName") String theFileName,
            @RequestParam("theFilePath") String theFilePath,
            @Valid @ModelAttribute("preload") Material material,
            RedirectAttributes redirectAttributes, HttpServletRequest request)
            throws Exception
    {
        if (!material.getFileName().equals(theFileName))
        {
            File temp = new File(theFilePath);
            String path = RequestUtils.getRealPath(request.getSession()
                    .getServletContext(), Contants.IMAGE_PATH + File.separator
                    + Contants.MATERIAL_PATH);
            File file = new File(path + File.separator + temp.getName());
            FileUtils.copyFile(temp, file);
            material.setFileName(theFileName);
            material.setFilePath(file.getName());
        }
        materialService.save(material);
        redirectAttributes.addFlashAttribute("message", "更新资料成功");
        return "redirect:/material/show/" + projectId;
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes)
    {
        Long projectId = materialService.get(id).getProject().getId();
        materialService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除资料成功");
        return "redirect:/material/show/" + projectId;
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
        if (materialService.findByName(name) == null)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> save(@RequestParam("name") String name,
            @RequestParam("filePath") String filePath,
            @RequestParam("projectId") Long projectId,
            HttpServletRequest request) throws Exception
    {
        name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        File temp = new File(filePath);
        String path = RequestUtils.getRealPath(request.getSession()
                .getServletContext(), Contants.IMAGE_PATH + File.separator
                + Contants.MATERIAL_PATH);
        File file = new File(path + File.separator + temp.getName());
        FileUtils.copyFile(temp, file);
        // FileUtils.copyDirectory(file, temp);
        System.out.println("===================" + file.getAbsolutePath());
        Material material = new Material(file.getName(),
                file.getAbsolutePath(), name, projectService.get(projectId));
        materialService.save(material);
        Map<String, Object> result = Maps.newHashMap();
        result.put("id", material.getId());
        result.put("name", material.getName());
        result.put("fileName", material.getFileName());
        return result;
    }

    @Override
    protected Class getEntityClass()
    {
        return Material.class;
    }

    @Override
    protected MaterialService getEntityService()
    {
        return materialService;
    }
}
