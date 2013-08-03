package cn.newtouch.web.documents;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.contants.AuthType;
import cn.newtouch.contants.Contants;
import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Material;
import cn.newtouch.entity.User;
import cn.newtouch.service.MaterialService;
import cn.newtouch.service.ProjectService;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.util.RequestUtils;
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

    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Long id)
    {
        materialService.delete(id);
        return "true";
    }

    @RequestMapping(value = "show/{attachId}/{projectId}", method = RequestMethod.GET)
    public String registerForm(@PathVariable("attachId") Long attachId,
            @PathVariable("projectId") Long projectId, Model model)
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
        model.addAttribute("attachId", attachId);
        model.addAttribute("projectId", projectId);
        Map<String, Object> searchParams = Maps.newHashMap();
        searchParams.put("EQL_project.id", projectId);
        List<Material> materials = materialService.search(searchParams);
        model.addAttribute("materials", materials);
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
