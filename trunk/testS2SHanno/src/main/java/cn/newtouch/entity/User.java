//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: zzHe
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
package cn.newtouch.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.newtouch.constant.Constants;
import cn.newtouch.util.hibernate.AutoIdEntity;

import com.google.common.collect.Lists;

@Entity
@Table(name = "user")
// @MappedSuperclass
// 默认的缓存策略
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends AutoIdEntity
{
    /**
     * serialVersionUID long
     */
    private static final long serialVersionUID = 1L;

    private String            username;                               // 用户名

    private String            password;                               // 密码

    private String            email;                                  // 邮件

    private Date              createTime;                             // 创建时间

    private List<UserRole>    roles            = Lists.newArrayList();

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @OneToMany(cascade = CascadeType.REFRESH, targetEntity = UserRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OrderBy(value = "id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<UserRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<UserRole> roles)
    {
        this.roles = roles;
    }

    /**
     * 
     * 根据科目库ID获取等级ID
     * 
     * @since 2012-5-8
     * @author zzHe
     * @param subPoolId
     * @return
     */
    @Transient
    public List<UserRole> getRoleOtherBySubPoolId(long subPoolId)
    {
        List<UserRole> result = Lists.newArrayList();
        for (UserRole userRole : roles)
        {
            if (userRole.getSubjectPool().getId() != subPoolId)
            {
                result.add(userRole);
            }
        }
        return result;
    }

    /**
     * 
     * 根据科目库ID获取等级ID
     * 
     * @since 2012-5-8
     * @author zzHe
     * @param subPoolId
     * @return
     */
    @Transient
    public Long getRoleIdBySubPoolId(long subPoolId)
    {
        for (UserRole userRole : roles)
        {
            if (userRole.getSubjectPool().getId() == subPoolId)
            {
                return userRole.getRole().getId();
            }
        }
        return Constants.LEVEL_SYSTEM_ID;
    }

    /**
     * 
     * 根据科目库ID获取等级名称
     * 
     * @since 2012-5-8
     * @author zzHe
     * @param subPoolId
     * @return
     */
    @Transient
    public String getRoleTypeNameBySubPoolId(long subPoolId)
    {
        for (UserRole userRole : roles)
        {
            if (userRole.getSubjectPool().getId() == subPoolId)
            {
                return userRole.getRole().getTypeName();
            }
        }
        return Constants.LEVEL_SYSTEM_STRING;
    }

    /**
     * 
     * 判断用户是否为系统管理员
     * 
     * @since 2012-5-8
     * @author zzHe
     * @return
     */
    @Transient
    public boolean isSuper()
    {
        for (UserRole userRole : roles)
        {
            if (userRole.getRole().getLevel() == Constants.LEVEL_SYSTEM)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 取得某个用户某个科目库对应的功能权限列表
     * 
     * @param subjectPoolId
     * @return
     */
    @Transient
    public List<Authority> getAuths(Long subjectPoolId)
    {
        List<Authority> resAuths = Lists.newArrayList();
        for (UserRole userRole : this.roles)
        {
            if (userRole.getRole().getLevel() == Constants.LEVEL_SYSTEM)
            {
                resAuths.addAll(userRole.getRole().getAuthorityList());
            }
            else
                if (userRole.getSubjectPool().getId().longValue() == subjectPoolId
                        .longValue())
                {
                    resAuths.addAll(userRole.getRole().getAuthorityList());
                }
        }
        return resAuths;
    }
}