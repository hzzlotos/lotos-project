package cn.newtouch.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.entity.User;
import cn.newtouch.service.UserService;
import cn.newtouch.util.springsecurity.SpringSecurityUtils;

public class AuthorityTag extends TagSupport
{
    // SKIP_BODY = 0; 标签内容不显示

    // EVAL_BODY_INCLUDE = 1;

    // SKIP_PAGE = 5; 标签以外的内容不显示

    // EVAL_PAGE = 6; 标签内容显示,继续执行下面的页面

    private static final long serialVersionUID = 3905528206810167095L;

    private Long              subjectPoolId;

    private String            username;

    private String            authfunc;

    private UserService       userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        userService = userService;
    }

    /**
     * @param subjectpool
     *            The subjectpool to set.
     * @jsp.attribute required="true" rtexprvalue="true"
     */
    public void setSubjectPoolId(Long subjectPoolId)
    {
        this.subjectPoolId = subjectPoolId;
    }

    /**
     * @param username
     *            The username to set.
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @param authfunc
     *            The authfunc to set.
     * @jsp.attribute required="true" rtexprvalue="true"
     */
    public void setAuthfunc(String authfunc)
    {
        this.authfunc = authfunc;
    }

    /**
     * Process the start of this tag.
     * 
     * @return int status
     * 
     * @exception JspException
     *                if a JSP exception has occurred
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException
    {
        // ApplicationContext app = WebApplicationContextUtils
        // .getWebApplicationContext(this.pageContext.getServletContext()); //
        // 获取spring上下文！
        // UserManager userManager = (UserManager) app.getBean("userManager");

        // 取得用户
        User user = null;
        if (!StringUtils.isEmpty(username))
        {
            user = userService.findUserByUserName(username);
        }
        else
        {
            String curUsername = SpringSecurityUtils.getCurrentUserName();
            if (StringUtils.isEmpty(curUsername))
            {
                return Tag.SKIP_BODY;
            }
            user = userService.findUserByUserName(curUsername);
        }
        if (user == null)
        {
            return Tag.SKIP_BODY;
        }

        // 判断是否是项目库管理员
        if (user.isSuper())
        {
            return Tag.EVAL_PAGE;
        }

        // 取得当前用户对于科目库的选项列表
        if (user.getAuths(subjectPoolId).contains(authfunc))
        {
            return Tag.EVAL_PAGE;
        }
        else
        {
            return Tag.SKIP_BODY;
        }
    }

    /**
     * Release aquired resources to enable tag reusage.
     * 
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    @Override
    public void release()
    {
        super.release();
    }
}
