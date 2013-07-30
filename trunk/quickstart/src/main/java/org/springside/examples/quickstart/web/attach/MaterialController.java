package org.springside.examples.quickstart.web.attach;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        if (null == user.getAttach())
        {
            TreeNode tn = new TreeNode();
            tn.setParentKey("0");
            tn.setKey("key");
            tn.setValue("总公司");
            tree.add(tn);
            List<Attach> attachs = attachService.getAll();

            for (Attach attach : attachs)
            {
                tn = new TreeNode();
                tn.setKey(String.valueOf(attach.getId()));
                tn.setValue(attach.getName());
                if (null == attach.getParent())
                {
                    tn.setParentKey("key");
                }
                else
                {
                    tn.setParentKey(String.valueOf(attach.getParent().getId()));
                }
                tree.add(tn);
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
        return attachService;
    }
}
