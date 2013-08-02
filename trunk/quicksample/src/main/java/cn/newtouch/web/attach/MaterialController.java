package cn.newtouch.web.attach;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import cn.newtouch.entity.Attach;
import cn.newtouch.entity.Material;
import cn.newtouch.entity.User;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.service.attach.AttachService;
import cn.newtouch.service.attach.MaterialService;
import cn.newtouch.util.RequestUtils;
import cn.newtouch.vo.TreeNode;
import cn.newtouch.web.BaseController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/material")
public class MaterialController extends BaseController<Attach, Long>
{
    @Autowired
    private AttachService   attachService;

    @Autowired
    private AccountService  accountService;

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "")
    public String list(Model model, ServletRequest request)
    {
        return "material/materialList";
    }

    @RequestMapping(value = "attahTree")
    @ResponseBody
    public ResponseEntity<?> getAttahList()
    {
        List<TreeNode> tree = Lists.newArrayList();
        User user = accountService.get(getCurrentUserId());
        TreeNode tn = null;
        Attach attach = null;
        if (RoleType.ROLE_ADMIN == user.getRole())
        {
            tn = new TreeNode();
            tn.setId("0");
            tn.setName("总公司");
            tree.add(tn);
            List<Attach> attachs = attachService.getAll();
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

    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> save(@RequestParam("name") String name,
            @RequestParam("filePath") String filePath,
            @RequestParam("attachId") Long attachId, HttpServletRequest request)
            throws Exception
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
                file.getAbsolutePath(), name, attachService.get(attachId));
        materialService.save(material);
        Map<String, Object> result = Maps.newHashMap();
        result.put("id", material.getId());
        result.put("name", material.getName());
        result.put("fileName", material.getFileName());
        return result;
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(@RequestParam("id") Long id) throws Exception
    {
        materialService.delete(id);
        return "true";
    }

    @RequestMapping(value = "show/{attachId}", method = RequestMethod.GET)
    public String registerForm(@PathVariable("attachId") Long attachId,
            Model model)
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
        Map<String, Object> searchParams = Maps.newHashMap();
        searchParams.put("EQL_attach.id", attachId);
        List<Material> materials = materialService.search(searchParams);
        model.addAttribute("materials", materials);
        return result;
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
