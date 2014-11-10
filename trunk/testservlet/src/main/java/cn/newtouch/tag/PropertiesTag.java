package cn.newtouch.tag;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.newtouch.util.PropertiesUtil;

public class PropertiesTag extends TagSupport
{
    private static final long serialVersionUID = 1L;

    private String            propName;

    private String            attiName;

    public void setPropName(String propName)
    {
        this.propName = propName;
    }

    public void setAttiName(String attiName)
    {
        this.attiName = attiName;
    }

    @Override
    public int doEndTag() throws JspException
    {
        JspWriter out = this.pageContext.getOut();
        Properties p = PropertiesUtil.getProperties(this.propName, this.propName.split("\\.")[1]);
        String sb = String.valueOf(p.get(this.attiName));
        try
        {
            out.print(p.get(this.attiName) == null ? "" : sb);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new JspException();
        }
        return super.doEndTag();
    }

    @Override
    public int doStartTag() throws JspException
    {
        return super.doStartTag();
    }
}
