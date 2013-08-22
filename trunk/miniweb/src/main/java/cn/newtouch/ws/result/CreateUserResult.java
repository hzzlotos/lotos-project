package cn.newtouch.ws.result;

import javax.xml.bind.annotation.XmlType;

/**
 * CreateUser方法的返回结果.
 * 
 * @author calvin
 */
@XmlType(name = "CreateUserResult")
public class CreateUserResult extends WSResult
{

    private Long userId;

    /**
     * 新建用户的ID.
     */
    public Long getUserId()
    {
        return this.userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}
