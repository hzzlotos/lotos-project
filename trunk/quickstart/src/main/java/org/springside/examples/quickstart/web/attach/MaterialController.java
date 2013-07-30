package org.springside.examples.quickstart.web.attach;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.examples.quickstart.contants.RoleType;
import org.springside.examples.quickstart.entity.Attach;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.attach.AttachService;
import org.springside.examples.quickstart.vo.TreeNode;
import org.springside.examples.quickstart.web.BaseController;

import com.google.common.collect.Lists;

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
    private AttachService  attachService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "")
    public String list(Model model, ServletRequest request)
    {
        return "attach/material";
    }

    /**
     * Ajax请求校验loginName是否唯一。
     */
    @RequestMapping(value = "attahTree", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String registerForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("id", id);
        return "attach/material-show";
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
