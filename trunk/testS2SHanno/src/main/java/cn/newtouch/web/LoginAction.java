//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package cn.newtouch.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import cn.newtouch.entity.SubjectPool;
import cn.newtouch.entity.User;
import cn.newtouch.service.SubjectPoolService;
import cn.newtouch.service.UserService;
import cn.newtouch.util.Struts2Utils;

import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 登录
 * 
 * @author zzHe
 * @version 1.0
 * @since 2011-11-8
 */
@Namespace("/")
@Results( { @Result(name = "successLogin", location = "/j_spring_security_check?j_username=${username}&j_password=${password}") })
public class LoginAction extends ActionSupport
{
    /**
     * serialVersionUID long
     */
    private static final long  serialVersionUID = 1L;

    private SubjectPoolService subjectPoolService;

    private UserService        userService;

    private String             username;                               // 用户名

    private String             password;                               // 密码

    private Long               subjectPoolId;                          // 项目库Id

    private List<SubjectPool>  subjectPools     = Lists.newArrayList(); // 获得项目库

    @Override
    public String execute() throws Exception
    {
        // 获得项目库
        subjectPools = subjectPoolService.getAll("id", false);
        HttpServletRequest request = ServletActionContext.getRequest();
        // ip地址
        System.out.println("ip===============" + request.getRemoteAddr());
        return SUCCESS;
    }

    /**
     * 
     * 非系统管理员登录
     * 
     * @since 2011-11-15
     * @author fangyong
     * @return
     * @throws Exception
     */
    public String enter() throws Exception
    {
        try
        {
            // 参数处理
            HttpServletRequest request = Struts2Utils.getRequest();

            // 非空验证
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)
                    || null == subjectPoolId)
            {
                addActionMessage("数据不完整,请重新登录");
                execute();
                return SUCCESS;
            }

            // 验证用户名
            User user = userService.findUserByUserName(username);
            if (user == null || !user.getPassword().equals(password))
            {
                addActionMessage("用户名或密码错误");
                execute();
                return SUCCESS;
            }

            // 保存项目库Id
            request.getSession().setAttribute("subjectPoolId",
                    this.subjectPoolId);
        }
        catch (Exception e)
        {
            addActionMessage("登录失败");
            execute();
            e.printStackTrace();
            return SUCCESS;
        }
        return "successLogin";
    }

    @Autowired
    public void setSubjectPoolService(SubjectPoolService subjectPoolService)
    {
        this.subjectPoolService = subjectPoolService;
    }

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public void setSubjectPoolId(Long subjectPoolId)
    {
        this.subjectPoolId = subjectPoolId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public List<SubjectPool> getSubjectPools()
    {
        return subjectPools;
    }

    public void setSubjectPools(List<SubjectPool> subjectPools)
    {
        this.subjectPools = subjectPools;
    }

}