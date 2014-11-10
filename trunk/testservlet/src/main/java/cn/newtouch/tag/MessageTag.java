package cn.newtouch.tag;

import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.LocaleUtils;

public class MessageTag extends BodyTagSupport
{
    private static final long serialVersionUID = 1L;

    private String            key              = null;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    @Override
    public int doEndTag() throws JspException
    {
        JspWriter out = this.pageContext.getOut();
        try
        {
            String language = null;
            if (this.pageContext.getSession() != null)
            {
                language = (String) this.pageContext.getSession().getAttribute("language");
            }
            if (language == null)
            {
                language = "zh_CN";
            }
            Locale locale = LocaleUtils.toLocale(language);
            String sb = locale.getCountry();

            out.print(sb == null ? "" : sb);

        }
        catch (Exception ioe)
        {
            throw new JspException("Error:" + ioe.getMessage());
        }
        return super.doEndTag();
    }

    @Override
    public void doInitBody() throws JspException
    {
        super.doInitBody();
    }

    @Override
    public int doStartTag() throws JspException
    {
        return super.doStartTag();
    }
}
