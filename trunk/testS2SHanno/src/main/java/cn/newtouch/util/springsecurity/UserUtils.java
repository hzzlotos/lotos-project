package cn.newtouch.util.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.entity.User;
import cn.newtouch.service.UserService;

public class UserUtils
{
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 取得当前登录基本用户对象
     * 
     * @return
     */
    public static User getCurBaseUser()
    {
        String username = SpringSecurityUtils.getCurrentUserName();
        if ("anonymousUser".equals(username))
        {
            return null;
        }
        return userService.findUserByUserName(username);
    }
}
