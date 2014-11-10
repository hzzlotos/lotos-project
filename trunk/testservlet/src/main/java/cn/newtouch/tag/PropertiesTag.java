package cn.newtouch.tag;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import cn.newtouch.util.PropertiesUtil;

//TagSupport与BodyTagSupport的区别主要是标签处理类是否需要与标签体交互
//如果不需要交互的就用TagSupport，否则如果需要交互就用BodyTagSupport

//doStartTag()方法是遇到标签开始时会呼叫的方法
//其返回值是EVAL_BODY_INCLUDE与SKIP_BODY，前者表示将显示标签间的文字，后者表示不显示标签间的文字
//doEndTag()方法是在遇到标签结束时呼叫的方法
//其返回值是EVAL_PAGE与 SKIP_PAGE，前者表示处理完标签后继续执行以下的JSP网页，后者是表示不处理接下来的JSP网页
//doAfterBody()这个方法是在显示完标签间文字之后呼叫的
//其返回值有EVAL_BODY_AGAIN与SKIP_BODY，前者会再显示一次标签间的文字，后者则继续执行标签处理的下一步。

//EVAL_BODY_INCLUDE：把Body读入存在的输出流中，doStartTag()函数可用
//EVAL_PAGE：继续处理页面，doEndTag()函数可用
//SKIP_BODY：忽略对Body的处理，doStartTag()和doAfterBody()函数可用
//SKIP_PAGE：忽略对余下页面的处理，doEndTag()函数可用
//EVAL_BODY_TAG：已经废止，由EVAL_BODY_BUFFERED取代
//EVAL_BODY_BUFFERED：申请缓冲区，由setBodyContent()函数得到的BodyContent对象来处理tag的body，将BodyContent的内容输出
//如果类实现了BodyTag，那么doStartTag()可用，否则非法doStartTag()不可使用EVAL_BODY_BUFFERED字段

public class PropertiesTag extends BodyTagSupport
{
    private static final long serialVersionUID = 1L;

    private String            attiName;

    private String            propName;

    @Override
    public int doAfterBody() throws JspException
    {
        return super.doAfterBody();
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
    public void doInitBody() throws JspException
    {
        super.doInitBody();
    }

    @Override
    public int doStartTag() throws JspException
    {
        return super.doStartTag();
    }

    public void setAttiName(String attiName)
    {
        this.attiName = attiName;
    }

    @Override
    public void setBodyContent(BodyContent b)
    {
        super.setBodyContent(b);
    }

    public void setPropName(String propName)
    {
        this.propName = propName;
    }
}
