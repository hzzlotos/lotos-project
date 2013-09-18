package cn.newtouch.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.entity.SubjectPool;
import cn.newtouch.service.SubjectPoolService;
import cn.newtouch.util.Struts2Utils;
import cn.newtouch.util.hibernate.Page;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/pool")
@Results( { @Result(name = "reload", location = "subject-pool.action", type = "redirect") })
public class SubjectPoolAction extends ActionSupport
{

    private static final long  serialVersionUID = 1L;

    private Page<SubjectPool>  page             = new Page<SubjectPool>(
                                                        Page.DEFAULT_PAGESIZE_10);

    private SubjectPoolService subjectPoolService;

    private Long               id;

    private SubjectPool        subjectPool;

    @Override
    public String execute() throws Exception
    {
        if (!page.isOrderBySetted())
        {
            page.setOrderBy("id");
            page.setOrder(Page.ASC);
        }
        page = subjectPoolService.getAll(page);
        return SUCCESS;
    }

    @Override
    public String input()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println("referer==============="
                + request.getHeader("Referer"));
        if (id != null && id != 0)
        {
            subjectPool = subjectPoolService.get(id);
        }
        else
        {
            subjectPool = new SubjectPool();
        }
        return INPUT;
    }

    public String save()
    {
        if (id == null || id == 0)
        {
            subjectPool.setId(subjectPoolService.getMaxSerialNO());
        }
        subjectPoolService.save(subjectPool);
        return "reload";
    }

    /**
     * 支持使用Jquery.validate Ajax检验用户名是否重复.
     */
    public String checkName()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String newLoginName = request.getParameter("subjectPool.name");
        String oldLoginName = request.getParameter("oldname");

        if (subjectPoolService.isNameUnique(newLoginName, oldLoginName))
        {
            Struts2Utils.renderText("true");
        }
        else
        {
            Struts2Utils.renderText("false");
        }
        // 因为直接输出内容而不经过jsp,因此返回null.
        return null;
    }

    @Autowired
    public void setSubjectPoolService(SubjectPoolService subjectPoolService)
    {
        this.subjectPoolService = subjectPoolService;
    }

    public Page<SubjectPool> getPage()
    {
        return page;
    }

    public void setPage(Page<SubjectPool> page)
    {
        this.page = page;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public SubjectPool getSubjectPool()
    {
        return subjectPool;
    }

    public void setSubjectPool(SubjectPool subjectPool)
    {
        this.subjectPool = subjectPool;
    }
}