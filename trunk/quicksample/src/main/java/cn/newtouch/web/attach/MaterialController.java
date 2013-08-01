package cn.newtouch.web.attach;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.newtouch.contants.RoleType;
import cn.newtouch.entity.Attach;
import cn.newtouch.entity.User;
import cn.newtouch.service.account.AccountService;
import cn.newtouch.service.attach.AttachService;
import cn.newtouch.vo.TreeNode;
import cn.newtouch.web.BaseController;

import com.google.common.collect.Lists;

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
