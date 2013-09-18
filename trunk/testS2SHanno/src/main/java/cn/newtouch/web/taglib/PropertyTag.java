package cn.newtouch.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.newtouch.util.PropertyUtils;

public class PropertyTag extends TagSupport
{

    // SKIP_BODY=0 ：跳过了开始和结束标签之间的代码。
    // EVAL_BODY_INCLUDE=1：将body的内容输出到存在的输出流中
    // SKIP_PAGE=5 ： 忽略剩下的页面。
    // EVAL_PAGE=6：标签内容显示,继续执行下面的页面

    private static final long serialVersionUID = 1L;

    private String            propertyName;

    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
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
        JspWriter out = pageContext.getOut();
        try
        {
            out.print(PropertyUtils.getPropertyWithName(propertyName));
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return EVAL_PAGE;
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
