package cn.newtouch.ws.result;

import javax.xml.bind.annotation.XmlType;

/**
 * AuthUser方法的返回结果.
 * 
 * @author calvin
 */
@XmlType(name = "AuthUserResult")
public class AuthUserResult extends WSResult
{

    private boolean valid;

    public boolean isValid()
    {
        return this.valid;
    }

    public void setValid(boolean valid)
    {
        this.valid = valid;
    }
}
