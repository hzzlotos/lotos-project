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
package cn.newtouch.util.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.newtouch.util.hibernate.HibernateDao;
import cn.newtouch.util.hibernate.Page;
import cn.newtouch.util.hibernate.PropertyFilter;

@Transactional
public abstract class EntityService<T, PK extends Serializable>
{

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 在子类实现此函数,为下面的CRUD操作提供DAO.
     */
    protected abstract HibernateDao<T, PK> getEntityDao();

    // CRUD函数 //

    @Transactional(readOnly = true)
    public T get(final PK id)
    {
        return getEntityDao().get(id);
    }

    @Transactional(readOnly = true)
    public Page<T> getAll(final Page<T> page)
    {
        return getEntityDao().getAll(page);
    }

    @Transactional(readOnly = true)
    public List<T> getAll()
    {
        return getEntityDao().getAll();
    }

    /**
     * 
     * 取得所有对象，支持排序
     * 
     * @since 2010-8-23
     * @author houbing.qian
     * @param orderBy
     * @param isAsc
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getAll(String orderBy, boolean isAsc)
    {
        return getEntityDao().getAll(orderBy, isAsc);
    }

    @Transactional(readOnly = true)
    public Page<T> search(final Page<T> page, final List<PropertyFilter> filters)
    {
        return getEntityDao().findPage(page, filters);
    }

    @Transactional(readOnly = true)
    public Page<T> search(final Page<T> page)
    {
        return getEntityDao().findPage(page);
    }

    public void save(final T entity)
    {
        getEntityDao().save(entity);
    }

    public void delete(final PK id)
    {
        getEntityDao().delete(id);
    }

    /**
     * 查找前num个对象,按照orderAttribue倒序排列
     */
    @Transactional(readOnly = true)
    public List<T> search(int num, String orderAttribue)
    {
        return this.search(num, orderAttribue, Page.DESC);
    }

    /**
     * 查找前num个对象,按照orderAttribue和排序方式
     */
    @Transactional(readOnly = true)
    public List<T> search(int num, String orderAttribue, String order)
    {
        if (!StringUtils.hasLength(orderAttribue))
        {
            orderAttribue = "id";
        }
        Page<T> page = new Page<T>();
        page.setOrderBy(orderAttribue);
        page.setOrder(order);
        page.setPageNo(1);
        page.setPageSize(num);
        page.setAutoCount(false);
        page = search(page);
        if (null != page)
        {
            return page.getResult();
        }
        return null;
    }
}
