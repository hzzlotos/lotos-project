package cn.newtouch.userSSimpl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import cn.newtouch.entity.Authority;
import cn.newtouch.entity.User;
import cn.newtouch.service.UserService;
import cn.newtouch.util.Struts2Utils;

import com.google.common.collect.Sets;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author calvin
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService
{
    private UserService userService;

    /**
     * 获取用户Details信息的回调函数.
     */
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException
    {
        User user = userService.findUserByUserName(username);

        Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);

        // -- eisr2示例中无以下属性, 暂时全部设为true. --//
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userdetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked,
                grantedAuths);

        return userdetails;
    }

    /**
     * 获得用户所有角色的权限集合.
     */
    private Set<GrantedAuthority> obtainGrantedAuthorities(User user)
    {
        Set<GrantedAuthority> authSet = Sets.newHashSet();
        HttpServletRequest request = Struts2Utils.getRequest();
        long subjectPoolId = Long.valueOf(request.getSession().getAttribute(
                "subjectPoolId").toString());
        for (Authority authority : user.getAuths(subjectPoolId))
        {
            authSet.add(new GrantedAuthorityImpl(authority.getPrefixedName()));
        }
        return authSet;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
}